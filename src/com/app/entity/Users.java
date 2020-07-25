/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/**
 *
 * @author ahza0
 */
public class Users {
    private int userID;
    private String name;
    private String title;
    private String email;
    private String password;
    private String position;
    private Date birthDate;
    private Date hireDate;
    private SimpleDateFormat sdfGet = new SimpleDateFormat("yyyy-MMM-dd");
    private SimpleDateFormat sdfSet = new SimpleDateFormat("yyyy-MMM-dd");

    public Users() {
    }

    public Users(JSONObject obj) throws ParseException {
        this.userID = obj.optInt("userID");
        this.name = obj.optString("name");
        this.title = obj.optString("title");
        this.email = obj.optString("email");
        this.position = obj.optString("position");
        this.password = obj.optString("password");
        this.birthDate = sdfGet.parse(obj.optString("birthDate"));
        this.hireDate = sdfGet.parse(obj.optString("hireDate"));
    }
    
    public JSONObject toJson(){
       JSONObject json = new JSONObject();
       json.put("userID", userID);
       json.put("name", name);
       json.put("title", title);
       json.put("email", email);
       json.put("position", position);
       json.put("password", password);
       json.put("birthDate", sdfSet.format(birthDate));
       json.put("hireDate", sdfSet.format(hireDate));       
       return json;
    }
    
    public Object getValue(int index){
        switch(index){
            case 0: return userID;
            case 1: return name;
            case 2: return title;
            case 3: return sdfGet.format(birthDate);
            case 4: return sdfGet.format(hireDate);
            case 5: return position;
            case 6: return email;
            default: return null;
        }
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    
}
