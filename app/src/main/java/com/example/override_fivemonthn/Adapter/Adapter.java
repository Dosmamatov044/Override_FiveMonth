package com.example.override_fivemonthn.Adapter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.override_fivemonthn.R;
import com.example.override_fivemonthn.model.BoredAction;
import com.like.LikeButton;


import java.text.MessageFormat;
import java.util.List;
import java.util.Random;


public class Adapter extends RecyclerView.Adapter <Adapter.ViewHolder> {

    List<BoredAction> list;



    public Image_Interface onItemClick;

    public Adapter(List<BoredAction> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.list, parent, false);
        return new ViewHolder(view);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Onbind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  void Adapter(Image_Interface onItemClick) {
        this.onItemClick = onItemClick;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCategory, explore_the, free, textPrice, Participants;
        ImageView person1, person2, person3, person4;


        ProgressBar progressBar;
        LikeButton likeButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewCategory = itemView.findViewById(R.id.textViewCategory);
            explore_the = itemView.findViewById(R.id.explore_the);
            free = itemView.findViewById(R.id.free);
            textPrice = itemView.findViewById(R.id.textPrice);
            Participants = itemView.findViewById(R.id.Participants);

            progressBar = itemView.findViewById(R.id.progress_bar);
            person1 = itemView.findViewById(R.id.percon1);
            person1 = itemView.findViewById(R.id.percon2);
            person1 = itemView.findViewById(R.id.percon3);
            person1 = itemView.findViewById(R.id.percon4);

            likeButton = itemView.findViewById(R.id.buttonHeartlist);
            likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick.onItemClick(getAdapterPosition());


                }
            });
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        public void Onbind(BoredAction boredAction) {
            TextView free, Participants;


            textPrice.setText(MessageFormat.format("{0}", boredAction.getPrice().toString()));
            progressBar.setProgress((int) (boredAction.getAccessibility() * 90), true);
            explore_the.setText(boredAction.getActivity());
            textViewCategory.setText(boredAction.getType());
            Participants(boredAction);

        }
        public void Participants(BoredAction boredAction) {






            }


        } }





