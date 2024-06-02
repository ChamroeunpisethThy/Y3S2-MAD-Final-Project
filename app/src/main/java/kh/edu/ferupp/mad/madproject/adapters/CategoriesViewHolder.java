package kh.edu.ferupp.mad.madproject.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import kh.edu.ferupp.mad.madproject.models.Categories;
import kh.edu.ferupp.mad.madproject.databinding.ViewHolderItemBinding;

public class CategoriesViewHolder extends RecyclerView.ViewHolder {
    private ViewHolderItemBinding binding;

    public CategoriesViewHolder(@NonNull ViewHolderItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Categories categories) {
        Picasso.get().load(categories.getImageUrl()).into(binding.imageUrl);
        binding.description.setText(categories.getDescription());
    }
}
