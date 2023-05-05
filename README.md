[![Substack][substack]][substack-url]
[![Discord Shield][discord]][discord-url]
[![License][license]][license-url]

# Road to Reality

Welcome to the Road to Reality!

A journey through computational physics, from `eval/apply` to the [Einstein
field equations](https://en.wikipedia.org/wiki/Einstein_field_equations).

Some notes on what these are and where to find them. Please subscribe to [the
newsletter][substack-url] for updates.

> If you find this work interesting, please consider sponsoring it via [Github
> Sponsors](https://github.com/sponsors/sritchie). Thank you!

## How do I read the essays?

There are currently two ways to read the essays:

- Read the static output at  https://reality.mentat.org
- Edit them and take notes as you go!

I strongly believe that work like this should be ABLE to be read in the same
environment that the author had available when writing. You can read a paper
book with pen in hand and mark it up. These computational essays come with their
own computing environment.

The essays are unique in that each is backed by a source code file written in
the Clojure programming language. I hope you'll pay the small up front cost
required to get a computer set up to read these essays alongside their code. The
environment has the beautiful property that if you change the source code, the
entire essay will re-render and incorporate your changes.

So as you read, if you become curious about what a simulation would look like
with different initial conditions, or how a satellite might behave if you change
its orbit... or if you want to hijack an essay and turn it into a programmable
calculator, you can do that!

## How can I help?

- Subscribe: [![Substack][substack]][substack-url]
- Join the Discord and discuss: [![Discord Shield][discord]][discord-url]
- Use these essays as a template to publish your own computational explorations.
- Send me requests!
- Sponsor the project.

If you find the project inspiring I'd love to talk. The best thing you can do is
riff on and share the essays, and to the extent that you find them inspiring,
use them to teach someone else.

## Why are you writing these?

This project stems from my own frustration at the one-way nature of the way I
was studying math and physics. When I read books like Sussman's, I felt like I
was building new machinery in my mind and gaining new abilities. I wanted to
share what I'd learned, but I couldn't take someone else with me.

These essays are my attempt to build up the web of mathematical and physical
exploration that I've been through on a narrative spine, from small pieces all
the way to classical mechanics and general relativity.

See the intro essay for more detail. TODO link to some of the earlier essays.

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

This will start the Clerk server at http://localhost:7777 with a file watcher
that updates the page each time any file in the `essays` directory changes. The
ClojureScript build running in the background will pick up any changes to any
file in the `src` directory.

### REPL-Based Exploration

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
(clerk/show! "essays/reality/introduction.clj")
```

## License

Copyright © 2022-2023 Sam Ritchie.

Distributed under the [MIT License](LICENSE). See [LICENSE](LICENSE).

[clerk-url]: https://clerk.vision
[discord-url]: https://discord.gg/hsRBqGEeQ4
[discord]: https://img.shields.io/discord/731131562002743336?style=flat&colorA=000000&colorB=000000&label=&logo=discord
[emmy-slack-url]: https://clojurians.slack.com/archives/C01ECA9AA74
[fdg-book-url]: https://mitpress.mit.edu/9780262019347/functional-differential-geometry/
[license-url]: LICENSE
[license]: https://img.shields.io/badge/license-MIT-brightgreen.svg
[physics-in-clj-talk-url]: https://www.youtube.com/watch?v=7PoajCqNKpg
[refman-url]: https://cljdoc.org/d/org.mentat/emmy/CURRENT/doc/reference-manual
[substack-url]: https://roadtoreality.substack.com
[substack]: https://img.shields.io/badge/Substack-%23006f5c.svg?style=flat&logo=substack&logoColor=FF6719
[scmutils-refman-url]: https://groups.csail.mit.edu/mac/users/gjs/6946/refman.txt
[sicm-book-url]: https://mitpress.mit.edu/9780262028967/structure-and-interpretation-of-classical-mechanics
[sicp-book-url]: https://mitpress.mit.edu/9780262510875/structure-and-interpretation-of-computer-programs
