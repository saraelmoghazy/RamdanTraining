package com.example.ramdantraining.View.Login;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.ramdantraining.R;
import com.example.ramdantraining.shared.Util.UtilsValidation;

public class LoginFragment extends Fragment {

    private Button signbtn;
    private String userName = "";
    private LoginViewModel mViewModel;
    private NavController navController;
    private EditText username_et, password_et;
    private boolean validationName;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        signbtn = view.findViewById(R.id.signin_btn);
        username_et = view.findViewById(R.id.username_et);
        username_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                UtilsValidation.ValidUserName(username_et, getActivity());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password_et = view.findViewById(R.id.password_et);
        signbtn.setOnClickListener(v -> {
            if (getUserName()) {
                Bundle bundle = new Bundle();
                bundle.putString("name", userName);
                navController.navigate(R.id.action_loginFragment_to_homeFragment, bundle);
            }
        });
    }

    private Boolean getUserName() {
        boolean isValidate = false;
        if (UtilsValidation.ValidUserName(username_et, getActivity())) {
            userName = username_et.getText().toString();
            isValidate = true;
        }
        return isValidate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

    }

}
