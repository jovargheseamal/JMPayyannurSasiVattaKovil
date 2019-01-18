package com.ciatlab.jmpayyannursasivattakovil;

/**
 * Created by ADMIN on 29-04-2018.
 */

public class Show_class {
    String id,Comp,Email,Date;

    public Show_class( String comp, String email,String id, String date) {
        this.id = id;
        Comp = comp;
        Email = email;
        Date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComp() {
        return Comp;
    }

    public void setComp(String comp) {
        Comp = comp;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
