package com.example.netflixeslite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Home extends AppCompatActivity {
    // slide
  private List<Slide> slidescontent;
  private ViewPager viewPager;
  Button btninfomovie;
    // end of slide
    //set rycler view tv show
    private RecyclerView tv_shows;
    private RecyclerView movielist;
    // Set indicator SLide
    private TabLayout indicators;
    private RecyclerView movielist2;
    private RequestQueue requestQueue;
    private List<Movie2> movieLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //set inisial content viewpager for slide
        viewPager = findViewById(R.id.slider_img);
        // indicator
        indicators = findViewById(R.id.status_indicator);

        //content set
        slidescontent = new ArrayList<>();
        slidescontent.add(new Slide(R.drawable.doctorstrange,"Doctor Strange in the Multiverse of Madness"));
        slidescontent.add(new Slide(R.drawable.topgun,"Top Gun Maverick"));
        slidescontent.add(new Slide(R.drawable.thefiery,"The Fiery Priest"));
        slidescontent.add(new Slide(R.drawable.theblackpink,"Black Pink Movie"));
        AdapterSlide adapter= new AdapterSlide(this,slidescontent);
        viewPager.setAdapter(adapter);
        // indicator
        indicators.setupWithViewPager(viewPager,true);
        // set timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Home.timer(), 3000,6000);
        // Set buttin info movie
        tv_shows = findViewById(R.id.rv_tv);
        List<tvshow> lmenu = new ArrayList<>();
        lmenu.add(new tvshow("",R.drawable.mnet));
        lmenu.add(new tvshow("",R.drawable.foxtv));
        lmenu.add(new tvshow("",R.drawable.nettvlogo));
        tvshowAdapter tvshowAdapter  = new tvshowAdapter(this,lmenu);
        tv_shows.setAdapter(tvshowAdapter);
        tv_shows.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        movielist = findViewById(R.id.rycle_view);
        List<movies> lmmovie = new ArrayList<>();
        lmmovie.add(new movies("The GLory",R.drawable.theglory));
        lmmovie.add(new movies("Wednesday", R.drawable.wednesday));
        lmmovie.add(new movies("Chainsaw Man", R.drawable.chainsawman));
        lmmovie.add(new movies("The Spongebob Movie", R.drawable.spongeboob));
        MovieAdapter movieAdapter = new MovieAdapter(this,lmmovie);
        movielist.setAdapter(movieAdapter);
        movielist.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        // Set buttin info movie

        movielist2 = findViewById(R.id.rycle_view2);
        movielist2.setHasFixedSize(true);
        movielist2.setLayoutManager(new LinearLayoutManager(this));
        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();
        movieLists = new ArrayList<>();
        fetchMovie();
    }
    // set timer untuk konten slide
    class timer extends TimerTask {
        @Override
        public void run() {
            Home.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem()<slidescontent.size()-1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    }
                    else
                        viewPager.setCurrentItem(0);
                }
            });
        }
    }

    public void munculpopup(View view) {
        BottomSheetDialog bottomSheetDialog= new BottomSheetDialog(
                Home.this, R.style.BottomSheetDialogThemes
        );
        View bottomview = LayoutInflater.from(getApplicationContext()).inflate(
                R.layout.layoutpopupbottom,(LinearLayout)findViewById(R.id.popupbuy)
        );
        bottomSheetDialog.setContentView(bottomview);
        bottomSheetDialog.show();
    }
    private void fetchMovie() {
        String url = "https://www.json-generator.com/api/json/get/cfsXpFGwwO?indent=2";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, (String) null, (Response.Listener<JSONArray>) new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0 ; i < response.length() ; i ++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String title = jsonObject.getString("Title");
                        int poster = jsonObject.getInt("Movie");
                        Movie2 movie2 = new Movie2(title,poster);
                        movieLists.add(movie2);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                    MovieAdapter adapter = new MovieAdapter(Home.this , movieLists);

                    movielist2.setAdapter(adapter);
                }

            }
                ,new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Home.this, error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
        }
    }

}