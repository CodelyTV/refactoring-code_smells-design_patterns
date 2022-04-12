module.exports = {
  testMatch: ["<rootDir>/tests/unit/**/*.(spec|test).(js|jsx|ts|tsx)"],
  testEnvironment: "jsdom",
  setupFilesAfterEnv: ["<rootDir>/setupTests.ts"],
  testPathIgnorePatterns: ["node_modules", "<rootDir>/.next/"],
  transform: {
    "^.+\\.(js|jsx|ts|tsx)$": "ts-jest",
  },
  moduleNameMapper: {
    "\\.(css|less|scss|sass)$": "identity-obj-proxy",
    "\\.(jpg|jpeg|png|gif|eot|otf|webp|ttf|woff|woff2|mp4|webm|wav|mp3|m4a|aac|oga)$": "jest-transform-stub",
  },
  globals: {
    "ts-jest": {
      babelConfig: true,
      tsconfig: {
        jsx: "react-jsx",
      },
    },
  },
};
