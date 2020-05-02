package com.example.ramdantraining.shared.Util;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;


import com.example.ramdantraining.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilsValidation {

    public static boolean ValidEmail(TextView mEmail, Context context) {
        String valid_email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{3,5})$";
        Matcher matcher_email = Pattern.compile(valid_email).matcher(mEmail.getText().toString().toLowerCase());
        if (matcher_email.matches()) {
            return true;
        } else {
            mEmail.setError(context.getResources().getString(R.string.invalidEmail));
            mEmail.requestFocus();
            return false;
        }
    }
    public static boolean ValidUserName(TextView mUserName, Context context) {
        String validName = "([a-zA-Z]{2,30})";
        String mName = mUserName.getText().toString().toLowerCase();
        Matcher matcher_phone = Pattern.compile(validName).matcher(mName);
        if (matcher_phone.matches()) {
            return true;
        } else {
            mUserName.setError(context.getResources().getString(R.string.invalidName));
            mUserName.requestFocus();
            return false;
        }
    }
}
