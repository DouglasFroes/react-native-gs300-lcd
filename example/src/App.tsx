import * as React from 'react';

import { View, TextInput, Button, StyleSheet } from 'react-native';
import {
  onImageBase64,
  onImageUrl,
  onInitGS00LCD,
  onLight,
  onOffLight,
  onQrCode,
  onText,
} from 'react-native-gs300-lcd';
import { imageBase64 } from './img64';

const url =
  'https://api200167485.s3.sa-east-1.amazonaws.com/demo/https%3A//api200167485.s3.sa-east-1.amazonaws.com/demo/null/1685548208038-icon.png/1692380144108-ic_launcher_round.png';

export default function App() {
  const [msg, setMsg] = React.useState<string>('Test');
  const [font, setFont] = React.useState<string>('80');

  const fontNumber = parseInt(font, 10) < 20 ? 20 : parseInt(font, 10);

  React.useEffect(() => {
    onInitGS00LCD();
  }, []);

  return (
    <View style={styles.container}>
      <TextInput
        style={styles.input}
        value={msg}
        onChangeText={(text) => setMsg(text)}
        placeholder="Mensagem"
        selectionColor="#fff"
        cursorColor="#fff"
        placeholderTextColor="#fff"
      />
      <TextInput
        style={styles.input}
        value={font}
        onChangeText={(text) => setFont(text)}
        placeholder="Font minimum 20"
        selectionColor="#fff"
        cursorColor="#fff"
        placeholderTextColor="#fff"
        keyboardType="numeric"
      />

      <Button
        title="Texto center"
        onPress={() => onText(`\n\n${msg}`, fontNumber, 'center')}
      />
      <Button
        title="Texto left"
        onPress={() => onText(msg, fontNumber, 'left')}
      />
      <Button
        title="Texto right"
        onPress={() => onText(msg, fontNumber, 'right')}
      />
      <Button title="IMG URL" onPress={() => onImageUrl(url)} />
      <Button title="IMG BASE64" onPress={() => onImageBase64(imageBase64)} />

      <Button title="QRCode Text" onPress={() => onQrCode(msg)} />
      <Button title="ON LCD" onPress={() => onLight()} />
      <Button title="OFF LCD" onPress={() => onOffLight()} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  input: {
    height: 40,
    margin: 12,
    borderWidth: 1,
  },
});
