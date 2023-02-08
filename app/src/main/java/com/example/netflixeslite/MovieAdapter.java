package com.example.netflixeslite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView .Adapter<MovieAdapter.MyViewHolder>{
    Context context;
    List<movies> mdata;

    public MovieAdapter(Context context, List<movies> mdata) {
        this.context = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(context).inflate(R.layout.itm_movie,viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

          myViewHolder.Tvtitle.setText(mdata.get(i).getTitle());
          myViewHolder.imgMovie.setImageResource(mdata.get(i).getGambarMovie());

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView Tvtitle;
        private ImageView imgMovie;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Tvtitle = itemView.findViewById(R.id.title_movies);
            imgMovie = itemView.findViewById(R.id.item_imagesmovies);

        }
    }
}
