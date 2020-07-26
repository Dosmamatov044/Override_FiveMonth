package com.example.override_fivemonthn.Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.override_fivemonthn.App;
import com.example.override_fivemonthn.R;
import com.example.override_fivemonthn.model.BoredAction;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.ArrayList;
import java.util.Collections;

public class HeartListFrag extends Fragment {

    private ArrayList<BoredAction> list = new ArrayList<>();
private  int pos;
     Adapter adapter;
    BoredAction boredAction;
    LikeButton likeButton;
    RecyclerView recyclerView;


    public static Fragment newInstance() {
        return new HeartListFrag();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_heart_list, container, false);


        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        likeButton = view.findViewById(R.id.buttonHeartlist);


      RecyclerView  recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        list.addAll(App.boredStorage.getAllActions());
        adapter = new Adapter(list);
        recyclerView.setAdapter(adapter);


        adapter.Adapter(new Image_Interface() {
            @Override
            public void onItemClick(int pos) {
                App.boredStorage.deleteBoredAction(list.get(pos));

                list.remove(pos);
                adapter.notifyDataSetChanged();

            }
        } );


        loadData2();
        Remove();


    }

    private void Remove() {


        if (likeButton != null) {

            likeButton.setOnLikeListener(new OnLikeListener() {
                @Override
                public void liked(LikeButton likeButton) {

                }

                @Override
                public void unLiked(LikeButton likeButton) {
                    App.boredStorage.deleteBoredAction(boredAction);


                }
            });


        }


    }

    private void loadData2() {


        list.clear();
        list.addAll(App.boredStorage.getAllActions());
        Collections.reverse(list);

        adapter.notifyDataSetChanged();

    }


    @Override
    public void onResume() {
        super.onResume();
        loadData2();
    }

    @Override
    public void onPause() {
        super.onPause();
        loadData2();
    }


}
