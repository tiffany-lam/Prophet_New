package com.prophet.prophets.prophet;

/**
 * Created by Nick Spencer on 10/13/2017.
 */

public class Profile {
    private int DBID;
    private String name;
    private String familyMembers;
    private String skills;
    private String locations;

    public Profile(int DBID, String name, String familyMembers, String skills, String locations){
        this.DBID = DBID;
        this.name = name;
        this.familyMembers = familyMembers;
        this.skills = skills;
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(String familyMembers) {
        this.familyMembers = familyMembers;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public int getDBID(){
        return this.DBID;
    }

    public void setDBID(int DBID){
        this.DBID = DBID;
    }
}
