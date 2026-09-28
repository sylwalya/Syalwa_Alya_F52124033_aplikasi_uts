package com.Syalwa_Alya_F52124033.aplikasi_uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.Locale;

public class ChanelAdapter extends ArrayAdapter<ChanelProduct> {

    private final Context context;

    private static class ViewHolder {
        ImageView imgProduct;
        TextView tvCategory;
        ImageButton btnFavorite;
        TextView tvProductName;
        TextView tvProductSubtitle;
        TextView tvRating;
        TextView tvReviews;
        TextView tvPrice;
    }

    public ChanelAdapter(@NonNull Context context, @NonNull List<ChanelProduct> products) {
        super(context, 0, products);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_chanel_product, parent, false);
            holder = new ViewHolder();
            holder.imgProduct = convertView.findViewById(R.id.imgProduct);
            holder.tvCategory = convertView.findViewById(R.id.tvCategory);
            holder.btnFavorite = convertView.findViewById(R.id.btnFavorite);
            holder.tvProductName = convertView.findViewById(R.id.tvProductName);
            holder.tvProductSubtitle = convertView.findViewById(R.id.tvProductSubtitle);
            holder.tvRating = convertView.findViewById(R.id.tvRating);
            holder.tvReviews = convertView.findViewById(R.id.tvReviews);
            holder.tvPrice = convertView.findViewById(R.id.tvPrice);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ChanelProduct product = getItem(position);

        if (product != null) {
            holder.imgProduct.setImageResource(product.getImageResId());
            holder.tvCategory.setText(product.getCategory().toUpperCase(Locale.ROOT));
            holder.tvProductName.setText(product.getName());

            String subText = product.getSubtitle() + " • " + product.getVolume();
            holder.tvProductSubtitle.setText(subText);

            String ratingStr = String.format(Locale.getDefault(), "%.1f", product.getRating());
            holder.tvRating.setText(ratingStr);

            String reviewsStr = String.format(Locale.getDefault(), "(%,d ulasan)", product.getReviewsCount());
            holder.tvReviews.setText(reviewsStr);

            holder.tvPrice.setText(product.getPrice());

            if (product.isFavorite()) {
                holder.btnFavorite.setImageResource(R.drawable.ic_heart_filled);
            } else {
                holder.btnFavorite.setImageResource(R.drawable.ic_heart_outline);
            }

            holder.btnFavorite.setOnClickListener(v -> {
                boolean newState = !product.isFavorite();
                product.setFavorite(newState);
                if (newState) {
                    holder.btnFavorite.setImageResource(R.drawable.ic_heart_filled);
                    Toast.makeText(context, product.getName() + " ditambahkan ke Favorit ❤️", Toast.LENGTH_SHORT).show();
                } else {
                    holder.btnFavorite.setImageResource(R.drawable.ic_heart_outline);
                    Toast.makeText(context, product.getName() + " dihapus dari Favorit", Toast.LENGTH_SHORT).show();
                }
            });
        }

        return convertView;
    }
}
