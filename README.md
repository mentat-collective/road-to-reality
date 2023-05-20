[![Substack][substack]][substack-url]
[![Discord Shield][discord]][discord-url]
[![License][license]][license-url]

# Road to Reality Essays

Welcome to the Road to Reality!

The Road to Reality is an essay series by me, [Sam
Ritchie](https://samritchie.io). Starting with the basics of Lisp (the
[Clojure](https://clojure.org) programming language, specifically), we'll build
a modern computer algebra system and use that system to explore and simulate
gems of modern physics like variational mechanics and general relativity.

The only way to really learn how a machine works is to build one yourself. By
the time we're through, you'll understand modern physics with the intuitive ease
of a mechanic debugging the drivetrain of a familiar car. You will have _built
the car_, and will be able to drive the car with confidence into the strange
country of quantum mechanics, general relativity, chaos theory and phase space.

The essays live at https://reality.mentat.org. Get started reading at the
[Introduction](https://reality.mentat.org/essays/reality/introduction).

I publish updates on the essays in the ["Road to Reality" Substack
newsletter][substack-url]. Please subscribe at
https://roadtoreality.substack.com.

## How can I help?

The Road to Reality essays are part of my larger attempt to build a system for
writing and publishing [executable
textbooks](https://roadtoreality.substack.com/p/the-dynamic-notebook). If you
find any of this inspiring or interesting, you can:

- Subscribe to the newsletter: [![Substack][substack]][substack-url]
- Join the Discord community: [![Discord Shield][discord]][discord-url]
- Send me a note at [sam@mentat.org](mailto:sam@mentat.org).

Please consider sponsoring the effort via [Github
Sponsors](https://github.com/sponsors/sritchie), or by signing up for a paid
subscription to the ["Road to Reality" Substack][substack-url].

The _best_ thing you can do is riff on and share the essays, and to the extent
that you find them inspiring, use them to teach someone else.

## How do I read the essays?

There are currently two ways to read the essays:

- Read the static output at https://reality.mentat.org
- Run them as a program, and edit and play along as you read!

I strongly believe that work like this should be read in the same environment
that I used while writing. You can read a paper book with pen in hand, mark it
up and take margin notes; why not do the same with these executable essays?

Each essay is backed by a source code file written in the Clojure programming
language. I hope you'll pay the small up-front cost of setting up your computer
and downloading the essays (described in the ["Running the
Essays"](#running--editing-the-essays) section).

The environment has the beautiful property that if you (you!!) change the source
code, the entire essay will re-render and incorporate your changes.

So as you read, if you become curious about what a simulation would look like
with different initial conditions, or how a satellite might behave if you change
its orbit... or if you want to hijack an essay completely and turn it into a
programmable calculator, you can do that!

These essays are successful only to the extent that you feel empowered to edit
and fiddle with them, and maybe even use the tools to explore and learn on your
own.

## Why are you writing these?

My work on this project stemmed from my own frustration at the one-way nature of
the way I was studying math and physics. When I read books like Sussman and
Wisdom's ["Structure and Interpretation of Classical Mechanics"][sicm-book-url],
I felt like I was building new machinery inside my head that let me see new
patterns in the world that I hadn't been able to see before.

I wanted to share what I'd learned, but the only language available was
symbol-heavy and inscrutable to my friends. I couldn't show anyone what I could
now see in my head.

My work on the [Emmy computer algebra system](https://emmy.mentat.org) and the
other projects [described on the "Tools"
page](https://reality.mentat.org/essays/reality/tools) is my attempt to make
tangible and accessible some of the discoveries and progression that humans have
achieved in math and physics over the last 2,000 years in a way that feels less
like torture and more like exploring a beautiful, strange series of simulations
and video games.

Put more simply: An executable Wikipedia / Digital Museum full of interactive
simulations demonstrating our best understanding of the rules reality follows
_should exist_. No one else seemed to be building it, so I decided to start
poking around.

# Running / Editing the Essays

To run the essays, you'll need to complete the following steps:

- Download the essays to your computer
- Set up your computer to run the essays
- Choose a programming "text editor" that you'll use to edit the files
- Run the program that builds the essays....
- Play!

if you get stuck at any point, [write up where you're stuck on this
form](https://github.com/mentat-collective/road-to-reality/issues/new) and I'll
help you get going.

> **Note**
>
> I know that this is a fairly annoying sequence of steps! I will simplify this
> process over time. Eventually you'll be able to read and edit the essays fully
> in the browser at https://reality.mentat.org. This is where we are now, not
> where we'll end up.

## Download the Essays

Open your terminal and run the following commands:

```sh
cd ~/Documents # or pick your location
git clone git@github.com:mentat-collective/road-to-reality.git
cd road-to-reality
```

The essays live inside of the `essays` folder.

> If you don't know what this means, install [GitHub
> Desktop](https://desktop.github.com/), create an account or sign in, and
> choose "Clone a Repository from the Internet". Type the phrase "mentat road",
> select the first item in the list and click "Clone".

## Dependencies

Install the following dependencies (follow the hyperlinks for install
instructions):

- [Java](https://practical.li/clojure/install/java/)
- [Clojure CLI tools](https://clojure.org/guides/install_clojure)
- [`babashka`](https://github.com/babashka/babashka#installation)

You'll also need `node` installed, preferably via
[`nvm`](https://github.com/nvm-sh/nvm#installing-and-updating).

Now, in the `road-to-reality` directory you entered above, run the following
command to check your installation and see all of the [Babashka
Tasks](https://book.babashka.org/#tasks) declared in the `bb.edn` file:

```sh
bb tasks
```

## Choosing an Editor

The essays are rendered using the [Clerk][clerk-url] notebook system.

[Clerk][clerk-url] is a program that watches Clojure source code files and
renders them in a browser window. To use this workflow you'll need to choose
your own text editor to edit these source files.

Here are links to guides for the most popular editors and Clojure plugins:

- [Calva](https://calva.io/jack-in-guide/) for [Visual Studio
  Code](https://code.visualstudio.com/) (use this if you're not sure!)
- [Cider](https://docs.cider.mx/cider/basics/up_and_running.html#launch-an-nrepl-server-from-emacs) for [Emacs](https://www.gnu.org/software/emacs/)
- [Cursive](https://cursive-ide.com/userguide/repl.html) for [Intellij IDEA](https://www.jetbrains.com/idea/download/#section=mac)
- [Clojure-Vim](https://github.com/clojure-vim/vim-jack-in) for [Vim](https://www.vim.org/) and [Neovim](https://neovim.io/)

> If this is your first time using Clojure, I recommend
> [Calva](https://calva.io/jack-in-guide/) for [Visual Studio
> Code](https://code.visualstudio.com/).

Once you've chosen an editor, open the `road-to-reality` project in the editor
and navigate to the `essays/reality/introduction.clj` file.

## Editing the Essays

Back at your terminal, run the following command:

```
bb clerk-watch
```

Eventually a browser window will appear, pointing to http://localhost:7777. If
you close the window by accident this link will get you back to the essay view.

Now edit any line in `introduction.clj` -- maybe add an exclamation point
somewhere? -- and save the file. If the browser display updates to the
introduction essay with your change, you're now in business! Read in the browser
pane, and edit any example you find in the essays. A simple edit-and-save should
cause everything to update.

## REPL-Based Exploration

Alternatively, instead of `bb clerk-watch` follow your editor's instructions
(see ["Choosing an Editor"](#choosing-an-editor) above) to start a Clojure REPL,
and then run `(user/serve!)`.

Running the essays this way will let you use the Clojure REPL to explore.

To show or reload a particular notebook, call `nextjournal.clerk/show!` with the
file's path as argument. The [Book of Clerk](https://book.clerk.vision) has
[good instructions on how to configure your editor for
this](https://book.clerk.vision/#editor-integration).

You can try this without any editor support by starting a REPL from the command
line:

```sh
bb repl
```

Then start the server:

```clj
(user/serve!)
```

To show a file, pass it to `clerk/show!`:

```clj
(nextjournal.clerk/show! "essays/reality/introduction.md")
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
