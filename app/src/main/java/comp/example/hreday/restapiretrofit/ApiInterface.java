package comp.example.hreday.restapiretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("wmotb")
    Call<List<PojoClass>> getName();
}
