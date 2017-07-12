package com.example.utsav.retrofitcomplex.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utsav.retrofitcomplex.R;
import com.example.utsav.retrofitcomplex.model.UserResponse;

import java.util.ArrayList;

/**
 * Created by utsav on 22-06-2017.
 */

public class UserDataAdapter extends RecyclerView.Adapter<UserDataAdapter.UserDataHolder> {
    private ArrayList<UserResponse> userResponseArrayList = new ArrayList<>();
    private Context context;

    public UserDataAdapter(ArrayList<UserResponse> userResponseArrayList, Context context) {
        this.userResponseArrayList = userResponseArrayList;
        this.context = context;
    }

    @Override
    public UserDataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_user, parent, false);
        return new UserDataHolder(view);
    }

    @Override
    public void onBindViewHolder(UserDataHolder holder, int position) {
        UserResponse userResponse = userResponseArrayList.get(position);
        holder.tvName.setText(userResponse.getName());
        holder.tvCity.setText(userResponse.getAddress().getCity());
    }

    @Override
    public int getItemCount() {
        return userResponseArrayList.size();
    }

    public class UserDataHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tvName, tvCity;

        public UserDataHolder(View itemView) {
            super(itemView);
            tvCity = (AppCompatTextView) itemView.findViewById(R.id.tv_city);
            tvName = (AppCompatTextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
