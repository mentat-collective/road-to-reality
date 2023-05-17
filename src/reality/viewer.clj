(ns reality.viewer
  (:require [emmy.env :as e]
            [emmy.expression :as x]
            [emmy.viewer :as ev]
            [nextjournal.clerk :as clerk]))

(defn install! []
  (clerk/add-viewers!
   [ev/meta-viewer
    {:pred x/literal?
     :transform-fn
     (clerk/update-val
      (comp clerk/tex e/->TeX))}]))
