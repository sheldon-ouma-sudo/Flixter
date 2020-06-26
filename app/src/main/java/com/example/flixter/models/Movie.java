package com.example.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;


@Parcel
public class Movie {


    String backdropPath;
      String posterpath;
      String title;
      String overview;
      Double voteAverage;

      public  Movie(JSONObject jsonObject) throws JSONException {
         backdropPath = jsonObject.getString("backdrop_path");
         posterpath = jsonObject.getString("poster_path");
         title = jsonObject.getString("title");
         overview = jsonObject.getString("overview");
         voteAverage = jsonObject.getDouble("vote_average");

      }




    public Movie() {
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException{
          List<Movie> movies = new ArrayList<>();
          for(int i = 0; i<movieJsonArray.length(); i++){
             movies.add(new Movie(movieJsonArray.getJSONObject(i)));
          }
      return movies;
      }

    public String getPosterpath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterpath);
    }

    public String getBackdropPath(){
          return String.format("https://image.tmdb.org/t/p/w342/%s",backdropPath);
    }


    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public Number getVoteAverage() {

        return voteAverage;
    }
}
