package com.goudarziha.dcmetrorider;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentStationTimes extends Activity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_station_times);

    }
}

class DownloadStationTimes extends AsyncTask<Void, Void, ArrayList<String>>{

    String stationCode;

    DownloadStationTimes(String stationCode) {
        this.stationCode = stationCode;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<String> doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<String> arrayList) {
        super.onPostExecute(arrayList);
    }
}
