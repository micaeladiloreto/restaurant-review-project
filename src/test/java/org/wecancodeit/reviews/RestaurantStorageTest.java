package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;
import org.wecancodeit.reviews.pojos.Restaurant;
import org.wecancodeit.reviews.reposandstorage.RestaurantRepository;
import org.wecancodeit.reviews.reposandstorage.RestaurantStorage;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;


public class RestaurantStorageTest {

    @Test
    public void restaurantStorageShouldSaveRestaurants() {
        RestaurantRepository restRepo = mock(RestaurantRepository.class);
        RestaurantStorage restaurantStorage = new RestaurantStorage(restRepo);
        Restaurant mockRestaurant = mock(Restaurant.class);

        restaurantStorage.saveRestaurant(mockRestaurant);

        verify(restRepo).save(mockRestaurant);
    }

    @Test
    public void restaurantStorageShouldRetrieveRestaurantByName() {
        RestaurantRepository restRepo = mock(RestaurantRepository.class);
        RestaurantStorage restaurantStorage = new RestaurantStorage(restRepo);
        Restaurant mockRestaurant = mock(Restaurant.class);

//        when(restRepo.findByName(mockRestaurant.getName()).thenReturn(Optional.of(mockRestaurant)) );

        Restaurant retrievedRestaurant = restaurantStorage.retrieveRestaurantByName(mockRestaurant.getName());

        assertThat(retrievedRestaurant).isEqualTo(mockRestaurant.getName());
    }

    @Test
    public void restaurantStorageShouldRetrieveRestaurantByType() {
        RestaurantRepository restRepo = mock(RestaurantRepository.class);
        RestaurantStorage restaurantStorage = new RestaurantStorage(restRepo);
        Restaurant mockRestaurant = mock(Restaurant.class);

        Restaurant retrievedRestaurant = restaurantStorage.retrieveRestaurantType(mockRestaurant.getTypeOfRest());

        assertThat(retrievedRestaurant).isEqualTo(mockRestaurant.getTypeOfRest());
    }

//    @Test
//    public void restaurantStorageShouldRetrieveAllRestaurantsByHashtag(){
//        HashtagRepository hashRepo = mock(HashtagRepository.class);
//        Hashtag mockHashtag = mock(Hashtag.class);
//        RestaurantRepository restRepo = mock(RestaurantRepository.class);
//        RestaurantStorage restaurantStorage = new RestaurantStorage(restRepo);
//        Restaurant mockRestaurant = mock(Restaurant.class);
//        Restaurant mockRestaurant2 = mock(Restaurant.class);
//
//
//        Iterable<Restaurant> retrievedRestaurants = restaurantStorage.retrieveAllRestaurantsByHashtag(mockHashtag);
//        Restaurant currentRestaurant= mockRestaurant;
//        for(Restaurant currentRestaurant1: retrievedRestaurants){
//            if(currentRestaurant1.getHashtags().contains(mockHashtag)) {
//                currentRestaurant = currentRestaurant1;
//            }
//        }
//        assertThat(currentRestaurant.getHashtags()).contains(mockHashtag);
//    }

//needs to be worked
//    @Test
//    public void restaurantStorageShouldRetrieveAllRestaurantsByType(){
//        RestaurantRepository restRepo = mock(RestaurantRepository.class);
//        RestaurantStorage restaurantStorage = new RestaurantStorage(restRepo);
//        Restaurant mockRestaurant = mock(Restaurant.class);
//
//        Restaurant retrievedRestaurant = restaurantStorage.retrieveRestaurantType(mockRestaurant.getTypeOfRest());
//
//        assertThat(retrievedRestaurant).isEqualTo(mockRestaurant.getTypeOfRest());
//    }
//


}
