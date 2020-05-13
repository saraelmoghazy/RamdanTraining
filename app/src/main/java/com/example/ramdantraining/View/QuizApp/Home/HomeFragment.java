package com.example.ramdantraining.View.QuizApp.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.ramdantraining.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class HomeFragment extends Fragment {

    private TextView toLeaderTv, name_tv;
    private Button playBtn;
    private NavController navController;
    private String email_text = "";
    private HomeViewModel mViewModel;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                new MaterialAlertDialogBuilder(getActivity())
                        .setTitle("Exit?")
                        .setMessage("Are you sure want to exit?")
                        .setPositiveButton("Yes", (dialog, which) -> navController.navigate(R.id.action_homeFragment_to_welcomeFragment))
                        .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                        .show();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getActivity(), onBackPressedCallback);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        name_tv = view.findViewById(R.id.name_tv);
        name_tv.setText(getArguments().getString("name"));
        email_text = getArguments().getString("email");
//        Toast.makeText(getActivity(), "" + email_text, Toast.LENGTH_SHORT).show();
        playBtn = view.findViewById(R.id.play_btn);
        playBtn.setOnClickListener(v -> {
            String name = name_tv.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            navController.navigate(R.id.action_homeFragment_to_matchFragment, bundle);
        });
        toLeaderTv = view.findViewById(R.id.leader_tv);
        toLeaderTv.setOnClickListener(v -> navController.navigate(R.id.action_homeFragment_to_leaderBoardFragment));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }

}
