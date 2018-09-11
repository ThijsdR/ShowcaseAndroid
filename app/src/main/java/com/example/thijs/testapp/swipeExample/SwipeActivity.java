package com.example.thijs.testapp.swipeExample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.thijs.testapp.R;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

public class SwipeActivity extends AppCompatActivity
{

    private SwipePlaceHolderView mSwipeView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        mSwipeView = findViewById(R.id.swipeView);
        Context mContext = getApplicationContext();

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.card_swipe_in_msg)
                        .setSwipeOutMsgLayoutId(R.layout.card_swipe_out_msg));


        for (Profile profile : Utils.loadProfiles(this.getApplicationContext()))
        {
            mSwipeView.addView(new SwipeCard(mContext, profile, mSwipeView));
        }

        findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mSwipeView.doSwipe(false);
            }
        });

        findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mSwipeView.doSwipe(true);
            }
        });
    }
}
