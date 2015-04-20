package com.example.glowpadexample.test;

import android.app.Instrumentation;
import android.graphics.Point;
import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;
import android.view.MotionEvent;

import com.example.glowpadexample.MainActivity;
import com.example.glowpadexample.R;
import com.fima.glowpadview.GlowPadView;

/**
 * 测试框架其实很大啊，我记一些知道的类：<br>
 * android.test.TouchUtils ViewAsserts类
 *
 * <p>
 * 那些断言函数： assertNotNull 、assertEquals之类的
 * </p>
 * --------------------------<br>
 * <p>
 * 还有关于测试的类中，我想知道AndroidTestCase是怎么用的？从我的感觉里，
 * 难到只有继承ActivityInstrumentationTestCase2的因为其带activity,才可以测一些UI?
 * AndroidTestCase这个类只用来测一些逻辑?
 * </p>
 * 不过好像有这么说的intrumentationTestCase与AndroidTestCase是面向两种不同的方向的
 *
 */
public class MainActivityInstrumentationTest extends
        ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity;
    private Instrumentation mInstr;
    private GlowPadView mGlowPadView;

    public MainActivityInstrumentationTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
        mInstr = getInstrumentation();
        mGlowPadView = (GlowPadView) mActivity.findViewById(R.id.glow_pad_view);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    // public void testClick() {
    // // 上边这种performClick不管用..
    // // mGlowPadView.performClick();
    // // 这个TouchUtils是管用的
    // TouchUtils.clickView(this, mGlowPadView);
    // }
    //
    // public void testDrag() {
    // TouchUtils.drag(this, 240, 480, 500, 500, 10);
    // TouchUtils.dragViewToTop(this, mGlowPadView);
    // // 这个走了么？
    // TouchUtils.dragViewTo(this, mGlowPadView, Gravity.BOTTOM, 240, 768);
    // }
    //
    // public void testTap() {
    // TouchUtils.tapView(this, mGlowPadView);
    // }

    /**
     * 用来模拟一个MotionEvent,照这个例子来的：
     * http://blog.softteco.com/2011/02/touch-hold-swipe-release-gesture.html<br>
     * http://stackoverflow.com/questions/4396059/how-to-simulate-a-touch-event-
     * in-android<br>
     * http://blog.csdn.net/jazywoo123/article/details/8656970<br>
     * <br>
     * metaState写成0,eventTime比downTime晚了100ms之类的
     */
    public void testMotionEvent() {
        // 这个obtain函数很多参数啊..
        long downTime = SystemClock.uptimeMillis();
        long eventTime = downTime + 100;
        Point ptr = new Point(250, 500);
        int metaState = 0;
        MotionEvent ev = MotionEvent.obtain(downTime, eventTime,
                MotionEvent.ACTION_DOWN, ptr.x, ptr.y, metaState);
        mInstr.sendPointerSync(ev);
        ev.recycle();
    }
    // public void test() {
    // 想试一下那些东西,但不知道怎么试
    // Send string input value
    // getInstrumentation().runOnMainSync(new Runnable() {
    // @Override
    // public void run() {
    // senderMessageEditText.requestFocus();
    // }
    // });
    // getInstrumentation().waitForIdleSync();
    // getInstrumentation().sendStringSync("Hello Android!");
    // getInstrumentation().waitForIdleSync();
    // }
}
