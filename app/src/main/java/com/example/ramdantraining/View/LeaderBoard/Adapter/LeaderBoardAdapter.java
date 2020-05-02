package com.example.ramdantraining.View.LeaderBoard.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ramdantraining.R;
import com.example.ramdantraining.shared.Model.UserModel;
import com.example.ramdantraining.shared.Util.RecycleViewOnClick;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class LeaderBoardAdapter extends RecyclerView.Adapter<LeaderBoardAdapter.ViewHolder> {
    private Context context;
    private List<UserModel> userModels = new ArrayList<>();
    private RecycleViewOnClick recycleViewOnClick;

    public LeaderBoardAdapter(List<UserModel> userModels, RecycleViewOnClick recycleViewOnClick) {
        this.userModels = userModels;
        this.recycleViewOnClick = recycleViewOnClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.leader_board_item_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.user_id_tv.setText(String.valueOf(userModels.get(position).getUserID() ));
        holder.username_tv.setText(userModels.get(position).getUserName());
        holder.user_points_tv.setText(userModels.get(position).getUserPoint());
        holder.user_img.setBackgroundResource(userModels.get(position).getUserPhoto());
    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public void setList(List<UserModel> userModels) {
        this.userModels = userModels;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView username_tv, user_points_tv, user_id_tv;
        ImageView user_img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username_tv = itemView.findViewById(R.id.username_tv);
            user_points_tv = itemView.findViewById(R.id.user_points_tv);
            user_id_tv = itemView.findViewById(R.id.user_id_tv);
            user_img = itemView.findViewById(R.id.user_img);
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