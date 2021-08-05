package org.wecancodeit.reviews.reposandstorage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.pojos.Hashtag;
import org.wecancodeit.reviews.pojos.Restaurant;
import org.wecancodeit.reviews.pojos.TypeOfRestaurant;

@Service
public class RestaurantStorage {
    private RestaurantRepository restaurantRepo;

    public RestaurantStorage(RestaurantRepository restaurantRepo){
        this.restaurantRepo = restaurantRepo;
    }

    public Restaurant retrieveRestaurantById(Long id){
        return restaurantRepo.findById(id).get();
    }

    public Restaurant retrieveRestaurantByName(String name){
        return restaurantRepo.findByName(name);
    }

    public Iterable<Restaurant> retrieveAllByRestaurantType(TypeOfRestaurant typeOfRestaurant){
        return restaurantRepo.findAllByTypeOfRest(typeOfRestaurant);
    }

    public Restaurant retrieveRestaurantType(TypeOfRestaurant typeOfRestaurant){
        return restaurantRepo.findByTypeOfRest(typeOfRestaurant);
    }

    public void deleteRestaurantById(Long id){
        restaurantRepo.deleteById(id);
    }

    public void saveRestaurant(Restaurant restaurantToAdd){
        restaurantRepo.save(restaurantToAdd);
    }

    public Iterable<Restaurant> retrieveAllRestaurantsByHashtag(Hashtag hashName){
        return restaurantRepo.findRestaurantsByHashtags(hashName);
    }
}
