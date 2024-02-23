# react-native-gs300-lcd

sub lcd gs300

## Installation

```sh
npm install react-native-gs300-lcd

or

yarn add react-native-gs300-lcd
```

### Android

Open file `android/settings.gradle` and add the following code:

```gradle
include (':sublcd')
project(':sublcd').projectDir = file('../../android/libs/sublcd')
```



## Usage

```js
import { onText } from 'react-native-gs300-lcd';

// ...

onText('Hello, World!', 80, 'center');
```



## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
