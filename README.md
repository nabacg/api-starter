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

```
