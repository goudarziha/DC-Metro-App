package com.goudarziha.dcmetrorider;

import android.os.AsyncTask;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DownloadData extends AsyncTask<Void, Void, Map<String, ArrayList<String>>> {

    public String line;
    ArrayList<String> addressList = new ArrayList<String>();
    ArrayList<String> stationList = new ArrayList<String>();
    ArrayList<String> codeList = new ArrayList<String>();
    ArrayList<String> stationTogether1List = new ArrayList<String>();
    ArrayList<String> stationTogether2List = new ArrayList<String>();
    ArrayList<String> lineCode1List = new ArrayList<String>();
    ArrayList<String> lineCode2List = new ArrayList<String>();
    ArrayList<String> lineCode3List = new ArrayList<String>();
    ArrayList<Double> latList = new ArrayList<Double>();
    ArrayList<Double> lonList = new ArrayList<Double>();

    DownloadData(String line) {
        this.line = line;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Map<String, ArrayList<String>> doInBackground(Void... String) {

        try {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("http://api.wmata.com/Rail.svc/json/jStations?LineCode=" + line + "&api_key=y7judqszawx3cx236tytb6gq");

            HttpResponse httpResponse = defaultHttpClient.execute(httpGet);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"));
            String json = bufferedReader.readLine();

            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("Stations");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject oneObject = jsonArray.getJSONObject(i);
                String station = oneObject.getString("Name");
                String code = oneObject.getString("Code");
                String stationTogether1 = oneObject.getString("StationTogether1");
                String stationTogether2 = oneObject.getString("StationTogether2");
                String lineCode1 = oneObject.getString("LineCode1");
                String lineCode2 = oneObject.getString("LineCode2");
                String lineCode3 = oneObject.getString("LineCode3");

                double lat = oneObject.getDouble("Lat");
                double lon = oneObject.getDouble("Lon");

                String street = oneObject.getJSONObject("Address").getString("Street");
                String city = oneObject.getJSONObject("Address").getString("City");
                String state = oneObject.getJSONObject("Address").getString("State");
                String zipCode = oneObject.getJSONObject("Address").getString("Zip");
                String address = street + " " + city + ", " + state + " " + zipCode;

                addressList.add(i, address);
                stationList.add(i, station);
                codeList.add(i, code);
                stationTogether1List.add(i, stationTogether1);
                stationTogether2List.add(i, stationTogether2);
                lineCode1List.add(i, lineCode1);
                lineCode2List.add(i, lineCode2);
                lineCode3List.add(i, lineCode3);
                latList.add(i, lat);
                lonList.add(i, lon);
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        map.put("Station", stationList);
        map.put("Code", codeList);
        map.put("StationTogether1", stationTogether1List);
        map.put("StationTogether2", stationTogether2List);
        map.put("LineCode1", lineCode1List);
        map.put("LineCode2", lineCode2List);
        map.put("LineCode3", lineCode3List);

        return map;
    }

    @Override
    protected void onPostExecute( Map<String, ArrayList<String>> map) {
        super.onPostExecute(map);
    }
}
