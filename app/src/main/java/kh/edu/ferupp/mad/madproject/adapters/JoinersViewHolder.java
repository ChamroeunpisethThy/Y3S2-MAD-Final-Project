package kh.edu.ferupp.mad.madproject.adapters;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import kh.edu.ferupp.mad.madproject.models.Joiners;
import kh.edu.ferupp.mad.madproject.databinding.ViewHolderJoinerlistBinding;
public class JoinersViewHolder extends RecyclerView.ViewHolder {
    private ViewHolderJoinerlistBinding binding;

    public JoinersViewHolder(@NonNull ViewHolderJoinerlistBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Joiners joiners) {
        Picasso.get().load(joiners.getImageUrl()).into(binding.imageUrl);
        binding.JoinerName.setText(joiners.getJoinerName());
        binding.school.setText(joiners.getSchool());
    }
}
