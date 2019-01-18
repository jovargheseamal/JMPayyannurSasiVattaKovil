package com.ciatlab.jmpayyannursasivattakovil;

/**
 * Created by ADMIN on 29-04-2018.
 */

public class ListClass {
    String id,Ename,Desc,Date;
    ListClass(String evntname, String descp, String id,String date)
    {
        this.id=id;
        this.Ename=evntname;
        this.Desc=descp;
        this.Date=date;
    }

    public String getEname() {
        return Ename;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
