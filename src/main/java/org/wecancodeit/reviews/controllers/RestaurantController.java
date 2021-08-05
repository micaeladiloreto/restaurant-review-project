package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.reviews.reposandstorage.RestaurantStorage;
import org.wecancodeit.reviews.pojos.Restaurant;
import org.wecancodeit.reviews.pojos.TypeOfRestaurant;

@Controller   /* required annotation for a Spring controller.  This is a required predecessor to the '@RequestMapping' annotation */
public class RestaurantController {    /* declares a public class named RestaurantController, the same name as the file, for use by any other classes throughout the program   */
    private RestaurantStorage restStorage;

    public RestaurantController(RestaurantStorage restStorage) {
        this.restStorage = restStorage;
    }

    @RequestMapping("type-of-restaurants")   /* This Spring annotation maps the HTTP request to a handler method of the MVC controllers.  In this case 'type-of-restaurants' becomes the path from which the returned webpage is run */
    public String displaySingleRestaurantEnum(Model model) {  /* creates a method called 'disp...Enum'; accepts a Model returning a view name. Essentially copies the values of the enum into the String's internal buffer to be used in the loop to return the list of types of restaurants ??? */
        TypeOfRestaurant[] allRest = TypeOfRestaurant.values();   /* creates an Array named 'allRest' containing all the values from the enum 'TypeOfRestaurant' from the file TypeOfRestaurant.java */
        model.addAttribute("allRests", allRest);  /* "allRests" is the name used in the view to get the value with ${allRest}.  */

        return "type-list";  /* the name of the html file is returned */
    }

    @RequestMapping("type-of-restaurants/{typeOfRest}")
    public String displayRestaurantType(Model model, @PathVariable String typeOfRest, String name) {

        TypeOfRestaurant selectedType = TypeOfRestaurant.CHINESE;
        for (TypeOfRestaurant type : TypeOfRestaurant.values()) {
            if (type.name().equalsIgnoreCase(typeOfRest)) {
                selectedType = type;
            }
        }
        Iterable<Restaurant> restaurants = restStorage.retrieveAllByRestaurantType(selectedType);
        model.addAttribute("restaurants", restaurants);
        return "type-view";
    }

    @GetMapping("type-of-restaurants/{typeOfRest}/{name}")
    public String displaySingleRestaurant(Model model, @PathVariable String typeOfRest, @PathVariable String name) {
        Restaurant restaurant = restStorage.retrieveRestaurantByName(name);
        TypeOfRestaurant selectedType = TypeOfRestaurant.CHINESE;
        for (TypeOfRestaurant type : TypeOfRestaurant.values()) {
            if (type.name().equalsIgnoreCase(typeOfRest)) {
                selectedType = type;
            }
        }
        Iterable<Restaurant> restaurants = restStorage.retrieveAllByRestaurantType(selectedType);
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("restaurants", restaurants);

        return "restaurant-view";
    }

}
