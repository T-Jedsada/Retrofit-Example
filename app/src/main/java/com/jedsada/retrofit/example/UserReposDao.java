package com.jedsada.retrofit.example;

import com.google.gson.annotations.SerializedName;

public class UserReposDao {
    @SerializedName("id")
    private int id;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("name")
    private String name;
    @SerializedName("language")
    private String language;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserReposDao that = (UserReposDao) o;

        if (id != that.id) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return language != null ? language.equals(that.language) : that.language == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserReposDao{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
