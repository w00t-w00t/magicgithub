package com.openclassrooms.magicgithub.ui.user_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.openclassrooms.magicgithub.R;
import com.openclassrooms.magicgithub.model.User;
import com.openclassrooms.magicgithub.utils.UserDiffCallback;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * The adapter that manages the list of users.
 */
public class UserListAdapter extends RecyclerView.Adapter<ListUserViewHolder> {

    /**
     * The list of users.
     */
    private List<User> users = new ArrayList<>();

    /**
     * The listener that handles the delete click on a user.
     */
    private final Listener callback;
    public interface Listener {
        void onClickDelete(User user);
    }

    /**
     * Constructor.
     * @param callback The listener that handles the delete click on a user.
     */
    public UserListAdapter(Listener callback) {
        this.callback = callback;
    }

    /**
     * Called when the view holder is being created.
     * @param parent The parent view.
     * @param viewType The view type.
     * @return The view holder.
     */
    @NonNull
    @Override
    public ListUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create view holder and inflating its xml layout
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_list_user, parent,false);
        // Return a new holder instance
        return new ListUserViewHolder(view);
    }

    /**
     * Called when the view holder is being bound.
     * @param holder The view holder.
     * @param position The position.
     */
    @Override
    public void onBindViewHolder(@NonNull ListUserViewHolder holder, int position) {
        holder.bind(users.get(position), callback);
    }

    /**
     * Returns the number of items.
     * @return The number of items.
     */
    @Override
    public int getItemCount() {
        return users.size();
    }

    /**
     * Updates the list of users.
     * @param newList The new list of users.
     */
    public void updateList(List<User> newList) {
        // calculate diff between old and new list
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new UserDiffCallback(newList, this.users));
        // create a fresh list from the new list
        this.users = new ArrayList<>(newList);
        // dispatch the diff result to the adapter
        diffResult.dispatchUpdatesTo(this);
    }
}

