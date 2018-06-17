package com.ikheiry.roomapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ikheiry.roomapp.MainActivity;
import com.ikheiry.roomapp.R;
import com.ikheiry.roomapp.model.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    private EditText userId, userName, userEmail;
    private Button bnSave;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        userId = view.findViewById(R.id.txt_user_id);
        userName = view.findViewById(R.id.txt_user_name);
        userEmail = view.findViewById(R.id.txt_user_email);

        bnSave = view.findViewById(R.id.bn_save);

        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(userId.getText().toString());
                String name = userName.getText().toString();
                String email = userEmail.getText().toString();

                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(), "User added successfully...", Toast.LENGTH_SHORT).show();

                userId.setText("");
                userName.setText("");
                userEmail.setText("");
            }
        });

        return view;
    }

}
