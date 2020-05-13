package com.example.ramdantraining.View.QuizApp.GameOver;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.ramdantraining.R;

public class GameOverFragment extends Fragment {

    private GameOverViewModel mViewModel;
    private NavController navController;
    private Button try_again_btn, back_btn;

    public static GameOverFragment newInstance() {
        return new GameOverFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_over_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        try_again_btn = view.findViewById(R.id.try_again_btn);
        try_again_btn.setOnClickListener(v -> navController.navigate(R.id.action_gameOverFragment_to_matchFragment));
        back_btn = view.findViewById(R.id.back_btn);
        back_btn.setOnClickListener(v -> navController.navigate(R.id.action_gameOverFragment_to_homeFragment));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(GameOverViewModel.class);
        // TODO: Use the ViewModel
    }

}
