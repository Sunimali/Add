package com.example.user.add;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.toolbox.HttpResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                addPetOwner();
            }
        });
    }

    public void addPetOwner() {

        final PetOwner p = new PetOwner("sunimali rathnayake", "sunimaliR", "1234eqw", "matara", "sunimali@gmail.com", "0713172413", "123qwe", "image");

        // For Add data
        class MyTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... abc) {
                String output = "";
                for (String s1 : abc) {
                    output = sendDetails(s1);
                }
                return output;
            }
            /*
            params.put("name",p.get(0));
                params.put("username", username);
                params.put("password", p.get(1));
                params.put("address", p.get(2));
                params.put("email", p.get(3));
                params.put("mobile", p.get(4));
                params.put("id",id);
                params.put("imageURL",imageToString(bitmap));*/

            private String sendDetails(String url) {
                SharedPrefManager s = new SharedPrefManager(MainActivity.this);
                String my = s.myConnection(url,p.getName(),p.getUserName(),p.getPassword()
                        , p.getAddress(),p.getEmail(),
                        p.getMobileNumber(),p.getPetOwnerID()
                        ,p.getUrl());
                return my;
            }

            @Override
            protected void onPostExecute(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();

            }
        }
        MyTask task = new MyTask();
        task.execute(netconstraints.URL_REGISTER);
    }
}
