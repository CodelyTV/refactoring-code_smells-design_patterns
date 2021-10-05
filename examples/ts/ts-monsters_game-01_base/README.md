# TypeScript Bootstrap (base / project starter)

This is a repository intended to serve as a starting point if you want to bootstrap a project in TypeScript.

## Features

- [TypeScript](https://www.typescriptlang.org/) (v4)
- [Webpack](https://webpack.js.org/) (v5)
- [Babel](https://babeljs.io/) with [preset-env](https://babeljs.io/docs/en/babel-preset-env)
- [Prettier](https://prettier.io/)
- [ESLint](https://eslint.org/) with:
  - [Simple Import Sort](https://github.com/lydell/eslint-plugin-simple-import-sort/)
  - [Import plugin](https://github.com/benmosher/eslint-plugin-import/)
  - [HTML plugin](https://github.com/BenoitZugmeyer/eslint-plugin-html)
  - And a few other ES2015+ related rules
- [Jest](https://jestjs.io) with [DOM Testing Library](https://testing-library.com/docs/dom-testing-library/intro)
- [Cypress](https://www.cypress.io/) with [Testing Library](https://testing-library.com/docs/cypress-testing-library/)
- [GitHub Action workflows](https://github.com/features/actions) set up to run tests and linting on push

## Running the app

```
# install dependencies
npm install

# run in dev mode on port 8080
npm run dev

# generate production build
npm run build

# run generated content in dist folder on port 8080
npm run start
```

## Testing

### Jest with Testing Library

```
npm run test
```

### Cypress

```
# run in dev mode on port 8080
npm run dev

# open Cypress to run tests on dev mode
npm run cy:open

# open Cypress on CLI
npm run cy:run
```

## Linting

```
# run linter
npm run lint

# fix lint issues
npm run lint:fix
```
