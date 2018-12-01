package com.faraa.sohrabpakravan.dambel.WebService;

import android.content.Context;
import android.util.Log;

import com.faraa.sohrabpakravan.dambel.Models.CoachDetails;
import com.faraa.sohrabpakravan.dambel.Models.PhoneVerification;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import java.util.ArrayList;
import java.util.List;

public class Caller  extends Thread {
    private static final Object _balancee = null;
    public Soap cs;
    //AppSQLiteHelper db;
    private Context mContext;
    // public ResultID resultId;
    // public MatchTree resultMatchTree;
    private Context _soapContext;
    private int lang;

    public Caller() {

        //db = new AppSQLiteHelper(activity.getApplicationContext());
        // String url = "http://mylavan.com/tabletglobalservice.asmx";
        // cs = new SOAP("http://tempuri.org/", url);

        String url = "http://208.73.202.178:5050/webservices/dambelwebservice.asmx";
        //String url2 = "http://208.73.202.178:100/Service/regUserService.asmx";
        cs = new Soap("http://tempuri.org/", url);
        Log.i("SORI CAller", "url o khoond");

    }

    public String insertPhone(String phone)
    {
        List<PropertyInfo> list = new ArrayList<PropertyInfo>();


        PropertyInfo pi1 = new PropertyInfo();
        pi1.setName("phone");
        pi1.setValue(phone);
        pi1.setType(String.class);
        list.add(pi1);

        try {

            SoapObject resp = cs.Call("InsertPhone", list);


        } catch (Exception ex) {
            Log.e("Dambel_Caller", ex.toString());

        }
        return "";
    }

    public PhoneVerification phoneLogin(String phone, String code)
    {
        List<PropertyInfo> list = new ArrayList<PropertyInfo>();
        PhoneVerification result = null ;


        PropertyInfo pi1 = new PropertyInfo();
        pi1.setName("phone");
        pi1.setValue(phone);
        pi1.setType(String.class);
        list.add(pi1);

        PropertyInfo pi2 = new PropertyInfo();
        pi2.setName("code");
        pi2.setValue(code);
        pi2.setType(String.class);
        list.add(pi2);
        try {

            SoapObject resp = cs.Call("CheckVerificationCode", list);

            result = new PhoneVerification(resp);

        } catch (Exception ex) {
            Log.e("Dambel_Caller", ex.toString());

        }
        return result;
    }
    public CoachDetails getAllCoaches(String userID, String appToken)
    {
        List<PropertyInfo> list = new ArrayList<PropertyInfo>();
        CoachDetails result = null ;


        PropertyInfo pi1 = new PropertyInfo();
        pi1.setName("userID");
        pi1.setValue(userID);
        pi1.setType(String.class);
        list.add(pi1);

        PropertyInfo pi2 = new PropertyInfo();
        pi2.setName("appToken");
        pi2.setValue(appToken);
        pi2.setType(String.class);
        list.add(pi2);
        try {

            SoapObject resp = cs.Call("GetAllCoach", list);

            result = new CoachDetails(resp);

        } catch (Exception ex) {
            Log.e("Dambel_Caller", ex.toString());

        }
        return result;
    }


}
