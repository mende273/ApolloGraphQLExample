# Apollo Graphql Android Example

Simple implementation of Apollo for Android. The project is using the free graphql api from [SpaceX](https://spacex-production.up.railway.app/) for providing data.

## What is Apollo?
[Apollo](https://www.apollographql.com/docs/kotlin/) is a GraphQL client that generates Kotlin and Java models from GraphQL queries.

## Implementation
- Add plugin:
```kotlin
apollo = {
  id = "com.apollographql.apollo3",
  version.ref = "apollo"
}
```
- Add Apollo runtime dependency to your app module
```kotlin
apollo-runtime = {
  group = "com.apollographql.apollo3",
  name = "apollo-runtime",
  version.ref = "apollo"
}
```
- Set package name for generated models in your build.gradle file
```kotlin
apollo {
  service("service") {
    packageName.set("com.example")
  }
}
```

- Download the schema.graphqls
- Create the client
```kotlin
ApolloClient.Builder()
            .serverUrl("serverUrl")
            .okHttpClient(okHttpClient)
            .build()
```

## Other technologies used in the project
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - a dependency injection library for Android.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Android’s modern toolkit for building native UI.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) and [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html#asynchronous-flow) - Official Kotlin's tooling for performing asynchronous work.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - The ViewModel is designed to store and manage UI-related data in a lifecycle conscious way.
- [StateFlow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow#stateflow) - StateFlow is a state-holder observable flow that emits the current and new state updates to its collectors.
