package com.openclassrooms.magicgithub.utils;

import android.view.View;

import org.hamcrest.Matcher;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Utility class for RecyclerView
 */
public class RecyclerViewUtils {

    /**
     * Check if the RecyclerView has the expected number of items utility class
     */
    public static class ItemCount implements ViewAssertion {

        // Number of items expected
        private final int expectedCount;

        // Constructor
        public ItemCount(int expectedCount) {
            this.expectedCount = expectedCount;
        }

        // Check if the RecyclerView has the expected number of items
        @Override
        public void check(View view, NoMatchingViewException noViewFoundException) {
            // Check if the view has been found
            if (noViewFoundException != null) {
                throw noViewFoundException;
            }
            // Check if the view is a RecyclerView
            RecyclerView recyclerView = (RecyclerView) view;
            // Get the recycler view adapter
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            // Check if the number of items is the expected one
            assertThat(adapter.getItemCount(), is(expectedCount));
        }
    }

    /**
     * Factory to get a view action that clicks on a child view with a specified id
     */
    public static ViewAction clickChildView(final int id) {
        // ViewAction that clicks on a child view with a specified id
        return new ViewAction() {

            // No constraints
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            // Get the description of the action
            @Override
            public String getDescription() {
                return "Click on a child view with specified id.";
            }

            // Perform the action
            @Override
            public void perform(UiController uiController, View view) {
                // Find view with specified id
                View v = view.findViewById(id);
                // Perform click on view
                v.performClick();
            }

        };
    }
}