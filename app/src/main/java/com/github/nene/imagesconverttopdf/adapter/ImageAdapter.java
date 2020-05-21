package com.github.nene.imagesconverttopdf.adapter;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Intent intent;
    private List<Bitmap> bitmaps;
    private static final String IMAGE_ADAPTER = "ImageAdapter";

    public ImageAdapter(Context c, Intent data) {
        bitmaps = new ArrayList<>();
        mContext = c;
        intent = data;
        imagesBitmap();
    }

    public int getCount() {
        return bitmaps.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8, 8, 8, 8);
        imageView.setImageBitmap(bitmaps.get(position));
        return imageView;
    }

    private void imagesBitmap() {
        ClipData clipData = intent.getClipData();
        if (clipData != null) {
            for (int i = 0, n = clipData.getItemCount(); i < n; i++) {
                Uri fileUri = clipData.getItemAt(i).getUri();
                try {
                    bitmaps.add(convertUriToBitmap(fileUri));
                } catch (FileNotFoundException e) {
                    Log.e(IMAGE_ADAPTER, e.getStackTrace().toString());
                }
            }
        } else {
            Uri fileUri = intent.getData();
            try {
                bitmaps.add(convertUriToBitmap(fileUri));
            } catch (
                    FileNotFoundException e) {
                Log.e(IMAGE_ADAPTER, e.getStackTrace().toString());
            }
        }
    }

    private Bitmap convertUriToBitmap(Uri filePath) throws FileNotFoundException {
        Bitmap bitmap;
        try {
            InputStream stream = mContext.getContentResolver().openInputStream(filePath);
            bitmap = BitmapFactory.decodeStream(stream);
            return bitmap;
        } catch (FileNotFoundException exp) {

            throw exp;

        }
    }
}