package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by Pawan khandal on 10/18/18,57
 */
class Emojifier {
    private final static String TAG = Emojifier.class.getSimpleName();
    static void detectFaces(Context context, Bitmap bitmap){
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();
        SparseArray<com.google.android.gms.vision.face.Face> faces = detector.detect(frame);
    
        Log.d(TAG, "detectFaces: no of faces "+faces.size());
    
        if (faces.size() == 0) {
            Toast.makeText(context, "No face Detected", Toast.LENGTH_SHORT).show();
        }
        detector.release();
    }
}
