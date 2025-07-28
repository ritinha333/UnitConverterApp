# Unit Converter Android App 📱

A simple and elegant Android application built with Jetpack Compose that allows users to convert between different units of length measurement.

## 📱 Features

- **Length Unit Conversion**: Convert between Centimeters, Meters, Feet, and Millimeters  
- **Modern UI**: Built with Jetpack Compose and Material Design 3  
- **Real-time Validation**: Input validation with toast notifications for invalid values  
- **Intuitive Interface**: Easy-to-use dropdown menus for unit selection  
- **Custom Theming**: Bordeaux color scheme for a distinctive look  
- **State Persistence**: Maintains input values across configuration changes  

## 📸 Screenshots

To-do!

## 📏 Supported Units

| Unit        | Symbol | Conversion Factor | Example           |
|-------------|--------|-------------------|-------------------|
| Centimeters | cm     | 0.01              | 100 cm = 1 m      |
| Meters      | m      | 1.0               | 1 m = 3.28 ft     |
| Feet        | ft     | 0.3048            | 1 ft = 30.48 cm   |
| Millimeters | mm     | 0.001             | 1000 mm = 1 m     |

## 📂 Project Structure

```
app/
├── manifests/
│   └── AndroidManifest.xml
├── kotlin+java/
│   └── com.example.unitconverter/
│       ├── ui.theme/
│       │   ├── Color.kt
│       │   ├── Theme.kt
│       │   └── Type.kt
│       ├── MainActivity.kt
│       ├── UnitConverterInit.kt
│       └── UnitConverterViews.kt
└── res/
    └── (generated resources)
```

## 🔧 Key Components

### 🏠 MainActivity
The main entry point of the application that sets up the Compose UI with the custom theme.

### 🖼️ UnitConverterViews
Contains all the UI components like `Title`, `UnitsTextField`, `InputBox`, `OutputBox`, `ConvertButton`, `ResultText`, and `DropdownMenuUnitConverter`.

### ⚙️ UnitConverterInit
Hosts the `StartComposable()` function that orchestrates the entire UI and manages state.

## 🛠 Technical Details

### Built With

- Kotlin 1.8.0+
- Android API 21+
- Jetpack Compose (Material3)

### Dependencies

```
implementation 'androidx.compose.material3:material3'
implementation 'androidx.compose.foundation:foundation'
implementation 'androidx.activity:activity-compose'
implementation 'androidx.compose.ui:ui-tooling-preview'
```

### Conversion Logic

```kotlin
val result = (inputValue * inputFactor / outputFactor * 100.0).roundToInt() / 100.0
```

## 📥 Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/ritinha333/unit-converter-android.git
    cd unit-converter-android
    ```
2. Open in Android Studio
3. Sync and Build:
    ```bash
    ./gradlew build
    ```
4. Run the app on a device or emulator

## 📋 Requirements

| Component       | Minimum      | Recommended     |
|-----------------|--------------|-----------------|
| Android SDK     | API 21       | API 34          |
| Android Studio  | Flamingo     | Latest Stable   |
| Kotlin          | 1.8.0        | Latest          |
| RAM             | 4GB          | 8GB+            |

## 🚀 Usage

1. Launch the app 📱  
2. Enter a numeric value 🔢  
3. Select input and output units ⬇️  
4. Tap "Convert" ✨  
5. View the result 💡  

### Input Validation

⚠️ Toast messages show for:

- Empty input fields
- Non-numeric values
- Invalid characters

## 🎨 Design System

### Color Palette

| Color     | Hex Code | Usage                         |
|-----------|----------|-------------------------------|
| Bordeaux  | #800020  | Primary color, buttons        |
| White     | #FFFFFF  | Text on dark backgrounds      |
| Black     | #000000  | Text on light backgrounds     |

### Typography

```kotlin
MaterialTheme.typography.headlineLarge  // Title
MaterialTheme.typography.headlineMedium // Result text
```

## 🤝 Contributing

### Quick Start

1. Fork the repo
2. Create a feature branch:
    ```bash
    git checkout -b feature/AmazingFeature
    ```
3. Commit and push:
    ```bash
    git commit -m 'Add some AmazingFeature'
    git push origin feature/AmazingFeature
    ```
4. Open a Pull Request

### Code Style Guidelines

✅ Follow Kotlin conventions  
✅ Use meaningful names  
✅ Add comments for complex logic  
✅ Maintain formatting  
✅ Write tests

### Labels

| Type          | Label         |
|---------------|---------------|
| 🐛 Bug Fix     | `bug`         |
| ✨ Feature     | `enhancement` |
| 📚 Documentation | `documentation` |
| 🔧 Maintenance | `maintenance` |

## 🔮 Future Enhancements

- **More Unit Categories**: Weight, Temperature, Volume, Area
- **User Experience**: History, Favorites, Voice input, Haptics
- **Accessibility**: Dark mode, Screen reader, Multi-language
- **Advanced Features**: Scientific notation, Widgets, Export

## 🐛 Known Issues

- Minor UI glitch on small screens
- Occasional toast overlap with keyboard

## 📊 Performance

| Metric         | Value      |
|----------------|------------|
| App Size       | < 5MB      |
| Startup Time   | < 2s       |
| Memory Usage   | < 50MB     |
| Min Android    | API 21     |

## 🧪 Testing

```bash
# Unit tests
./gradlew test

# UI tests
./gradlew connectedAndroidTest

# All tests
./gradlew check
```

## 📄 License

This project is licensed under the MIT License - see the LICENSE file.

## 🙏 Acknowledgments

Thanks to:

- 🚀 Android Team for Jetpack Compose
- 🎨 Material Design for UI
- 👥 Kotlin Team for the language
- 🌟 Open Source Community

## 📞 Contact & Support

| Platform | Link                  |
|----------|-----------------------|
| 📧 Email | rita.alexandra.monteiro3@gmail.com |
| 🐙 GitHub | @ritinha333         |
| 💼 LinkedIn | Rita Monteiro            |

---

<div align="center">
Made with ❤️ in Kotlin  
⭐ If you found this project helpful, please give it a star! ⭐  
</div>
