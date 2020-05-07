package com.example.appforros.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appforros.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private Button iv_add;
    private TextView robot_id;
    private EditText robot_ip;
    private List<String> list = new ArrayList<String>();
    private RecycleAdapter adapter;
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        root = inflater.inflate(R.layout.fragment_home, container, false);
        iv_add = root.findViewById(R.id.iv_add);
        mRecyclerView = root.findViewById(R.id.recyclerview);
        robot_id = root.findViewById(R.id.robot_id);
        robot_ip = root.findViewById(R.id.robot_ip);

        initRecycle();
        iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long ip_true = ipCheck(robot_ip.getText().toString());
                if (ip_true == -1) {
                    Snackbar.make(v, "请输入正确ip地址" + ip_true, Snackbar.LENGTH_SHORT).show();
                    robot_ip.setText("");
                } else {
                    adapter.addData(list.size(), ip_true, robot_ip.getText().toString());
                    robot_ip.setText("");
                    robot_id.setText("机器人" + list.size());
                }
            }
        });
        return root;
    }

    private void initRecycle() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        list = initData();
        adapter = new RecycleAdapter(this.getActivity(), list);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    protected ArrayList<String> initData() {
        ArrayList<String> mDatas = new ArrayList<String>();

        return mDatas;
    }

    private long ipCheck(String ip) {
        int[] ip_part = new int[4];
        long ip_true = 0;
        String[] ip_split = ip.split("\\.");
        if (ip_split.length != 4) {
            return -1;
        }
        for (int i = 0; i < ip_split.length; i++) {
            try {
                ip_part[i] = Integer.parseInt(ip_split[i]);
            } catch (NumberFormatException e) {
                return -1;
            }
            if (ip_part[i] < 0 || ip_part[i] > 255) {
                return -1;
            }
        }
        for (int i = 0; i < 4; i++) {
            ip_true = ip_true*256 + ip_part[i];
        }
        //Snackbar.make(root, ip_part[0] + "   " + ip_part[1] + "   " + ip_part[2] + "   " + ip_part[3], Snackbar.LENGTH_SHORT).show();
        //Snackbar.make(root, ip_true + "   ", Snackbar.LENGTH_LONG).show();
        return ip_true;
    }
}