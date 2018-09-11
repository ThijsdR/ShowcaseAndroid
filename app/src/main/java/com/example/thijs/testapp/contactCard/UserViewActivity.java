package com.example.thijs.testapp.contactCard;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thijs.testapp.R;

public class UserViewActivity extends AppCompatActivity
{
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_view);

        User user = (User) getIntent().getSerializableExtra("Persona");

        ImageView profilePicture = findViewById(R.id.imageView7);
        Glide.with(getApplicationContext()).load(user.getPicture().getLarge()).into(profilePicture);

        ImageView background = findViewById(R.id.imageView5);
        if (user.getGender().equals("male")) {
            Glide.with(getApplicationContext()).load(R.drawable.background_male).into(background);
        } else {
            Glide.with(getApplicationContext()).load(R.drawable.background_female).into(background);
        }

        TextView nameTV = findViewById(R.id.nameTV);
        nameTV.setText(user.getName().getFirstName().substring(0, 1).toUpperCase() + user.getName().getFirstName().substring(1)
                + " " + user.getName().getLastName().substring(0, 1).toUpperCase() + user.getName().getLastName().substring(1));

        TextView genderTV = findViewById(R.id.genderTV);
        genderTV.setText(user.getGender());

        TextView emailTV = findViewById(R.id.emailTV);
        emailTV.setText(user.getEmail());

        TextView phoneTV = findViewById(R.id.phoneTV);
        phoneTV.setText(user.getPhone() + "\n" + user.getCell());

        TextView addressTV = findViewById(R.id.addressTV);
        addressTV.setText(user.getLocation().getStreet() + "\n" + user.getLocation().getCity() + "\n" + user.getLocation().getState());

        TextView timezoneTV = findViewById(R.id.timezoneTV);
        timezoneTV.setText(user.getLocation().getTimezone().getOffset());

        TextView descriptionTV = findViewById(R.id.descriptionTV);
        descriptionTV.setText(user.getLocation().getTimezone().getDescription());
    }

    public void imageClick(View view) {
        Dialog builder = new Dialog(UserViewActivity.this);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //nothing;
            }
        });
        
        User user = (User) getIntent().getSerializableExtra("Persona");
        ImageView imageView = new ImageView(UserViewActivity.this);
        Glide.with(getApplicationContext()).load(user.getPicture().getLarge()).into(imageView);

        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        builder.show();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
    }
}
