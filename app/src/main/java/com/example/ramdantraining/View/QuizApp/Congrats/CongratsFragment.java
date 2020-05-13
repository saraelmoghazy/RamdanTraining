package com.example.ramdantraining.View.QuizApp.Congrats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.ramdantraining.R;

public class CongratsFragment extends Fragment {

    private CongratsViewModel mViewModel;
    private NavController navController;
    private Button try_again_btn,back_btn;
    private TextView leader_tv;

    public static CongratsFragment newInstance() {
        return new CongratsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.congrats_fragment, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        leader_tv = view.findViewById(R.id.leader_tv);
        leader_tv.setOnClickListener(v ->
                navController.navigate(R.id.action_congratsFragment_to_leaderBoardFragment));
        try_again_btn = view.findViewById(R.id.try_again_btn);
        try_again_btn.setOnClickListener(v ->
                navController.navigate(R.id.action_congratsFragment_to_matchFragment));
        back_btn = view.findViewById(R.id.back_btn);
        back_btn.setOnClickListener(v ->
                navController.navigate(R.id.action_congratsFragment_to_homeFragment));

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CongratsViewModel.class);
        // TODO: Use the ViewModel
    }

}
