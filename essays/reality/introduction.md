```clojure
^{:nextjournal.clerk/visibility {:code :hide}}
(ns reality.introduction
  "The first essay in the Road to Reality series."
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

```clojure
#_" If you're reading this, you've figured out how to run and read this essay
from its source code. Welcome!

Clerk supports files written in Markdown format (ending in `.md`) or Clojure
format (ending in `.clj`.)

This particular essay is written in Markdown. If you want to add new code forms
for Clerk to evaluate, you'll need to surround them in a code fence of triple
backticks like the one surrounding this string.

I did this because this particular essay is so prose-heavy! In `.clj` essays you
can drop code anywhere you like and Clerk will evaluate it and splice in
results.
"
```

# Introduction

## Welcome to the Road to Reality!

Over the course of this essay series, you are going to build a workshop full of
the tools required to create and explore simulated worlds that behave like our
most advanced models of reality.

Each tool in the workshop will take the form of a program written in the Lisp
programming language[^clojure]; accordingly, you will learn how to read and
write Lisp code as a side-effect of our journey together. Lisp is one of our
oldest programming languages. The entire language definition fits on half a
sheet of paper[^lisp]. Out of this small set of fundamentals you will learn to
describe our universe.

The only way to really learn how a machine works is to build one yourself. By
the time we're through, you'll understand modern physics with the intuitive ease
of a mechanic debugging the drivetrain of a familiar car. You will have _built
the car_, and will be able to drive the car with confidence into the strange
country of quantum mechanics, general relativity, chaos theory and phase space.

[^clojure]: More precisely, in a dialect of Lisp called
    [Clojure](https://clojure.org/).

[^lisp]: See Michael Nielsen's lovely essay [_Lisp as the Maxwell’s equations of
    software_](https://michaelnielsen.org/ddi/lisp-as-the-maxwells-equations-of-software/).

## Physics as Discovery

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
began to figure out ways to control nature, bringing the disciplines of
engineering into the story.

Our knowledge of how reality unfolds is written in the language of mathematics,
in equations like this one[^euler]:

$$D\left(\partial_{2} L \circ \Gamma[q]\right)- \partial_{1} L \circ \Gamma[q] = 0$$

[^euler]: The [Euler-Lagrange
    equations](https://tgvaughan.github.io/sicm/chapter001.html#h1-6), written
    in functional notation.

This line of text expresses a profound statement about the thrifty way that
physical systems evolve, spending as little as possible of the difference
between the system's kinetic and potential energy as time ticks forward.[^action]

[^action]: This idea is called the "Principle of Least Action".

Most of us (myself included) look at this line of text and can't visualize
anything at all! If you're not one of the tiny number of people that have
learned to interpret these symbols, this barrier deprives you of the ability to
understand the details of this grand human story, let alone contribute to its
next chapters.

We can do better. Take an example of a system that's easy to visualize[^irons]:
a particle attached to the surface of a donut, moving along and pulled into a
bending path by the donut's curves. You might imagine some pattern like this:

[^irons]: Image from [_"Geodesics of the
    Torus"_](http://www.rdrop.com/~half/math/torus/geodesics.xhtml), by Mark
    Irons.

```clojure
^{::clerk/visibility {:code :hide}}
(clerk/image
 "http://www.rdrop.com/~half/math/torus/period.1.unbounded.5-loop.geodesic.png")
```

Here are the system's equations of motion. To describe the actual path the
particle will take, when you plug in the various distances and angles, both of
these equations must come out to zero at every moment in time:

```clojure
^{::clerk/visibility {:code :fold}
  ::clerk/width :full}

(let [L     (toroid/L-toroidal 'R 'r)
      theta (literal-function 'theta)
      phi   (literal-function 'phi)]
  (simplify
   (((Lagrange-equations L) (up theta phi))
    't)))
```

I don't see anything in my head when I look at these equations. But! I generated
the equations using a program, and your computer will happily use them to
animate a little microworld. This simulation shows the bead rolling around with
its future path projected ahead of it:

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

Now we have something tangible to play with[^future]. In a future essay we'll
add controls for modifying the shape of the torus and firing the bead off at
different starting angles. There are wild patterns lurking in simple systems.

[^future]: Drag the camera around with your mouse or finger and zoom in and out.
    You'll see this example again in more interactive style.

## Executing the Essays

To build the tools covered in the series, you'll need to set up your computer
with the same environment that I used to write the essays.

To do this, follow the instructions at the [Road to Reality GitHub
repository](https://github.com/mentat-collective/road-to-reality#running--editing-the-essays).
As I say in that guide, if you get stuck at any point, [write up where you're
stuck using this
form](https://github.com/mentat-collective/road-to-reality/issues/new) and I'll
help you get going.

Each of the essays is a _program_, written as a mix of prose and Clojure
code[^code] forms.

[^code]: This essay's source code [lives
here](https://github.com/mentat-collective/road-to-reality/blob/main/essays/reality/introduction.md).

Another program called [Clerk](https://clerk.vision/) executes this
essay-program each time I save the file and renders the changes to the
http://localhost:7777 in my browser.

Clerk treats prose and comments as
[Markdown](https://www.markdownguide.org/basic-syntax) and formats output
accordingly.

When Clerk encounters a Clojure expression, it evaluates the expression and
displays the result below the expression that produced it. For example, this
expression should evaluate to 6[^evaluate]:

[^evaluate]: See the [Tools](/essays/reality/tools#clojure) page to understand
    why.

```clojure
(+ 1 2 3)
```

Clerk's superpower is that it is _moldable_. We can teach Clerk to render
different kinds of expressions using any visualization that the browser can
handle.

### Emmy

Every notebook has access to the powerful
[Emmy](https://github.com/mentat-collective/emmy) computer algebra system. Emmy
extends Clojure with all of the abilities and tools required to run advanced
physics simulations.

I can write math by adding together Clojure's symbols instead of numbers, and
Clerk will print the result as beautiful $\LaTeX$:

```clojure
(+ 'x 'y)
```

In a more advanced example, I can add new functions, or programmer's verbs, to
the environment:

```clojure
(defn f [x]
  (+ (* 1/120 (expt x 5))
     (* -1/6 (expt x 3))
     x))
```

Here is the result of calling `f` with symbol `'x`, rendered in mathematical
notation:

```clojure
(f 'x)
```

I can also pass `f` to the `plot/of-x` function, producing a result that Clerk
renders as an in-line, scrollable mathematical plot[^viewers]:

[^viewers]: Using code from the
    [emmy-viewers](https://github.com/mentat-collective/emmy-viewers) library.

```clojure
(plot/of-x f {:color (:blue plot/Theme)})
```

You'll become comfortable with the plotting system as we proceed, so I won't say
more now. But I can't resist showing off the ability to compose detailed,
scrollable visualizations:

```clojure
(plot/mafs
 {:height 400}
 (plot/cartesian)
 (plot/of-x f {:color (:blue plot/Theme)})
 (plot/of-x (D f) {:color (:green plot/Theme)})
 (plot/of-x ((square D) f) {:color (:violet plot/Theme)}))
```

or interactive scenes, with glowing pink points that invite manipulation:

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

In the next essay I'll discuss what it means to model reality, and how we can
use these models to make predictions about the future.

## What you need to know

At the end of this series, you will:

- have built your own workshop full of software that you can use to simulate
  reality and explore the leading edge of mathematical physics;

- understand the ideas behind these tools in a deep, intuitive way;

- have become a proficient programmer, comfortable with a text editor and a
  means for running and exploring code.

I will have been successful if you head off in directions that I've never
imagined, and use what you've learned to teach or excite someone else in your
life.

For a final dose of motivation, here's Richard Feynman on the enriching effect
that his study of physics has had on his appreciation for the beauty and
structure that animates our world:

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
Feynman.

For updates on the project and notifications about new essays, please subscribe
to the Road to Reality newsletter:

```
^{::clerk/visibility {:code :hide}}
(rv/substack)
```

## Exercises

1. Follow the instructions at the [Road to Reality GitHub
   repository](https://github.com/mentat-collective/road-to-reality#running--editing-the-essays),
   and get to the point where you have this essay open in your text editor and a
   Clerk process watching the essays for updates.
2. Edit the definition of `f` above and save the file. Notice that any
   expression that depends on `f` refreshes automatically.
3. Play around in the scratchpad below, saving after each edit and noticing the
   results that Clerk renders. This won't work in the browser, so you'll have to
   complete exercise 1 and edit the block in your text editor.

```clojure
(str "edit me on your local computer!")
```
