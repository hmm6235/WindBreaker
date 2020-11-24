package kr.ac.koreatech.mainactivity;

import android.os.AsyncTask;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

        public class CallAttraction extends AsyncTask<Integer, Void, List<AttractionData>> {
            private String uri;
            List<AttractionData> list = new ArrayList<>();
            public CallAttraction(){super();uri = " http://3.17.125.138:8080/signUp";}
            public CallAttraction(String uri){super();this.uri = uri;}
            @Override
            protected List<AttractionData> doInBackground(Integer... integers) {
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
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    readObject(jsonReader);
                }
                jsonReader.endArray();

            //  String key = jsonReader.nextName();
            // value = jsonReader.nextString();
        } else {/*
                value[0].setName("error");value[0].setAddress("error");value[0].setTel("error");
                value[0].setDate("error");*/
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
        try {
            jsonReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myConnection.disconnect();
        return list;
    }

    private void readObject(JsonReader reader){
        try {
            reader.beginObject();
            AttractionData value = new AttractionData();
            while (reader.hasNext()) {
                String key = reader.nextName();
                if (key.equals("name")) {
                    value.setName(reader.nextString());
                    continue;
                } else if (key.equals("address")) {
                    value.setAddress(reader.nextString());
                    continue;
                }else if (key.equals("id")) {
                    value.setId(reader.nextString());
                    continue;
                } else if (key.equals("tell")) {
                    value.setTel(reader.nextString());
                    continue;
                } else if (key.equals("date")) {
                    value.setDate(reader.nextString());
                    break;
                } else if (key.equals("latitude")) {
                    value.setLatitude(reader.nextString());
                    continue;
                } else if (key.equals("longitude")) {
                    value.setLongitude(reader.nextString());
                    continue;
                } else if (key.equals("description")) {
                    value.setDescription(reader.nextString());
                    continue;
                } else {
                    reader.skipValue(); // Skip values of other keys
                }
            }
            list.add(value);
            reader.endObject();
        }catch(IOException e){e.printStackTrace();}
    }
    }