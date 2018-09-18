package com.online.entity;

public class Student {
    private Integer studentid;

    private String username;

    private String password;

    private Integer result;

    private Integer classno;

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getClassno() {
        return classno;
    }

    public void setClassno(Integer classno) {
        this.classno = classno;
    }
}