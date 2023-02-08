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

public class tvshowAdapter extends RecyclerView.Adapter<tvshowAdapter.mytvshowlist> {
    Context context;
    List<tvshow>mdatatv;

    public tvshowAdapter(Context context, List<tvshow> mdatatv) {
        this.context = context;
        this.mdatatv = mdatatv;
    }

    @NonNull
    @Override
    public tvshowAdapter.mytvshowlist onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemreycle,parent,false);
        return new mytvshowlist(view);
    }

    @Override
    public void onBindViewHolder(@NonNull tvshowAdapter.mytvshowlist holder, int position) {
        holder.titlestv.setText(mdatatv.get(position).getNamaTv());
        holder.gambarstv.setImageResource(mdatatv.get(position).getGambartv());

    }

    @Override
    public int getItemCount() {
        return mdatatv.size();
    }

    public class mytvshowlist extends RecyclerView.ViewHolder {
        private TextView titlestv;
        private ImageView gambarstv;
        public mytvshowlist(@NonNull View itemView) {
            super(itemView);
            titlestv = itemView.findViewById(R.id.titlestv);
            gambarstv = itemView.findViewById(R.id.gambar_tv);

        }
    }
}
