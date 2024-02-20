package com.devdroid.projdayfin3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.devdroid.projdayfin3.ProductResultModel;

import java.util.List;

public class RVRetrofitAdapter extends RecyclerView.Adapter<RVRetrofitAdapter.ViewHolder> {
    private List<Product> productList;
    private Context context;

    public RVRetrofitAdapter(Context context, List<Product
            > productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.titleTextView.setText(product.getTitle());
        holder.priceTextView.setText(String.valueOf(product.getPrice()));
        holder.descriptionTextView.setText(product.getDescription());

        // Load image using Glide or another image loading library
        Glide.with(context).load(product.getImages().get(0)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idTextView;
        TextView titleTextView;
        TextView priceTextView;
        TextView descriptionTextView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.productTitle);
            priceTextView = itemView.findViewById(R.id.productPrice);
            descriptionTextView = itemView.findViewById(R.id.productDescription);
            imageView = itemView.findViewById(R.id.productImage);
        }
    }
}
