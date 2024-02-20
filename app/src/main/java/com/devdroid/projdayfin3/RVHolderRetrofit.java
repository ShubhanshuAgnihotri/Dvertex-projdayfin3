package com.devdroid.projdayfin3;
import android.content.ClipData;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class RVHolderRetrofit extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView textView;

    public RVHolderRetrofit(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.productImage);
        textView = itemView.findViewById(R.id.productTitle);
    }

    public void bindData(Product item) {
        // Use Picasso to load image into ImageView
        Picasso.get().load(item.getImages().get(0)).into(imageView);

        textView.setText(item.getTitle());
    }
}

