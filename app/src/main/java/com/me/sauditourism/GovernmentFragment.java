package com.me.sauditourism;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

public class GovernmentFragment extends Fragment {

    private ImageView viewsIv;

    private Button leftBtn;
    private Button rightBtn;

    Data data;

    private GovernmentTourism governmentTourism;

    GovernmentFragment(Data data){
        this.data = data;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.government_fragment, container, false);
    }

    private void replaceFragment(){
        governmentTourism = new GovernmentTourism(data);
        String backStateName =  governmentTourism.getClass().getName();

        FragmentManager manager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0);

        if (!fragmentPopped && manager.findFragmentByTag(backStateName) == null){
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.container1, governmentTourism, backStateName);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewsIv = (ImageView) view.findViewById(R.id.governmentViewsIv);

        viewsIv.setImageResource(data.getImages()[3]);
        viewsIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GovernmentFragment.this.getContext() , data.getTxt() , Toast.LENGTH_SHORT).show();
            }
        });

        leftBtn = (Button) view.findViewById(R.id.leftBtn);
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment();
            }
        });

        rightBtn = (Button) view.findViewById(R.id.rightBtn);
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment();
            }
        });
    }
}