package com.example.windbreaker_edit;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MyRest {
    public List<AttractionData> callAttraction(String search) throws ExecutionException, InterruptedException {
        String uri = "http://3.17.125.138:8080/windBreaker/attraction";
        List<AttractionData> list;
        uri = uri + "/search?search="+search;
        CallAttraction t = new CallAttraction(uri);
        //value = new AttractionData[10];
        list = t.execute().get();
        return list;
    }
}
