package com.coffeecode.moviecataloguesubmission1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String[] dataTitle, dataLanguage, dataUserscore, dataOverview, dataYear;
    private TypedArray dataPoster;
    private ArrayList<Movie> movies;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_movie);
        movieAdapter = new MovieAdapter(this);
        listView.setAdapter(movieAdapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Movie movie = new Movie();
                movie.setPoster(dataPoster.getResourceId(position, -1));
                movie.setTitle(dataTitle[position]);
                movie.setYear(dataYear[position]);
                movie.setUser_score(dataUserscore[position]);
                movie.setLanguage(dataLanguage[position]);
                movie.setOverview(dataOverview[position]);

                Intent moveWithObjectIntent = new Intent(MainActivity.this, MovieDetailActivity.class);
                moveWithObjectIntent.putExtra(MovieDetailActivity.EXTRA_DATA, movie);
                startActivity(moveWithObjectIntent);

            }
        });

    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_tittle);
        dataLanguage = getResources().getStringArray(R.array.data_language);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
        dataOverview = getResources().getStringArray(R.array.data_overview);
        dataUserscore = getResources().getStringArray(R.array.data_user_score);
        dataYear = getResources().getStringArray(R.array.data_year);
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setOverview(dataOverview[i]);
            movie.setLanguage(dataLanguage[i]);
            movie.setUser_score(dataUserscore[i]);
            movie.setYear(dataYear[i]);
            movies.add(movie);
        }
        movieAdapter.setMovies(movies);
    }

    @Override
    public void onClick(View v) {

    }
}
