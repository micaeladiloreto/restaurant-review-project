package org.wecancodeit.reviews.reposandstorage;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.pojos.Hashtag;
import org.wecancodeit.reviews.pojos.Restaurant;
import org.wecancodeit.reviews.pojos.TypeOfRestaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    public Restaurant findByName(String name);
    public Restaurant findByTypeOfRest(TypeOfRestaurant typeOfRest);
    public Iterable<Restaurant> findAllByTypeOfRest(TypeOfRestaurant typeOfRestaurant);
    public Iterable<Restaurant> findRestaurantsByHashtags(Hashtag hashName);
}
