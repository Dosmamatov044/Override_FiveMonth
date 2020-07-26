package com.example.override_fivemonthn.presentation.intro;

import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.override_fivemonthn.R;


public class IntroFragment extends Fragment {














    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_intro, container, false);


    }




    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //TODO:Init views
        int position=getArguments().getInt("keyForPosition");
        switch (position){

            //TODO
        }



        //saveIsShown();










    }










//


}
