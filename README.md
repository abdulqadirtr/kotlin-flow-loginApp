## ✨ Features

- 🏗️ **MVVM Architecture** — Separation of UI, presentation logic, and data responsibilities.
- 🎨 **Jetpack Compose** — Declarative UI with reusable composable functions.
- 🧠 **ViewModel** — Manages screen-related state and presentation logic.
- 🔄 **StateFlow** — Reactive UI state management.
- 🧭 **Navigation Compose** — Navigation between screens with a managed back stack.
- ⚡ **Kotlin Coroutines** — Asynchronous programming and lifecycle-aware coroutine execution.
- 🌊 **Kotlin Flow** — Asynchronous data streams where needed.
- 📦 **Repository Pattern** — Separation of data access from presentation logic.
- 🧪 **Compose UI Testing** — Automated UI tests for verifying user interactions and UI behavior.
- 🛡️ **UI State Handling** — Loading, success, and error states where implemented.

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Kotlin | Primary programming language |
| Jetpack Compose | Declarative UI development |
| MVVM | Application architecture |
| ViewModel | UI-related state and presentation logic |
| StateFlow | Reactive state management |
| Kotlin Coroutines | Asynchronous programming |
| Kotlin Flow | Asynchronous data streams |
| Navigation Compose | Navigation between screens |
| Compose UI Testing | Automated UI behavior testing |
| Repository Pattern | Data-layer abstraction |

## 🧪 UI Testing with Jetpack Compose

The project includes Compose UI tests to verify that the interface behaves as expected.

UI testing can help validate:

- Whether important UI elements are displayed.
- Whether buttons and other controls respond to user interactions.
- Whether navigation actions lead to the expected screen.
- Whether UI content reflects the expected state.

Example of a Compose UI test:

```kotlin
@get:Rule
val composeTestRule = createComposeRule()

@Test
fun greeting_isDisplayed() {
    composeTestRule.setContent {
        Text("Hello Android")
    }

    composeTestRule
        .onNodeWithText("Hello Android")
        .assertIsDisplayed()
}
```

This example demonstrates the basic testing approach. Adapt it to the actual composables and test cases in your project.

## 📚 What You'll Learn

- Structuring Android applications with MVVM.
- Managing UI state with ViewModel and StateFlow.
- Building declarative interfaces with Jetpack Compose.
- Navigating between screens using Navigation Compose.
- Performing asynchronous work with Kotlin Coroutines.
- Separating data access using the Repository Pattern.
- Writing automated UI tests with the Compose testing framework.
- Verifying UI elements and user interactions using semantic matchers and assertions.
