package org.wecancodeit.reviews.pojos;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private String hashName;

    @ManyToMany(mappedBy = "hashtags")
    private Set<Restaurant> restaurants;

    protected Hashtag() {
    }

    public Hashtag(String hashName) {
        this.hashName = hashName;
    }

    public Long getId() {
        return id;
    }

    public String getHashName() {
        return hashName;
    }

    @Override
    public String toString() {
        return hashName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtag hashtag = (Hashtag) o;
        return Objects.equals(id, hashtag.id) && Objects.equals(hashName, hashtag.hashName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hashName);
    }
}




