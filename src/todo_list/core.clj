(ns todo-list.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]
            [ring.handler.dump :refer [handle-dump]]
            [todo-list.handlers :refer :all]
            [hiccup.core :as markup]))


(defroutes app
  (GET "/" [] welcome)
  (GET "/goodbye" [] goodbye)
  (GET "/ynwa" [] ynwa)
  (GET "/request-info" [] handle-dump)
  (GET "/calculator/:op/:a/:b" [] calculator)
  (not-found (markup/html [:body
                           [:h1 "This is not the page you are looking for"]
                           [:p "Sorry, the page you requested was not found!"]])))

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
