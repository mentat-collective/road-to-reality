(ns hooks.mathbox.macros
  (:require [clj-kondo.hooks-api :as api]))

(defn ->sym [node]
  (update node :value (comp symbol name)))

(defn defprim
  "Converts a node representing an invocation of the [[mathbox.macros/defprim]]
  macro into a matching `defn` call."
  [{:keys [node]}]
  (let [[_ var-to-alias & body]   (:children node)
        [docstring body] (if (api/string-node? (first body))
                           [(first body) (rest body)]
                           [nil body])
        attrs (when (api/map-node? (first body))
                (first body))]
    {:node
     (api/list-node
      (concat [(api/token-node 'defn)
               (->sym var-to-alias)]
              (when docstring [docstring])
              (when attrs     [attrs])
              [(api/vector-node [])
               var-to-alias]))}))
