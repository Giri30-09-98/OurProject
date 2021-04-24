package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button bt;
    ImageView iv;
    TextView tv;
    String myurl="https://pixabay.com/api/?key=20988196-7f44f8a10d5d1ce567188a3ae&q=";
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.edit);
        bt=findViewById(R.id.button);
        iv=findViewById(R.id.image);
        tv=findViewById(R.id.text);
        progressBar=findViewById(R.id.progress);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ImgTsk().execute();
            }
        });
    }
    class ImgTsk extends AsyncTask<String,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {

            String data=et.getText().toString();

            try {
                URL url=new URL(myurl+data);
                HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();
                InputStream inputStream=urlConnection.getInputStream();
                Scanner scanner=new Scanner(inputStream);
                scanner.useDelimiter("aaa");
                if(scanner.hasNext()){
                    return scanner.next();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            try {
                JSONObject job=new JSONObject(s);
                JSONArray hits=job.getJSONArray("hits");
                JSONObject hitObject=hits.getJSONObject(7);
                String image=hitObject.getString("webformatURL");
                String cts=hitObject.getString("user");
                Picasso.get().load(image).into(iv);
                tv.setText(cts);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
