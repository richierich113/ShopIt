package com.richardduahboakye.shopit.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.richardduahboakye.shopit.ItemDetailsActivity;
import com.richardduahboakye.shopit.MainActivity;
import com.richardduahboakye.shopit.R;
import com.richardduahboakye.shopit.model.ItemModel;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    private Context context;
    private List<ItemModel> list;

    RequestOptions options;

    public RecyclerAdapter(Context context, List<ItemModel> list) {
        this.context = context;
        this.list = list;

        //Requesting options for Glide
        options = new RequestOptions().centerCrop().placeholder(R.drawable.img_shimmer).error(R.drawable.img_shimmer);

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        myViewHolder.listItemContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ItemDetailsActivity.class);
                intent.putExtra("name", list.get(myViewHolder.getAdapterPosition()).getName());
                intent.putExtra("rating", list.get(myViewHolder.getAdapterPosition()).getRating());
                intent.putExtra("price", list.get(myViewHolder.getAdapterPosition()).getPrice());
                intent.putExtra("stock", list.get(myViewHolder.getAdapterPosition()).getStock());
                intent.putExtra("category", list.get(myViewHolder.getAdapterPosition()).getCategory());
                intent.putExtra("description", list.get(myViewHolder.getAdapterPosition()).getDescription());
                intent.putExtra("img", list.get(myViewHolder.getAdapterPosition()).getImg());


                /*Pair[] pairs = new Pair[1];

                pairs[0] = new Pair<View,String>(myViewHolder.ListImageView, "ImageToImage");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                   // ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(context,pairs);
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, myViewHolder.ListImageView, "ImageToImage");

                }*/
                //ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, myViewHolder.ListImageView, "small_img");

                context.startActivity(intent);

            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

          //ItemModel itemModel = list.get(position);

        holder.ListName.setText(list.get(position).getName());
        holder.ListPrice.setText(list.get(position).getPrice());
        holder.ListRating.setText(list.get(position).getRating());
        holder.ListStock.setText(list.get(position).getStock());

        Glide.with(context).load(list.get(position).getImg()).apply(options).into(holder.ListImageView);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView ListImageView;
        TextView ListName;
        TextView ListPrice;
        TextView ListRating;
        TextView ListStock;

        RelativeLayout listItemContainer;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            listItemContainer = itemView.findViewById(R.id.container);
            ListImageView = itemView.findViewById(R.id.itemImg);
            ListName = itemView.findViewById(R.id.name);
            ListPrice = itemView.findViewById(R.id.price);
            ListRating = itemView.findViewById(R.id.rating);
            ListStock = itemView.findViewById(R.id.stock);
        }
    }
}
