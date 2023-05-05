(ns user
  (:require [mentat.clerk-utils.build :as b]
            [mentat.clerk-utils.css :as css]
            [nextjournal.clerk.config :as cc]))

(try (requiring-resolve 'cljs.analyzer.api/ns-resolve) (catch Exception _ nil))
(require '[emmy.env])
(require '[emmy.expression.render :as xr])

(alter-var-root
 #'xr/*TeX-vertical-down-tuples*
 (constantly true))

(alter-var-root
 #'cc/*bounded-count-limit*
 (constantly 2))

(css/set-css!
 ;; mafs
 "https://unpkg.com/computer-modern@0.1.2/cmu-serif.css"
 "https://unpkg.com/mafs@0.15.2/core.css"
 "https://unpkg.com/mafs@0.15.2/font.css"

 ;; JSXGraph
 "https://cdn.jsdelivr.net/npm/jsxgraph@1.5.0/distrib/jsxgraph.css"

 ;; mathbox
 "https://unpkg.com/mathbox@2.3.1/build/mathbox.css"

 ;; mathlive
 "https://unpkg.com/mathlive@0.85.1/dist/mathlive-static.css"
 "https://unpkg.com/mathlive@0.85.1/dist/mathlive-fonts.css")

(def index
  "essays/reality/index.clj")

(def defaults
  {:index index
   :cljs-namespaces '[reality.sci-extensions]})

(def serve-defaults
  (assoc defaults
         :port 7777
         :watch-paths ["essays"]
         :browse? true))

(def static-defaults
  (assoc defaults
         :browse? false
         :paths ["essays/**.clj" "essays/**.cljc" "essays/**.md"]
         :cname "reality.mentat.org"
         :git/url "https://github.com/mentat-collective/road-to-reality"))

(defn serve!
  "Alias of [[mentat.clerk-utils.build/serve!]] with [[defaults]] supplied as
  default arguments.

  Any supplied `opts` overrides the defaults."
  ([] (serve! {}))
  ([opts]
   (b/serve!
    (merge serve-defaults opts))))

(def ^{:doc "Alias for [[mentat.clerk-utils.build/halt!]]."}
  halt!
  b/halt!)

(defn build!
  "Alias of [[mentat.clerk-utils.build/build!]] with [[static-defaults]] supplied
  as default arguments.

  Any supplied `opts` overrides the defaults."
  [opts]
  (b/build!
   (merge static-defaults opts)))
