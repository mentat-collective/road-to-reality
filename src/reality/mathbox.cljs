(ns reality.mathbox
  (:require [demo.mathbox :as dm]
            [leva.core]
            [mathbox.core]
            [mathbox.primitives :as mb]
            [nextjournal.clerk.render]
            [reagent.core :as r]))

(defn ToroidPoint
  [{state      :initial-state
    state->xyz :state->xyz
    :as opts}]
  (reagent.core/with-let
    [render-fn (apply js/Function state->xyz)
     !state    (reagent.core/atom {:time 0 :state state})
     !arr      (reagent.core/atom (js/Array. 2.0 0.5))]
    [:<>
     [:div.hidden
      [nextjournal.clerk.render/inspect @!arr]
      [nextjournal.clerk.render/inspect @!state]]
     [dm/Evolve
      {:L      (:L opts)
       :params !arr
       :atom   !state}]
     [mathbox.core/MathBox
      {:container  {:style {:height "400px" :width "100%"}}
       :renderer   {:background-color 0xffffff}}
      [mb/Cartesian (:cartesian opts)
       [mb/Axis {:axis 1 :width 3}]
       [mb/Axis {:axis 2 :width 3}]
       [mb/Axis {:axis 3 :width 3}]
       [demo.mathbox/Curve
        {:state-derivative (apply js/Function (:L opts))
         :state->xyz render-fn
         :initial-state-fn
         (fn []
           (let [s (:state (.-state !state))]
             (if (array? s)
               s
               (clj->js (flatten s)))))
         :steps 200
         :params !arr}]
       [dm/Comet
        {:dimensions 3
         :length 20
         :color 0xa0d0ff
         :size 10
         :opacity 0.99
         :path
         (let [out #js [0 0 0]]
           (fn [emit _ _]
             (render-fn (:state (.-state !state))
                        out
                        (.-state !arr))
             (emit (aget out 0)
                   (aget out 2)
                   (aget out 1))))}]
       [dm/Torus render-fn !arr]]]]))
