(ns reality.sci-extensions
  (:require [emmy-viewers.sci]
            [reality.custom]
            [sci.ctx-store]
            [sci.core :as sci]))

;; ## SCI Environment Extension
;;
;; This namespace extends the SCI environment used by Clerk, making available
;; any custom ClojureScript we use while [writing
;; viewers](https://book.clerk.vision/#writing-viewers) for the essays.

;; ## SCI Environment Extension

;; First, install the `emmy-viewers` environment extensions:

(emmy-viewers.sci/install!)

(def custom-namespace
  (sci/copy-ns reality.custom
               (sci/create-ns 'reality.custom)))

(def custom-namespaces
  {'reality.custom custom-namespace})

(sci.ctx-store/swap-ctx!
 sci/merge-opts
 {:classes    {'Math  js/Math}
  :namespaces custom-namespaces})
