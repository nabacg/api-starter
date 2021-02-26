(ns api-starter.core
  (:require   [ring.adapter.jetty :as jetty]
              [clojure.java.jdbc :as jdbc]
              [clojure.java.io :as io]
              [clojure.string :as string]
              [cheshire.core :as json]))



;; more info about supported connection types http://clojure-doc.org/articles/ecosystem/java_jdbc/home.html#database-support
(def conn-info {:dbtype "h2" :dbname  "/tmp/sampledb" })

(defn sample-records
  "Generating some dummy sample data to populate the DB"
  [n]
  (let [first-names  ["Johnny" "Ann" "Marie" "Stefan"]
        last-names   ["Smith" "Kowalsky" "Wolf"]
        categories   ["Premium" "Classic" "FreeAccount"] ]
    (->> (range n)
         (map (fn [i]
                {:firstname (rand-nth first-names) ;; pick random item from collection
                 :lastname  (rand-nth last-names)
                 :category  (rand-nth categories)
                 :age       (rand-int 82)})))))


(defn init-db [num-records]
  ;; make sure we start with a clear database
  ;; db-do-commands runs a vector of sql commands in a single transaction
  (jdbc/db-do-commands conn-info
                       ["CREATE TABLE IF NOT EXISTS users(firstname varchar(64), lastname varchar(64), category varchar(16), age int)"
                        "TRUNCATE TABLE users"])

  ;; insert n rows
  (jdbc/insert-multi! conn-info "users" (sample-records num-records)))



(defn business-logic [data-rows]
  (->> data-rows
       (filter (fn [{:keys [age]}] (> age 18)))
       (map (fn [{:keys [firstname lastname] :as user}]
              ;; simulating some business logic by adding new derived attribute
              ;; modify records by adding :username, from Stefan Franz => sfranz
              (assoc user  :username
                     (string/lower-case (str (subs firstname 0 1)  lastname)))))
       (group-by :category)))


(defn http-handler [req]
  {:body
   (-> (jdbc/query conn-info "select * from users")
       business-logic
       json/generate-string) })



(defn -main [& args]
  (init-db 100) ;; create tables and insert dummy data
  (jetty/run-jetty
   #'http-handler
   {:port 8031}))
