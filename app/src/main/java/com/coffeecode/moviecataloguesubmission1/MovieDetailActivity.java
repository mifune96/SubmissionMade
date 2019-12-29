package com.coffeecode.moviecataloguesubmission1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MovieDetailActivity extends AppCompatActivity {
    public static final String EXTRA_DATA = "extra_data";
    String title, language, userscore, year, overview;
    int poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        getSupportActionBar().setTitle("Detail Movie");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvTitle = findViewById(R.id.tv_tittle);
        TextView tvLanguage = findViewById(R.id.tv_languange);
        TextView tvUserScore = findViewById(R.id.tv_user_score);
        TextView tvOverView = findViewById(R.id.tv_overview);
        TextView tvYear = findViewById(R.id.tv_year);
        ImageView ivPoster = findViewById(R.id.iv_poster);

        Movie movie = getIntent().getParcelableExtra(EXTRA_DATA);

        title = movie.getTitle();
        poster = movie.getPoster();
        language = movie.getLanguage();
        userscore = movie.getUser_score();
        overview = movie.getOverview();
        year = movie.getYear();

        ivPoster.setImageResource(poster);
        tvTitle.setText(title);
        tvLanguage.setText(language);
        tvOverView.setText(overview);
        tvUserScore.setText(userscore);
        tvYear.setText(year);


    }
}
