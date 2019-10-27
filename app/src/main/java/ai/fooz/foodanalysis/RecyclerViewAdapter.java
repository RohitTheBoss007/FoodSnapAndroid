package ai.fooz.foodanalysis;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Juned on 3/27/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyView> {

    private List<String> list;
    CameraActivity cameraActivity;
    RecyclerView recyclerView;
    int selectedPosition;

    public class MyView extends RecyclerView.ViewHolder {

        public TextView textView;
        public LinearLayout cardview;

        public MyView(View view) {
            super(view);

            textView = (TextView) view.findViewById(R.id.textview1);
            cardview = (LinearLayout) view.findViewById(R.id.cardview);

        }
    }


    public RecyclerViewAdapter(List<String> horizontalList, CameraActivity cameraActivity, RecyclerView recyclerView, int sPos) {
        this.list = horizontalList;
        this.cameraActivity = cameraActivity;
        this.recyclerView = recyclerView;
        this.selectedPosition = sPos;
    }

    @Override
    public MyView onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_item, parent, false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyView holder, final int position) {

        holder.textView.setText(list.get(position));

        if (position==selectedPosition){
            holder.cardview.setBackgroundDrawable(cameraActivity.getResources().getDrawable(R.drawable.button_bg_blue));
            holder.textView.setTextColor(cameraActivity.getResources().getColor(R.color.white));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < list.size(); i++){
                    MyView myView = (MyView) recyclerView.findViewHolderForAdapterPosition(i);
                    myView.cardview.setBackgroundDrawable(cameraActivity.getResources().getDrawable(R.drawable.button_bg_white));
                    myView.textView.setTextColor(cameraActivity.getResources().getColor(R.color.gray));
                }


                holder.cardview.setBackgroundDrawable(cameraActivity.getResources().getDrawable(R.drawable.button_bg_blue));
                holder.textView.setTextColor(cameraActivity.getResources().getColor(R.color.white));

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}