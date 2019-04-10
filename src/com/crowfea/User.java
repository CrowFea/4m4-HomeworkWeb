package com.crowfea;

public class User {

private String username;
private String userpass;
private int lognum;
private String regtime;
private String category;
private String name;
private String school;

public String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}
public String getUserpass() {
    return userpass;
}
public void setUserpass(String userpass) {
    this.userpass = userpass;
}

public int getLognum() {
    return lognum;
}
public void setLognum(int lognum) {
    this.lognum = lognum;
}
public String getRegtime() {
    return regtime;
}
public void setRegtime(String regtime) {
    this.regtime = regtime;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category=category;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name=name;
}

public String getSchool() {
	return school;
}

public void setSchool(String school) {
	this.school=school;
}
}