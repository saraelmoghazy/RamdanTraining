package com.example.ramdantraining.View.Welcome;

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

public class WelcomeFragment extends Fragment {

    Button signbtn, signupBtn;
    TextView movie_tv;
    private WelcomeViewModel mViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.welcome_fragment, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        signbtn = view.findViewById(R.id.signin_btn);
        signbtn.setOnClickListener(v -> navController.navigate(R.id.action_welcomeFragment_to_loginFragment));
        signupBtn = view.findViewById(R.id.signup_btn);
        signupBtn.setOnClickListener(v -> navController.navigate(R.id.action_welcomeFragment_to_signupFragment));
        movie_tv= view.findViewById(R.id.movie_tv);
        movie_tv.setOnClickListener(v->navController.navigate(R.id.action_welcomeFragment_to_movieFragment));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WelcomeViewModel.class);
        // TODO: Use the ViewModel
    }

}
