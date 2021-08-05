package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wecancodeit.reviews.reposandstorage.HashtagRepository;
import org.wecancodeit.reviews.reposandstorage.RestaurantStorage;
import org.wecancodeit.reviews.pojos.TypeOfRestaurant;
import org.wecancodeit.reviews.pojos.Hashtag;
import org.wecancodeit.reviews.pojos.Restaurant;

@Controller
public class FormInputController {
    private HashtagRepository hashtagRepo;
    private RestaurantStorage restStorage;

    public FormInputController(HashtagRepository hashtagRepo, RestaurantStorage restStorage){
        this.hashtagRepo = hashtagRepo;
        this.restStorage = restStorage;
    }

    @PostMapping("type-of-restaurants/{typeOfRest}/{name}")
    public String hashtagFormInput(Model model, @RequestParam String usrHashtag, @PathVariable String typeOfRest,
                                   @PathVariable String name){

        Hashtag newHashtag = new Hashtag(usrHashtag);
        Hashtag existingHashtag = hashtagRepo.findHashtagByHashName(usrHashtag);
        if(usrHashtag.length()>0){
            if(existingHashtag == null){
                hashtagRepo.save(newHashtag);
            }
            else{
                newHashtag = existingHashtag;
            }
        }
        Restaurant restaurant = restStorage.retrieveRestaurantByName(name);
        TypeOfRestaurant selectedType = TypeOfRestaurant.CHINESE;
        for (TypeOfRestaurant type : TypeOfRestaurant.values()) {
            if (type.name().equalsIgnoreCase(typeOfRest)) {
                selectedType = type;
            }
        }
        if(usrHashtag.length()>0) {
            if (!restaurant.getHashtags().contains(newHashtag)) {
                restaurant.addHashtag(newHashtag);
                restStorage.saveRestaurant(restaurant);
            }
        }

        Iterable<Restaurant> restaurants = restStorage.retrieveAllByRestaurantType(selectedType);
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("restaurants", restaurants);
        return "restaurant-view";
    }
}
