package comp.example.hreday.restapiretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView=findViewById(R.id.recyclerId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Retrofit  retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        ApiInterface apiInterface =retrofit.create(ApiInterface.class);
        Call<List<PojoClass>> call=apiInterface.getName();
        call.enqueue(new Callback<List<PojoClass>>() {
            @Override
            public void onResponse(Call<List<PojoClass>> call, Response<List<PojoClass>> response) {
                showIt(response.body());
            }

            @Override
            public void onFailure(Call<List<PojoClass>> call, Throwable t) {

            }
        });


    }

    private void showIt(List<PojoClass> response) {

        Adapter adapter=new Adapter(getApplicationContext(),response);
        recyclerView.setAdapter(adapter);

    }
}
