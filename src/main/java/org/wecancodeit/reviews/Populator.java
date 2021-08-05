package org.wecancodeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviews.pojos.Hashtag;
import org.wecancodeit.reviews.pojos.Restaurant;
import org.wecancodeit.reviews.pojos.TypeOfRestaurant;
import org.wecancodeit.reviews.reposandstorage.HashtagRepository;
import org.wecancodeit.reviews.reposandstorage.RestaurantStorage;

@Component
public class Populator implements CommandLineRunner {
    private RestaurantStorage restaurantStorage;
    private HashtagRepository hashtagRepository;

    public Populator(RestaurantStorage restaurantStorage, HashtagRepository hashtagRepository) {
        this.restaurantStorage = restaurantStorage;
        this.hashtagRepository = hashtagRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Hashtag foodBaby = new Hashtag("#foodbaby");
        hashtagRepository.save(foodBaby);
        Hashtag hitsDifferent = new Hashtag("#hitsdifferent");
        hashtagRepository.save(hitsDifferent);
        Hashtag mommasCooking = new Hashtag("#mommascooking");
        hashtagRepository.save(mommasCooking);
        Hashtag nasty = new Hashtag("#nasty");
        hashtagRepository.save(nasty);
        Hashtag oldSchool = new Hashtag("#oldschool");
        hashtagRepository.save(oldSchool);
        Hashtag yummy = new Hashtag("#yummy");
        hashtagRepository.save(yummy);

        Restaurant chiChis = new Restaurant("Chi-Chi's", "..\\images\\chi-chis-logo.png", 1, "$$",
                "So good they failed... In November 2003, a month after filing for Chapter 11 bankruptcy, " +
                        "Chi-Chi's was hit with the largest hepatitis A outbreak in U.S. history, with at least" +
                        " four deaths and 660 other victims of illness in the Pittsburgh area, including high" +
                        " school students who caught the disease from the original victims. The hepatitis was " +
                        "traced back to green onions at the Chi-Chi's at Beaver Valley Mall near Monaca, " +
                        "Pennsylvania, about 30 miles northwest of Pittsburgh. Chi-Chi's settled the hepatitis " +
                        "A lawsuits by July 2004. At the time the suits were settled, Chi-Chi's had only 65 " +
                        "restaurants, fewer than half of the number of four years prior.", TypeOfRestaurant.MEXICAN, nasty);
        Restaurant curry = new Restaurant("Curry-NA-Hurry", "..\\images\\curry-na-hurry.jpg", 4,
                "$$", "Great Curry! Must check out! Perfect for when you want some great Indian " +
                "food quickly and are feeling lazy.", TypeOfRestaurant.INDIAN, yummy, foodBaby);
        Restaurant gyro = new Restaurant("Gyro-Shoppe", "..\\images\\gyro-shoppe.jpg", 5, "$",
                "They have the best gyros.  The tzatziki sauce is to die for, not too thick, not too watery." +
                        "Also, their baklava is delicious.  Check it out!", TypeOfRestaurant.MEDITERRANEAN, yummy);
        Restaurant inNOut = new Restaurant("In-N-Out Burger", "..\\images\\in-n-out.svg", 5, "$$",
                "California staple. Mouth-watering burgers.  In-N-Out Burger is an American regional chain" +
                        " of fast food restaurants with locations primarily in California and the Southwest. The" +
                        " menu consists of three burger varieties: hamburger, cheeseburger, and" +
                        " \"Double-Double\" (two hamburger patties and two slices of cheese). French fries and" +
                        " fountain drinks are available, as well as three flavors of milkshakes. The hamburgers" +
                        " come with lettuce, tomato, with or without onions (the customer is asked upon ordering, and" +
                        " may have them fresh or grilled), and a sauce, which is called \"spread\" (a Thousand" +
                        " Island dressing variant).", TypeOfRestaurant.AMERICAN, oldSchool, yummy, foodBaby);
        Restaurant mcdonalds = new Restaurant("McDonald's", "..\\images\\mcdonalds.png", 2, "$",
                "An american fast food favorite. Delicious burgers and weirdly good french fries. " +
                        "Their coke and sprite just hits different.", TypeOfRestaurant.AMERICAN, oldSchool, hitsDifferent);
        Restaurant oliveGarden = new Restaurant("Olive Garden", "..\\images\\olive-garden.svg", 1,
                "$$", "Come here for your run of the mill spaghetti fare.  You can find lean cuisine " +
                "packages in the back. You could do better at home. Promise.", TypeOfRestaurant.ITALIAN,
                mommasCooking);
        Restaurant pandaExpress = new Restaurant("Panda Express", "..\\images\\panda-express.png",
                3, "$", "Panda Express is a fast casual chinese restaurant.They invented orange " +
                "chicken. Great place for quick and dirty chinese food.", TypeOfRestaurant.CHINESE, yummy);

        restaurantStorage.saveRestaurant(chiChis);
        restaurantStorage.saveRestaurant(curry);
        restaurantStorage.saveRestaurant(gyro);
        restaurantStorage.saveRestaurant(inNOut);
        restaurantStorage.saveRestaurant(mcdonalds);
        restaurantStorage.saveRestaurant(oliveGarden);
        restaurantStorage.saveRestaurant(pandaExpress);

    }
}


