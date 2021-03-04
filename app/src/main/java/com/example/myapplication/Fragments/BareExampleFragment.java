package com.example.myapplication.Fragments;

import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Activities.FinalActivity;

import uk.co.airsource.android.common.ui.cameraview.DecodeTask;
import uk.co.airsource.android.common.ui.cameraview.interfaces.CameraDecodeListener;
import vcode.vstenterprises.sdk.decoder.VCodeDecodeWorker;
import vcode.vstenterprises.sdk.decoder.VCodeImageDecoder;
import vcode.vstenterprises.sdk.ui.VCodeScanFragment;
import vcode.vstenterprises.sdk.ui.VCodeScanView;


public class BareExampleFragment extends VCodeScanFragment
        implements VCodeScanView.VCodeScanFragmentListener,
        VCodeImageDecoder.VCodeResultListener, VCodeScanView.VCodeScanImageListener, CameraDecodeListener
{

    /*
    VCodeScanFragmentListener vCodeScanFragmentListener;
    VCodeScanImageListener vCodeScanImageListener;
    VCodeImageDecoder.VCodeResultListener vCodeResultListener;
    CameraDecodeListener cameraDecodeListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            vCodeScanFragmentListener = (VCodeScanFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement VCodeScanFragmentListener");
        }
        try {
            vCodeScanImageListener = (VCodeScanImageListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement VCodeScanImageListener");
        }
        try {
            vCodeResultListener = (VCodeImageDecoder.VCodeResultListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement vCodeResultListener");
        }
        try {
            cameraDecodeListener = (CameraDecodeListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement CameraDecodeListener");
        }
    }
     */
    public BareExampleFragment() {
        // Required empty public constructor
    }

    public static BareExampleFragment newInstance() {
        BareExampleFragment fragment = new BareExampleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = super.onCreateView(inflater, container, savedInstanceState);
        this.setListener(this);
        return view;
    }


    /*
    public void onDetach() {
        super.onDetach();
        this.vCodeResultListener = null;
        this.vCodeScanFragmentListener = null;
        this.vCodeScanImageListener = null;
        this.cameraDecodeListener = null;
    }
     */



    @Override
    public void decodeTaskCompleted(DecodeTask<VCodeDecodeWorker> task) {
        super.decodeTaskCompleted(task);
        Log.e("BareFragVcode", "decodeTaskCompleted: ");
        Log.e("BareFragVcode", "task: " + task.getFrameBuffer().toString());
    }



    @Override
    public void onFoundUTI(@NonNull String s, @NonNull RectF rectF) {
        Log.e("BareFragVcode", "onFoundUTI: " + s);


        Intent intent = new Intent(getActivity().getApplicationContext(), FinalActivity.class);
        intent.putExtra("VCODE", s);
        startActivity(intent);


    }

    @Override
    public void gotVCodeResult(byte[] bytes, byte[] bytes1, float[] floats, long l) {
        Log.e("BareFragVcode", "gotVCodeResult: ");
    }

    @Override
    public void gotErrorWhileDecoding(Error error) {
        Log.e("BareFragVcode", "gotErrorWhileDecoding: " + error.toString());
    }

    @Override
    public void onCompletedScan(@Nullable Error error, @Nullable String s, @Nullable RectF rectF) {
        Log.e("BareFragVcode", "onCompletedScan: " + error.toString());
        Log.e("BareFragVcode", "onCompletedScan: " + s);
    }

    @Override
    public void onDecodeStarted() {
        Log.e("BareFragVcode", "onDecodeStarted: ");
    }

    @Override
    public void onDecodeStopped() {
        Log.e("BareFragVcode", "onDecodeStopped: ");
    }

}
