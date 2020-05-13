package com.example.ramdantraining.View.QuizApp.Signup.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ramdantraining.R;
import com.example.ramdantraining.shared.Model.UserAvatar;
import com.example.ramdantraining.shared.Util.RecycleViewOnClick;

import java.util.ArrayList;
import java.util.List;

public class AvatarAdapter extends RecyclerView.Adapter<AvatarAdapter.ViewHolder> {
    private Context context;
    private List<UserAvatar> userAvatars = new ArrayList<>();
    private RecycleViewOnClick recycleViewOnClick;

    public AvatarAdapter(List<UserAvatar> userAvatars, RecycleViewOnClick recycleViewOnClick) {
        this.userAvatars = userAvatars;
        this.recycleViewOnClick = recycleViewOnClick;
    }

    @NonNull
    @Override
    public AvatarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AvatarAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.avatar_item_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AvatarAdapter.ViewHolder holder, int position) {
        holder.avatar_img.setBackgroundResource(userAvatars.get(position).getAvatar());
    }

    @Override
    public int getItemCount() {
        return userAvatars.size();
    }

    public void setList(List<UserAvatar> userAvatars) {
        this.userAvatars = userAvatars;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar_img = itemView.findViewById(R.id.avatar_img);
            itemView.setOnClickListener(v -> {
                if (recycleViewOnClick != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        recycleViewOnClick.onItemClick(position, itemView);
                    }
                }
            });

            itemView.setOnLongClickListener(v -> {
                if (recycleViewOnClick != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        recycleViewOnClick.onLongClick(position, itemView);
                    }
                }
                return true;
            });
        }
    }
}