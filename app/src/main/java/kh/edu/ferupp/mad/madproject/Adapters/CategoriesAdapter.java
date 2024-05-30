package kh.edu.ferupp.mad.madproject.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import kh.edu.ferupp.mad.madproject.Models.Categories;
import kh.edu.ferupp.mad.madproject.databinding.FragmentHomeBinding;
import kh.edu.ferupp.mad.madproject.databinding.ViewHolderItemBinding;

public class CategoriesAdapter extends ListAdapter<Categories, CategoriesViewHolder> {
    public CategoriesAdapter() {
        super(new DiffUtil.ItemCallback<Categories>() {
            @Override
            public boolean areItemsTheSame(@NonNull Categories oldItem, @NonNull Categories newItem) {
                return false;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Categories oldItem, @NonNull Categories newItem) {
                return false;
            }
        });
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewHolderItemBinding binding = ViewHolderItemBinding.inflate(inflater);
        return new CategoriesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        Categories categories = getItem(position);
        holder.bind(categories);

    }
}
