```clojure
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
            [reality.toroid :as toroid]
            [reality.viewer :as rv]))

^{::clerk/visibility {:code :hide :result :hide}}
(rv/install!)
```

# Introduction

## Welcome to the Road to Reality!

Over the course of this essay series, you are going to build a workshop full of
all of the tools required to create and explore simulated worlds that behave
like our most advanced models of reality.

Each tool in the workshop will take the form of a program written in a
programming language called Lisp[^clojure]; accordingly, you will learn how to
read and write Lisp code as a side-effect of our journey together. Lisp is one
of our oldest programming languages, and has a famously tiny core[^lisp].

The only way to really learn how something works is to build it yourself. By the
time we're through, you'll understand modern physics like a mechanic understands
the drivetrain of car &mdash; you will have _built the car_ and can drive your
car into the strange country of quantum mechanics, general relativity, chaos
theory and phase space.

[^clojure]: Specifically a dialect of Lisp called
    [Clojure](https://clojure.org/).

[^lisp]: Blah blah [half a page of
    code](https://michaelnielsen.org/ddi/lisp-as-the-maxwells-equations-of-software/)

## Why Physics?

The tools you'll build are the tools of modern physics, and the story of their
design is the story of thousands of years of difficult, creative, intense work
by some of the most visionary humans that have lived. The idea that the points
of light we see in the night sky move according to some predictable pattern
&mdash; or that these are the same patterns that describe the planets' motion
around the sun, or a lobbed baseball's arc &mdash; is outrageous. But it seems
to be true!

In fact there doesn't seem to be anything going on in the universe that
_doesn't_ follow some predictable pattern, or law. The tooth-and-nail fight to
figure out these patterns led to the invention of mathematics and science. Of
course, once humans figured out that nature acted according to patterns, we
began to figure out ways to control nature through engineering.

Our knowledge of how reality works is written down in the language of
mathematics, like this[^euler]:

$$D\left(\partial_{2} L \circ \Gamma[q]\right)- \partial_{1} L \circ \Gamma[q] = 0$$

[^euler]: These are the Euler-Lagrange equations, written in functional notation.

Most of us can't look at this line of text and see any connection to reality.
The problem is that mathematics [can't](https://google.com) _perform itself_.

Sometimes we get pictures! For example, this image[^irons] describing the path a
particle attached to a donut would take:

[^irons]: From [_"Geodesics of the
    Torus"_](http://www.rdrop.com/~half/math/torus/geodesics.xhtml), by Mark
    Irons

```clojure
^{::clerk/visibility {:code :hide}}
(clerk/image
 "http://www.rdrop.com/~half/math/torus/period.1.unbounded.5-loop.geodesic.png")
```

By the end we'll write code to generate this simulated world.

```clojure
^{::clerk/viewer toroid/geodesic-viewer
  ::clerk/width :full
  ::clerk/visibility {:code :hide}}
(let [R 2
      r 0.5]
  ;; If you're reading the source code, forgive me... I only recently figured
  ;; out how to write_simulations like this in a nice-to-edit way! I'm cheating
  ;; to get this first essay out. I'll come back and turn this into a foldable
  ;; code block, so that it's easy to play around and explore.
  {:params {:R R :r r}
   :schema
   {:R   {:min 0.5 :max 2 :step 0.01}
    :r   {:min 0.5 :max 2 :step 0.01}}
   :keys [:R :r]
   :state->xyz toroid/toroidal->rect
   :L toroid/L-toroidal
   :initial-state [0 [0 0] [6 1]]
   :cartesian
   {:range [[-10 10]
            [-10 10]
            [-10 10]]
    :scale [3 3 3]}})
```

[discovery fiction](https://michaelnotebook.com/df/index.html)!

building all of the tools required to simulate reality, and programming little
microworlds that will let us explore all of the strangeness waiting for us at
large and small scales.


We are going to start with a Lisp interpreter, and build a powerful, modern
computer algebra system capable of solving Einstein's field equations. Some of
this tooling exists, and some of it we'll be building together in support of the
essays.

### Why?

I have spent the last two years digging through scmutils and converting it into
Emmy. The library reads like the memoir an engineer; you see ideas about system
design and physics forming as the library accumulates depth. The experience
convinced me that there is a powerful human story lurking behind the code.

GJS started this library during a sabbatical to hang out with Feynman. Early
versions led to the Digital Orrery, a supercomputer that he designed to
investigate whether our solar system is chaotic. Will the whole system shake
itself apart?

The library is a recapitulation of thousands of years of human discovery and
progress.

I have an idea of where we're going, but I expect to drag you off in all
sorts of interesting mathematical and historical directions. The difference
between this and your typical mathematical blog or book is that everything we
explore will be usable by you, potentially in your own work, potentially in a
personal playground that you can model off of these essays.

### What is Physics?

Humans have fought hard over thousands of years to figure out the laws that
seem to govern our reality.

This is an amazing human drama. What the hell does it all mean? As we've gone
we've developed tools that have led to all sorts of engineering advances...
we can exert control over the world too.

These laws are written in the language of mathematics. Unfortunately most of
us don't read math... most of can't participate in the journey, or even
appreciate what it is that we've figured out.

## Why programming?

Programming lets us build little worlds. This is the only way to understand
what we're doing. Quote Sussman too.

## Goals

At the end of the series you will:

- Know how to program!
- Understand what the _goals_ of physics are, and what it means to "model reality"
- Understand modern physics deep in your bones...

I think that the best way to understand math and physics is to build it
yourself, to fashion your own telescope.

## Executable Essays

Each of these essays, including this introduction, is a program. The notebook
system executed this program to generate the output that you're reading!

Clerk scans the file (here's the file that generates this), and every time it
sees a code form, it outputs the code form and then, below it, the _result_
of running that code:

```clojure
(+ 1 2)
```

Thanks to Emmy, we can also do math:

```clojure
(+ 'x 'y)
```

### Lisp / Clojure

We're going to do this with a programming language called Clojure.

### Clerk

Clerk extends this by letting us _teach_ the system how to show off values.

`+` is a function, and we can make our own using `defn`...

```clojure
(defn f [x]
  (+ (* 1/120 (expt x 5))
     (* -1/6 (expt x 3))
     x))
```

Then we can call it:

```clojure
(f 'x)
```

We can also show^[If you are _astute_ enough!] it as a plot:

```clojure
(plot/of-x f {:color (:blue plot/Theme)})
```

And of course we can build up interesting scenes.

```clojure
(plot/mafs {:height 400}
           (plot/cartesian)
           (plot/of-x f {:color (:blue plot/Theme)})
           (plot/of-x (D f) {:color (:green plot/Theme)})
           (plot/of-x ((square D) f) {:color (:violet plot/Theme)}))
```

Interactive scenes[^show-code]. I expect this will be impenetrable now, you'll
be able to read this.

[^show-code]: This is a sidenote. The purpose of this text is to merely
demonstrate the use of sidenotes.

```clojure
^{::clerk/visibility {:code :fold}}
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
```

And you should be able to go off in directions that I had never imagined
before, and trivially share those changes back out to me.

Let's let Feynman have the final word:

> Poets say science takes away from the beauty of the stars—mere globs of gas
> atoms. Nothing is “mere.” I too can see the stars on a desert night, and feel
> them. But do I see less or more? The vastness of the heavens stretches my
> imagination &mdash; stuck on this carousel my little eye can catch
> one-million-year-old light. A vast pattern &mdash; of which I am a part
> &mdash; perhaps my stuff was belched from some forgotten star, as one is
> belching there. Or see them with the greater eye of Palomar, rushing all apart
> from some common starting point when they were perhaps all together.
>
> What is the pattern, or the meaning, or the why? It does not do harm to the
> mystery to know a little about it. For far more marvelous is the truth than
> any artists of the past imagined! Why do the poets of the present not speak of
> it? What men are poets who can speak of Jupiter if he were like a man, but if
> he is an immense spinning sphere of methane and ammonia must be
> silent?[^feynman]

[^feynman]: From lecture 3 of [_"The Feynman Lectures on
Physics"_](https://www.feynmanlectures.caltech.edu/I_03.html), by Richard
Feynman

## What you need to know

Summarize the chapter here.

Next, we'll talk about what it means to "model reality"!

```
^{::clerk/visibility {:code :hide}}
(rv/substack)
```


sample chapter from Tao https://terrytao.files.wordpress.com/2020/10/sample_chapter.pdf
