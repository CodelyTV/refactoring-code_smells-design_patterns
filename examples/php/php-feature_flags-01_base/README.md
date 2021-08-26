# Feature Flags example

Example containing bad practices when dealing with global state and the Singleton pattern.

Singletons used in this example:
- [FeatureFlags](src/FeatureFlags.php)
- [MySqlConnection](src/Persistence/MySqlConnection.php)
- [Debug](src/Debug.php)
- [EmailNotifier](src/Email/EmailNotifier.php)

## Ways of using this example

You can practice with this example as you want. Here are some ideas:

- Reason about why Singleton patter is not useful in this context.
- Try to remove some Singletons.
- Reason about global mutable state: Should `Feature Flags` be mutable? Is there a way of making it immutable?
- Try identifying some code smells.
- Try to cover the application with tests without modifying production code.
- Try to perform some refactoring.
