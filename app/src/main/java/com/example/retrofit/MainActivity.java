package com.example.retrofit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

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
                .baseUrl("https://ubmcc.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final dummy dummy=retrofit.create(dummy.class);

        /*Call<List<users>> call=dummy.getUsers();
        call.enqueue(new Callback<List<users>>() {
            @Override
            public void onResponse(Call<List<users>> call, Response<List<users>> response) {
                if(!response.isSuccessful()){
                    text.setText(response.code());
                    return;
                }
                List<users> employees2=response.body();

                for(users employees1: employees2){
                    String content="";
                    content+="ID: "+employees1.getId()+"\n";
                    content+="Employee username: "+employees1.getUsername()+"\n";
                    content+="Employee email: "+employees1.getEmail()+"\n";
                    content+="Employee password: "+employees1.getPassword()+"\n\n";

                    text.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<users>> call, Throwable t) {
                text.setText(t.getMessage());
            }
        });*/

        /*users user=new users("axil.ishan99@gmail.com","Rockstar99","Ishan111");
        Call<users2> call = dummy.addURL("www.google.com");
        call.enqueue(new Callback<users2>() {
            @Override
            public void onResponse(Call<users2> call, Response<users2> response) {
                if(!response.isSuccessful()){
                    text.setText("code: "+response.code());
                }
                //users2 postResponse=response.body();
                String content="";
                content+="Code: "+response.code()+"\n";
                /*content+="Email: "+postResponse.getEmail()+"\n";
                content+="Username: "+postResponse.getUsername()+"\n";
                content+="Id: "+postResponse.getId()+"\n";

                text.setText(content);

            }
            @Override
            public void onFailure(Call<users2> call, Throwable t) {
                text.setText(t.getMessage());
            }
        });*/

        URL url=new URL("www.facebook.com");
        Call<URL> call1=dummy.addURL("www.facebook.com");
        call1.enqueue(new Callback<URL>() {
            @Override
            public void onResponse(Call<URL> call, Response<URL> response) {
                text.setText(response.code());
            }

            @Override
            public void onFailure(Call<URL> call, Throwable t) {
                text.setText(t.getMessage());
            }
        });

    }

}
