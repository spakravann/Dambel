package com.faraa.sohrabpakravan.dambel.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class ProgramChildModel implements Parcelable {

    public final String type;
    public final String time;

    public ProgramChildModel(String _type, String _time) {
        this.type = _type;
        this.time = _time;

    }

    protected ProgramChildModel(Parcel in) {
        type = in.readString();
        time = in.readString();
    }

    public static final Creator<ProgramChildModel> CREATOR = new Creator<ProgramChildModel>() {
        @Override
        public ProgramChildModel createFromParcel(Parcel in) {
            return new ProgramChildModel(in);
        }

        @Override
        public ProgramChildModel[] newArray(int size) {
            return new ProgramChildModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(type);
        dest.writeString(time);
    }
}
