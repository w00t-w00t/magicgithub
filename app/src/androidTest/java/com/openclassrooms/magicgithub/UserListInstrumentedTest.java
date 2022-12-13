package com.openclassrooms.magicgithub;

import com.openclassrooms.magicgithub.ui.user_list.ListUserActivity;
import com.openclassrooms.magicgithub.utils.RecyclerViewUtils;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.openclassrooms.magicgithub.utils.RecyclerViewUtils.clickChildView;

/**
 * Instrumented test, which will execute on an Android device.
 * Testing ListUserActivity screen.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class UserListInstrumentedTest {

    // declare the scenario : the activity to be launched first
    @Rule
    public IntentsTestRule<ListUserActivity> mActivityRule = new IntentsTestRule<>(ListUserActivity.class);

    // current users list size
    private int currentUsersSize = -1;

    /**
     * Before each test, we get the current users size.
     */
    @Before
    public void setup() {
        currentUsersSize = mActivityRule.getActivity().getUserRepository().getUsers().size();
    }

    /**
     * Check if the recycler view is not empty at startup.
     */
    @Test
    public void checkIfRecyclerViewIsNotEmpty() {
        onView(withId(R.id.activity_list_user_rv)).check(new RecyclerViewUtils.ItemCount(currentUsersSize));
    }

    /**
     * Check if adding an item to the list is working.
     */
    @Test
    public void checkIfAddingRandomUserIsWorking() {
        // click to add a random user
        onView(withId(R.id.activity_list_user_fab)).perform(click());
        // check if the recycler view has one more item
        onView(withId(R.id.activity_list_user_rv)).check(new RecyclerViewUtils.ItemCount(currentUsersSize + 1));
    }

    /**
     * Check if deleting an item from the list is working.
     */
    @Test
    public void checkIfRemovingUserIsWorking() {
        // click to remove the first user
        onView(ViewMatchers.withId(R.id.activity_list_user_rv))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, clickChildView(R.id.item_list_user_delete_button)));
        // check if the recycler view has one less item
        onView(withId(R.id.activity_list_user_rv)).check(new RecyclerViewUtils.ItemCount(currentUsersSize - 1));
    }
}