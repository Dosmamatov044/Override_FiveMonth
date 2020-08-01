package com.example.override_fivemonthn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.ImageDecoder;
import android.os.BatteryManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.override_fivemonthn.Main.MainActivity;

public class BatteryReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {


        TextView statusLabel=((MainActivity)context).findViewById(R.id.statusLabel);
        TextView percentLabel=((MainActivity)context).findViewById(R.id.percentageLabel);
        ImageView batteryImage=((MainActivity)context).findViewById(R.id.bateryChange);

        String action=intent.getAction();
        if (action!=null&&action.equals(Intent.ACTION_BATTERY_CHANGED)){

          int status=intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
          String message="";

          switch (status){

              case BatteryManager.BATTERY_STATUS_FULL:
                  message="Full";
                  break;

              case BatteryManager.BATTERY_STATUS_CHARGING:
                  message="charging";

                  break;
                  case BatteryManager.BATTERY_STATUS_DISCHARGING:
                  message="Discharging";
                  break;
                  case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                  message="Not charging";
                  break;
                  case BatteryManager.BATTERY_STATUS_UNKNOWN:
                  message="unknown";
                  break;

          }
            statusLabel.setText(message);

          int Level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
          int scale=intent.getIntExtra(BatteryManager.EXTRA_SCALE,-1);
          int percentage=Level*100/scale;
          percentLabel.setText(percentage+"%");


            Resources res=context.getResources();
            if (percentage>=90){

                batteryImage.setImageDrawable(res.getDrawable(R.drawable.b100));
            }else if(90>percentage&&percentage>=65){

                batteryImage.setImageDrawable(res.getDrawable(R.drawable.b75));
            }else if(65>percentage&&percentage>=40){

                batteryImage.setImageDrawable(res.getDrawable(R.drawable.b50));
            }else if(40>percentage&&percentage>=15){

                batteryImage.setImageDrawable(res.getDrawable(R.drawable.b25));
            }else {

                batteryImage.setImageDrawable(res.getDrawable(R.drawable.b0));
            }



        }

    }
}
