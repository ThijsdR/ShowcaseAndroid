package com.example.thijs.testapp.swipeExample;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thijs.testapp.R;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;


/**
 * Private methods/variables/constants are not supported..
 * DON'T CHANGE IT!!!!
 */
@Layout(R.layout.card_swipe)
public class SwipeCard
{

    @View(R.id.profileImageView)
    ImageView profileImageView;

    @View(R.id.nameAgeTxt)
    TextView nameAgeTxt;

    @View(R.id.locationNameTxt)
    TextView locationNameTxt;

    Profile mProfile;
    Context mContext;
    SwipePlaceHolderView mSwipeView;

    SwipeCard(Context context, Profile profile, SwipePlaceHolderView swipeView)
    {
        mContext = context;
        mProfile = profile;
        mSwipeView = swipeView;
    }

    @Resolve
    public void onResolved()
    {
        Glide.with(mContext).load(mProfile.getImageUrl()).into(profileImageView);
        nameAgeTxt.setText(mProfile.getName() + ", " + mProfile.getAge());
        locationNameTxt.setText(mProfile.getLocation());
    }

    @SwipeOut
    public void onSwipedOut()
    {
        Log.d("EVENT", "onSwipedOut");
        mSwipeView.addView(this);
    }

    @SwipeCancelState
    public void onSwipeCancelState()
    {
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    public void onSwipeIn()
    {
        Log.d("EVENT", "onSwipedIn");
    }

    @SwipeInState
    public void onSwipeInState()
    {
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    public void onSwipeOutState()
    {
        Log.d("EVENT", "onSwipeOutState");
    }
}
