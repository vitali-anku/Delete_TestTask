package app.apptesttask.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import app.apptesttask.R;
import app.apptesttask.mvp.models.LocalData;
import app.apptesttask.mvp.models.heroes.Character;
import app.apptesttask.mvp.presenter.HeroesListAdapterPresenter;
import app.apptesttask.mvp.view.HeroesListsView;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerHeroesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements HeroesListsView {

    @InjectPresenter
    HeroesListAdapterPresenter heroesListAdapterPresenter;

    private boolean visibleBtnStar;

    private List<Character> mHeroesList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_heroes_list, viewGroup, false);
        return new HeroesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((HeroesViewHolder) viewHolder).bind(mHeroesList.get(position), visibleBtnStar);
    }

    @Override
    public int getItemCount() {
        return mHeroesList.size();
    }

    public void setItemsList(@NonNull List<Character> heroesList, boolean visibleStar) {
        int position = heroesList.size();
        mHeroesList.addAll(heroesList);
        visibleBtnStar = visibleStar;
        notifyItemRangeInserted(position, heroesList.size());
    }

    public void clearItemList() {
        mHeroesList.clear();
        notifyDataSetChanged();
    }

    @Override
    public void updateLikes(List<Integer> inProgress, List<Integer> likesId) {

    }

    class HeroesViewHolder extends RecyclerView.ViewHolder {

        CircleImageView avatarImageView;
        TextView nameHeroView;
        TextView descriptionHeroView;
        ImageButton imageButton;

        HeroesViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarImageView = itemView.findViewById(R.id.id_hero);
            nameHeroView = itemView.findViewById(R.id.name_hero);
            descriptionHeroView = itemView.findViewById(R.id.description_hero);
            imageButton = itemView.findViewById(R.id.favorites_id);
        }

        void bind(final Character character, boolean visibleBtnStar) {

            Glide.with(itemView.getContext())
                    .load(character.getThumbnail().toString())
                    .into(avatarImageView);
            nameHeroView.setText(character.getName());
            descriptionHeroView.setText(character.getDescription());

            if(!visibleBtnStar){
                imageButton.setVisibility(View.GONE);
            }

            int id = character.getId();
            paintButton(id);

            imageButton.setOnClickListener(v -> {
                LocalData.toggleLike(id);
                paintButton(id);
            });
        }

        private void paintButton(int id){
            boolean status = LocalData.mInProgress.contains(id);
            if(status) imageButton.setBackgroundResource(R.drawable.ic_star_open);
            else imageButton.setBackgroundResource(R.drawable.ic_star_close);
        }
    }
}
