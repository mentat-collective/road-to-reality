(ns reality.viewer
  (:require [emmy.env :as e]
            [emmy.expression :as x]
            [emmy.structure :as s]
            [emmy.viewer :as ev]
            [nextjournal.clerk :as clerk]))

(defn install! []
  (clerk/add-viewers!
   [ev/meta-viewer
    {:pred (some-fn x/literal? s/structure?)
     :transform-fn
     (clerk/update-val
      (comp clerk/tex e/->TeX))}]))

(defn substack
  ([] (substack 100))
  ([height]
   (clerk/html
    [:center
     [:iframe
      {:src "https://roadtoreality.substack.com/embed"
       :width "100%" :height height
       :style
       {:border "1px solid #EEE"
        :background "white"
        :frameborder 0
        :scrolling "no"}}]])))
