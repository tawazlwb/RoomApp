package com.ikheiry.roomapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ikheiry.roomapp.MainActivity;
import com.ikheiry.roomapp.R;
import com.ikheiry.roomapp.model.User;

import java.util.List;

public class ReadUserFragment extends Fragment {

    private TextView txt_info;

    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);

        txt_info = view.findViewById(R.id.txt_display);

        List<User> users = MainActivity.myAppDatabase.myDao().getUsers();
        String info = "";

        for (User user : users){
            info += "\n\nId : " + user.getId() +
                    "\nName : " + user.getName() +
                    "\nEmail : " + user.getEmail();
        }

        txt_info.setText(info);

        return view;
    }

}
