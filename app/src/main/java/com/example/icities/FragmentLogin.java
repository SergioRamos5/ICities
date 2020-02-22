package com.example.icities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputEditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FragmentLogin extends Fragment {

    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseAuth mAuth;
    Button btLogIn, btSignUp;
    TextInputEditText user, password;

    public FragmentLogin() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login_layout, container, false);


        mAuth = FirebaseAuth.getInstance();

        user = v.findViewById(R.id.editTextUser);
        password = v.findViewById(R.id.editTextPassword);
        btLogIn = v.findViewById(R.id.btLogIn);
        btSignUp = v.findViewById(R.id.btSignUp);


        mAuthListener = firebaseAuth -> {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {
                Toast.makeText(getActivity(), user.getEmail() + " LOGUEADO", Toast.LENGTH_LONG).show();
                mAuth = firebaseAuth;
            } else
                Toast.makeText(getActivity(), "Usuario NULO", Toast.LENGTH_LONG).show();
        };

        btLogIn.setOnClickListener(view -> mAuth.signInWithEmailAndPassword(user.getText().toString(), password.getText().toString())
                .addOnCompleteListener(getActivity(), task -> {
                    if (!task.isSuccessful()) {
                        Toast.makeText(getActivity(), "Authentication failed:" + task.getException(), Toast.LENGTH_SHORT).show();
                    } else {
                        FragmentTabs();
                    }
                }));

        btSignUp.setOnClickListener(view -> mAuth.createUserWithEmailAndPassword(user.getText().toString(), password.getText().toString())
                .addOnCompleteListener(getActivity(), task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(getActivity(), "Usuario creado", Toast.LENGTH_SHORT).show();
                        FragmentTabs();
                    } else
                        Toast.makeText(getActivity(), "Problemas al crear usuario" + task.getException(), Toast.LENGTH_LONG).show();
                }));


        return v;
    }

    private void FragmentTabs() {
        FragmentManager FM = getActivity().getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        Fragment fragment = new FragmentTabs();
        FT.replace(R.id.fragment_container, fragment);
        FT.commit();
    }

}
