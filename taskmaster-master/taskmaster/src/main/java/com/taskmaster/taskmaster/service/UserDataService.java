package com.taskmaster.taskmaster.service;

import com.taskmaster.taskmaster.model.UserData;

import java.util.Optional;

public interface UserDataService {

    public Optional<UserData> findUserDataById(Long UserDataId);
}
