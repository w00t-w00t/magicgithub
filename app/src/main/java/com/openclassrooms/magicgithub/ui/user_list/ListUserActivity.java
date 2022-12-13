package com.openclassrooms.magicgithub.ui.user_list;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.openclassrooms.magicgithub.base.BaseActivity;
import com.openclassrooms.magicgithub.R;
import com.openclassrooms.magicgithub.model.User;

/**
 * Displays a list of users.
 */
public class ListUserActivity extends BaseActivity implements UserListAdapter.Listener {

    /**
     * The recycler view that displays the list of users.
     */
    RecyclerView recyclerView;

    /**
     * The float action button to add a random user.
     */
    FloatingActionButton fab;

    /**
     * The adapter that manages the list of users.
     */
    private UserListAdapter adapter;

    /**
     * Called when the activity is being created.
     * @param savedInstanceState The saved instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        configureFab();
        configureRecyclerView();
    }

    /**
     * Called when the activity is being resumed.
     */
    @Override
    protected void onResume() {
        super.onResume();
        // ensure to reload data when coming back after rotation and so on
        loadData();
    }

    /**
     * Configures the floating action button.
     */
    private void configureRecyclerView() {
        recyclerView = findViewById(R.id.activity_list_user_rv);
        adapter = new UserListAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    /**
     * Configures the floating action button.
     */
    private void configureFab() {
        fab = findViewById(R.id.activity_list_user_fab);
        fab.setOnClickListener(view -> {
            getUserRepository().generateRandomUser();
            loadData();
        });
    }

    /**
     * Loads/refresh the data.
     */
    private void loadData() {
        adapter.updateList(getUserRepository().getUsers());
    }

    /**
     * Called when a drop click is done on a user.
     * @param user The user.
     */
    @Override
    public void onClickDelete(User user) {
        Log.d(ListUserActivity.class.getName(), "User tries to delete a item.");
        getUserRepository().deleteUser(user);
        loadData();
    }
}
