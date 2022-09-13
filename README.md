# Road to Reality

Welcome to the essay series. This project stems from my own frustration at the
one-way nature of the way I was studying math and physics. When I read books
like Sussman's, I felt like I was building new machinery in my mind and gaining
new abilities. I wanted to share what I'd learned, but I couldn't take someone
else with me.

These essays are my attempt to build up the web of mathematical and physical
exploration that I've been through on a narrative spine, from small pieces all
the way to classical mechanics and general relativity.

See the intro essay for more detail.

## Why?

I'm offering these in a spirit of playfulness and generosity, with no explicit
"useful" purpose beyond the joy of understanding new things with other people. I
will write about this in one of the essays.

## How do I read the essays?

There are currently two ways to read the essays. The first way is to visit the
static output: (link to github output!)

I strongly believe that work like this should be ABLE to be read in the same
environment that the author had available when writing. You can read a paper
book with pen in hand and mark it up. These computational essays come with their
own computing environment.

The essays are unique in that each is backed by a source code file written in
the Clojure programming language. I hope you'll pay the small up front cost
required to get a computer set up to read these essays alongside their code. The
environment has the beautiful property that if you change the source code, the
entire essay will re-render and incorporate your changes. So as you read, if you
become curious about what a simulation would look like with different initial
conditions, or how a satellite might behave if you change its orbit... or if you
want to hijack an essay and turn it into a programmable calculator, you can do
that!

I will add instructions soon on how to get the environment running. If you want
this now, please file an issue.

## How can I help?

- Join the Discord and discuss: link to Discord
- Use these essays as a template to publish your own computational explorations.
- Send me requests!
- Sponsor the project.

If you find the project inspiring I'd love to talk. The best thing you can do is
riff on and share the essays, and to the extent that you find them inspiring,
use them to teach someone else.

# Stack

These essays are written in Clojure and presented using Clerk. Clerk is an
extensible notebook system, with the lovely feature that YOU can run everything
here.

You might also see this project as a prototype environment for a scientific
computing and authoring environment.

## Clerk

The core, extensible system. This is the rendering and publishing engine for the
project. I've extended, or am planning to extend, Clerk with a number of
"viewers" that make it possible to interact with mathematical objects and
visualizations.

### mathbox.cljs

I was very inspired by this work, and currently have a grant to make these tools
available to the wider Clojure community. Mathbox is a visualization engine
written on top of three.js... all of these are technologies I don't know that
well, but the idea is that I want to be able to describe a scene of mathematical
objects and have them render.

https://github.com/mentat-collective/mathbox.cljs

### jsxgraph (planned)

Mathbox isn't terribly interactive; you have to work from code. JSXGraph, I
think, will let me offer essays that are interactive even in their static
output. None of this works yet but I think it's necessary for the early work.

https://jsxgraph.uni-bayreuth.de/wp/index.html

### mathlive (planned)

I want an equation editor, and I'm going to follow Chris's lead here. This looks
like an awesome project.

## SICMUtils

This is the computational engine behind the essays, and is immensely powerful.
The essays are really a tour of the construction of this library, of advanced
programming techniques, and of the historical origin of scmutils and Sussman's
work in Scheme and Lisp.

https://github.com/sicmutils/sicmutils
