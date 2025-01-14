package com.taskmaster.taskmaster.reporitory;


import com.taskmaster.taskmaster.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {
}
