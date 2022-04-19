module.exports = {
  env: {
    browser: true,
    es2021: true,
    node: true,
  },
  settings: {
    react: {
      version: "detect",
    },
  },
  extends: ["plugin:react/recommended", "plugin:import/typescript", "plugin:@next/next/recommended"],
  parser: "@typescript-eslint/parser",
  plugins: ["react", "@typescript-eslint"],
  parserOptions: {
    ecmaFeatures: {
      jsx: true,
    },
    ecmaVersion: 12,
    sourceType: "module",
  },
  rules: {
    "react/react-in-jsx-scope": "off",
  }
};
