package com.example.badellha;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class bottom_bar extends Fragment {



    public bottom_bar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView=inflater.inflate(R.layout.fragment_bottom_bar,container,false);

        // get home button
        // when click -> go to home page activity

        Button home_activity=(Button)myView.findViewById(R.id.home_page_button);
        home_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(), Home_Activity.class);
                startActivity(i);
            }
        });

        // get requests button
        // when click -> go to requests activity

        Button requests=(Button)myView.findViewById(R.id.request_button);
        requests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(), Requests_activity.class);
                startActivity(i);
            }
        });

        // get add button
        // when click -> go to add products activity

        Button add_activity=(Button)myView.findViewById(R.id.new_button);
        add_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),create_new_post.class);
                startActivity(i);
            }
        });

        // get my profile button
        // when click -> go to my profile activity

        Button profile_button=(Button)myView.findViewById(R.id.profile_button);
        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),my_profile.class);
                startActivity(i);
            }
        });

        // get logout button
        // when click -> close the application completely

        Button logout=(Button)myView.findViewById(R.id.logout_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finishAffinity();
            }
        });
        return myView;
    }
}