package kh.edu.ferupp.mad.madproject.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import kh.edu.ferupp.mad.madproject.databinding.ViewHolderItemBinding;
import kh.edu.ferupp.mad.madproject.models.Categories;
public class CategoriesAdapter extends ListAdapter<Categories, CategoriesViewHolder> {

    public CategoriesAdapter() {
        super(new DiffUtil.ItemCallback<Categories>() {
            @Override
            public boolean areItemsTheSame(@NonNull Categories oldItem, @NonNull Categories newItem) {
                // Assuming unique IDs for categories
                return oldItem.getIdCategory().equals(newItem.getIdCategory());
            }

            @Override
            public boolean areContentsTheSame(@NonNull Categories oldItem, @NonNull Categories newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewHolderItemBinding binding = ViewHolderItemBinding.inflate(inflater, parent, false);
        return new CategoriesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        Categories category = getItem(position);
        holder.bind(category);
    }
}