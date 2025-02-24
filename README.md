## YouTrack

https://youtrack.jetbrains.com/issue/CMP-7670/iOS-Korean-text-input-shows-decomposed-syllables-in-TextField-within-M3-BottomSheet

## Android

https://github.com/user-attachments/assets/730d5ce5-0cbe-4abe-89b6-b1bf1c0e8b26

Galaxy 24+ (Android 14)

## iOS

https://github.com/user-attachments/assets/e7287bac-a90c-496e-b7df-c0460b473a7f

iPhone SE2 (iOS 18.3)

## iOS Simulator

https://github.com/user-attachments/assets/37d9d758-c78b-4319-aa5d-41010670d84d

iPhone 16

kotlin: 2.1.10
agp: 8.8.1
compose-multiplatform 1.7.3

This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…# CMP-M3-BottomSheet-iOS-TextField-Issue
