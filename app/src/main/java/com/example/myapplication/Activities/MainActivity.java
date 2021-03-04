package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.myapplication.Fragments.BareExampleFragment;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity
        //implements VCodeScanView.VCodeScanFragmentListener, VCodeImageDecoder.VCodeResultListener, VCodeScanView.VCodeScanImageListener, CameraDecodeListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        open_fragment(getSupportFragmentManager(),R.id.container, BareExampleFragment.newInstance(), "BareExampleFragment");

    }

    public void open_fragment(FragmentManager fragmentManager, int fragmentContainerId, Fragment newFragment, String fragmentName){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.addToBackStack(fragmentName);
        transaction.add(fragmentContainerId, newFragment, fragmentName).commit();
    }

    /*
    @Override
    public void onFoundUTI(@NonNull String s, @NonNull RectF rectF) {
        Log.e("MainActVCode", "onFoundUTI: " + s);
    }

    @Override
    public void gotVCodeResult(byte[] bytes, byte[] bytes1, float[] floats, long l) {
        Log.e("MainActVCode", "gotVCodeResult: ");
    }

    @Override
    public void gotErrorWhileDecoding(Error error) {
        Log.e("MainActVCode", "gotErrorWhileDecoding: " + error.toString());
    }

    @Override
    public void onCompletedScan(@Nullable Error error, @Nullable String s, @Nullable RectF rectF) {
        Log.e("MainActVCode", "onCompletedScan: " + error.toString());
        Log.e("MainActVCode", "onCompletedScan: " + s);
    }

    @Override
    public void onDecodeStarted() {
        Log.e("MainActVCode", "onDecodeStarted: ");
    }

    @Override
    public void onDecodeStopped() {
        Log.e("MainActVCode", "onDecodeStopped: ");
    }

     */
}
