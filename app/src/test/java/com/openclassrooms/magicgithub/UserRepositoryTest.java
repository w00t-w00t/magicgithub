package com.openclassrooms.magicgithub;

import com.openclassrooms.magicgithub.di.Injection;
import com.openclassrooms.magicgithub.model.User;
import com.openclassrooms.magicgithub.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.List;
import java.util.stream.Collectors;

import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS;
import static com.openclassrooms.magicgithub.api.FakeApiServiceGenerator.FAKE_USERS_RANDOM;
import static org.junit.Assert.*;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;


/**
 * Unit test, which will execute on a JVM.
 * Testing UserRepository.
 */
@RunWith(JUnit4.class)
public class UserRepositoryTest {

    /**
     * UserRepository to test.
     */
    private UserRepository userRepository;

    /**
     * Setup UserRepository before each test.
     */
    @Before
    public void setup() {
        userRepository = Injection.createUserRepository();
    }

    /**
     * Test if the list of users from the repository matches the static initial generated list
     */
    @Test
    public void getUsersWithSuccess() {
        List<User> usersActual = userRepository.getUsers();
        List<User> usersExpected = FAKE_USERS;
        assertThat(usersActual, containsInAnyOrder(usersExpected.toArray()));
    }

    /**
     * Test if the random user is generated as expected (attributes like avatar, id, login, are not null)
     */
    @Test
    public void generateRandomUserWithSuccess() {
        // clear all initial users in the list
        userRepository.getUsers().clear();
        // generate a new random user
        userRepository.generateRandomUser();
        // get the random user from the list
        User user = userRepository.getUsers().get(0);
        // check if we have exactly one user in the list
        assertEquals(1, userRepository.getUsers().size());
        // check if attributes come from the random fake users list
        assertTrue(FAKE_USERS_RANDOM.stream().map(User::getAvatarUrl).collect(Collectors.toList()).contains(user.getAvatarUrl()));
        assertTrue(FAKE_USERS_RANDOM.stream().map(User::getId).collect(Collectors.toList()).contains(user.getId()));
        assertTrue(FAKE_USERS_RANDOM.stream().map(User::getLogin).collect(Collectors.toList()).contains(user.getLogin()));
        // check if attributes DO not come from the initial fake users list
        assertFalse(FAKE_USERS.stream().map(User::getAvatarUrl).collect(Collectors.toList()).contains(user.getAvatarUrl()));
        assertFalse(FAKE_USERS.stream().map(User::getId).collect(Collectors.toList()).contains(user.getId()));
        assertFalse(FAKE_USERS.stream().map(User::getLogin).collect(Collectors.toList()).contains(user.getLogin()));
    }

    /**
     * Test if the user is deleted as expected (user is not in the list anymore)
     */
    @Test
    public void deleteUserWithSuccess() {
        User userToDelete = userRepository.getUsers().get(0);
        userRepository.deleteUser(userToDelete);
        assertFalse(userRepository.getUsers().contains(userToDelete));
    }
}