package com.goudarziha.dcmetrorider;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class LineListFragments extends FragmentActivity {
}

class BlueLineFragment extends Fragment {

    ListView lv;
    ArrayList<String> stationList, codeList, lineCode1, lineCode2, lineCode3, stationTogether1,addLineCode;
    Map<String, ArrayList<String>> map, extraStations;
    FragmentManager manager;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        try {
            final DownloadData dd = new DownloadData("BL");
            map = dd.execute().get();
            stationList = map.get("Station");
            codeList = map.get("Code");
            lineCode1 = map.get("LineCode1");
            lineCode2 = map.get("LineCode2");
            lineCode3 = map.get("LineCode3");
            stationTogether1 = map.get("StationTogether1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        View view = inflater.inflate(R.layout.fragment_line, container, false);

        lv = (ListView) view.findViewById(R.id.listView);
//        if (stationTogether1.size() > 0) {
//            try {
//                final DownloadDataAddStation dda = new DownloadDataAddStation(stationTogether1.get(0));
//                extraStations = dda.execute().get();
//                addLineCode = extraStations.get("StationTogether1");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        } else {
            LineListAdapter adapter = new LineListAdapter(getActivity(), stationList, lineCode1, lineCode2, lineCode3);
            lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), stationList.get(i), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), FragmentStationTimes.class);
                intent.putExtra("stationCode", codeList.get(i));
                startActivity(intent);
            }
        });
        return view;
    }
}

class GreenLineFragment extends Fragment {

    ListView lv;
    ArrayList<String> stationList, codeList, lineCode1, lineCode2, lineCode3;
    Map<String, ArrayList<String>> map;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        try {
            final DownloadData dd = new DownloadData("GR");
            map = dd.execute().get();
            stationList = map.get("Station");
            codeList = map.get("Code");
            lineCode1 = map.get("LineCode1");
            lineCode2 = map.get("LineCode2");
            lineCode3 = map.get("LineCode3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        View view = inflater.inflate(R.layout.fragment_line, container, false);

        lv = (ListView) view.findViewById(R.id.listView);
        LineListAdapter adapter = new LineListAdapter(getActivity(), stationList, lineCode1, lineCode2, lineCode3);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), stationList.get(i), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), FragmentStationTimes.class);
                intent.putExtra("stationCode", codeList.get(i));
                startActivity(intent);
            }
        });
        return view;
    }
}

class OrangeLineFragment extends Fragment {

    ListView lv;
    ArrayList<String> stationList, codeList, lineCode1, lineCode2, lineCode3;
    Map<String, ArrayList<String>> map;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        try {
            final DownloadData dd = new DownloadData("OR");
            map = dd.execute().get();
            stationList = map.get("Station");
            codeList = map.get("Code");
            lineCode1 = map.get("LineCode1");
            lineCode2 = map.get("LineCode2");
            lineCode3 = map.get("LineCode3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        View view = inflater.inflate(R.layout.fragment_line, container, false);

        lv = (ListView) view.findViewById(R.id.listView);
        LineListAdapter adapter = new LineListAdapter(getActivity(), stationList, lineCode1, lineCode2, lineCode3);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), stationList.get(i), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), FragmentStationTimes.class);
                intent.putExtra("stationCode", codeList.get(i));
                startActivity(intent);
            }
        });
        return view;
    }
}

class RedLineFragment extends Fragment {

    ListView lv;
    ArrayList<String> stationList, codeList, lineCode1, lineCode2, lineCode3;
    Map<String, ArrayList<String>> map;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        try {
            final DownloadData dd = new DownloadData("RD");
            map = dd.execute().get();
            stationList = map.get("Station");
            codeList = map.get("Code");
            lineCode1 = map.get("LineCode1");
            lineCode2 = map.get("LineCode2");
            lineCode3 = map.get("LineCode3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        View view = inflater.inflate(R.layout.fragment_line, container, false);

        lv = (ListView) view.findViewById(R.id.listView);
        LineListAdapter adapter = new LineListAdapter(getActivity(), stationList, lineCode1, lineCode2, lineCode3);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), stationList.get(i), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), FragmentStationTimes.class);
                intent.putExtra("stationCode", codeList.get(i));
                startActivity(intent);
            }
        });
        return view;
    }
}

class SilverLineFragment extends Fragment {

    ListView lv;
    ArrayList<String> stationList, codeList, lineCode1, lineCode2, lineCode3;
    Map<String, ArrayList<String>> map;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        try {
            final DownloadData dd = new DownloadData("SV");
            map = dd.execute().get();
            stationList = map.get("Station");
            codeList = map.get("Code");
            lineCode1 = map.get("LineCode1");
            lineCode2 = map.get("LineCode2");
            lineCode3 = map.get("LineCode3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        View view = inflater.inflate(R.layout.fragment_line, container, false);

        lv = (ListView) view.findViewById(R.id.listView);
        LineListAdapter adapter = new LineListAdapter(getActivity(), stationList, lineCode1, lineCode2, lineCode3);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), stationList.get(i), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), FragmentStationTimes.class);
                intent.putExtra("stationCode", codeList.get(i));
                startActivity(intent);
            }
        });
        return view;
    }
}

class YellowLineFragment extends Fragment {

    ListView lv;
    ArrayList<String> stationList, codeList, lineCode1, lineCode2, lineCode3;
    Map<String, ArrayList<String>> map;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        try {
            final DownloadData dd = new DownloadData("YL");
            map = dd.execute().get();
            stationList = map.get("Station");
            codeList = map.get("Code");
            lineCode1 = map.get("LineCode1");
            lineCode2 = map.get("LineCode2");
            lineCode3 = map.get("LineCode3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        View view = inflater.inflate(R.layout.fragment_line, container, false);

        lv = (ListView) view.findViewById(R.id.listView);
        LineListAdapter adapter = new LineListAdapter(getActivity(), stationList, lineCode1, lineCode2, lineCode3);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), stationList.get(i), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), FragmentStationTimes.class);
                intent.putExtra("stationCode", codeList.get(i));
                startActivity(intent);
            }
        });
        return view;
    }
}

