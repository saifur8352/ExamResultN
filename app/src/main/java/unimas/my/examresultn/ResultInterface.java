package unimas.my.examresultn;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public
interface ResultInterface {
    @GET("5d08466034000059005d969f")
    Call<List<Model>> getRestResponse();

}

