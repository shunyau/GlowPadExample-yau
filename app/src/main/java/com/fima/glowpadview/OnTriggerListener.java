package com.fima.glowpadview;

import android.view.View;

public interface OnTriggerListener {
    int NO_HANDLE = 0;
    int CENTER_HANDLE = 1;

    public void onGrabbed(View v, int handle);

    public void onReleased(View v, int handle);

    public void onTrigger(View v, int target);

    public void onGrabbedStateChange(View v, int handle);

    public void onFinishFinalAnimation();
}
