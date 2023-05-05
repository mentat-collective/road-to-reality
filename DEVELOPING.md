## Dev Dependencies

- [node.js](https://nodejs.org/en/)
- The [Clojure command line tool](https://clojure.org/guides/install_clojure)
- [Babashka](https://github.com/babashka/babashka#installation)

## Github Pages, Docs Notebook

The project's [Github Pages site](https://reality.mentat.org) hosts all essays
in the form of interactive [Clerk](https://github.com/nextjournal/clerk)
notebooks.

### Local Development

Start a Clojure process however you like, and run `(user/serve!)` to run the
Clerk server. This command should open up `localhost:7777`.

Alternatively, run

```sh
bb clerk-watch
```

### Static Build

To test the static build locally:

```
bb publish-local
```

This will generate the static site in `public/build`, start a development http
server and open up a browser window (http://127.0.0.1:8080/) with the production
build of the essays

### GitHub Pages

To build and release to Github Pages:

```
bb release-gh-pages
```

This will ship the site to https://reality.mentat.org.

## Linting

Essays and supporting code are linted with
[`clj-kondo`](https://github.com/clj-kondo/clj-kondo):

```
bb lint
```
