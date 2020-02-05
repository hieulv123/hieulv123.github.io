package com.t3h.filternews.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.filternews.R;
import com.t3h.filternews.activity.MainActivity;
import com.t3h.filternews.activity.NewsActivity;
import com.t3h.filternews.adapter.FavoriteAdapter;
import com.t3h.filternews.api.AppDatabase;
import com.t3h.filternews.model.News;

import java.util.ArrayList;

public class FavoriteFragment extends Fragment implements FavoriteAdapter.FavoriteItemListener {

    private RecyclerView lvFavorite;
    private FavoriteAdapter adapter;
    private ArrayList<News> data = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_favorite, container, false);
        return v;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvFavorite = getActivity().findViewById(R.id.lv_favorite);
        adapter = new FavoriteAdapter(getContext());
        adapter.setListener(this);
        lvFavorite.setAdapter(adapter);
        getData();
    }

    public void getData() {
        data.clear();
        data.addAll(AppDatabase.getInstance(getContext()).getNewsDao().getFavorite(true));
        adapter.setData(data);
    }


    @Override
    public void onNewsItemClicked(int position) {
        Intent intent = NewsActivity.getInstance(getContext(), data.get(position).getUrl());
        startActivity(intent);
    }

    @Override
    public void onNewsItemLongClicked(int position) {
        AppDatabase.getInstance(getContext()).getNewsDao().delete(data.get(position));
        getData();
    }
}
