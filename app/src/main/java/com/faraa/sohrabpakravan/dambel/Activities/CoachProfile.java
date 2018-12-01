package com.faraa.sohrabpakravan.dambel.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.faraa.sohrabpakravan.dambel.Models.CoachDetails;
import com.faraa.sohrabpakravan.dambel.R;
import com.faraa.sohrabpakravan.dambel.WebService.Caller;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class CoachProfile extends AppCompatActivity {

    ImageView imageView;
    LinearLayout layout;
    Button receiveProgram;
    TextView coach_name, price, sessions, period, type, resume;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_profile);
        layout = findViewById(R.id.rating_layout);
        imageView = findViewById(R.id.imageView1);

        coach_name = findViewById(R.id.coachName);
        price = findViewById(R.id.price);
        sessions = findViewById(R.id.tv_sessions);
        period = findViewById(R.id.tv_course_time);
        type = findViewById(R.id.type);
        resume = findViewById(R.id.tv_resume);

        new getAllOverViewsDetail().execute();




        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/IRANYekanRegular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );


        receiveProgram = findViewById(R.id.btn_receive_program);

        receiveProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReceiveProgram.class);
                startActivity(intent);
            }
        });


    }

    private class getAllOverViewsDetail extends AsyncTask<Void, Void, CoachDetails> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected CoachDetails doInBackground(Void... integers) {
            Log.i("Sohrab", "Doing the Background");

            CoachDetails detail= new Caller().getAllCoaches("","");

            return detail;

        }

        @Override
        protected void onPostExecute(CoachDetails coachDetails) {
            super.onPostExecute(coachDetails);
            //TODO we should add other items here too

            for(int i=0; i<coachDetails.get_user().size(); i++){
                coach_name.setText(coachDetails.get_user().get(i).get_firstName() + " " + coachDetails.get_user().get(i).get_lastName());
                price.setText(coachDetails.get_user().get(i).get_vipPrice());
            }

            sessions.setText(coachDetails.get_sportFieldName());

        }


    }

    }
