^{:nextjournal.clerk/visibility {:code :hide}}
(ns reality.introduction
  {:nextjournal.clerk/toc true}
  (:refer-clojure
   :exclude [+ - * / zero? compare divide numerator denominator
             infinite? abs ref partial =])
  (:require [emmy.env :refer :all]
            [emmy.mafs :as plot]
            [emmy.viewer :as ev :refer [with-let]]
            [mentat.clerk-utils.viewers :refer [q]]
            [nextjournal.clerk :as clerk]
            [reality.viewer :as rv]))

^{::clerk/visibility {:code :hide :result :hide}}
(rv/install!)

;; # Introduction
;;
;; ## Welcome to the Road to Reality!
;;
;; In this essay series, we (you and I!) are going to explore the wonders of
;; modern physics by building all of the tools required to simulate reality, and
;; programming little microworlds that will let us explore all of the
;; strangeness waiting for us at large and small scales.
;;
;; We are going to start with a Lisp interpreter, and build a powerful, modern
;; computer algebra system capable of solving Einstein's field equations. Some
;; of this tooling exists, and some of it we'll be building together in support
;; of the essays.
;;
;; I have an idea of where we're going, but I expect to drag you off in all
;; sorts of interesting mathematical and historical directions. The difference
;; between this and your typical mathematical blog or book is that everything we
;; explore will be usable by you, potentially in your own work, potentially in a
;; personal playground that you can model off of these essays.

;; ### What is Physics?

;; Humans have fought hard over thousands of years to figure out the laws that
;; seem to govern our reality.
;;
;; This is an amazing human drama. What the hell does it all mean? As we've gone
;; we've developed tools that have led to all sorts of engineering advances...
;; we can exert control over the world too.
;;
;; These laws are written in the language of mathematics. Unfortunately most of
;; us don't read math... most of can't participate in the journey, or even
;; appreciate what it is that we've figured out.
;;
;; ## Why programming?
;;
;; Programming lets us build little worlds. This is the only way to understand
;; what we're doing. Quote Sussman too.

;; ## Goals
;;
;; At the end of the series you will:
;;
;; - Know how to program!
;; - Understand what the _goals_ of physics are, and what it means to "model reality"
;; - Understand modern physics deep in your bones...
;;
;; I think that the best way to understand math and physics is to build it
;; yourself, to fashion your own telescope.
;;
;; ## Executable Essays
;;
;; Each of these essays, including this introduction, is a program. The notebook
;; system executed this program to generate the output that you're reading!
;;
;; Clerk scans the file (here's the file that generates this), and every time it
;; sees a code form, it outputs the code form and then, below it, the _result_
;; of running that code:

(+ 1 2)

;; Thanks to Emmy, we can also do math:

(+ 'x 'y)

;; ### Lisp / Clojure
;;
;; We're going to do this with a programming language called Clojure.

;; ### Clerk
;;
;; Clerk extends this by letting us _teach_ the system how to show off values.
;;
;; `+` is a function, and we can make our own using `defn`...

(defn f [x]
  (+ (* 1/120 (expt x 5))
     (* -1/6 (expt x 3))
     x))

;; Then we can call it:

(f 'x)

;; We can also show it as a plot:

^{::clerk/width :wide}
(plot/of-x f {:color (:blue plot/Theme)})

;; And of course we can build up interesting scenes.
^{::clerk/width :wide}
(plot/mafs {:height 400}
           (plot/cartesian)
           (plot/of-x f {:color (:blue plot/Theme)})
           (plot/of-x (D f) {:color (:green plot/Theme)})
           (plot/of-x ((square D) f) {:color (:violet plot/Theme)}))

;; Interactive scenes. Click the `show code` link, though I expect this will be
;; impenetrable now, you'll be able to read this.

^{::clerk/width :wide
  ::clerk/visibility {:code :fold}}
(with-let [!c [0 2]]
  (let [a  [2 0]
        b  [-2 0]]
    (plot/mafs
     {:height 300}
     (plot/cartesian)
     (plot/polygon
      {:stroke-style "dashed"
       :points
       (q (let [[cx cy] @~!c]
            [[cx (- cy)] ~a ~b]))})
     (plot/polygon
      {:points [(q @~!c) a b]
       :color (:blue plot/Theme)})
     (plot/movable-point {:atom !c}))))

;; And you should be able to go off in directions that I had never imagined
;; before, and trivially share those changes back out to me.

;; ## What you need to know
;;
;; Summarize the chapter here.
;;
;; Next, we'll talk about what it means to "model reality".
