package com.ikheiry.roomapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ikheiry.roomapp.MainActivity;
import com.ikheiry.roomapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    Button bnAddUser, bnViewUsers, bnUpdateUser, bnDeleteUser;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        bnAddUser = view.findViewById(R.id.bn_add_user);
        bnAddUser.setOnClickListener(this);

        bnViewUsers = view.findViewById(R.id.bn_view_users);
        bnViewUsers.setOnClickListener(this);

        bnUpdateUser = view.findViewById(R.id.bn_update_user);
        bnUpdateUser.setOnClickListener(this);

        bnDeleteUser = view.findViewById(R.id.bn_delete_user);
        bnDeleteUser.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bn_add_user:
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, new AddUserFragment())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.bn_view_users:
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, new ReadUserFragment())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.bn_update_user:
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, new UpdateUserFragment())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.bn_delete_user:
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, new DeleteUserFragment())
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
