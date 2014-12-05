package com.goudarziha.dcmetrorider;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LineListAdapter extends ArrayAdapter<String> {

    Context context;
    ArrayList<String> stations;
    ArrayList<String> lineCode1;
    ArrayList<String> lineCode2;
    ArrayList<String> lineCode3;
    ArrayList<String> stationTogether;

    ImageView line1, line2, line3;

    public LineListAdapter(Context context, ArrayList<String> stations, ArrayList<String> lineCode1, ArrayList<String> lineCode2, ArrayList<String> lineCode3) {
        super(context, R.layout.station_line_item, stations);
        this.context = context;
        this.stations = stations;
        this.lineCode1 = lineCode1;
        this.lineCode2 = lineCode2;
        this.lineCode3 = lineCode3;
    }

    public LineListAdapter(Context context, ArrayList<String> stations, ArrayList<String> lineCode1, ArrayList<String> stationTogether) {
        super(context, R.layout.station_line_item, stations);
        this.context = context;
        this.stations = stations;
        this.lineCode1 = lineCode1;
        this.stationTogether = stationTogether;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = inflater.inflate(R.layout.station_line_item, parent, false);
        TextView tvStation = (TextView) row.findViewById(R.id.tvStation);
        tvStation.setText(stations.get(position));

        line1 = (ImageView) row.findViewById(R.id.ivLineColor);
        line2 = (ImageView) row.findViewById(R.id.ivLineColor2);
        line3 = (ImageView) row.findViewById(R.id.ivLineColor3);

        if (lineCode1.get(position).equals("BL")) {
            line1.setBackgroundColor(Color.parseColor("#0795d3"));
        }
        if (lineCode1.get(position).equals("RD")) {
            line1.setBackgroundColor(Color.parseColor("#be1337"));
        }
        if (lineCode1.get(position).equals("GR")) {
            line1.setBackgroundColor(Color.parseColor("#00b050"));
        }
        if (lineCode1.get(position).equals("YL")) {
            line1.setBackgroundColor(Color.parseColor("#f5d415"));
        }
        if (lineCode1.get(position).equals("SV")) {
            line1.setBackgroundColor(Color.parseColor("#a2a4a1"));
        }
        if (lineCode1.get(position).equals("OR")) {
            line1.setBackgroundColor(Color.parseColor("#da8707"));
        }

        //SECOND LINE CODES if available
        if (lineCode2.get(position).equals("BL")) {
            line2.setVisibility(View.VISIBLE);
            line2.setBackgroundColor(Color.parseColor("#0795d3"));
        }
        if (lineCode2.get(position).equals("RD")) {
            line2.setVisibility(View.VISIBLE);
            line1.setBackgroundColor(Color.parseColor("#be1337"));
        }
        if (lineCode2.get(position).equals("GR")) {
            line2.setVisibility(View.VISIBLE);
            line2.setBackgroundColor(Color.parseColor("#00b050"));
        }
        if (lineCode2.get(position).equals("YL")) {
            line2.setVisibility(View.VISIBLE);
            line2.setBackgroundColor(Color.parseColor("#f5d415"));
        }
        if (lineCode2.get(position).equals("SV")) {
            line2.setVisibility(View.VISIBLE);
            line2.setBackgroundColor(Color.parseColor("#a2a4a1"));
        }
        if (lineCode2.get(position).equals("OR")) {
            line2.setVisibility(View.VISIBLE);
            line2.setBackgroundColor(Color.parseColor("#da8707"));
        }

        //THIRD LINE CODES if available
        if (lineCode3.get(position).equals("BL")) {
            line3.setVisibility(View.VISIBLE);
            line3.setBackgroundColor(Color.parseColor("#0795d3"));
        }
        if (lineCode3.get(position).equals("RD")) {
            line3.setVisibility(View.VISIBLE);
            line3.setBackgroundColor(Color.parseColor("#be1337"));
        }
        if (lineCode3.get(position).equals("GR")) {
            line3.setVisibility(View.VISIBLE);
            line3.setBackgroundColor(Color.parseColor("#00b050"));
        }
        if (lineCode3.get(position).equals("YL")) {
            line3.setVisibility(View.VISIBLE);
            line3.setBackgroundColor(Color.parseColor("#f5d415"));
        }
        if (lineCode3.get(position).equals("SV")) {
            line3.setVisibility(View.VISIBLE);
            line3.setBackgroundColor(Color.parseColor("#a2a4a1"));
        }
        if (lineCode3.get(position).equals("OR")) {
            line3.setVisibility(View.VISIBLE);
            line3.setBackgroundColor(Color.parseColor("#da8707"));
        }

        return row;
    }
}
