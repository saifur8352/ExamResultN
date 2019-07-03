package unimas.my.examresultn;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public
class MainActivity extends AppCompatActivity {

    TextView semesterCode, gpa, cgpa,taken_credits, cal_credits;
     SharedPreferences sharedPreferences;
    public static final String NUM_PREFS = "num_prefs";
    public static final String SEMESTER_CODE = "semester_code";
    public static final String GPA = "gpa";
    public static final String CGPA = "cgpa";
    public static final String TAKEN_CREDITS = "taken_credits";
    public static final String CAL_CREDITS = "cal_credits";

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        semesterCode= findViewById(R.id.semester_code);
        gpa= findViewById(R.id.gpa_result);
        cgpa=findViewById(R.id.cgpa_result);
        taken_credits= findViewById(R.id.t_credits);
        cal_credits= findViewById(R.id.c_credits);


        sharedPreferences = getSharedPreferences(NUM_PREFS, 0);
        semesterCode.setText(sharedPreferences.getString(MainActivity.SEMESTER_CODE,"2018"));
        gpa.setText(sharedPreferences.getString(MainActivity.GPA, "000"));
        cgpa.setText(sharedPreferences.getString(MainActivity.CGPA, "000"));
        taken_credits.setText(sharedPreferences.getString(MainActivity.TAKEN_CREDITS, "000"));
        cal_credits.setText(sharedPreferences.getString(MainActivity.CAL_CREDITS, "000"));
        fetchList();

    }

    private void fetchList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/v2/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        ResultInterface resultInterface = retrofit.create(ResultInterface.class);
        Call<List<Model>> call = resultInterface.getRestResponse();
        call.enqueue(new Callback<List<Model>>() {
                         @Override
                         public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                             Log.i("Response", response.message());
                             List<Model> info = response.body();

                             for (Model model : info) {

                                 saveNumInSharedPrefs(model);
                             }
                         }
                         @Override
                         public void onFailure(Call<List<Model>> call, Throwable t) {
                             Log.e("Error", t.getMessage());
                         }
                     }
        );


    }

    private void saveNumInSharedPrefs(Model model) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(SEMESTER_CODE, model.getSemester());
            editor.putString(GPA, model.getGpa());
            editor.putString(CGPA, model.getCgpa());
            editor.putString(TAKEN_CREDITS, model.getTotalTakenCredits());
            editor.putString(CAL_CREDITS, model.getTotalCalculatedCredits());
            editor.apply();
    }

}
