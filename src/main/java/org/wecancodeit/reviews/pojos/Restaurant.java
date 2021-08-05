package org.wecancodeit.reviews.pojos;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String logo;
    private int rating;
    private String price;

    @Lob
    private String description;

    private TypeOfRestaurant typeOfRest;

    @ManyToMany
    private Collection<Hashtag> hashtags;

    protected Restaurant(){}

    public Restaurant(String name, String logo, int rating, String price, String description,
                      TypeOfRestaurant typeOfRest, Hashtag... hashtags){
        this.name = name;
        this.logo = logo;
        this.rating = rating;
        this.price = price;
        this.description = description;
        this.typeOfRest = typeOfRest;
        this.hashtags = Set.of(hashtags);
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public void addHashtag(Hashtag inHashtag){
        hashtags.add(inHashtag);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public int getRating() {
        return rating;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public TypeOfRestaurant getTypeOfRest() {
        return typeOfRest;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", rating=" + rating +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", typeOfRest=" + typeOfRest +
                ", hashtags=" + hashtags +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(logo, that.logo) && Objects.equals(rating, that.rating) && Objects.equals(price, that.price) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, logo, rating, price, description);
    }
}
