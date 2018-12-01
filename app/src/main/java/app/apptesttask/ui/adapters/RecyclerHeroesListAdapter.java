package app.apptesttask.ui.adapters;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import app.apptesttask.R;
import app.apptesttask.mvp.models.heroes.Character;
import app.apptesttask.mvp.models.heroes.Image;
import app.apptesttask.mvp.presenter.HeroesListTabFragmentPresenter;
import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerHeroesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private List<Character> mHeroesList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_heroes_list, viewGroup, false);
        return new HeroesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((HeroesViewHolder)viewHolder).bind(mHeroesList.get(position));
    }

    @Override
    public int getItemCount() {
        return mHeroesList.size();
    }

    public void setItemsList(@NonNull List<Character> heroesList){
//        if(!clear){
            int position = heroesList.size();
            mHeroesList.addAll(heroesList);

            notifyItemRangeInserted(position, heroesList.size());
//        }
//        else {
//            mHeroesList.clear();
//            mAvatarsList.clear();
//            notifyDataSetChanged();
//        }
    }

    public void clearItemList(){
        mHeroesList.clear();
        notifyDataSetChanged();
    }

    public class HeroesViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.avatar_image)
        CircleImageView avatarImageView;
        @BindView(R.id.name_hero)
        TextView nameHeroView;
        @BindView(R.id.description_hero)
        TextView descriptionHeroView;
        @BindView(R.id.favorites_id)
        Button favoritesIdButton;

        HeroesViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        void bind(final Character character){

            Image img = character.getThumbnail();

            Glide.with(itemView.getContext()).load(Uri.parse(img.toString())).into(avatarImageView);
            nameHeroView.setText(character.getName());
            descriptionHeroView.setText(character.getName());

            favoritesIdButton.setOnClickListener(v -> {

            });
        }
    }
}
