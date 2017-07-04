package com.jedsada.retrofit.example;

import com.google.gson.annotations.SerializedName;

public class UserReposDao {
    @SerializedName("id")
    private int id;
    @SerializedName("full_name")
    private String fullName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserReposDao that = (UserReposDao) o;

        if (id != that.id) return false;
        return fullName != null ? fullName.equals(that.fullName) : that.fullName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserReposDao{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
