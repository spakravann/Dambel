package com.faraa.sohrabpakravan.dambel.Models;

import android.util.Log;

import org.ksoap2.serialization.SoapObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    private int _id;
    private String _firstName;
    private String _lastName;
    private String _mobilePhone;
    private String _email;
    private String _imageURL;
    private String _userType;
    private String _appToken;
    private Date _tokenExpDate;
    private String _code;
    private String _address;
    private Date _birthday;
    private String _username;
    private String _status;
    private String _vipPrice;


    public void set_code(String _code) {
        this._code = _code;
    }

    public String get_code() {
        return _code;
    }

    public void set_appToken(String _appToken) {
        this._appToken = _appToken;
    }

    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }


    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_id() {
        return _id;
    }

    public void set_birthday(Date _birthday) {
        this._birthday = _birthday;
    }

    public Date get_birthday() {
        return _birthday;
    }

    public String get_appToken() {
        return _appToken;
    }

    public void set_email(String _email) {
        this._email = _email;
    }


    public void set_firstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String get_email() {
        return _email;
    }


    public String get_firstName() {
        return _firstName;
    }

    public void set_imageURL(String _imageURL) {
        this._imageURL = _imageURL;
    }

    public String get_imageURL() {
        return _imageURL;
    }

    public void set_lastName(String _lastName) {
        this._lastName = _lastName;
    }

    public String get_lastName() {
        return _lastName;
    }

    public void set_mobilePhone(String _mobilePhone) {
        this._mobilePhone = _mobilePhone;
    }

    public String get_mobilePhone() {
        return _mobilePhone;
    }

    public void set_status(String _status) {
        this._status = _status;
    }

    public String get_status() {
        return _status;
    }

    public void set_tokenExpDate(Date _tokenExpDate) {
        this._tokenExpDate = _tokenExpDate;
    }

    public Date get_tokenExpDate() {
        return _tokenExpDate;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_username() {
        return _username;
    }

    public void set_userType(String _userType) {
        this._userType = _userType;
    }

    public String get_userType() {
        return _userType;
    }

    public void set_vipPrice(String _vipPrice) {
        this._vipPrice = _vipPrice;
    }

    public String get_vipPrice() {
        return _vipPrice;
    }

    public User(){

    }

    public User(SoapObject input){

        try{
           // _id = Integer.valueOf(input.getPropertySafelyAsString("ID"));
            _firstName = input.getPropertySafelyAsString("FirstName");
            _lastName = input.getPropertySafelyAsString("LastName");
            _mobilePhone = input.getPropertySafelyAsString("MobilePhone");
            _email = input.getPropertySafelyAsString("Email");
            _imageURL = input.getPropertySafelyAsString("ImageURL");
            _appToken = input.getPropertySafelyAsString("AppToken");
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                _tokenExpDate = formatter.parse(input.getPropertySafelyAsString("Birthday"));
                _birthday = formatter.parse(input.getPropertySafelyAsString("Birthday"));
            } catch (Exception ex) {
                _tokenExpDate = new Date();
                _birthday = new Date();
            }
            _userType = input.getPropertySafelyAsString("UserType");
            _code = input.getPropertySafelyAsString("Code");
           // _address = input.getPropertySafelyAsString("Address");
            _username = input.getPropertySafelyAsString("UserName");
            _status = input.getPropertySafelyAsString("Status");
            _vipPrice = input.getPropertySafelyAsString("VIP_Price");


        } catch(Exception e){
            Log.e("User Soap", e.toString());
        }

    }
}
