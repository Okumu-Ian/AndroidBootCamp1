package com.eeyan.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText first_name ;
    EditText last_name ;
    EditText phone_number ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         first_name = findViewById(R.id.edt_first_name);
         last_name = findViewById(R.id.edt_last_name);
         phone_number = findViewById(R.id.edt_phone_number);
    }

    public void sendToDb(){
        final String fname = first_name.getText().toString();
        final String lname = last_name.getText().toString();
        final String phone = phone_number.getText().toString();

        String url = "";

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("fname",fname);
                params.put("lname",lname);
                params.put("phone",phone);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);
    }
}
