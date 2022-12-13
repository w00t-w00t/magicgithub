package com.openclassrooms.magicgithub.repository;

import com.openclassrooms.magicgithub.api.ApiService;
import com.openclassrooms.magicgithub.model.User;

import java.util.List;

public class UserRepository {

    /**
     * The API Service
     */
    private final ApiService apiService;

    /**
     * Constructor
     * @param apiService the API Service
     */
    public UserRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    /**
     * Get a list of users
     * @return the list of users
     */
    public List<User> getUsers() {
        return apiService.getUsers();
    }

    /**
     * Generate a random user
     */
    public void generateRandomUser() {
        apiService.generateRandomUser();
    }

    /**
     * Delete a user
     * @param user the user to delete
     */
    public void deleteUser(User user) {
        apiService.deleteUser(user);
    }
}
