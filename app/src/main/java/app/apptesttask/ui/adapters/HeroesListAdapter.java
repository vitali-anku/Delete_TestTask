package app.apptesttask.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import app.apptesttask.R;
import app.apptesttask.mvp.presenter.HeroesListTabFragmentPresenter;
import app.apptesttask.mvp.view.ListAdapterView;
import de.hdodenhof.circleimageview.CircleImageView;

public class HeroesListAdapter extends RecyclerView.Adapter<HeroesListAdapter.HeroesViewHolder> {

    private HeroesListTabFragmentPresenter presenter;

    @Inject
    public HeroesListAdapter(HeroesListTabFragmentPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public HeroesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new HeroesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_heroes_list, parent, false));
    }

    @Override
    public void onBindViewHolder(HeroesViewHolder holder, int position) {
        presenter.onBindRepositoryRowViewAtPosition(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getCount();
    }

    class HeroesViewHolder extends RecyclerView.ViewHolder implements ListAdapterView {

        CircleImageView avatarImageView;
        TextView nameHeroView;
        TextView descriptionHeroView;
        ImageButton imageButton;

        HeroesViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarImageView = itemView.findViewById(R.id.id_hero);
            nameHeroView = itemView.findViewById(R.id.name_hero);
            descriptionHeroView = itemView.findViewById(R.id.description_hero);
            imageButton = itemView.findViewById(R.id.btn_add_favoriet);
        }

        @Override
        public void setData(String image, String name, String description) {
            Glide.with(itemView.getContext())
                    .load(image)
                    .into(avatarImageView);
            nameHeroView.setText(name);
            descriptionHeroView.setText(description);
        }

        @Override
        public void setStar(int resId) {
            imageButton.setBackgroundResource(resId);
        }
    }
}
