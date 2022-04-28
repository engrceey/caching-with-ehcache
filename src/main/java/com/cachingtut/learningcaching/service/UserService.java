package com.cachingtut.learningcaching.service;

import com.cachingtut.learningcaching.model.User;
import com.cachingtut.learningcaching.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private UserRepository userRepository;

    @Cacheable(key = "'allUser'", value = "allUserCache")
    public List<User> getAllUsers() {
        System.out.println("Getting All the users from DB!");
        return userRepository.findAll();
    }

    @Cacheable(key = "#id",value = "oneUserSearchCache")
    public User searchUser(int id) {
        System.out.println("Getting the user from DB!");
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @CachePut(key = "'allUser'", value = "allUserCache")
    public User addNewUser(User user) {
        System.out.println("Registering the new user");
        userRepository.save(user);
        return user;
    }

    @CacheEvict(value = "allUserCache", allEntries = true)
    public boolean removeUser(int id) {
        System.out.println("Getting the user from DB!");
        if (userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            System.out.println("Successfully deleted the user!");
            return true;
        }
        System.out.println("User Not Found!");
        return false;
    }
}