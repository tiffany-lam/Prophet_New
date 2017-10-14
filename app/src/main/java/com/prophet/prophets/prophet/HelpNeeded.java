package com.prophet.prophets.prophet;

/**
 * Created by Paz_X on 10/14/2017.
 */

public class HelpNeeded
{
    private int dbid;
    private String name;
    private String GpsCoordinates;


    public HelpNeeded(){}

    public HelpNeeded(int id, String naam, String gps)
    {
        this.dbid = id;
        this.name = naam;
        this.GpsCoordinates = gps;

    }


    public int getDbid() {return dbid;}

    public void setDbid(int dbid) {this.dbid = dbid;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getGpsCoordinates() {return GpsCoordinates;}

    public void setGpsCoordinates(String gpsCoordinates) {GpsCoordinates = gpsCoordinates;}


}
