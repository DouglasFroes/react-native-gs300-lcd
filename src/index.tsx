import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-gs300-lcd' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const Gs300Lcd = NativeModules.Gs300Lcd
  ? NativeModules.Gs300Lcd
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function multiply(a: number, b: number): Promise<number> {
  return Gs300Lcd.multiply(a, b);
}
