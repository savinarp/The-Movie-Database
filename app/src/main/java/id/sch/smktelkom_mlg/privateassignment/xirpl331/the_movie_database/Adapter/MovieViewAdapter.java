package id.sch.smktelkom_mlg.privateassignment.xirpl331.the_movie_database.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl331.the_movie_database.Activity.DetailsActivity;
import id.sch.smktelkom_mlg.privateassignment.xirpl331.the_movie_database.Fragments.FavoriteMovies;
import id.sch.smktelkom_mlg.privateassignment.xirpl331.the_movie_database.Fragments.NewMovies;
import id.sch.smktelkom_mlg.privateassignment.xirpl331.the_movie_database.Fragments.PopularMovies;
import id.sch.smktelkom_mlg.privateassignment.xirpl331.the_movie_database.Fragments.TopRatedMovies;
import id.sch.smktelkom_mlg.privateassignment.xirpl331.the_movie_database.Models.Movie;
import id.sch.smktelkom_mlg.privateassignment.xirpl331.the_movie_database.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl331.the_movie_database.Utils.Utils;

/**
 * Created by Savina on 5/13/2017.
 */

public class MovieViewAdapter extends RecyclerView.Adapter<MovieViewAdapter.MyViewHolder> {
    private ArrayList<Movie> mMovieList;
    private Context mContext;
    private int lastPosition = -1;


    public MovieViewAdapter(Context mContext, ArrayList<Movie> mMovieList) {
        this.mContext = mContext;
        this.mMovieList = mMovieList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_popular_movies, parent, false);


        return new MyViewHolder(itemView);
    }

    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Movie movie = mMovieList.get(position);
        holder.title.setText(movie.getMovie_name());

        if (PopularMovies.imageSize == 1 || TopRatedMovies.imageSize == 1 || NewMovies.imageSize == 1 || FavoriteMovies.imageSize == 1) {
            Picasso.with(mContext).load(movie.getMovie_poster_path()).resize(200, 480).into(holder.thumbnail);
        } else if (PopularMovies.imageSize == 2 || TopRatedMovies.imageSize == 2 || NewMovies.imageSize == 2 || FavoriteMovies.imageSize == 2) {
            Picasso.with(mContext).load(movie.getMovie_poster_path()).resize(200, 580).into(holder.thumbnail);
        } else if (PopularMovies.imageSize == 4 || TopRatedMovies.imageSize == 4 || NewMovies.imageSize == 4 || FavoriteMovies.imageSize == 4) {
            Picasso.with(mContext).load(movie.getMovie_poster_path()).resize(200, 660).into(holder.thumbnail);
        } else {
            Picasso.with(mContext).load(movie.getMovie_poster_path()).resize(180, 600).into(holder.thumbnail);
        }

        //setAnimation(holder.itemView, position);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Utils.isInternetAvailable(mContext)) {
                    String movie = mMovieList.get(position).getMovie().toString();
                    Intent intent = new Intent(mContext, DetailsActivity.class);
                    intent.putExtra("movie", movie);
                    mContext.startActivity(intent);
                } else {
                    Toast.makeText(mContext, "No Internet Connection", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.fade_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        ImageView thumbnail;

        MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }
}
