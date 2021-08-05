package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wecancodeit.reviews.pojos.Hashtag;
import org.wecancodeit.reviews.pojos.Restaurant;
import org.wecancodeit.reviews.pojos.TypeOfRestaurant;
import org.wecancodeit.reviews.reposandstorage.HashtagRepository;
import org.wecancodeit.reviews.reposandstorage.RestaurantRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    HashtagRepository hashtagRepository;
    @Autowired
    TestEntityManager testEnManager;

    @Test
    public void restaurantShouldBeCreatedAndShouldHaveOneHashtag(){
        Hashtag hashtag = new Hashtag("#nasty");
        hashtagRepository.save(hashtag);
        Restaurant restaurant = new Restaurant("name","logo",2,"$",
                "description", TypeOfRestaurant.CHINESE,hashtag);
        restaurantRepository.save(restaurant);

        testEnManager.flush();
        testEnManager.clear();

        Restaurant retrievedRestaurant = restaurantRepository.findById(restaurant.getId()).get();
        assertThat(retrievedRestaurant.getHashtags()).contains(hashtag);
    }

    @Test
    public void restaurantShouldBeCreatedAndShouldHaveMultipleHashtags(){
        Hashtag hashtag1 = new Hashtag("#hitsdifferent");
        Hashtag hashtag2 = new Hashtag("foodbaby");
        hashtagRepository.save(hashtag1);
        hashtagRepository.save(hashtag2);
        Restaurant restaurant = new Restaurant("name","logo",4,"$$",
                "description",TypeOfRestaurant.AMERICAN,hashtag1,hashtag2);
        restaurantRepository.save(restaurant);

        testEnManager.flush();
        testEnManager.clear();

        Restaurant retrievedRestaurant = restaurantRepository.findById(restaurant.getId()).get();
        assertThat(retrievedRestaurant.getHashtags()).contains(hashtag1, hashtag2);

    }

    @Test
    public void restaurantShouldBeCreatedAndOnlyHaveOneType(){
        Restaurant restaurant = new Restaurant("name","logo",4,"$$",
                "description",TypeOfRestaurant.AMERICAN);
        restaurantRepository.save(restaurant);

        testEnManager.flush();
        testEnManager.clear();

        Restaurant retrievedRestaurant = restaurantRepository.findById(restaurant.getId()).get();
        assertThat(retrievedRestaurant.getTypeOfRest()).isEqualTo(TypeOfRestaurant.AMERICAN);
    }
}
