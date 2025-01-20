package com.taskmaster.taskmaster.service.impl;

import com.taskmaster.taskmaster.model.UserData;
import com.taskmaster.taskmaster.reporitory.UserRepository;
import com.taskmaster.taskmaster.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserData> findUserDataById(Long UserDataId){
        return userRepository.findById(UserDataId);
    }

}
