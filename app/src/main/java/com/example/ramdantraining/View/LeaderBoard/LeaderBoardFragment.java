package com.example.ramdantraining.View.LeaderBoard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ramdantraining.R;
import com.example.ramdantraining.View.LeaderBoard.Adapter.LeaderBoardAdapter;
import com.example.ramdantraining.shared.Model.UserModel;
import com.example.ramdantraining.shared.Util.RecycleViewOnClick;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoardFragment extends Fragment implements RecycleViewOnClick {

    private RecyclerView recyclerView;
    private LeaderBoardAdapter leaderBoardAdapter;
    private LeaderBoardViewModel mViewModel;
    private List<UserModel> userModels = new ArrayList<>();
    private NavController navController;


    public static LeaderBoardFragment newInstance() {
        return new LeaderBoardFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.leader_board_fragment, container, false);
        recyclerView = view.findViewById(R.id.leaderBoard_rv);
        setData();
        setupRecycleview(userModels);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    private void setupRecycleview(List<UserModel> userModels) {
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        leaderBoardAdapter = new LeaderBoardAdapter(userModels, this);
        recyclerView.setAdapter(leaderBoardAdapter);
    }

    private void setData() {
        userModels.add(new UserModel(1, "test1", "1100pts", R.drawable.man1));
        userModels.add(new UserModel(2, "test2", "1200pts", R.drawable.man2));
        userModels.add(new UserModel(3, "test3", "1300pts", R.drawable.man3));
        userModels.add(new UserModel(4, "test4", "1400pts", R.drawable.man4));
        userModels.add(new UserModel(5, "test5", "1500pts", R.drawable.man5));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LeaderBoardViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onItemClick(int position, View v) {
        navController.navigate(R.id.action_leaderBoardFragment_to_profileFragment);
    }

    @Override
    public void onLongClick(int position, View v) {
        Toast.makeText(getActivity(), "Long Press", Toast.LENGTH_SHORT).show();
    }
}
