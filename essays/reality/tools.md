```clojure
(ns reality.tools
  #:nextjournal.clerk
  {:toc true :visibility :hide-ns})
```

# Tools

These essays are written in Clojure and presented using Clerk. Clerk is an
extensible notebook system, with the lovely feature that YOU can run everything
here.

You might also see this project as a prototype environment for a scientific
computing and authoring environment.

## Emmy

This is the computational engine behind the essays. The essays are really a tour
of the construction of this library, of advanced programming techniques, and of
the historical origin of scmutils and Sussman's work in Scheme and Lisp.

https://github.com/mentat-collective/emmy

## Clerk

The core, extensible system. This is the rendering and publishing engine for the
project. I've extended, or am planning to extend, Clerk with a number of
"viewers" that make it possible to interact with mathematical objects and
visualizations.

## mathbox.cljs

I was very inspired by this work, and currently have a grant to make these tools
available to the wider Clojure community. Mathbox is a visualization engine
written on top of three.js... all of these are technologies I don't know that
well, but the idea is that I want to be able to describe a scene of mathematical
objects and have them render.

https://github.com/mentat-collective/mathbox.cljs

## jsxgraph, Mafs.cljs

Mathbox isn't terribly interactive; you have to work from code. JSXGraph, I
think, will let me offer essays that are interactive even in their static
output. None of this works yet but I think it's necessary for the early work.

https://jsxgraph.uni-bayreuth.de/wp/index.html

## MathLive

I want an equation editor, and I'm going to follow Chris's lead here. This looks
like an awesome project.
