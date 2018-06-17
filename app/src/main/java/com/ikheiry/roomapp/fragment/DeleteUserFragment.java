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

public class DeleteUserFragment extends Fragment {

    private EditText txtId;
    private Button bnDelete;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);

        txtId = view.findViewById(R.id.txt_delete_id);
        bnDelete = view.findViewById(R.id.bn_delete);

        bnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(txtId.getText().toString());
                User user = new User();
                user.setId(id);

                MainActivity.myAppDatabase.myDao().deleteUser(user);
                Toast.makeText(getActivity(), "User deleted successfully...", Toast.LENGTH_SHORT).show();

                txtId.setText("");
            }
        });

        return view;
    }

}
