package com.example.icities;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class FragmentBio extends Fragment {

    private TextView name, surname, telephone;
    private FirebaseAuth mAuth;
    public FragmentBio() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bio, container, false);

        mAuth = FirebaseAuth.getInstance();
        Userdata user = UserDataFromRest.getUser(mAuth.getUid());

        name = v.findViewById(R.id.nameUserBio);
        surname = v.findViewById(R.id.surnameUserBio);
        telephone = v.findViewById(R.id.telephoneUserBio);

        name.setText(user.getUsername());
        surname.setText(user.getUsersurname());
        telephone.setText(user.getUserphone());

        return v;
    }

}
