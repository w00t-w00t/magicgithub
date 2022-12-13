package com.openclassrooms.magicgithub.utils;

import com.openclassrooms.magicgithub.model.User;

import java.util.List;
import androidx.recyclerview.widget.DiffUtil;

/**
 * Utility class to compare list of users
 */
public class UserDiffCallback extends DiffUtil.Callback{

    /**
     * Old list of users
     */
    private final List<User> oldUsers;

    /**
     * New list of users
     */
    private final List<User> newUsers;

    /**
     * Constructor
     * @param newUsers new list of users
     * @param oldUsers old list of users
     */
    public UserDiffCallback(List<User> newUsers, List<User> oldUsers) {
        this.newUsers = newUsers;
        this.oldUsers = oldUsers;
    }

    /**
     * Get old list size
     * @return old list size
     */
    @Override
    public int getOldListSize() {
        return oldUsers.size();
    }

    /**
     * Get new list size
     * @return new list size
     */
    @Override
    public int getNewListSize() {
        return newUsers.size();
    }

    /**
     * Check if two items are the same at given positions
     * @param oldItemPosition old item position
     * @param newItemPosition new item position
     * @return
     */
    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldUsers.get(oldItemPosition).getId() == newUsers.get(newItemPosition).getId() ;
    }

    /**
     * Check if two items have the same content at given positions
     * @param oldItemPosition old item position
     * @param newItemPosition new item position
     * @return
     */
    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldUsers.get(oldItemPosition).equals(newUsers.get(newItemPosition));
    }
}