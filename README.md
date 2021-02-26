# Installation

- Assuming Mac OS, install clojure with brew. More [info](https://www.clojure.org/guides/getting_started)

``` bash
brew install clojure/tools/clojure
```

- clone this repo
- cd inside it
- run the server with `run-server`

``` bash
clojure -X:run-server
2021-02-26 17:16:22.142:INFO::main: Logging initialized @1347ms to org.eclipse.jetty.util.log.StdErrLog
2021-02-26 17:16:23.727:INFO:oejs.Server:main: jetty-9.4.22.v20191022; built: 2019-10-22T13:37:13.455Z; git: b1e6b55512e008f7fbdf1cbea4ff8a6446d1073b; jvm 11.0.6+10
...
```

- test the service

``` bash
curl localhost:8031
{"Premium":[{"firstname":"Ann","lastname":"Franz","category":"Premium","age":44,"username":"afranz"},{"firstname":"Marie","lastname":"Smith","category":"Premium","age":81,"username":"msmith"},{"firstname":"Marie","lastname":"Franz","category":"Premium","age":79,"username":"mfranz"},{"firstname":"Stefan","lastname":"Franz","category":"Premium","age":47,"username":"sfranz"},{"firstname":"Ann","lastname":"Kowalsky","category":"Premium","age":36,"username":"akowalsky"},{"firstname":"Marie","lastname":"Kowalsky","category":"Premium","age":71,"username":"mkowalsky"},{"firstname":"Marie","lastname":"Kowalsky","category":"Premium","age":28,"username":"mkowalsky"},{"firstname":"Stefan","lastname":"Franz","category":"Premium","age":44,"username":"sfranz"},{"firstname":"Ann","lastname":"Smith","category":"Premium","age":73,"username":"asmith"},{"firstname":"Stefan","lastname":"Kowalsky","category":"Premium","age":34,"username":"skowalsky"},{"firstname":"Johnny","lastname":"Kowalsky","category":"Premium","age":41,"username":"jkowalsky"},{"firstname":"Stefan","lastname":"Franz","category":"Premium","age":60,"username":"sfranz"},{"firstname":"Johnny","lastname":"Franz","category":"Premium","age":67,"username":"jfranz"}
....
```
