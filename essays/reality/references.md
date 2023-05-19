```clojure
^{:nextjournal.clerk/visibility {:code :hide}}
(ns reality.references
  {:nextjournal.clerk/toc true})
```

# Road to Reality References

This page contains an in-progress directory of books, links and articles that
have helped readers get comfortable with the concepts in the essays. If you have
something great, please [suggest it
here](https://github.com/mentat-collective/road-to-reality/issues/new) and I'll
add it to the list.

## Sussman and Wisdom's SICM, Notation etc

- [Structure and Interpretation of Classical
  Mechanics](https://amzn.to/3b4fMG5), by Sussman and Wisdom.

  - A beautiful [HTML version of the 2nd edition lives
    here](https://tgvaughan.github.io/sicm/).

  - Here's an [open access PDF version of the 1st
    edition](https://library.oapen.org/viewer/web/viewer.html?file=/bitstream/handle/20.500.12657/26048/0103d4acb9fdde999d4c94fbbf711b99a2a7.pdf),
    if you've gotta have a free PDF.

  - [Sam's Roam Notes from Chapter 1: Lagrangian Mechanics](https://roamresearch.com/#/app/sritchie/page/3eV9kOrBm). These are a nice summary of what the chapter is aiming at. I recommend reading this for the high level overview before attempting the first chapter.

  - [Errata for the 2nd edition of SICM](http://groups.csail.mit.edu/mac/users/gjs/6946/errata.pdf). I've found some more, which I'll add to this page as I go.

- The [course website](https://groups.csail.mit.edu/mac/users/gjs/6946/) for MIT's 6.946, ["Classical Mechanics: A Computational Approach"](https://groups.csail.mit.edu/mac/users/gjs/6946/). This is a graduate level course in classical mechanics that uses this textbook. The course page has excellent materials, links to errata, all the goods.

- [MIT OpenCourseware page for the Fall 2008 version of the course](https://ocw.mit.edu/courses/earth-atmospheric-and-planetary-sciences/12-620j-classical-mechanics-a-computational-approach-fall-2008/index.htm). This uses the first edition of the textbook. I haven't gone through this page in any detail.

- [Emmy Reference
  Manual](https://cljdoc.org/d/org.mentat/emmy/CURRENT/doc/reference-manual) in
  Clojure. This is a port of the original
  [refman.txt](https://groups.csail.mit.edu/mac/users/gjs/6946/refman.txt) that
  Sussman and Wisdom supply to students of [MIT's 6.946
  course](http://groups.csail.mit.edu/mac/users/gjs/6946/)

- [Talk: Programming for the Expression of Ideas](https://www.infoq.com/presentations/Expression-of-Ideas/), by Gerald Sussman. This is a wild talk that goes through examples from SICM and FDG in an attempt to hammer home the idea that code is a more expressive, self-contained vehicle for many of our mathematical ideas than traditional, "impressionistic" mathematical notation.

- [Paper: The Role of Programming in the Formulation of Ideas](https://dspace.mit.edu/handle/1721.1/6707), by Sussman and Wisdom ([direct PDF link here](https://dspace.mit.edu/bitstream/handle/1721.1/6707/AIM-2002-018.pdf?sequence=2&isAllowed=y)). This paper gives an overview of the whole pedagogical theory behind the approach in SICM and FDG. This is quite close to the first chapter of FDG.

- a large collection of [worked SICM exercises on Nextjournal](https://nextjournal.com/sicm).

These each have URLs like https://nextjournal.com/sicm/ch-9-our-notation. Insert
`try` before `sicm`, like https://nextjournal.com/try/sicm/ch-9-our-notation,
and the page will become editable. Play with Emmy here!

- [Procedural approach to classical mechanics](http://fmnt.info/blog/20180228_sicm/index.html), by [Francesco Montanari](http://fmnt.info). Another great overview of the functional notation that Sussman and Wisdom adopted from Spivak's [Calculus on Manifolds](https://amzn.to/2ZTfPy1), with examples from the Scheme scmutils library.

### Functional Differential Geometry

- [Functional Differential Geometry](https://amzn.to/2ZVHVsl), by Sussman and Wisdom. The [PDF lives here](http://xahlee.info/math/i/functional_geometry_2013_sussman_14322.pdf). This is a "sequel" to SICM, and builds up the mathematical toolkit used in general relativity using the same "Code as Communication" approach from SICM.

## Community Talks

- 31 Mar 2017 » [Video: Physics in Clojure](https://www.youtube.com/watch?v=7PoajCqNKpg), by Colin Smith

- 2 Dec 2020 » [Video: Scicloj SICMUtils meetup with Sam Ritchie, Colin Smith and Jordan Miller](https://www.youtube.com/watch?v=GyUSh0AAloA&feature=youtu.be)

- 4 Dec 2020 » [Video: re:Clojure 2020 - Functional Physics & the Preservation of Society](https://www.youtube.com/watch?v=8AxMp0nfN7s), by Sam Ritchie ([slides](https://speakerdeck.com/sritchie/functional-physics-and-the-preservation-of-society))

- 26 Jan 2021 » Video: London Clojurians Meetup: [Dynamic Notebooks and Literate Programming](https://www.youtube.com/watch?v=UCEzBNh9ufs&feature=emb_title), by Sam Ritchie ([slides](https://speakerdeck.com/sritchie/dynamic-notebooks-and-literate-programming))

## The Full Journey

- [Teach Yourself Physics](https://amzn.to/3sxEVie), by [Jakob Schwichtenberg](http://jakobschwichtenberg.com)

- [The Feynman Lectures on Physics](https://www.feynmanlectures.caltech.edu), by [Richard Feynman](https://en.wikipedia.org/wiki/Richard_Feynman)

## Classical Mechanics

- [The Theoretical Minimum: What You Need to Know to Start Doing Physics](https://amzn.to/3r1wV8N), by [Leonard Susskind](https://en.wikipedia.org/wiki/Leonard_Susskind)
  - [associated lectures from Lenny](https://theoreticalminimum.com/courses/classical-mechanics/2011/fall)

- [No Nonsense Classical Mechanics](https://amzn.to/3bNRWxl), by [Jakob Schwichtenberg](http://jakobschwichtenberg.com)

## Least Action & more specific texts

- [Optics: The Principle of Least Time](https://www.feynmanlectures.caltech.edu/I_26.html); this is lecture 26 from the Feynman Lectures on Physics.

- [Energy: The Subtle Concept](https://amzn.to/3bNSymD), by [Jennifer Coopersmith](https://jennifercoopersmith.com)

- [The Lazy Universe: An Introduction to the Principle of Least Action](https://amzn.to/3kvL4IF), by [Jennifer Coopersmith](https://jennifercoopersmith.com)

- [The Variational Principles of Mechanics](https://amzn.to/37RdKqy), by [Cornelius Lanczos](https://en.wikipedia.org/wiki/Cornelius_Lanczos)

## Calculus

- [The Essence of Calculus](https://www.youtube.com/playlist?list=PLZHQObOWTQDMsr9K-rj53DwVRMYO3t5Yr), from [3blue1brown](https://www.3blue1brown.com)

- 3blue1brown's [Differential Equations](https://www.youtube.com/playlist?list=PLZHQObOWTQDNPOjrT6KVlfJuKtYTftqH6) series

- [Calculus On Manifolds](https://amzn.to/2ZTfPy1), by [Michael Spivak](https://en.wikipedia.org/wiki/Michael_Spivak). This is Gerald Sussman's _favorite book_ on Calculus, and the book that introduced the calculus notation that Sussman and Wisdom implemented in SICM.

## History

- [A History of Vector Analysis: The Evolution of the Idea of a Vectorial System](https://amzn.to/2ZSNTtY), by [Michael J Crowe](https://www3.nd.edu/~mcrowe1/)

    - This was a fascinating read; dealing with rotations in 3D space was, it
      turns out, an API design problem that's lasted for centuries now. Vectors
      won the day, but they probably aren't the final say.

## Numerical Methods

- [Abstraction in Numerical
  Methods](https://dspace.mit.edu/bitstream/handle/1721.1/6060/AIM-997.pdf?sequence=2),
  by Matthew Halfant and Gerald Sussman.

## Data Visualization

- [Vega Lite: A Grammar of Interactive Graphics](https://www.youtube.com/watch?v=9uaHRWj04D4); a talk from 2017 that goes over the wonderful library we're exploring as a data visualization layer for Emmy.
