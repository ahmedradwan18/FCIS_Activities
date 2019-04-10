package com.aradwan054.fcis_activites;

public class Activity {
    private String activity_name;
    private String activity_vision;

    public Activity(String activity_name, String activity_vision, String activity_mission, String activity_backGround, String activity_foreGround, int activity_year) {
        this.activity_name = activity_name;
        this.activity_vision = activity_vision;
        this.activity_mission = activity_mission;
        this.activity_backGround = activity_backGround;
        this.activity_foreGround = activity_foreGround;
        this.activity_year = activity_year;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getActivity_vision() {
        return activity_vision;
    }

    public void setActivity_vision(String activity_vision) {
        this.activity_vision = activity_vision;
    }

    public String getActivity_mission() {
        return activity_mission;
    }

    public void setActivity_mission(String activity_mission) {
        this.activity_mission = activity_mission;
    }

    public String getActivity_backGround() {
        return activity_backGround;
    }

    public void setActivity_backGround(String activity_backGround) {
        this.activity_backGround = activity_backGround;
    }

    public String getActivity_foreGround() {
        return activity_foreGround;
    }

    public void setActivity_foreGround(String activity_foreGround) {
        this.activity_foreGround = activity_foreGround;
    }

    public int getActivity_year() {
        return activity_year;
    }

    public void setActivity_year(int activity_year) {
        this.activity_year = activity_year;
    }

    private String activity_mission;
    private String activity_backGround;
    private String activity_foreGround;
    private int activity_year;
}
