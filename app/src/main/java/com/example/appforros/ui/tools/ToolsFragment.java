package com.example.appforros.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appforros.R;
import com.example.appforros.ui.home.RecycleAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ToolsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private Button send_mes;
    private List<String> rlist = new ArrayList<String>();
    //private List<String> llist = new ArrayList<String>();
    private RightAdapter rightAdapter;
    //private LeftAdapter leftAdapter;
    private int count = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        send_mes = root.findViewById(R.id.chat_message_send);
        final EditText mes = root.findViewById(R.id.chat_message);
        mRecyclerView = root.findViewById(R.id.recycle_chat);
        initRecycle();
        final EditText chat_mes = root.findViewById(R.id.chat_message);

        send_mes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(v, mes.getText(), Snackbar.LENGTH_SHORT).show();
                //mes.setText("");
                rightAdapter.addData(rlist.size(), chat_mes.getText().toString());
                chat_mes.setText("");
            }
        });
        return root;
    }

    private void initRecycle() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        rlist = initData();
        //llist = initData();
        rightAdapter = new RightAdapter(this.getActivity(), rlist);
        //leftAdapter = new LeftAdapter(this.getActivity(), llist);
        mRecyclerView.setAdapter(rightAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    protected ArrayList<String> initData() {
        ArrayList<String> mDatas = new ArrayList<String>();

        return mDatas;
    }
}