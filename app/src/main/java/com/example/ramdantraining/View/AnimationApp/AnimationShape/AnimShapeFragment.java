package com.example.ramdantraining.View.AnimationApp.AnimationShape;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ramdantraining.R;

public class AnimShapeFragment extends Fragment {

    Button rotate_btn, scale_btn, color_btn, fade_btn, translate_btn;
    ImageView android_img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_anim_shape, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        android_img = view.findViewById(R.id.android_img);

        rotate_btn = view.findViewById(R.id.rotate_btn);
        rotate_btn.setOnClickListener(v -> rotater());

        translate_btn = view.findViewById(R.id.translate_btn);
        translate_btn.setOnClickListener(v -> translater());

        scale_btn = view.findViewById(R.id.scale_btn);
        scale_btn.setOnClickListener(v -> scaler());

        color_btn = view.findViewById(R.id.color_btn);
        color_btn.setOnClickListener(v -> colorizer());

        fade_btn = view.findViewById(R.id.fade_btn);
        fade_btn.setOnClickListener(v -> fader());

    }

    private void colorizer() {
        ObjectAnimator animator = ObjectAnimator.ofArgb(android_img,"backgroundColor", Color.BLACK, Color.RED);
        animator.setDuration(500);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                color_btn.setEnabled(false);

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                color_btn.setEnabled(true);

            }
        });
        animator.start();
    }

    private void fader() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(android_img, View.ALPHA, 0f);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                fade_btn.setEnabled(false);

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                fade_btn.setEnabled(true);

            }
        });
        animator.start();
    }

    private void scaler() {
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 4f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 4f);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(
                android_img, scaleX, scaleY);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                scale_btn.setEnabled(false);

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                scale_btn.setEnabled(true);

            }
        });
        animator.start();
    }

    private void translater() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(android_img, View.TRANSLATION_X,
                200f);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                translate_btn.setEnabled(false);

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                translate_btn.setEnabled(true);

            }
        });
        animator.start();
    }

    private void rotater() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(android_img, View.ROTATION, -360f, 0f);
        animator.setDuration(1000);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                rotate_btn.setEnabled(false);

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                rotate_btn.setEnabled(true);

            }
        });
        animator.start();
    }

}
