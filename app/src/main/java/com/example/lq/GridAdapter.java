package com.example.lq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    Context context;
    int [] images;
    String [] titles;
    LayoutInflater layoutInflater;
    View v;

    public GridAdapter(Context context, int[] images, String[] titles) {
        this.context = context;
        this.images = images;
        this.titles = titles;
    }

    @Override
    public int getCount() {
        return images.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        v= new View(context);
        v = layoutInflater.inflate(R.layout.view_navchoise,null);


        ImageView imageView= (ImageView) v.findViewById(R.id.imageview_navchoise);
        TextView textView = (TextView) v.findViewById(R.id.textview_navchoise2);

        imageView.setImageResource(images[position]);
        textView.setText(titles[position]);

        return v;
    }
}
