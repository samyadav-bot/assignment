package com.example.Project1.service;

import com.example.Project1.entity.User;
import com.example.Project1.model.UserData;
import com.example.Project1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class UserRelationshipService {

    HashMap<Integer, UserData>  userRepMap=new HashMap<>();

    @Autowired
    UserRepository userRepository;

    public List<UserData> getUserRelationShip(){
        List<User> userAllData = getUserAllData();
       return addToUserRelationShipTree(userAllData);
    }

    private List<UserData> addToUserRelationShipTree( List<User> users){
        List<UserData>  userRepList=new ArrayList<>();
        Collections.sort(users, (x,y)-> x.getParentid()- y.getParentid());
        for(User user: users){
            UserData userData=new UserData();
            userData.setName(user.getName());
            if(!userRepMap.containsKey(user.getParentid())){
                userRepList.add(userData);
            }else{
                userRepMap.get(user.getParentid()).getChild().add(userData);
            }
            userRepMap.put(user.getId(),userData );

        }
        return userRepList;
    }

    private List<User> getUserAllData(){
        return userRepository.findAll();
    }

}
