package com.coffeecode.moviecataloguesubmission1;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
    private String title;
    private String language;
    private String user_score;
    private String overview;
    private String year;
    private int poster;

    public Movie() {

    }

    protected Movie(Parcel in) {
        title = in.readString();
        language = in.readString();
        user_score = in.readString();
        overview = in.readString();
        year = in.readString();
        poster = in.readInt();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUser_score() {
        return user_score;
    }

    public void setUser_score(String user_score) {
        this.user_score = user_score;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(language);
        dest.writeString(user_score);
        dest.writeString(overview);
        dest.writeString(year);
        dest.writeInt(poster);
    }

    @Override
    public int describeContents() {
        return 0;
    }


}
