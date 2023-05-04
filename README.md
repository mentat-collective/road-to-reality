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

## Emmy

This is the computational engine behind the essays, and is immensely powerful.
The essays are really a tour of the construction of this library, of advanced
programming techniques, and of the historical origin of scmutils and Sussman's
work in Scheme and Lisp.

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

[![License][license]][license-url]

# Demos

To run it all:

```sh
bb clerk-watch
```

Then visit http://localhost:7777 if it doesn't open automatically. Visit, change
and save any of the demos in `essays` to render them in Clerk.

> If you find this work interesting, please consider sponsoring it via [Github
> Sponsors](https://github.com/sponsors/sritchie). Thank you!

## Dependencies

Install the following dependencies:

- TODO note about JVM
- [Clojure CLI tools](https://clojure.org/guides/install_clojure)
- [`babashka`](https://github.com/babashka/babashka#installation)

You'll also need `node` installed, preferably via
[`nvm`](https://github.com/nvm-sh/nvm#installing-and-updating).

Run the following command to see all of the [Babashka
Tasks](https://book.babashka.org/#tasks) declared in `bb.edn`:

```sh
bb tasks
```

## Choosing an Editor

Clerk is a notebook environment that requires you to choose your own text editor
to work with the source files that generate your notebooks.

Here are links to guides for the most popular editors and Clojure plugins::

- [Calva](https://calva.io/jack-in-guide/) for [Visual Studio Code](https://code.visualstudio.com/)
- [Cider](https://docs.cider.mx/cider/basics/up_and_running.html#launch-an-nrepl-server-from-emacs) for [Emacs](https://www.gnu.org/software/emacs/)
- [Cursive](https://cursive-ide.com/userguide/repl.html) for [Intellij IDEA](https://www.jetbrains.com/idea/download/#section=mac)
- [Clojure-Vim](https://github.com/clojure-vim/vim-jack-in) for [Vim](https://www.vim.org/) and [Neovim](https://neovim.io/)

> If this is your first time using Clojure, I recommend
> [Calva](https://calva.io/jack-in-guide/) for [Visual Studio
> Code](https://code.visualstudio.com/).

## Developing with Clerk

You can develop against Clerk using its file watcher, using manual calls to
`clerk/show!`, or with a combination of both.

### Via File-Watcher

The simplest way to interact with Clerk is with Clerk's [file watcher
mode](https://book.clerk.vision/#file-watcher).

Run the following command to run the `serve!` function in `dev/user.clj`:

```sh
bb clerk-watch
```

Clerk will watch for changes of any file in the `notebooks` directory. The
ClojureScript build running in the background will pick up any changes to any
file in the `src` directory.

Change this by changing the value under `:watch-paths` in `user/serve-defaults`,
or passing an override to `bb clerk-watch`:

```
bb clerk-watch :watch-paths '["different_directory"]'
```

This will start the Clerk server at http://localhost:7777 with a file
watcher that updates the page each time any file in the `src` directory changes.

### REPL-Based Development

Alternatively, follow your editor's instructions (see ["Choosing an
Editor"](#choosing-an-editor) above) to start a Clojure REPL, and then run
`(user/serve!)`.

To show or reload a particular notebook, call `nextjournal.clerk/show!` with the
file's path as argument. The [Book of Clerk](https://book.clerk.vision) has
[good instructions on how to configure your editor for
this](https://book.clerk.vision/#editor-integration).

You can try this without any editor support by starting a REPL from the command
line:

```sh
clj -A:nextjournal/clerk
```

Then start the server:

```clj
(serve!)
```

To show a file, pass it to `clerk/show!`:

```clj
(clerk/show! "essays/reality/talk.clj")
```

> **Note**
> These commands work because dev/user.clj requires `nextjournal.clerk` under a
> `clerk` alias, and defines a `serve!` function.

## Custom ClojureScript and JavaScript

All ClojureScript code you add to `src/reality/custom.cljs` is available
for use inside any [custom viewer code you
write](https://book.clerk.vision/#writing-viewers).

This is made possible by the code in `src/reality/sci_viewers.cljs`. If you
want to add more namespaces, follow the instructions in `sci_viewers.cljs` to
get them into Clerk's SCI environment.

That file also contains instructions on how to make JavaScript and NPM
dependencies available to your viewers.

## Static Builds

Once you're ready to share your work, run the following command to generate a
standalone static build of your project to the `public/build` directory:

```sh
bb build-static
```

Start a local webserver and view the static build with the following command:

```
bb serve
```

Or run both commands in sequence with:

```
bb publish-local
```

> By default, the static build will include every file in the `essays`
> directory. Change this by changing the `:paths` entry in `static-defaults`
> inside `dev/user.clj`.

## License

Copyright © 2022-2023 Sam Ritchie.

Distributed under the [MIT License](LICENSE). See [LICENSE](LICENSE).

[clerk-url]: https://clerk.vision
[emmy-viewers-url]: https://emmy-viewers.mentat.org
[fdg-book-url]: http://mitpress.mit.edu/books/functional-differential-geometry
[license]: https://img.shields.io/badge/License-EPL%201.0-green.svg
[license-url]: LICENSE
[sicm-book-url]: https://mitpress.mit.edu/books/structure-and-interpretation-classical-mechanics-second-edition
