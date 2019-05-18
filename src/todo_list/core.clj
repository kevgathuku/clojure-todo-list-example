(ns todo-list.core
  (:require [ring.adapter.jetty :as jetty]))


(defn welcome
  "A ring handler to process all requests sent to the webapp.
  Takes the request map as its argument and returns a response map"
  [request]
  {:status 200
   :body
     "<h1>Hello, Clojure World</h1>
     <p>Welcome to your first Clojure app.
       This message is returned regardless of the route, sorry<p>"
   :headers {"Content-Type" "text/html"}})

(defn -main
  "A simple web server using Ring & Jetty"
  [port-number]
  (jetty/run-jetty
    welcome
    {:port (Integer. port-number)}))
