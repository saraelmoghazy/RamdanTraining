package com.example.ramdantraining.View.AnimationApp.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.ramdantraining.R;

public class AnimHomeFragment extends Fragment {

    Button animation_btn, motion_btn, shimmer_btn, item_animation_btn;

    NavController navController;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_anim_home, container, false);

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        animation_btn = view.findViewById(R.id.animation_btn);
        animation_btn.setOnClickListener(v -> navController.navigate(R.id.action_animHomeFragment_to_animShapeFragment));
        motion_btn = view.findViewById(R.id.motion_btn);
        motion_btn.setOnClickListener(v -> navController.navigate(R.id.action_animHomeFragment_to_animMotionFragment));
        shimmer_btn = view.findViewById(R.id.shimmer_btn);
        shimmer_btn.setOnClickListener(v -> navController.navigate(R.id.action_animHomeFragment_to_animShimmerFragment));
        item_animation_btn = view.findViewById(R.id.item_animation_btn);
        item_animation_btn.setOnClickListener(v -> navController.navigate(R.id.action_animHomeFragment_to_animItemFragment));
    }
}
