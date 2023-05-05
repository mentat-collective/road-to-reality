<!-- markdown-toc start - Don't edit this section. Run M-x markdown-toc-refresh-toc -->
# Road to Reality FAQ

- [How can I help?](#how-can-i-help)
- [How do I read the essays?](#how-do-i-read-the-essays)
- [Why are you writing these?](#why-are-you-writing-these)

<!-- markdown-toc end -->

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

The instructions for running the essays live at the [project's GitHub
page][edit-essays-url].

I strongly believe that work like this should be read in the same environment
that I used while writing. You can read a paper book with pen in hand, mark it
up and take margin notes; why not do the same with these executable essays?

Each essay is backed by a source code file written in the Clojure programming
language. I hope you'll pay the small up-front cost of setting up your computer
and downloading the essays (described in the ["Running the
Essays"][edit-essays-url] section).

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

[clerk-url]: https://clerk.vision
[edit-essays-url]: https://github.com/mentat-collective/road-to-reality#running--editing-the-essays
[discord-url]: https://discord.gg/hsRBqGEeQ4
[discord]: https://img.shields.io/discord/731131562002743336?style=flat&colorA=000000&colorB=000000&label=&logo=discord
[substack-url]: https://roadtoreality.substack.com
[substack]: https://img.shields.io/badge/Substack-%23006f5c.svg?style=flat&logo=substack&logoColor=FF6719
[sicm-book-url]: https://mitpress.mit.edu/9780262028967/structure-and-interpretation-of-classical-mechanics
