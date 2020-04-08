package com.example.retrofit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=findViewById(R.id.text);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final dummy dummy=retrofit.create(dummy.class);

        Call<List<employees>> call=dummy.getEmployees();
        call.enqueue(new Callback<List<employees>>() {
            @Override
            public void onResponse(Call<List<employees>> call, Response<List<employees>> response) {
                if(!response.isSuccessful()){
                    text.setText(response.code());
                    return;
                }
                List<employees> employees2=response.body();

                for(employees employees1: employees2){
                    String content="";
                    content+="ID: "+employees1.getId()+"\n";
                    content+="Employee userId: "+employees1.getUserId()+"\n";
                    content+="Employee title: "+employees1.getTitle()+"\n";
                    content+="Employee description: "+employees1.getBody()+"\n\n";

                    text.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<employees>> call, Throwable t) {
                text.setText(t.getMessage());
            }
        });
    }
}
