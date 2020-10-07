module.exports = {
    testEnvironment: 'node',
    verbose: true,
    cacheDirectory: './.tmp/jestCache',
    transform: {'^.+\\.js$': 'babel-jest'},
    testMatch:[ "**/tests/**/*.[jt]s?(x)", "**/?(*.)+(spec|test).[jt]s?(x)" ],
    moduleFileExtensions: ['js']
};
