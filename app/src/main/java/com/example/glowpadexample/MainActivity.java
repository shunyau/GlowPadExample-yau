package com.example.glowpadexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fima.glowpadview.GlowPadView;
import com.fima.glowpadview.OnTriggerListener;

public class MainActivity extends Activity implements
 OnTriggerListener {

    private GlowPadView mGlowPadView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGlowPadView = (GlowPadView) findViewById(R.id.glow_pad_view);
        mGlowPadView.setOnTriggerListener(this);
        mGlowPadView.setShowTargetsOnIdle(true);
    }

    @Override
    public void onTrigger(View v, int target) {
        Utils.footPrint();
        final int resId = mGlowPadView.getResourceIdForTarget(target);
        switch (resId) {
        case R.drawable.ic_item_camera:
            Toast.makeText(this, "Camera selected", Toast.LENGTH_SHORT).show();
            break;

        case R.drawable.ic_item_google:
            Toast.makeText(this, "Google selected", Toast.LENGTH_SHORT).show();
            break;

        case R.drawable.ic_item_facebook:
            Toast.makeText(this, "Facebook selected", Toast.LENGTH_SHORT).show();
            break;
        case R.drawable.ic_item_lock:
             Toast.makeText(this, "Lock selected", Toast.LENGTH_SHORT).show();
             break;
        default:
            // Code should never reach here.
        }
    }

    @Override
    public void onReleased(View v, int handle) {
        mGlowPadView.ping();
        Utils.footPrint();
    }

    @Override
    public void onGrabbed(View v, int handle) {
        Utils.footPrint();
    }

    @Override
    public void onGrabbedStateChange(View v, int handle) {
        Utils.footPrint();
    }

    @Override
    public void onFinishFinalAnimation() {
        Utils.footPrint();
    }
}
