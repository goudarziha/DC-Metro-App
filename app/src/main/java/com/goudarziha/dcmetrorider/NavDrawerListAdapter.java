package com.goudarziha.dcmetrorider;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NavDrawerListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NavDrawerItem> navDrawerItems;

    public NavDrawerListAdapter(Context context, ArrayList<NavDrawerItem> navDrawerItems) {
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return navDrawerItems.size();
    }

    @Override
    public Object getItem(int i) {
        return navDrawerItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater mInflater = LayoutInflater.from(context);
            view = mInflater.inflate(R.layout.drawer_nav_item, null);
        }

        ImageView imgIcon = (ImageView) view.findViewById(R.id.ivLineColor);
        TextView tvTitle = (TextView)view.findViewById(R.id.tvTitle);

        tvTitle.setText(navDrawerItems.get(i).getTitle());

        if (navDrawerItems.get(i).getTitle().equals("Red")) {imgIcon.setBackgroundColor(Color.parseColor("#be1337"));}
        if (navDrawerItems.get(i).getTitle().equals("Blue")) {imgIcon.setBackgroundColor(Color.parseColor("#0795d3"));}
        if (navDrawerItems.get(i).getTitle().equals("Orange")) {imgIcon.setBackgroundColor(Color.parseColor("#da8707"));}
        if (navDrawerItems.get(i).getTitle().equals("Yellow")) {imgIcon.setBackgroundColor(Color.parseColor("#f5d415"));}
        if (navDrawerItems.get(i).getTitle().equals("Silver")) {imgIcon.setBackgroundColor(Color.parseColor("#a2a4a1"));}
        if (navDrawerItems.get(i).getTitle().equals("Green")) {imgIcon.setBackgroundColor(Color.parseColor("#00b050"));}

        return view;
    }
}
