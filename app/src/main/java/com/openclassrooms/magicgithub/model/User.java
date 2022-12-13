package com.openclassrooms.magicgithub.model;

import java.util.Objects;
import java.util.Random;
import androidx.annotation.Nullable;
import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS_RANDOM;

/**
 * Model representing a User
 */
public class User {

    /**
     * User's unique identifier
     */
    private String id;

    /**
     * User's login
     */
    private String login;

    /**
     * User's avatar url
     */
    private String avatarUrl;

    /**
     * Constructor
     * @param id User's unique identifier
     * @param login User's login
     * @param avatarUrl User's avatar url
     */
    public User(String id, String login, String avatarUrl) {
        this.id = id;
        this.login = login;
        this.avatarUrl = avatarUrl;
    }

    /**
     * Getters
     */
    public String getId() { return id; }
    public String getLogin() { return login; }
    public String getAvatarUrl() { return avatarUrl; }

    /**
     * Generate random user
     */
    public static User random(){
        return FAKE_USERS_RANDOM.get(new Random().nextInt(FAKE_USERS_RANDOM.size()));
    }

    /**
     * Consider that two users are equals, if their avatars url and logins are equals
     * @param obj
     * @return
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof User)) return false;
        return (((User) obj).avatarUrl == this.avatarUrl && ((User) obj).login == this.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, avatarUrl);
    }
}