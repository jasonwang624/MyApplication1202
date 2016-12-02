package com.example.user.myapplication1202;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Main3Activity extends AppCompatActivity {
    RequestQueue queue;
    TextView tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        queue = Volley.newRequestQueue(Main3Activity.this);
        tv3 = (TextView) findViewById(R.id.textView2);
    }
    public void click1(View v)
    {
        StringRequest request = new StringRequest("http://rate.bot.com.tw/xrt?Lang=zh-TW", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int loc = response.indexOf("USD");
                Log.d("LOC", String.valueOf(loc));
                String s2 = response.substring(loc+364, loc+370);
                tv3.setText(s2);
                Log.d("LOC", s2);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        queue.start();
    }
}
