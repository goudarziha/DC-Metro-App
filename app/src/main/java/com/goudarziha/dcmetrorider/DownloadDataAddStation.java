package com.goudarziha.dcmetrorider;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

public class DownloadDataAddStation extends AsyncTask<Void, Void, Map<String, ArrayList<String>>> {

    String stationTogether;
    ArrayList<String> lineCode1, lineCode2, lineCode3;
    Map<String, ArrayList<String>> hashMap;

    DownloadDataAddStation(String stationTogether) {
        this.stationTogether = stationTogether;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Map<String, ArrayList<String>> doInBackground(Void... voids) {
        try {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("http://api.wmata.com/Rail.svc/json/jStationInfo?StationCode=" + stationTogether + "&api_key=y7judqszawx3cx236tytb6gq");

            HttpResponse httpResponse = defaultHttpClient.execute(httpGet);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"));
            String json = bufferedReader.readLine();

            JSONObject jsonObject = new JSONObject(json);
            String line1 = jsonObject.getString("LineCode1");
            String line2 = jsonObject.getString("LineCode2");
            String line3 = jsonObject.getString("LineCode3");

            lineCode1.add(line1);
            lineCode2.add(line2);
            lineCode3.add(line3);

            hashMap.put("LineCode1", lineCode1);
            hashMap.put("LineCode2", lineCode2);
            hashMap.put("LineCode3", lineCode3);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    protected void onPostExecute(Map<String, ArrayList<String>> hashMap) {
        super.onPostExecute(hashMap);
    }
}
