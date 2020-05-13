package com.example.ramdantraining.View.QuizApp.Signup;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ramdantraining.R;
import com.example.ramdantraining.View.QuizApp.Signup.Adapter.AvatarAdapter;
import com.example.ramdantraining.shared.Model.UserAvatar;
import com.example.ramdantraining.shared.Util.RecycleViewOnClick;
import com.example.ramdantraining.shared.Util.UtilsValidation;

import java.util.ArrayList;
import java.util.List;

public class SignupFragment extends Fragment implements RecycleViewOnClick {

    NavController navController;
    Button signupBtn;
    private SignupViewModel mViewModel;
    private EditText username_et, email_et;
    private String userName = "";
    private String email_text = "";
    private RecyclerView recyclerView;
    private AvatarAdapter avatarAdapter;
    private List<UserAvatar> userAvatarList = new ArrayList<>();


    public static SignupFragment newInstance() {
        return new SignupFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signup_fragment, container, false);
        recyclerView = view.findViewById(R.id.avatar_rv);
        setData();
        setupRecycleview(userAvatarList);
        return view;
    }

    private void setupRecycleview(List<UserAvatar> userAvatarList) {
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.setHasFixedSize(true);
        avatarAdapter = new AvatarAdapter(userAvatarList, this);
        recyclerView.setAdapter(avatarAdapter);
    }

    private void setData() {
        userAvatarList.add(new UserAvatar( R.drawable.man1));
        userAvatarList.add(new UserAvatar( R.drawable.man2));
        userAvatarList.add(new UserAvatar( R.drawable.man3));
        userAvatarList.add(new UserAvatar(R.drawable.man4));
        userAvatarList.add(new UserAvatar( R.drawable.man5));
        userAvatarList.add(new UserAvatar( R.drawable.man6));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        signupBtn = view.findViewById(R.id.signup_btn);
        username_et = view.findViewById(R.id.username_et);
        email_et = view.findViewById(R.id.email_et);
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
        email_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                UtilsValidation.ValidEmail(email_et, getActivity());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        signupBtn.setOnClickListener(v -> {
            if (getUserName() && getEmail()) {
                Bundle bundle = new Bundle();
                bundle.putString("name", userName);
                bundle.putString("email", email_text);
                navController.navigate(R.id.action_signupFragment_to_homeFragment,bundle);
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

    private Boolean getEmail() {
        boolean isValidate = false;
        if (UtilsValidation.ValidEmail(email_et, getActivity())) {
            email_text = email_et.getText().toString();
            isValidate = true;
        }
        return isValidate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SignupViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onItemClick(int position, View v) {
        Toast.makeText(getActivity(), "Select "+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLongClick(int position, View v) {

    }
}
