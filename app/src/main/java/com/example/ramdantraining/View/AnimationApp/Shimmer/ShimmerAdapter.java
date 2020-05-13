package com.example.ramdantraining.View.AnimationApp.Shimmer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ramdantraining.R;
import com.example.ramdantraining.shared.Model.UserModel;
import com.example.ramdantraining.shared.Util.RecycleViewOnClick;

import java.util.ArrayList;
import java.util.List;

public class ShimmerAdapter extends RecyclerView.Adapter<ShimmerAdapter.ViewHolder> {
    private Context context;
    private List<UserModel> userModelList = new ArrayList<>();
    private RecycleViewOnClick recycleViewOnClick;

    public ShimmerAdapter(List<UserModel> userModelList) {
        this.userModelList = userModelList;
    }

    @NonNull
    @Override
    public ShimmerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShimmerAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.shimmer_item_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShimmerAdapter.ViewHolder holder, int position) {
        holder.user_img.setBackgroundResource(userModelList.get(position).getUserPhoto());
        holder.name_txt.setText(userModelList.get(position).getUserName());
        holder.title_txt.setText(userModelList.get(position).getUserTitle());
        holder.body_txt.setText(userModelList.get(position).getUserBody());
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    public void setList(List<UserModel> userModelList) {
        this.userModelList = userModelList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title_txt, name_txt, body_txt;
        ImageView user_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            user_img = itemView.findViewById(R.id.user_img);
            title_txt = itemView.findViewById(R.id.title_txt);
            name_txt = itemView.findViewById(R.id.name_txt);
            body_txt = itemView.findViewById(R.id.body_txt);
        }
    }
}