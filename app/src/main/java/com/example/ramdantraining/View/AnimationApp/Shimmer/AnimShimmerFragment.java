package com.example.ramdantraining.View.AnimationApp.Shimmer;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ramdantraining.R;
import com.example.ramdantraining.shared.Model.UserModel;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

public class AnimShimmerFragment extends Fragment {

    ShimmerFrameLayout shimmer_view_container;
    RecyclerView shimmer_rv;
    ShimmerAdapter shimmerAdapter;
    private List<UserModel> userModels = new ArrayList<>();
    private Handler handler;
    private Runnable runnable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anim_shimmer, container, false);
        shimmer_rv = view.findViewById(R.id.shimmer_rv);
        setData();
        setupRecycleview(userModels);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ShimmerFrameLayout container = view.findViewById(R.id.shimmer_view_container);
        container.startShimmer(); // If auto-start is set to false

        handler = new Handler();
        runnable = () -> {
            container.stopShimmer();
            container.setVisibility(View.GONE);
            shimmer_rv.setVisibility(View.VISIBLE);
        };

        handler.postDelayed(runnable, 3000);
    }


    private void setupRecycleview(List<UserModel> userModels) {
        shimmer_rv.setItemAnimator(new DefaultItemAnimator());
        shimmer_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        shimmer_rv.setHasFixedSize(true);
        shimmerAdapter = new ShimmerAdapter(userModels);
        shimmer_rv.setAdapter(shimmerAdapter);
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

}
