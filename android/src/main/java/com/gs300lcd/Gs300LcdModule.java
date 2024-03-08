package com.gs300lcd;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import android.text.Layout;

import com.android.sublcdlibrary.SubLcdHelper;
import com.android.sublcdlibrary.SubLcdException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

@ReactModule(name = Gs300LcdModule.NAME)
public class Gs300LcdModule extends ReactContextBaseJavaModule {
  public static final String NAME = "Gs300Lcd";
  private SubLcdHelper lcd = null;

  public Gs300LcdModule(ReactApplicationContext reactContext) {
    super(reactContext);
    lcd = SubLcdHelper.getInstance();
    lcd.init(reactContext);
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void onText(String message, int size, String align) {
    try{
      if(align.contains("right")){
        lcd.sendText(message,Layout.Alignment.ALIGN_OPPOSITE,size);
      }else if(align.contains("center")){
        lcd.sendText(message,Layout.Alignment.ALIGN_CENTER,size);
      }else{
        lcd.sendText(message,Layout.Alignment.ALIGN_NORMAL,size);
      }
    }catch(SubLcdException e){
      e.printStackTrace();
    }
  }

  @ReactMethod
  public void onQrCode(String message) {
    try{
      lcd.contentToConvertQRCode(message);
    }catch(SubLcdException e){
      e.printStackTrace();
    }
  }

  @ReactMethod
  public void onLight() {
    try{
      lcd.sendBacklightOpen();
    }catch(SubLcdException e){
      e.printStackTrace();
    }
  }

  @ReactMethod
  public void onOffLight() {
    try{
      lcd.sendBacklightClose();
    }catch(SubLcdException e){
      e.printStackTrace();
    }
  }

  @ReactMethod
  public void onImageUrl(String url) {
    new LoadImageUlr().execute(url);
  }

  @ReactMethod
  public void onImageBase64(String image64) {
    final byte[] decodedString = Base64.decode(image64, Base64.DEFAULT);
    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

    try {
      lcd.sendBitmap(
        lcd.doRotateBitmap(decodedByte, 90)
      );
    } catch(SubLcdException  e){
        e.printStackTrace();
    }
  }
}
