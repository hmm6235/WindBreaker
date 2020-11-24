package com.example.windbreaker_edit;

public class AttractionData {
    private String id,name, address, tel, date, latitude, longitude, description;
    public AttractionData(String id, String n, String a, String t, String d, String la, String lo, String de){
        name = n; address = a; tel = t; date = d; this.id=id;
        latitude = la; longitude = lo; description = de;
    }
    public AttractionData(){
        id= null; name = null; address = null; tel = null; date = null;
        latitude = null; longitude = null; description = null;
    }
    public void setId(String id){this.id=id;}
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setTel(String tel) { this.tel = tel; }
    public void setDate(String date) {this.date = date;}
    public void setLatitude(String latitude) {this.latitude = latitude;}
    public void setLongitude(String longitude) {this.longitude = longitude;}
    public void setDescription(String description) {this.description = description;}

    public String getId() {return id;}
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getTel() { return tel; }
    public String getDate() { return date; }
    public String getLatitude(){return latitude;}
    public String getLongitude() {return longitude;}
    public String getDescription() {return description;}
}

