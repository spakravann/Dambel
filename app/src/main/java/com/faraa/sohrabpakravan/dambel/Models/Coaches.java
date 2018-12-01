package com.faraa.sohrabpakravan.dambel.Models;

public class Coaches {

    String _code;
    String _lisenceUrl;
    String _levelID;
    String _levelName;
    double _point;



    //delete later

    String name;
    String speciality;
    String price;
    int image;

    public Coaches(){

    }

    public Coaches(String _name, String _speciality, String _price, int _image){

        name = _name;
        speciality = _speciality;
        price = _price;
        image = _image;

    }


    public void set_code(String _code) {
        this._code = _code;
    }

    public String get_code() {
        return _code;
    }

    public void setLisenceUrl(String lisenceUrl) {
        this._lisenceUrl = lisenceUrl;
    }

    public String getLisenceUrl() {
        return _lisenceUrl;
    }

    public void set_levelID(String _levelID) {
        this._levelID = _levelID;
    }

    public String get_levelID() {
        return _levelID;
    }

    public void set_levelName(String _levelName) {
        this._levelName = _levelName;
    }

    public String get_levelName() {
        return _levelName;
    }

    public void set_lisenceUrl(String _lisenceUrl) {
        this._lisenceUrl = _lisenceUrl;
    }

    public double get_point() {
        return _point;
    }

    public String getName() {
        return name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

}
