(ns todo-list.core
  (:require [ring.adapter.jetty :as jetty]))

(defn -main
  "A simple web server using Ring & Jetty"
  [port-number]
  (jetty/run-jetty
    (fn [request]
      {:status 200
       :body "<h1>Hello, Clojure </h1>  <p>Welcome to your first Clojure app.  This message is returned regardless of the route, sorry</p>"
       :headers {"Content-Type" "text/html"}})
    {:port (Integer. port-number)}))
