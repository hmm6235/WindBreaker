package com.example.windbreaker_edit;

import android.os.AsyncTask;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CallJson extends AsyncTask<Integer, Void, JsonReader>{
    private String uri;
    public CallJson(){super();uri = " http://3.17.125.138:8080/signUp";}
    public CallJson(String uri){super();this.uri = uri;}
    @Override
    protected JsonReader doInBackground(Integer... integers) {
        //send("http://3.17.125.138:8080/signUp");

        URL myEndpoint =null;
        HttpURLConnection myConnection = null;
        InputStream responseBody = null;
        InputStreamReader responseBodyReader = null;
        JsonReader jsonReader = null;
        try {
            myEndpoint = new URL(uri);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            myConnection = (HttpURLConnection) myEndpoint.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myConnection.setRequestProperty("User-Agent", "my-rest-app-v0.1");


        try {
            if (myConnection.getResponseCode() == 200) {  //400 로그인 false
                responseBody = myConnection.getInputStream();
                responseBodyReader =
                        new InputStreamReader(responseBody, "UTF-8");
                jsonReader = new JsonReader(responseBodyReader);
                // jsonReader.beginArray();
//                while (jsonReader.hasNext()) {
//                    readObject(jsonReader);
//                }
//                jsonReader.endArray();

            } else {/*
                value[0].setName("error");value[0].setAddress("error");value[0].setTel("error");
                value[0].setDate("error");*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        myConnection.disconnect();
        return jsonReader;
    }
}
