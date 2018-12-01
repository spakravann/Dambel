package com.faraa.sohrabpakravan.dambel.Models;

import android.util.Log;

import org.ksoap2.serialization.SoapObject;

import java.util.ArrayList;

public class CoachDetails {

    private String _id;
    private String _code;
    private String _lisenceUrl;
    private String _levelID;
    private String _vipPrice;
    private String _levelName;
    private Double _point;
    private String _sportFieldID;
    private String _sportFieldName;

    ArrayList<User> _user;

    public CoachDetails() {

        _user = new ArrayList<>();

    }

    public void set_code(String _code) {
        this._code = _code;
    }

    public String get_code() {
        return _code;
    }

    public void set_lisenceUrl(String _lisenceUrl) {
        this._lisenceUrl = _lisenceUrl;
    }

    public double get_point() {
        return _point;
    }

    public void set_levelName(String _levelName) {
        this._levelName = _levelName;
    }

    public String get_levelName() {
        return _levelName;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_id() {
        return _id;
    }

    public void set_point(double _point) {
        this._point = _point;
    }

    public String get_lisenceUrl() {
        return _lisenceUrl;
    }

    public void set_sportFieldID(String _sportFieldID) {
        this._sportFieldID = _sportFieldID;
    }

    public String get_sportFieldID() {
        return _sportFieldID;
    }

    public void set_sportFieldName(String _sportFieldName) {
        this._sportFieldName = _sportFieldName;
    }

    public String get_sportFieldName() {
        return _sportFieldName;
    }

    public void set_vipPrice(String _vipPrice) {
        this._vipPrice = _vipPrice;
    }

    public String get_vipPrice() {
        return _vipPrice;
    }

    public void set_levelID(String _levelID) {
        this._levelID = _levelID;
    }

    public String get_levelID() {
        return _levelID;
    }

    public void set_user(ArrayList<User> _user) {
        this._user = _user;
    }

    public ArrayList<User> get_user() {
        return _user;
    }

    public CoachDetails(SoapObject input) {

        _user = new ArrayList<>();


        try {

            _code = input.getPropertySafelyAsString("Code");
            _lisenceUrl = input.getPropertySafelyAsString("LisenceUrl");
            _levelID = input.getPropertySafelyAsString("LevelID");
            _vipPrice = input.getPropertySafelyAsString("VIP_Price");
            _levelName = input.getPropertySafelyAsString("LevelName");
            _sportFieldID = input.getPropertySafelyAsString("SportFieldId");
            _sportFieldName = input.getPropertySafelyAsString("SportFieldName");
            try {
                _point = new Double(Double.valueOf(input.getPropertySafelyAsString("Point")));
            } catch (NumberFormatException e) {
                _point = 0.0; // your default value
            }

            //get list of users
            SoapObject user = (SoapObject) input.getPropertySafely("CoachList");
            if (user != null) {
                for (int i = 0; i < user.getPropertyCount(); ++i) {

                    _user.add( new User((SoapObject)user.getProperty(i)));
                }
            }

        } catch (Exception e) {
            Log.e("CoachDetail Soap", e.toString());
        }
    }
}
