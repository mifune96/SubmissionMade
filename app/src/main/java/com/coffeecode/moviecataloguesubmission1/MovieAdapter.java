package com.coffeecode.moviecataloguesubmission1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;

        if (view == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_moview, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return itemView;
    }

    private class ViewHolder {
        private TextView tvTittle;
        private TextView tvOverview;
        private ImageView ivPoster;

        ViewHolder(View view) {
            tvTittle = view.findViewById(R.id.tv_tittle_home);
            tvOverview = view.findViewById(R.id.tv_overview_home);
            ivPoster = view.findViewById(R.id.iv_poster_home);
        }

        void bind(Movie movie) {
            tvTittle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
            ivPoster.setImageResource(movie.getPoster());
        }

    }

}
