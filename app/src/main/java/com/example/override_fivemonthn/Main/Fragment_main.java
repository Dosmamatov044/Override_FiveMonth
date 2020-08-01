package com.example.override_fivemonthn.Main;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.override_fivemonthn.App;
import com.example.override_fivemonthn.BatteryReceiver;
import com.example.override_fivemonthn.BoredApiClient;
import com.example.override_fivemonthn.R;

import com.example.override_fivemonthn.model.BoredAction;
import com.google.android.material.slider.RangeSlider;


import com.like.LikeButton;
import com.like.OnLikeListener;



import java.text.MessageFormat;
import java.util.Objects;
import java.util.Random;


public class Fragment_main extends Fragment {

    private static final String FIRST = "save1";
    private static final String SECOND = "save2";


    Spinner spinner;
    TextView textCategory;
    String valueOfSpinner;
    TextView exploreThe;
    Button toNextTo;
    public TextView textPrice;
    Button update;
    ProgressBar progressBar;
    ImageView person1, person2, person3, person4;
    LikeButton likeButton;
    BoredAction boredAction1;
    String keyHeart;
    LottieAnimationView lottie;
    TextView textFree, textPartic, textAccess;
    private String QLink;
    Button link;

    public static Fragment newInstance() {
        return new Fragment_main();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);

    }





    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        person1 = view.findViewById(R.id.percon1);
        person2 = view.findViewById(R.id.percon2);
        person3 = view.findViewById(R.id.percon3);
        person4 = view.findViewById(R.id.percon4);

        textPrice = view.findViewById(R.id.textPrice);
        exploreThe = view.findViewById(R.id.explore_the);
        textCategory = view.findViewById(R.id.textViewCategory);
        spinner = view.findViewById(R.id.Change);
        progressBar = view.findViewById(R.id.progress_bar);
        toNextTo = view.findViewById(R.id.TonextTo);
        likeButton = view.findViewById(R.id.buttonHeart2);
        lottie = view.findViewById(R.id.lottieHi);
        textFree = view.findViewById(R.id.free);
        textPartic = view.findViewById(R.id.partic);
        textAccess = view.findViewById(R.id.access);
         link=view.findViewById(R.id.Link);
        //  btnLgtMode=view.findViewById(R.id.LightMode);
        //    btnDarkMode=view.findViewById(R.id.DarkMode);


        RangeSlider slider = view.findViewById(R.id.rangeSlider1);
        slider.setValues(0.0F, 5.0F);


        RangeSlider slider1 = view.findViewById(R.id.rangeSlider2);

        slider1.setValues(0.0F, 5.0F);

        spinner();

        addHeart();


        link.setOnClickListener((View v13) -> {
            Link();
        });




       /*      btnLgtMode.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {

                  }
              });

   btnDarkMode.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {

           AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
           startActivity(new Intent(getContext(),Fragment_main.class));


       }
   });*/


        toNextTo.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                nextClick();

            }
        });


    }


    private void addHeart() {
        try {


            likeButton.setOnLikeListener(new OnLikeListener() {
                @Override
                public void liked(LikeButton likeButton) {
                    try {
                        App.boredStorage.saveBoredAction(boredAction1);

                        Toast.makeText(getContext(), "Нажмите кнопку Next", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        likeButton.setLiked(true);
                        Toast.makeText(getContext(), "Нажмите кнопку Next", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void unLiked(LikeButton likeButton) {
                    try {

                        App.boredStorage.deleteBoredAction(boredAction1);
                    } catch (Exception e) {


                    }


                }
            });
        } catch (Exception d) {
        }


    }


    private void spinner() {

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(), R.array.types, R.layout.support_simple_spinner_dropdown_item);//CharSequense Parent String
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {   //
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                changeColor();
                valueOfSpinner = spinner.getSelectedItem().toString().trim();
                textCategory.setText(valueOfSpinner);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
    }





    private void Participants(BoredAction boredAction) {




Random random=new Random();
int r=random.nextInt(boredAction.getParticipants()+1+2+3+4)+2;

        if (boredAction.getParticipants() != null) {

    switch (r){
        case 1:
            person1.setVisibility(View.INVISIBLE);
            person2.setVisibility(View.INVISIBLE);
            person3.setVisibility(View.VISIBLE);
            person4.setVisibility(View.INVISIBLE);
            break;
            case 2:
                person1.setVisibility(View.INVISIBLE);
                person2.setVisibility(View.INVISIBLE);
                person3.setVisibility(View.VISIBLE);
                person4.setVisibility(View.INVISIBLE);

            break;
            case 3:
                person1.setVisibility(View.INVISIBLE);
                person2.setVisibility(View.INVISIBLE);
                person3.setVisibility(View.INVISIBLE);
                person4.setVisibility(View.INVISIBLE);

                break;
            case 4:
                person1.setVisibility(View.INVISIBLE);
                person2.setVisibility(View.INVISIBLE);
                person3.setVisibility(View.VISIBLE);
                person4.setVisibility(View.INVISIBLE);

            break;






    }







        }


    }











        public interface OnSelectedButtonListener {

        void onButtonSelected(int buttonIndex);

    }


    public void nextClick() {







        animateShow();

        try {





            App.boredApiClient.getAction(valueOfSpinner, null, null, null,null, null, null, null, new BoredApiClient.BoredActionCallback() {
                @RequiresApi(api = Build.VERSION_CODES.N)

                @Override
                public void onSuccess(BoredAction boredAction) {
                    try {
                        animateDontShow();
                        changeColor();


               linkFilter(boredAction);
                        Participants(boredAction);



                        boredAction1 = boredAction;
                        keyHeart = boredAction.getKey();

                        exploreThe.setText(boredAction.getActivity());

                        textPrice.setText(MessageFormat.format("{0}", boredAction.getPrice().toString()));

                        progressBar.setProgress((int) (boredAction.getAccessibility() * 90), true);



                        BoredAction boredAction3 = App.boredStorage.boredAction(keyHeart);
                        if (boredAction3 != null) {
                            likeButton.setLiked(true);
                            Toast.makeText(getContext(), "Нажми на кнопку Next", Toast.LENGTH_LONG).show();

                        } else {
                            likeButton.setLiked(false);


                        }


                    } catch (Exception e) {
                    }


                }

                @Override
                public void onFailure(Exception exception) {
                    if (exception == null) {

                        Toast.makeText(getContext(), "возможно что то отсутствует", Toast.LENGTH_LONG).show();


                    }

                }
            });


        } finally {
            Toast.makeText(getContext(), "Что-то нету", Toast.LENGTH_LONG).show();
        }


    }

    private void changeColor() {
        if (textCategory.getText().equals("education")) {
            textCategory.setBackgroundResource(R.color.six);


        } else if (textCategory.getText().equals("diy")) {
            textCategory.setBackgroundResource(R.color.five);


        } else if (textCategory.getText().equals("social")) {
            textCategory.setBackgroundResource(R.color.one);


        } else if (textCategory.getText().equals("music")) {
            textCategory.setBackgroundResource(R.color.two);
        } else if (textCategory.getText().equals("charity")) {
            textCategory.setBackgroundResource(R.color.three);
        } else if (textCategory.getText().equals("cooking")) {
            textCategory.setBackgroundResource(R.color.four);
        } else if (textCategory.getText().equals("busywork")) {
            textCategory.setBackgroundResource(R.color.eight);
        } else if (textCategory.getText().equals("recreational")) {
            textCategory.setBackgroundResource(R.color.seven);
        } else if (textCategory.getText().equals("relaxation")) {
            textCategory.setBackgroundResource(R.color.nine);
        }


    }

    private void animateDontShow() {
        likeButton.setVisibility(View.VISIBLE);
        lottie.setVisibility(View.INVISIBLE);
        person1.setVisibility(View.VISIBLE);
        textCategory.setVisibility(View.VISIBLE);
        person2.setVisibility(View.VISIBLE);
        person3.setVisibility(View.VISIBLE);
        person4.setVisibility(View.VISIBLE);
        exploreThe.setVisibility(View.VISIBLE);
        textPrice.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        textAccess.setVisibility(View.VISIBLE);
        textPartic.setVisibility(View.VISIBLE);
        textFree.setVisibility(View.VISIBLE);
        link.setVisibility(View.VISIBLE);
    }

    private void animateShow() {
        if (lottie != null) {

            lottie.setVisibility(View.VISIBLE);
            likeButton.setVisibility(View.INVISIBLE);
            person1.setVisibility(View.INVISIBLE);
            textCategory.setVisibility(View.INVISIBLE);
            person2.setVisibility(View.INVISIBLE);
            person3.setVisibility(View.INVISIBLE);
            person4.setVisibility(View.INVISIBLE);
            exploreThe.setVisibility(View.INVISIBLE);
            textPrice.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
            textAccess.setVisibility(View.INVISIBLE);
            textPartic.setVisibility(View.INVISIBLE);
            textFree.setVisibility(View.INVISIBLE);
       link.setVisibility(View.INVISIBLE);

        }


    }


  /*  public void Spinner1()  {
        valueOfSpinner = spinner.getSelectedItem().toString().trim();

        switch ()

    }*/

    private void linkFilter(BoredAction boredAction) {
        if (boredAction.getLink() != null) {
            if (boredAction.getLink().equals("")) {
                link.setVisibility(View.INVISIBLE);
            } else {
                link.setVisibility(View.VISIBLE);
                QLink = boredAction.getLink();
            }
        }}


    public void Link() {
        try {

      if(QLink==null){
          Toast.makeText(getContext(), "Нажмите кнопку Next Прежде чем переходить по ссылке", Toast.LENGTH_LONG).show();


      }

      Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);

            intent.setData(Uri.parse(QLink));
            startActivity(intent);
        }catch (Exception e){




        }
    }
}
 /*  public static <T> void method(BoredAction boredAction) {
        accibilR.setOnChangeRangeListener(new SimpleRangeView.OnChangeRangeListener() {
            @Override
            public void onRangeChanged(@NotNull SimpleRangeView simpleRangeView, int i, int i1) {

                accibilText.setText(String.valueOf(boredAction.getAccessibility() + i1));


                simpleRangeView.getActiveFocusThumbAlpha();

            }
        });
        accibilR.setOnTrackRangeListener(new SimpleRangeView.OnTrackRangeListener() {
            @Override
            public void onStartRangeChanged(@NotNull SimpleRangeView simpleRangeView, int i) {
                accibilText.setText(String.valueOf(boredAction.getAccessibility()));
                accibilText.setText(String.valueOf(i));


            }

            @Override
            public void onEndRangeChanged(@NotNull SimpleRangeView simpleRangeView, int i) {
                accibilText.setText(String.valueOf(boredAction.getAccessibility()));
                accibilText.setText(String.valueOf(i));

            }
        });
        accibilR.setOnRangeLabelsListener(new SimpleRangeView.OnRangeLabelsListener() {
            @org.jetbrains.annotations.Nullable
            @Override
            public String getLabelTextForPosition(@NotNull SimpleRangeView simpleRangeView, int i, @NotNull SimpleRangeView.State state) {


                return String.valueOf(boredAction.getAccessibility() + i);


            }


        });


    }*/



