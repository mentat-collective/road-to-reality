(ns reality.toroid
  (:refer-clojure
   :exclude [+ - * / = zero? compare
             numerator denominator ref partial
             infinite? abs])
  (:require [emmy.env :as e :refer :all]
            [emmy.mechanics.rotation :as rot]
            [emmy.expression.compile :as xc]
            [emmy.structure :as s]
            [nextjournal.clerk :as clerk]))

(defn toroidal->rect [R r]
  (fn [[_ [theta phi] _]]
    (*
     (rot/rotate-z-matrix phi)
     (s/up (+ R (* r (cos theta)))
           0
           (* r (sin theta))))))

(defn T-free-particle
  [[_ _ v]]
  (* 1/2 (square v)))

(defn V-free-particle
  [[_ _ _]]
  0)

(defn L-toroidal [R r]
  (comp
   (- T-free-particle
      V-free-particle)
   (F->C
    (toroidal->rect R r))))

^{::clerk/visibility {:code :hide :result :hide}}
(def geodesic-viewer
  {:transform-fn
   (comp clerk/mark-presented
         (clerk/update-val
          (fn [{:keys [L params initial-state state->xyz
                      keys] :as m}]
            (assoc m
                   :L
                   (xc/compile-state-fn
                    (compose e/Lagrangian->state-derivative L)
                    (mapv params keys)
                    initial-state
                    {:mode :js
                     :calling-convention :primitive
                     :generic-params? true})

                   :state->xyz
                   (xc/compile-state-fn
                    state->xyz
                    (mapv params keys)
                    initial-state
                    {:mode :js
                     :calling-convention :primitive
                     :generic-params? true})))))
   :render-fn 'reality.mathbox/ToroidPoint})
