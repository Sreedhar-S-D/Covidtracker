package sample;

public class user {
    private String Name ;
    private int age;
    private String Bloodgrp;
    private String ufever;
    private String cough;
    private String uforeign;
    private String password;
    private String Nearbyhosp;

    public user(String name, int age, String bloodgrp, String ufever, String cough, String uforeign) {
        Name = name;
        this.age = age;
        Bloodgrp = bloodgrp;
        this.ufever = ufever;
        this.cough = cough;
        this.uforeign = uforeign;
    }
    public user(String name, int age, String bloodgrp, String ufever, String cough, String uforeign,String password, String NearbyHosp) {
        Name = name;
        this.age = age;
        Bloodgrp = bloodgrp;
        this.ufever = ufever;
        this.cough = cough;
        this.uforeign = uforeign;
        this.password =password;
        this.Nearbyhosp = NearbyHosp;
    }
    public user(String name, int age, String bloodgrp, String ufever, String cough, String uforeign,String NearbyHosp) {
        Name = name;
        this.age = age;
        Bloodgrp = bloodgrp;
        this.ufever = ufever;
        this.cough = cough;
        this.uforeign = uforeign;
        this.Nearbyhosp = NearbyHosp;

    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBloodgrp() {
        return Bloodgrp;
    }

    public void setBloodgrp(String bloodgrp) {
        Bloodgrp = bloodgrp;
    }

    public String getUfever() {
        return ufever;
    }

    public void setUfever(String ufever) {
        this.ufever = ufever;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCough() {
        return cough;
    }

    public void setCough(String cough) {
        this.cough = cough;
    }

    public String getUforeign() {
        return uforeign;
    }

    public void setUforeign(String uforeign) {
        this.uforeign = uforeign;
    }

    public String getNearbyhosp() {
        return Nearbyhosp;
    }

    public void setNearbyhosp(String nearbyhosp) {
        Nearbyhosp = nearbyhosp;
    }
}

