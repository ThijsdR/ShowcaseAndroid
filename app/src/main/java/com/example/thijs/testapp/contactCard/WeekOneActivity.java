package com.example.thijs.testapp.contactCard;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.thijs.testapp.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeekOneActivity extends AppCompatActivity
{
    private List<User> userList = new ArrayList<>();
    private UserAdapter pAdapter;

    private GsonBuilder builder = new GsonBuilder();
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_one);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        gson = builder.create();

        /* Generate some random userdata */
        for (int i = 0; i < 20; i++)
        {
            getRandomUser();
        }

        pAdapter = new UserAdapter(WeekOneActivity.this, userList);
        recyclerView.setAdapter(pAdapter);
    }

    public void getRandomUser()
    {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, "https://randomuser.me/api/", null, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    JSONArray array = response.getJSONArray("results");
                    JSONObject userObject = array.getJSONObject(0);

                    User user = gson.fromJson(userObject.toString(), User.class);
                    userList.add(user);
                } catch (JSONException e)
                {
                    e.printStackTrace();
                    progressDialog.dismiss();
                }
                pAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Log.e("Volley", error.toString());
                        progressDialog.dismiss();
                    }
                }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
}
