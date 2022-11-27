package com.czy.myanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * ObjectAnimator属性动画实现 补间动画：
 *      作用于view对象上，如button。 实现 平移、缩放、透明、旋转
 */
public class AnimationActivity  extends AppCompatActivity {
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        mImageView = (ImageView) findViewById(R.id.image);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAlpha:
                setAlpha(view);
                break;
            case R.id.btnAnimatorSet:
                setAnimation(view);
                break;
            case R.id.btnRotationy:
                setRotation(view);
                break;
            case R.id.btnScalex:
                setScalex(view);
                break;
            case R.id.btnTranslation:
                setTranslation(view);
                break;
            default:
                break;
        }
    }

    //设置透明动画 —— 淡入淡出动画
    private void setAlpha(View view) {
        //ofFloat:此方法是设置透明度
        ObjectAnimator alpha = ObjectAnimator.ofFloat(mImageView, "alpha",
            new float[]{0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f});
        //设置动画时长
        alpha.setDuration(3000);
        alpha.addListener(new AnimatorListenerAdapter() {
            // 取消动画
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            // 动画结束
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }

            // 重复动画
            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            // 动画开始
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            // 动画暂停
            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
            }
        });
        //设置执行的模式
        alpha.setRepeatMode(ObjectAnimator.RESTART);
        //设置动画执行的次数
        alpha.setRepeatCount(1);
        //开启动画
        alpha.start();
    }

    //设置旋转动画
    private void setRotation(View view) {
        // rotation: 沿X和Y都旋转；
        // rotationX: 沿X轴旋转, rotationY:沿Y轴旋转
        ObjectAnimator rotation = ObjectAnimator.ofFloat(mImageView, "rotationY",
            new float[]{90f, 180f, 270f, 360f});
        rotation.setDuration(3000);
        rotation.setRepeatCount(2);
        rotation.setRepeatMode(ObjectAnimator.RESTART);
        rotation.start();
    }

    //设置平移动画
    private void setTranslation(View view) {
        // translation：平移动画， X和Y都平移
        // translationX: x轴平移
        // translationY: y轴平移
        ObjectAnimator translation = ObjectAnimator.ofFloat(mImageView, "translationY",
            new float[]{10f, 30f, 50f, 100f});
        translation.setDuration(3000);
        translation.setRepeatMode(ObjectAnimator.RESTART);
        translation.setRepeatCount(2);
        // 设置插值器
        translation.setInterpolator(new OvershootInterpolator());
        translation.start();
    }

    //设置缩放动画
    private void setScalex(View view) {
        // scale：沿着X和Y缩放
        //scaleX:沿X轴缩放  scaleY:沿Y轴缩放
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mImageView, "scaleY",
            new float[]{1f, 2f, 3f, 4f, 5f, 6f, 7f, 1f});
        scaleX.setDuration(3000);
        scaleX.setRepeatCount(2);
        scaleX.setRepeatMode(ObjectAnimator.RESTART);
        scaleX.start();
    }

    //动画集合
    private void setAnimation(View view) {
        AnimatorSet animatorSet=new AnimatorSet();
        //ofFloat:此方法是设置透明度
        ObjectAnimator alpha = ObjectAnimator.ofFloat(mImageView, "alpha",
            new float[]{0.0f, 0.2f, 0.4f, 0.6f, 0.8f, 1.0f});
        //设置动画时长
        alpha.setDuration(3000);
        //设置执行的模式
        alpha.setRepeatMode(ObjectAnimator.RESTART);
        //设置动画执行的次数
        alpha.setRepeatCount(1);
        //开启动画
        alpha.start();

        //rotation: 可以设置:rotationX:沿X轴旋转, rotationY:沿Y轴旋转
        ObjectAnimator rotation = ObjectAnimator.ofFloat(mImageView, "rotationY",
            new float[]{90f, 180f, 270f, 360f});
        rotation.setDuration(3000);
        rotation.setRepeatCount(2);
        rotation.setRepeatMode(ObjectAnimator.RESTART);
        rotation.start();

        ObjectAnimator translation = ObjectAnimator.ofFloat(mImageView, "translationY",
            new float[]{10f, 30f, 50f, 300f});
        translation.setDuration(3000);
        translation.setRepeatMode(ObjectAnimator.RESTART);
        translation.setRepeatCount(2);
        translation.start();

        //可以指定 scaleX:沿X轴缩放  scaleY:沿Y轴缩放
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mImageView, "scaleY",
            new float[]{1f, 2f, 3f, 4f, 5f, 6f, 7f, 1f});
        scaleX.setDuration(3000);
        scaleX.setRepeatCount(2);
        scaleX.setRepeatMode(ObjectAnimator.RESTART);
        scaleX.start();

        animatorSet.playTogether(alpha,translation,scaleX,rotation);
    }
}