package id.sch.smktelkom_mlg.privateassignment.xirpl331.the_movie_database.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import id.sch.smktelkom_mlg.privateassignment.xirpl331.the_movie_database.Fragments.MovieDetail;
import id.sch.smktelkom_mlg.privateassignment.xirpl331.the_movie_database.R;

/**
 * Created by Savina on 5/13/2017.
 */

public class DetailsActivity extends AppCompatActivity {

    public static String movieJSONString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);


        movieJSONString = getIntent().getStringExtra("movie");

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.details, new MovieDetail())
                    .commit();
        }
    }
}
