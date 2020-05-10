package com.example.appforros.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.appforros.R;
import com.example.appforros.RobotList;
import com.google.android.material.snackbar.Snackbar;

public class GalleryFragment extends Fragment {
    private RobotList robotList = RobotList.getInstance();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        Button forward = root.findViewById(R.id.forward);
        Button backoff  = root.findViewById(R.id.backoff);
        Button turnleft = root.findViewById(R.id.turn_left);
        Button turnright = root.findViewById(R.id.turn_right);
        final int chosed_id = robotList.getChosed_id();


        forward.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"机器人" + chosed_id + "发送前进指令", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        backoff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "机器人" + chosed_id + "发送后退指令", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        turnleft.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "机器人" + chosed_id + "发送左转指令", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        turnright.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "机器人" + chosed_id + "发送右转指令", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        return root;
    }
}