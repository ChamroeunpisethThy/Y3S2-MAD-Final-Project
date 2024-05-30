package kh.edu.ferupp.mad.madproject.Adapters;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import kh.edu.ferupp.mad.madproject.Models.Categories;
import kh.edu.ferupp.mad.madproject.databinding.ViewHolderItemBinding;

public class CategoriesViewHolder extends RecyclerView.ViewHolder {
    private ViewHolderItemBinding binding;
    public CategoriesViewHolder (@NonNull ViewHolderItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
   public void bind (Categories categories){
       Picasso.get().load(categories.getImageUrl()).into((Target) binding.imageView);
       binding.titleView.setText(categories.getTitle());
   }
}
