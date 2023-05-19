^{:nextjournal.clerk/visibility {:code :hide}}
(ns reality.foundations
  {:nextjournal.clerk/toc true})

;; ## Foundations, Lisp, Clojure

;; I want to talk about starting at the floor for a system like this. There are
;; various floors you can start at. These are called __axioms__ in formal
;; systems.

;; We're going to use Clojure, a Lisp, since it gives us a partner that can
;; execute statements that we write down. Unlike other books or series, we are
;; going to build... well, not quite everything, but we are going to start with
;; Lisp and go up from there. I'll try and call out places where we cheat.

;; You can start from different axioms! You can start from boolean algebra, and
;; work your way up from there.

;; You can start with sets, and the axioms behind set theory, and build your way up
;; from there.

;; But this is going to get us where we need to go. We are going to take this
;; language as our "raw ingredients" and do a plausible take on a system that can
;; pretend to be various classical bodies; then pretend to be an evolving wave
;; function, and finally the evolution of the spacetime fabric of the universe.

;; If we do this well, the thing we build along the way will be a tool that you
;; can use to think through your own questions computationally.

;; Clojure overview, how evaluation works, plus the basic data structures and
;; some of the core library. NOTE ON THIS from Jack: probably don't do this,
;; point people but note that we are going to build as we go.
