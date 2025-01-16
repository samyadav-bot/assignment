package com.example.Project1.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class UserData {

    String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    List<UserData> child=new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserData> getChild() {
        return child;
    }

    public void setChild(List<UserData> child) {
        this.child = child;
    }
}
