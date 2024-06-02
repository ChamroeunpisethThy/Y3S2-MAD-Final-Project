package kh.edu.ferupp.mad.madproject.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import kh.edu.ferupp.mad.madproject.models.Joiners;
import kh.edu.ferupp.mad.madproject.databinding.ViewHolderJoinerlistBinding;

public class JoinersAdapter extends ListAdapter<Joiners, JoinersViewHolder> {

    public JoinersAdapter() {
        super(new DiffUtil.ItemCallback<Joiners>() {
            @Override
            public boolean areItemsTheSame(@NonNull Joiners oldItem, @NonNull Joiners newItem) {
                // Assuming unique IDs for joiners
                return oldItem.getJoinerId().equals(newItem.getJoinerId());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Joiners oldItem, @NonNull Joiners newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @NonNull
    @Override
    public JoinersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewHolderJoinerlistBinding binding = ViewHolderJoinerlistBinding.inflate(inflater, parent, false);
        return new JoinersViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull JoinersViewHolder holder, int position) {
        Joiners joiner = getItem(position);
        holder.bind(joiner);
    }
}
