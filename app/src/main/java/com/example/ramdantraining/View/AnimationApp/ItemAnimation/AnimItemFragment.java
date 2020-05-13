package com.example.ramdantraining.View.AnimationApp.ItemAnimation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ramdantraining.R;
import com.example.ramdantraining.View.AnimationApp.Shimmer.ShimmerAdapter;
import com.example.ramdantraining.shared.Model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class AnimItemFragment extends Fragment {
    RecyclerView shimmer_rv;
    ItemAdapter itemAdapter;
    private List<UserModel> userModels = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anim_item, container, false);
        shimmer_rv = view.findViewById(R.id.item_rv);
        setData();
        setupRecycleview(userModels);
        return view;
    }

    private void setupRecycleview(List<UserModel> userModels) {
        shimmer_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getActivity(), resId);
        shimmer_rv.setLayoutAnimation(animation);
        shimmer_rv.setHasFixedSize(true);
        itemAdapter = new ItemAdapter(userModels);
        shimmer_rv.setAdapter(itemAdapter);
    }

    private void setData() {
        userModels.add(new UserModel("Ahmed Salah", R.drawable.man1, "How To Use Shimmer?", "-- test1"));
        userModels.add(new UserModel("Ahmed Salah", R.drawable.man2, "How To Use Shimmer?", "-- test2"));
        userModels.add(new UserModel("Ahmed Salah", R.drawable.man3, "How To Use Shimmer?", "-- test3"));
        userModels.add(new UserModel("Ahmed Salah", R.drawable.man4, "How To Use Shimmer?", "-- test4"));
        userModels.add(new UserModel("Ahmed Salah", R.drawable.man5, "How To Use Shimmer?", "-- test5"));
        userModels.add(new UserModel("Ahmed Salah", R.drawable.man6, "How To Use Shimmer?", "-- test6"));
        userModels.add(new UserModel("Ahmed Salah", R.drawable.man7, "How To Use Shimmer?", "-- test7"));
        userModels.add(new UserModel("Ahmed Salah", R.drawable.man8, "How To Use Shimmer?", "-- test8"));
        userModels.add(new UserModel("Ahmed Salah", R.drawable.woman1, "How To Use Shimmer?", "-- test9"));
        userModels.add(new UserModel("Ahmed Salah", R.drawable.woman2, "How To Use Shimmer?", "-- test10"));
        userModels.add(new UserModel("Ahmed Salah", R.drawable.woman3, "How To Use Shimmer?", "-- test11"));
    }
}
