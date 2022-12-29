package com.example.lq;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter  extends BaseAdapter {
    Context context;
    List<Pojo> listPojos;
    public MyAdapter(Context context, List<Pojo> listPojos) {
        this.context =context;
        this.listPojos= listPojos;


    }

    @Override
    public int getCount() {
        return listPojos.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int positon, View view, ViewGroup parent) {

        view = LayoutInflater.from(context).inflate(R.layout.activity_list_item,parent,false);

        ImageView image=view.findViewById(R.id.image_list);
        TextView title= view.findViewById(R.id.title_list);

        title.setText(listPojos.get(positon).getTitle());
        image.setImageResource(listPojos.get(positon).getImage());



        return view;
    }


}
