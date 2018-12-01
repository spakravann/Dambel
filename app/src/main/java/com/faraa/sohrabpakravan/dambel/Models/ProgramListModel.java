package com.faraa.sohrabpakravan.dambel.Models;

public class ProgramListModel {

    String name;
    String speciality;
    String programType;
    int coachImage;
    int programImage;

    public ProgramListModel(){

    }

    public ProgramListModel(String _name, String _speciality, String _programType, int _coachImage, int _programImage){

        name = _name;
        speciality = _speciality;
        programType = _programType;
        coachImage = _coachImage;
        programImage = _programImage;

    }

    public void setCoachImage(int coachImage) {
        this.coachImage = coachImage;
    }

    public int getCoachImage() {
        return coachImage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setProgramImage(int programImage) {
        this.programImage = programImage;
    }

    public int getProgramImage() {
        return programImage;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getProgramType() {
        return programType;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }
}
