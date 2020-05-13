package com.example.ramdantraining.View.QuizApp.Quiz;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.ramdantraining.R;

public class QuizFragment extends Fragment {

    private Button first_quiz_btn, sec_quiz_btn, third_quiz_btn, four_quiz_btn;
    private QuizViewModel mViewModel;
    private NavController navController;
    private Handler handler;
    private Runnable runnable;
    private int DELAYTIME =2000;

    public static QuizFragment newInstance() {
        return new QuizFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quiz_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        first_quiz_btn = view.findViewById(R.id.first_quiz_btn);
        sec_quiz_btn = view.findViewById(R.id.sec_quiz_btn);
        third_quiz_btn = view.findViewById(R.id.third_quiz_btn);
        four_quiz_btn = view.findViewById(R.id.four_quiz_btn);

        first_quiz_btn.setOnClickListener(v -> {
            enableButton(first_quiz_btn, sec_quiz_btn, third_quiz_btn, four_quiz_btn);
            changeButtonStyle(first_quiz_btn, R.color.GreenColor, R.color.WhiteColor);
            handler = new Handler();
            runnable = () -> {
                navController.navigate(R.id.action_quizFragment_to_congratsFragment);

            };
            handler.postDelayed(runnable, DELAYTIME);
        });
        sec_quiz_btn.setOnClickListener(v -> {
            changeButtonStyle(sec_quiz_btn, R.color.RedColor, R.color.WhiteColor);
            enableButton(sec_quiz_btn, first_quiz_btn, third_quiz_btn, four_quiz_btn);
            handler = new Handler();
            runnable = () -> {
                navController.navigate(R.id.action_quizFragment_to_gameOverFragment);

            };
            handler.postDelayed(runnable, DELAYTIME);
        });
        third_quiz_btn.setOnClickListener(v -> {
            enableButton(third_quiz_btn, first_quiz_btn, sec_quiz_btn, four_quiz_btn);
            changeButtonStyle(third_quiz_btn, R.color.RedColor, R.color.WhiteColor);
            handler = new Handler();
            runnable = () -> {
                navController.navigate(R.id.action_quizFragment_to_gameOverFragment);

            };
            handler.postDelayed(runnable, DELAYTIME);
        });
        four_quiz_btn.setOnClickListener(v -> {
            enableButton(four_quiz_btn, first_quiz_btn, sec_quiz_btn, third_quiz_btn);
            changeButtonStyle(four_quiz_btn, R.color.RedColor, R.color.WhiteColor);
            handler = new Handler();
            runnable = () -> {
                navController.navigate(R.id.action_quizFragment_to_gameOverFragment);

            };
            handler.postDelayed(runnable, DELAYTIME);
        });
    }

    private void enableButton(Button enableBtn, Button disableBtn, Button disableBtn2, Button disableBtn3) {
        enableBtn.setEnabled(true);
        disableBtn.setEnabled(false);
        disableBtn2.setEnabled(false);
        disableBtn3.setEnabled(false);
    }

    private void changeButtonStyle(Button button, int colorID, int textColor) {
        button.setBackgroundTintList(ContextCompat.getColorStateList(getActivity(), colorID));
        button.setTextColor(getResources().getColor(textColor));

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(QuizViewModel.class);
        // TODO: Use the ViewModel
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
