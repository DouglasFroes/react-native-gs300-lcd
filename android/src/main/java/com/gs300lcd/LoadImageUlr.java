package com.gs300lcd;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.squareup.picasso.Picasso;
import com.android.sublcdlibrary.SubLcdHelper;
import com.android.sublcdlibrary.SubLcdException;

class LoadImageUlr extends AsyncTask<String, Void, Bitmap> {
    @Override
    protected Bitmap doInBackground(String... params) {
        final String imageUrl = params[0];

        try {
            return Picasso.get().load(imageUrl).resize(300, 0).get();
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
