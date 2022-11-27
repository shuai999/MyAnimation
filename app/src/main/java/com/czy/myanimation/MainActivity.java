package com.czy.myanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.imageView);
        testAlpha();
        testRotate();
        testScale();
        testTranslate();
    }

    /**
     * 平移动画
     */
    private void testTranslate() {
        Animation animation = new TranslateAnimation(0, 100, 0, 120);
        animation.setDuration(3000);
        // 动画执行完后保持当前位置
        animation.setFillAfter(true);
        mImageView.startAnimation(animation);
    }

    /**
     * 缩放动画
     */
    private void testScale() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F);
        scaleAnimation.setDuration(3000);
        scaleAnimation.setFillAfter(true);
        mImageView.startAnimation(scaleAnimation);
    }

    /**
     * 旋转动画
     */
    private void testRotate() {
        Animation animation = new RotateAnimation(0, 45);
        animation.setDuration(5000);
        // 动画执行完后保持当前位置
        animation.setFillAfter(true);
        mImageView.startAnimation(animation);
    }

    /**
     * 淡入淡出动画
     */
    private void testAlpha() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.1F);
        alphaAnimation.setDuration(3000);
        // 动画播放完成后保持当前位置
        alphaAnimation.setFillAfter(true);
        mImageView.startAnimation(alphaAnimation);
    }
}