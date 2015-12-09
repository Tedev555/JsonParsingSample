package com.example.ted555.jsonparsingsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String strJson = "{\n" +
            "         \"Employee\" :[\n" +
            "         {\n" +
            "            \"id\":\"01\",\n" +
            "            \"name\":\"Gopal Varma\",\n" +
            "            \"salary\":\"500000\"\n" +
            "         },\n" +
            "         {\n" +
            "            \"id\":\"02\",\n" +
            "            \"name\":\"Sairamkrishna\",\n" +
            "            \"salary\":\"500000\"\n" +
            "         },\n" +
            "         {\n" +
            "            \"id\":\"03\",\n" +
            "            \"name\":\"Sathish kallakuri\",\n" +
            "            \"salary\":\"600000\"\n" +
            "         }\n" +
            "         ] \n" +
            "      }";

    String data="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.text1);
        TextView textView1 = (TextView) findViewById(R.id.text2);

        try {
            JSONObject jsonRootObject = new JSONObject(strJson);
            JSONArray jsonArray = jsonRootObject.optJSONArray("Employee");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id = Integer.parseInt(jsonObject.optString("id"));
                String name = jsonObject.optString("name");
                float salary = Float.parseFloat(jsonObject.optString("salary"));

                data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n\n ";
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        textView.setText(data);

    }
}
