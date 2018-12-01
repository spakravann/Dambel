package com.faraa.sohrabpakravan.dambel.Models;

import android.util.Log;

import org.ksoap2.serialization.SoapObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PhoneVerification {

    private String _code;
    private String _address;
    private Date _birthdayDate;


    public void set_code(String _code) {
        this._code = _code;
    }

    public String get_code() {
        return _code;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

    public Date get_birthdayDate() {
        return _birthdayDate;
    }

    public void set_birthdayDate(Date _birthdayDate) {
        this._birthdayDate = _birthdayDate;
    }

    public String get_address() {
        return _address;
    }

    public void set_birthdayDateFromString(String expirationDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            _birthdayDate = dateFormat.parse(expirationDate);
        } catch (Exception e) {
            _birthdayDate = new Date();
        }
    }

    public PhoneVerification(SoapObject input) {
        try {
            _code = input.getPropertySafelyAsString("Code");
            _address = input.getPropertySafelyAsString("Address");

            try {
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                _birthdayDate = formatter.parse(input.getPropertySafelyAsString("Birthday"));
            } catch (Exception ex) {
                _birthdayDate = new Date();
            }


        } catch (Exception e) {
            Log.e("PhoneVerification Soap", e.toString());
        }
    }
}
