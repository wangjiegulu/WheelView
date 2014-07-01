package com.wangjie.wheelview.sample;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.wangjie.androidbucket.log.Logger;
import com.wangjie.androidinject.annotation.annotations.base.AIClick;
import com.wangjie.androidinject.annotation.annotations.base.AILayout;
import com.wangjie.androidinject.annotation.annotations.base.AIView;
import com.wangjie.androidinject.annotation.present.AIActivity;
import com.wangjie.wheelview.R;
import com.wangjie.wheelview.WheelView;

import java.util.Arrays;

@AILayout(R.layout.main)
public class MainActivity extends AIActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    private static final String[] PLANETS = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Uranus", "Neptune", "Pluto"};

    @AIView(R.id.main_wv)
    private WheelView wva;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        wva.setOffset(1);
        wva.setItems(Arrays.asList(PLANETS));
        wva.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                Logger.d(TAG, "selectedIndex: " + selectedIndex + ", item: " + item);
            }
        });


    }

    @AIClick({R.id.main_show_dialog_btn})
    public void onClickCallbackSample(View view) {
        switch (view.getId()) {
            case R.id.main_show_dialog_btn:
                View outerView = LayoutInflater.from(context).inflate(R.layout.wheel_view, null);
                WheelView wv = (WheelView) outerView.findViewById(R.id.wheel_view_wv);
                wv.setOffset(2);
                wv.setItems(Arrays.asList(PLANETS));
                wv.setSeletion(3);
                wv.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
                    @Override
                    public void onSelected(int selectedIndex, String item) {
                        Logger.d(TAG, "[Dialog]selectedIndex: " + selectedIndex + ", item: " + item);
                    }
                });

                new AlertDialog.Builder(context)
                        .setTitle("WheelView in Dialog")
                        .setView(outerView)
                        .setPositiveButton("OK", null)
                        .show();

                break;
        }
    }


}
