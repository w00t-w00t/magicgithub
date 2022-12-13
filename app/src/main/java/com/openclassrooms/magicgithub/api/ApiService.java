package com.openclassrooms.magicgithub.api;

import com.openclassrooms.magicgithub.model.User;
import java.util.List;
import androidx.annotation.Nullable;

/**
 * Api service to fetch users.
 */
public interface ApiService {

    /**
     * Get the list of users
     */
    List<User> getUsers();

    /**
     * Generate a new user
     */
    void generateRandomUser();

    /**
     * Delete a user
     * @param username the user to delete
     */
    void deleteUser(User username);
}
