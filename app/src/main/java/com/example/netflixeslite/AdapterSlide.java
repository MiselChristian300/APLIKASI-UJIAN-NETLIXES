package com.example.netflixeslite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class AdapterSlide extends PagerAdapter {
    private Context context;
    private List<Slide> mlist;

    public AdapterSlide(Context context, List<Slide> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View Layoutslides = inflater.inflate(R.layout.activity_item_slide, null);
        ImageView imageViewSlide = Layoutslides.findViewById(R.id.main_contentSLide);
        TextView textViewSlide = Layoutslides.findViewById(R.id.title_slide);
        imageViewSlide.setImageResource(mlist.get(position).getImage());
        textViewSlide.setText(mlist.get(position).getTitle());
        container.addView(Layoutslides);
        return Layoutslides;
    }

    @Override
    public int getCount(){
        return mlist.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
