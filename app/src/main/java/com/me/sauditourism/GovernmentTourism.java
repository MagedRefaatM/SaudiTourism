package com.me.sauditourism;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GovernmentTourism extends Fragment {

    private TextView nameTv;
    Data data;

    private String[] Title = new String[4];

    public GovernmentTourism(Data data) {
        this.data = data;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        RecyclerView riyadhRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview1);
        nameTv = (TextView) view.findViewById(R.id.viewsTv);

        nameTv.setText(data.getTxt());
        RecyclerView.Adapter riyadhRecyclerViewAdapter = new RecyclerViewAdapter1(data.getImages());
        RecyclerView.LayoutManager riyadhRecylerViewLayoutManager = new LinearLayoutManager(getContext());
        riyadhRecyclerView.setLayoutManager(riyadhRecylerViewLayoutManager);
        riyadhRecyclerView.setAdapter(riyadhRecyclerViewAdapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.government_tourism, container, false);
    }
}