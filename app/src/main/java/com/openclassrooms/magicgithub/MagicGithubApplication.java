package com.openclassrooms.magicgithub;

import android.app.Application;

import com.openclassrooms.magicgithub.di.Injection;
import com.openclassrooms.magicgithub.repository.UserRepository;

import androidx.annotation.VisibleForTesting;

public class MagicGithubApplication extends Application {

    /**
     * Provides access to the data sources.
     */
    private UserRepository userRepository;

    /**
     * get the user repository
     * @return the user repository
     */
    public UserRepository getUserRepository() {
        if (userRepository == null) userRepository = Injection.createUserRepository();
        return userRepository;
    }

    /**
     * Used to force dependency injection to use a different data source in tests.
     */
    @VisibleForTesting
    public void resetUserRepository() {
        userRepository = null;
    }
}
