```clojure
^{:nextjournal.clerk/visibility {:code :hide}}
(ns reality.tools
  {:nextjournal.clerk/toc true}
  (:require [nextjournal.clerk :as clerk]))
```

# Tools

I'm writing The [Road to Reality essays](https://reality.mentat.org) using a
stack of tools that I've designed and built (with plenty of help!) to make it
easy and joyful to write documents with embedded code and interactive
simulations.

I'm writing these essays using the [Clerk][clerk-url] notebook engine and the
[Emmy](https://github.com/mentat-collective/emmy) computer algebra system. Each
essay contains interactive, executable code that you're meant to explore! I'll
add as much interactivity as I can to each essay, but for the full experience I
want you to read them using the same tools and environment that I used to write
the essays.

## Clojure

The essays consist of a mixture of prose and code in the [Clojure programming
language](https://en.wikipedia.org/wiki/Clojure). Clojure is a dialect of
[Lisp](https://en.wikipedia.org/wiki/Lisp_(programming_language)), one of the
oldest programming languages we have.

Lisp stands for Li(st) P(rocessing). Clojure code looks like a nest of lists.
The language takes forms like this:

```clojure
(+ 1 (* 2 3))
```

And evaluates them by

- Parsing a parenthesized list as `(<procedure> <argument1> <argument2> ...)`
- Evaluating each argument using these rules
- Passing the evaluated arguments to `procedure`, and replacing the whole list
  with the result.

Try doing this by hand on the above form, and you should get the following
intermediate steps:

    (+ 1 (* 2 3)) ;; 1 evaluates to itself, (* 2 3) needs evaluation!
    (+ 1 (* 2 3)) ;; 2 and 3 evaluate to themselves. Pass them to *...
    (+ 1 6)       ;; 1 and 6 are fully evaluated, pass them to +...
    7             ;; done!

There is not much more to it, and you'll be doing this process in your head
before long with much more complex code.

The wild truth is that we can use simple tools like this to build up powerful
environments to simulate ideas at the leading edge of modern computational
physics.

## Emmy

[Emmy](https://github.com/mentat-collective/emmy) is a [computer algebra
system](https://en.wikipedia.org/wiki/Computer_algebra_system) based on Gerald
Jay Sussman's powerful-yet-obscure
[`scmutils`](https://groups.csail.mit.edu/mac/users/gjs/6946/installation.html)
project.

Emmy is the computational engine behind the essays. The essays are really a tour
of the construction of this library, of advanced programming techniques, and of
the historical origin of scmutils and Sussman's work in Scheme and Lisp.

## Clerk

[Clerk][clerk-url] is a [computational
notebook](https://en.wikipedia.org/wiki/Notebook_interface) library for
[Clojure](#clojure). I write each essay in a Clojure source file and
[Clerk][clerk-url] converts the contents of the file into a beautifully rendered
HTML document like the one you're reading.

Clerk is "extensible", which means that I can teach it how to display different
mathematical objects.

Clerk renders this string as itself by default:

```
"{\\rm e}^{i\\pi} = -1"
```

If I tell Clerk to use the `clerk/tex` viewer to render the string, it will
instead generate beautifully typeset $\TeX$ output:

```clojure
(clerk/with-viewer clerk/tex
  "{\\rm e}^{i\\pi} = -1")
```

I've used this extensibility to implement a number of powerful Clerk viewers for
showing off interactive math and physics on 2D (via [Mafs.cljs](#mafs.cljs) and
[JSXGraph.cljs](#jsxgraph.cljs)) and 3D (via [MathBox.cljs](#mathbox.cljs))
rendering canvases. These appear throughout the essays!

To learn more about Clerk, visit:

- the [Book of Clerk](https://book.clerk.vision/)
- [The Clerk-Demo index](https://github.clerk.garden/nextjournal/clerk-demo)
- My [awesome-clerk](https://github.com/mentat-collective/awesome-clerk)
  directory of cool work I've found in the Clerk community.

## MathBox.cljs

[MathBox](https://github.com/unconed/mathbox) is a JavaScript library designed
for rendering complex mathematical scenes in 2D and 3D from a declarative
description of the scene. The brilliant [Steven Wittens](https://acko.net/)
wrote MathBox, and allowed me to adopt the project and take over as its
maintainer.

MathBox sits on top of [ThreeJS](https://threejs.org/), which in turn sits on
top of [WebGL](https://developer.mozilla.org/en-US/docs/Web/API/WebGL_API). See
https://mathbox.org/ for many examples of what MathBox can do.

I've wrapped MathBox in a Clojure-friendly package and published it as
[MathBox.cljs](https://mathbox.mentat.org/); this is the layer used by the
essays for any interactive 3D scene. I'll link to examples as they come online.

## Mafs.cljs

[Mafs](https://mafs.dev/) is a [React](https://react.dev/)-based JavaScript
library for writing declarative 2D mathematical scenes that are more interactive
than what MathBox allows out of the box.

See my [ClojureScript wrapper, Mafs.cljs](https://mafs.mentat.org/), for many
examples and more detail.

## JSXGraph.cljs

[JSXGraph](https://jsxgraph.org/) is a powerful JavaScript library for defining
complex, interactive geometric scenes, full of dependencies and relationships.

This toolkit is more powerful at displaying geometric constructions than [Mafs.cljs](#mafs.cljs), and I expect that I'll use heavily more when building up visual proofs in the style of books like Tristan Needham's [Visual Complex Analysis](https://global.oup.com/academic/product/visual-complex-analysis-9780192868923?cc=us&lang=en).

See my [ClojureScript wrapper, JSXGraph.cljs](https://jsxgraph.mentat.org/), for
many examples and more detail.

## Leva.cljs

[Leva](https://github.com/pmndrs/leva/) is a JavaScript library for writing
declarative GUIs with sliders, toggles, realtime charts and more.

[Leva.cljs](https://leva.mentat.org) wraps Leva and allows an author to build up
custom control panels for various simulations or interactive pieces of an
executable essay or textbook section.

## MathLive.cljs

[MathLive](https://mathlive.mentat.org/) provides an equation editor that
renders math as beautiful $\TeX$ inside of a form that lets a reader _edit_ the
rendered math.

[MathLive.cljs](https://mathlive.mentat.org/) extends MathLive with the ability
to extract the equations not just as text, but as a piece of Clojure source code
that [Emmy](#emmy) and the other tools discussed here can use to power
simulations and visuals.

Imagine a textbook where any equation is editable, and editing it updates any
figure that depends on that math.

[clerk-url]: https://clerk.vision
