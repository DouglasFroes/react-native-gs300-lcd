package com.gs300lcd;

import android.os.AsyncTask;
import com.android.sublcdlibrary.SubLcdHelper;
import com.android.sublcdlibrary.SubLcdException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

class LoadImage extends AsyncTask<String, Void, Bitmap> {
  @Override
  protected Bitmap doInBackground(String... params) {
    final String image64 = params[0];

    try {
      final byte[] decodedString = Base64.decode(image64, Base64.DEFAULT);
      Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

      return decodedByte;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  protected void onPostExecute(Bitmap bitmap) {
    if (bitmap != null) {
      try {
        SubLcdHelper.getInstance().sendBitmap(
          SubLcdHelper.getInstance().doRotateBitmap(bitmap, 90)
        );
      }catch(SubLcdException  e){
        e.printStackTrace();
      }
    }
  }
}
