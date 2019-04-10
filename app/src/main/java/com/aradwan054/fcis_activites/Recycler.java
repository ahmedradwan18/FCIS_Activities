package com.aradwan054.fcis_activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Recycler extends AppCompatActivity {
    private RecyclerView mRecycler;
    private RecyclerViewAdapter mAdapter;
    private ArrayList<Activity> mActivities;
    private RequestQueue mRequestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        mRecycler = findViewById(R.id.recycler);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mActivities = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        parseJson();

    }
    private void parseJson() {
        String url = "https://script.googleusercontent.com/macros/echo?user_content_key=pmTulYL5Gq517IS7JLDLYj_rh-1EMYgmlVz8JcJTIT-T_fUg-m3k_wy3JJHSg-IK5vgPIeMmLyAlb0bVCbauPzuoqZuIK1dmOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHa1GhPSVukpSQTydEwAEXFXgt_wltjJcH3XHUaaPC1fv5o9XyvOto09QuWI89K6KjOu0SP2F-BdwUVPxrLlGT-lMOTdNMFwVSc_aax-sRBnELnvupCLNBYjsegw2fMRHLhcnc4gaZBoxI5y7FLqOV0Tk27B8Rh4QJTQ&lib=MnrE7b2I2PjfH799VodkCPiQjIVyBAxva";
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("Sheet1");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject sheet = jsonArray.getJSONObject(i);
                        String activity_name = sheet.getString("activityName");
                        String vision = sheet.getString("vision");
                        String mission = sheet.getString("mission");
                        String backGround = sheet.getString("backGround");
                        String foreGround = sheet.getString("foreGround");
                        int year = sheet.getInt("year");
                        mActivities.add(new Activity(activity_name, vision, mission, backGround, foreGround, year));
                    }
                    mAdapter = new RecyclerViewAdapter(mActivities, Recycler.this);
                    mRecycler.setAdapter(mAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);

    }

}
