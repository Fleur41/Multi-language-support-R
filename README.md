# Multi-Language Support (Android) 🌍

[![Kotlin Version](https://img.shields.io/badge/Kotlin-2.2.10-blue.svg)](https://kotlinlang.org)
[![Compose](https://img.shields.io/badge/Jetpack%20Compose-Latest-green.svg)](https://developer.android.com/jetpack/compose)
[![Hilt](https://img.shields.io/badge/Hilt-2.60.1-orange.svg)](https://dagger.dev/hilt/)
[![DataStore](https://img.shields.io/badge/DataStore-Preferences-blueviolet.svg)](https://developer.android.com/topic/libraries/architecture/datastore)

A modern, robust Android application demonstrating **Dynamic Language Switching (I18n)** using best-in-class libraries and architectural patterns.

---

## 🚀 Overview

This project serves as a comprehensive guide for Android developers to implement real-time internationalization. It moves away from legacy `SharedPreferences` and XML-based UI, embracing **Jetpack Compose**, **DataStore**, and **Hilt** for a seamless user experience.

## ✨ Features

- 🔄 **Real-time Language Switching**: Instantly toggle between languages without manual app restarts.
- 💾 **Persistent Settings**: Language preferences are securely stored using **Jetpack Preferences DataStore**.
- 🎨 **Material 3 UI**: Beautiful, modern UI components built with the latest Material Design standards.
- 🏗️ **Clean Architecture**: Decoupled layers using ViewModel, Repository, and DataStore managers.
- 💉 **Dependency Injection**: Robust DI implementation with **Hilt**.
- 🇰🇪 **Bi-lingual Support**: Out-of-the-box support for **English** and **Swahili**.

## 🛠️ Tech Stack

- **[Kotlin](https://kotlinlang.org/)** - 100% Type-safe and expressive.
- **[Jetpack Compose](https://developer.android.com/jetpack/compose)** - Declarative UI framework.
- **[Hilt](https://dagger.dev/hilt/)** - Standardized dependency injection.
- **[Preferences DataStore](https://developer.android.com/topic/libraries/architecture/datastore)** - Modern, reactive data storage.
- **[Material 3](https://m3.material.io/)** - Google's latest design system.

## 📂 Project Structure

```text
com.sam.multilanguagesupport
├── datastore/             # DataStore management & Repository
├── multi_language_support/ # Core logic: Language Enum, ResourceManager
├── ui/theme/              # Material 3 Theme & Styling
└── MainActivity.kt        # Entry point & Locale observer
```

## ⚙️ How it Works

1. **Selection**: User picks a language in `MultiLanguageScreen`.
2. **Persistence**: The choice is saved via `DatastoreManager`.
3. **Reactive Observation**: `MainActivity` observes the `Language` flow from the `ViewModel`.
4. **Configuration Update**: The `ResourceManager` dynamically updates the `Locale` and `Configuration`.
5. **Auto-Recomposition**: Jetpack Compose automatically detects resource changes and updates the UI strings.

## 🛠️ Installation & Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Fleur41/Multi-language-support-R.git
   ```
2. **Open in Android Studio**:
   Use **Android Studio Ladybug (2024.2.1)** or newer.
3. **Build & Run**:
   Sync Gradle and run the app on an emulator or physical device.

## 🤝 Contributing

Contributions are welcome! If you'd like to add a new language or improve the architecture:
1. Fork the Project.
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`).
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the Branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.

---

Developed with ❤️ by [Fleur](https://github.com/Fleur41)