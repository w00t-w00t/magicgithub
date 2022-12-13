package com.openclassrooms.magicgithub.base;

import com.openclassrooms.magicgithub.MagicGithubApplication;
import com.openclassrooms.magicgithub.repository.UserRepository;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Base activity that contains the user repository.
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * Get the user repository.
     * @return the user repository.
     */
    public UserRepository getUserRepository() {
        return ((MagicGithubApplication) getApplication()).getUserRepository();
    }
}
