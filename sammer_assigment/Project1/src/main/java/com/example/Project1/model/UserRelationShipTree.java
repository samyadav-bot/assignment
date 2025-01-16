package com.example.Project1.model;

import com.example.Project1.entity.User;

import java.util.List;

public class UserRelationShipTree {

    List<UserData> rootlevel;

    public List<UserData> getRootlevel() {
        return rootlevel;
    }

    public void setRootlevel(List<UserData> rootlevel) {
        this.rootlevel = rootlevel;
    }
}
