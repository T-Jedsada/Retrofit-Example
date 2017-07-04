package com.jedsada.retrofit.example;

import com.google.gson.annotations.SerializedName;

public class UserInfoDao {
    @SerializedName("login")
    private String login;
    @SerializedName("id")
    private int id;
    @SerializedName("url")
    private String url;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoDao userInfoDao = (UserInfoDao) o;

        if (id != userInfoDao.id) return false;
        if (login != null ? !login.equals(userInfoDao.login) : userInfoDao.login != null) return false;
        return url != null ? url.equals(userInfoDao.url) : userInfoDao.url == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserInfoDao{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
