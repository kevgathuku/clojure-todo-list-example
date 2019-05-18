(ns todo-list.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]))


(defn welcome
  "A ring handler to process all requests sent to the webapp.
  Takes the request map as its argument and returns a response map"
  [request]
  {:status 200
   :body
   "<h1>Hello, from Clojure!</h1>
   <p>Welcome to your first Clojure app, I now update automatically.<p>
   <p>I now use defroutes to manage incoming requests</p>"
   :headers {"Content-Type" "text/html"}})


(defroutes app
  (GET "/" [] welcome)
  (not-found "<h1>This is not the page you are looking for</h1>
       <p>Sorry, the page you requested was not found!</p>"))

(defn -dev-main
  "A simple web server using Ring & Jetty that reloads code changes via the development profile of Leiningen"
  [port-number]
  (jetty/run-jetty
    (wrap-reload #'app)
    {:port (Integer. port-number)}))

(defn -main
  "A simple web server using Ring & Jetty"
  [port-number]
  (jetty/run-jetty
    app
    {:port (Integer. port-number)}))
