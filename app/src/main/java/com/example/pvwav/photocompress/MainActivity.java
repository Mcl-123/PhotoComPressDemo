package com.example.pvwav.photocompress;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

//        Glide.with(this).load(R.drawable.cat).into(imageView);
//        loadResImage(imageView);
//        getDeviceMaxMemory();
    }

    private void loadResImage(ImageView imageView) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat, options);
        //Bitmap bitmap = BitmapFactory.decodeFile("mnt/sdcard/weixin.png", options);
        imageView.setImageBitmap(bitmap);
        Log.i("====", "bitmap：ByteCount = " + bitmap.getByteCount() + ":::bitmap：AllocationByteCount = " + bitmap.getAllocationByteCount());
        Log.i("====", "width:" + bitmap.getWidth() + ":::height:" + bitmap.getHeight());
        Log.i("====", "inDensity:" + options.inDensity + ":::inTargetDensity:" + options.inTargetDensity);
        Log.i("====", "imageview.width:" + imageView.getWidth() + ":::imageview.height:" + imageView.getHeight());
//                                      mdpi           xxhdpi      xxxhdpi
//        ByteCount:                    29380608      3264512     1837056
//        bitmap：AllocationByteCount:  29380608      3264512     1837056
//        width:                        3072          1024        768
//        height:                       2391          797         598
//        inDensity:                    160           480         640
//        inTargetDensity:              480
    }

    private void getDeviceMaxMemory() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        Log.d("====", "Max memory is: " + maxMemory + "KB");
    }
}
