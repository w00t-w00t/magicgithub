package com.openclassrooms.magicgithub.di;

import com.openclassrooms.magicgithub.api.FakeApiService;
import com.openclassrooms.magicgithub.repository.UserRepository;

/**
 * Dependency injector to get instances of services/repositories
 * It's like the singleton pattern : you can globally access to the same instance of a class
 */
public class Injection {

    // get the user repository, based on the fake api service
    public static UserRepository createUserRepository() {
        return new UserRepository(new FakeApiService());
    }

}
