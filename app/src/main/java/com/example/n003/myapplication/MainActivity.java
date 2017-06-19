package com.example.n003.myapplication;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private ListView listview1;
    private ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

listview1 = (ListView)findViewById(R.id.listview1);

data = new ArrayList<String>();
        data.add("โบนัสของ level");
        data.add("data 2");
        data.add("data 3");
        data.add("data 4");
        data.add("data 5");

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,data);
        listview1.setAdapter(myAdapter);
    }
    public class GetExample {
        OkHttpClient client = new OkHttpClient();

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        String run(String url) throws IOException {
            Request request = new Request.Builder()
                    .url("http://apiv2.claimdi.com/v2/surveyorpoint/level_of_member")
                    .build();

            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            }
        }
}
}
