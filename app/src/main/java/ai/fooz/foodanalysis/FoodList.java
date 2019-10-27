package ai.fooz.foodanalysis;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Movie;
import android.media.Image;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodList extends RecyclerView.Adapter<FoodList.MyViewHolder> {

    private List<FoodItem> foodList;

    public FoodList(List<FoodItem> foodList) {
        this.foodList = foodList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;
        public TextView cals;
        public TextView carbs;
        public TextView fats;
        public TextView prots;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.txt);
            image = (ImageView) view.findViewById(R.id.img);
            cals = (TextView) view.findViewById(R.id.cals);
            carbs = (TextView) view.findViewById(R.id.carbs);
            fats = (TextView) view.findViewById(R.id.fats);
            prots = (TextView) view.findViewById(R.id.prots);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_single, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FoodItem foodItem = foodList.get(position);
        holder.name.setText(foodItem.getName());
        holder.cals.setText(foodItem.getCalories());
        holder.carbs.setText(foodItem.getCarbs());
        holder.fats.setText(foodItem.getFats());
        holder.prots.setText(foodItem.getProteins());

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 8;
        final Bitmap bitmap = BitmapFactory.decodeFile(Uri.parse(foodItem.getImage()).getPath(),
                options);
        holder.image.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }
}
