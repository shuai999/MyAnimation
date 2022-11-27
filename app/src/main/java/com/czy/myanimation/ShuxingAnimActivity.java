package com.czy.myanimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

public class ShuxingAnimActivity extends Activity {
    private Button mBtnAnim;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuxinganim);
        mBtnAnim = findViewById(R.id.btnAnim);
        test1();
    }

    /**
     * 让按钮宽度先边宽， 再边窄
     */
    private void test1() {
        // 1. 设置属性数值的初始值和结束值
        ValueAnimator animator = ValueAnimator.ofFloat((float) mBtnAnim.getLayoutParams().width, 500.0F, 200.0F);
        animator.setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 获取每次动画变化后的属性值
                float currentValue = (float) animation.getAnimatedValue();
                // 赋值给 mBtnAnim的 宽度， 就实现了按钮宽度属性的动态变化
                mBtnAnim.getLayoutParams().width = (int) currentValue;
                // 重新绘制，从而实现动画效果
                mBtnAnim.requestLayout();
//                mBtnAnim.invalidate();
            }
        });
        // 启动动画
        animator.start();
    }
}
