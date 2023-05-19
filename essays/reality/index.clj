^{:nextjournal.clerk/visibility
  {:code :hide}}
(ns reality.index
  {:nextjournal.clerk/toc true}
  (:require [reality.viewer :as rv]
            [nextjournal.clerk :as clerk]))

;; # Road to Reality Essays

;; Welcome to the Road to Reality!

;; The Road to Reality is an essay series by me, [Sam
;; Ritchie](https://samritchie.io). The essays live at
;; [reality.mentat.org](https://reality.mentat.org).

;; Get started reading at the [Introduction](essays/reality/introduction).

;; Over the course of the series, you are going to build a workshop full of the
;; tools required to create and explore simulated worlds that behave like our
;; most advanced models of reality.

;; Each tool in the workshop will take the form of a program written in the Lisp
;; programming language[^clojure].

;; [^clojure]: More precisely, in a dialect of Lisp called
;; [Clojure](https://clojure.org/).

;; The only way to really learn how a machine works is to build one yourself. By
;; the time we're through, you'll understand modern physics with the intuitive ease
;; of a mechanic debugging the drivetrain of a familiar car. You will have _built
;; the car_, and will be able to drive the car with confidence into the strange
;; country of quantum mechanics, general relativity, chaos theory and phase space.
;;


;; I publish updates on the essays at the ["Road to Reality" Substack
;; newsletter](https://roadtoreality.substack.com). Please subscribe:

^{::clerk/visibility {:code :hide}}
(rv/substack)
;;
;; ## Essay Index
;;
;; 1. [Introduction](essays/reality/introduction)
;;
;; ## Appendices
;;
;; - [FAQ](essays/reality/faq)
;; - [Tools](essays/reality/tools)

;; ## License

;; Copyright © 2023 Sam Ritchie.

;; Distributed under the [MIT
;; License](https://github.com/mentat-collective/road-to-reality/LICENSE).
;; See [LICENSE](https://github.com/mentat-collective/road-to-reality/LICENSE).
