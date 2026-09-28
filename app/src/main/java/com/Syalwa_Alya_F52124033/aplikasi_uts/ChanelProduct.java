package com.Syalwa_Alya_F52124033.aplikasi_uts;

public class ChanelProduct {
    private final int id;
    private final String name;
    private final String subtitle;
    private final String category;
    private final String price;
    private final String description;
    private final String volume;
    private final double rating;
    private final int reviewsCount;
    private final int imageResId;
    private boolean isFavorite;

    public ChanelProduct(int id, String name, String subtitle, String category, String price,
                         String description, String volume, double rating, int reviewsCount,
                         int imageResId) {
        this.id = id;
        this.name = name;
        this.subtitle = subtitle;
        this.category = category;
        this.price = price;
        this.description = description;
        this.volume = volume;
        this.rating = rating;
        this.reviewsCount = reviewsCount;
        this.imageResId = imageResId;
        this.isFavorite = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getVolume() {
        return volume;
    }

    public double getRating() {
        return rating;
    }

    public int getReviewsCount() {
        return reviewsCount;
    }

    public int getImageResId() {
        return imageResId;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
