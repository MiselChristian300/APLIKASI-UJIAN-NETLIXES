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

public class AdapterMovie2 extends RecyclerView.Adapter<AdapterMovie2.mymovielist2> {
    Context context;
    List<Movie2>mdatamovie2;

    public AdapterMovie2(Context context, List<Movie2> mdatamovie2) {
        this.context = context;
        this.mdatamovie2 = mdatamovie2;
    }

    @NonNull
    @Override
    public AdapterMovie2.mymovielist2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.itm_movie2,parent,false);
        return new mymovielist2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMovie2.mymovielist2 holder, int position) {
        Movie2 movie2 = mdatamovie2.get(position);
        holder.title.setText(mdatamovie2.get(position).getTitle());
        holder.imageView.setImageResource(mdatamovie2.get(position).getGambarmovie());

    }

    @Override
    public int getItemCount() {
        return mdatamovie2.size();
    }

    public class mymovielist2 extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;
        public mymovielist2(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.title_movies2);
            title = itemView.findViewById(R.id.title_movies2);

        }
    }
}
