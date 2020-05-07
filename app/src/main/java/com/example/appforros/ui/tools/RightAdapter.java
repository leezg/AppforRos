package com.example.appforros.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appforros.R;

import org.w3c.dom.Text;

import java.util.List;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.RightViewHolder> {
    private Context context;
    private List<String> list;
    private String command;

    public RightAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RightViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RightViewHolder holder = new RightViewHolder(LayoutInflater.from(
                context).inflate(R.layout.chat_right_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RightAdapter.RightViewHolder holder, final int position) {
        holder.right_chat.setText(command);
        if (position < 6) {
            holder.left_chat.setText("success");
        } else {
            holder.left_chat.setText("fail");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(int position, String command) {
        list.add("test" + position);
        this.command = command;
        notifyItemInserted(position);
    }


    class RightViewHolder extends RecyclerView.ViewHolder {
        TextView right_chat;
        TextView left_chat;
        public RightViewHolder(View view) {
            super(view);
            right_chat = view.findViewById(R.id.right_mes);
            left_chat = view.findViewById(R.id.left_mes);
        }
    }
}