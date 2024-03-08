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

export function onInitGS00LCD() {
  Gs300Lcd.onInit();
}

export function onText(
  i: string,
  size: number,
  align: 'left' | 'center' | 'right'
) {
  Gs300Lcd.onText(i, size, align);
}

export function onQrCode(i: string) {
  Gs300Lcd.onQrCode(i);
}

export function onLight() {
  Gs300Lcd.onLight();
}

export function onOffLight() {
  Gs300Lcd.onOffLight();
}

export function onImageUrl(url: string) {
  Gs300Lcd.onImageUrl(url);
}

export function onImageBase64(base64: string) {
  Gs300Lcd.onImageBase64(base64);
}

export function onImagePath(path: string) {
  Gs300Lcd.onImagePath(path);
}
