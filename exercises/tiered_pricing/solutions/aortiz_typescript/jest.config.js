module.exports = {
  testMatch: ["**/tests/**/*.test.ts"],
  transform: {
    "\\.ts$": "@swc/jest",
  },
};
