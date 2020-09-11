# EditViewPin

![API](https://img.shields.io/badge/API-23%2B-blue.svg?style=flat)  [![CircleCI](https://circleci.com/gh/hexdecimal16/EditTextPin/tree/master.svg?style=svg)](https://circleci.com/gh/https://github.com/hexdecimal16/EditTextPin/tree/master) [![Jitpack](https://jitpack.io/v/hexdecimal16/EditTextPin.svg)](https://jitpack.io/#hexdecimal16/EditTextPin/0.1.0)

---

EditTextPin for Android

This is a  simple library for android where we can take an OTP input from the user. This library will take only number input for now. The lenght is six digits. This library handles both insering and deleting of numbers. You can get the pin using getPin() function.

[<img src="media/demo.gif" width="300" />]()[<img src="media/demo1.png" width="300" />]()

## Gradle

* Step 1. Add the JitPack repository to your build file

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

* Step 2. Add the dependency (only for androidx projects)

```gradle
dependencies {
        implementation 'com.github.hexdecimal16:EditTextPin:Version'
}
```
Version:[![Release](https://jitpack.io/v/hexdecimal16/EditTextPin.svg?style=flat-square)]()
## Implement

```XML
   <com.dhairytripathi.library.EditTextPin
        android:id="@+id/editTextPin"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
```

### Java

```Java
EditTextPin editTextPin = findViewById(R.id.editTextPin);
String pin = editTextPin.getPin(); //To get the current entered pin
```
You're able to further customize or set initial values with styled attributes:

1) Add res-auto to your xml layout if you haven't yet

```XML
xmlns:app="http://schemas.android.com/apk/res-auto"
```

2) After that the following attributes will become available:

```XML
app:underlineColor="" <!-- To change underline color-->
app:textBackground="" <!-- Add a drawable to Edit Text background (For api 23+) -->
```

