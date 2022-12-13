package com.openclassrooms.magicgithub.ui.user_list;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.magicgithub.R;
import com.openclassrooms.magicgithub.model.User;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * The view holder for the user list.
 */
public class ListUserViewHolder extends RecyclerView.ViewHolder {

    /**
     * The image view for the avatar.
     */
    private ImageView avatar;

    /**
     * The text view for the name.
     */
    private TextView username;

    /**
     * The image button for the delete.
     */
    private ImageButton deleteButton;

    /**
     * Constructor.
     * @param itemView The view.
     */
    public ListUserViewHolder(@NonNull View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.item_list_user_avatar);
        username = itemView.findViewById(R.id.item_list_user_username);
        deleteButton = itemView.findViewById(R.id.item_list_user_delete_button);
    }

    /**
     * Binds a user to the view holder.
     * @param user The user.
     * @param callback The callback.
     */
    public void bind(User user, UserListAdapter.Listener callback) {

        // Load the avatar image
        Glide.with(itemView.getContext())
                .load(user.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(avatar);

        // Set the username
        username.setText(user.getLogin());

        // Set the delete button click listener
        deleteButton.setOnClickListener(view -> callback.onClickDelete(user));
    }
}
