package com.example.override_fivemonthn.Adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.override_fivemonthn.App;
import com.example.override_fivemonthn.R;
import com.example.override_fivemonthn.model.BoredAction;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.ArrayList;
import java.util.Collections;


public class HeartFragment extends Fragment {

    private Adapter favoritesAdapter;
    private int pos;
    private Adapter adapter;
    private ArrayList<BoredAction> list = new ArrayList<>();
    LikeButton like;
    BoredAction boredAction;



    public HeartFragment() {

    }


    public static HeartFragment newInstance() {

        return new HeartFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_heart, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new Adapter(list);
        recyclerView.setAdapter(adapter);
        like = view.findViewById(R.id.buttonHeartlist);
        adapter.Adapter(new Image_Interface() {
            @Override
            public void onItemClick(int pos) {
                App.boredStorage.deleteBoredAction(list.get(pos));
                list.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
//        loadData();
        toRemove();
        loadData2();
    }

    private void toRemove() {
        if (like != null) {
            like.setOnLikeListener(new OnLikeListener() {
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

    private void loadData2() {
        list.clear();
        list.addAll(App.boredStorage.getAllActions());
        Collections.reverse(list);
        adapter.notifyDataSetChanged();

    }



}