(ns todo-list.handlers
   (:require [hiccup.core :as markup]
             [hiccup.page :as page]))


(defn welcome
  "A ring handler to process all requests sent to the webapp.
  Takes the request map as its argument and returns a response map"
  [request]
  (page/html5 {:lang "en"}
    [:head [:title "Welcome"]]
    [:body
     [:h1 "Hello, from Clojure!"]
     [:p "Welcome to your first Clojure app, I now update automatically in dev mode"]
     [:p "I now use defroutes to manage incoming requests"]
     [:p "I also use Hiccup to generate this message!"]]))


(defn goodbye
  "A song to wish you goodbye"
  [request]
  (page/html5 {:lang "en"}
    [:head [:title "Goodbye"]]
    [:body
     [:h1 "Walking back to happiness"]
     [:p "Walking back to happiness with you"]
     [:p "Said, Farewell to loneliness I knew"]
     [:p "Laid aside foolish pride"]
     [:p "Learnt the truth from tears I cried"]]))

(defn ynwa
  "Liverpool F.C theme song"
  [request]
  (page/html5 {:lang "en"}
    [:head [:title "YNWA"]]
    [:body
     [:h1 "You'll never walk alone"]
     [:p "When you walk through a storm"]
     [:p "hold your head up high"]
     [:p "And don't be afraid of the dark."]
     [:p "At the end of a storm is a golden sky"]]))


(def operands {"+" + "-" - "*" * ":" /})

(defn calculator
  "A very simple calculator that can add, divide, subtract and multiply.
  This is done through the magic of variable path elements."
  [request]
  (let [a (Integer. (get-in request [:route-params :a]))
        b (Integer. (get-in request [:route-params :b]))
        op (get-in request [:route-params :op])
        f  (get operands op)]
    (if f
      {:status 200
       :body (str "Calculated result: " (f a b))
       :headers {}}
      
      {:status 404
       :body "Sorry, unknown operator.  I only recognise + - * : (: is for division)"
       :headers {}})))


