package com.example.thijs.testapp.contactCard;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.thijs.testapp.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>
{

    private List<User> userList;
    private Context mContext;

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView nameTextView;
        ImageView thumbnail;
        User clickedUser;

        MyViewHolder(View view)
        {
            super(view);

            nameTextView = view.findViewById(R.id.nameTextView);

            thumbnail = view.findViewById(R.id.thumbnail);

            view.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent intent = new Intent(mContext, UserViewActivity.class);
                    intent.putExtra("Persona", clickedUser);
                    mContext.startActivity(intent);
                }
            });
        }
    }

    UserAdapter(Context mContext, List<User> userList)
    {
        this.mContext = mContext;
        this.userList = userList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position)
    {
        final User user = userList.get(position);
        String name = user.getName().getTitle() + " " + user.getName().getFirstName().substring(0, 1).toUpperCase() + user.getName().getFirstName().substring(1)
                + " " + user.getName().getLastName().substring(0, 1).toUpperCase() + user.getName().getLastName().substring(1);

        holder.nameTextView.setText(name);

        Glide.with(mContext).load(user.getPicture().getMedium()).into(holder.thumbnail);

        holder.clickedUser = user;
    }

    @Override
    public int getItemCount()
    {
        return userList.size();
    }
}
