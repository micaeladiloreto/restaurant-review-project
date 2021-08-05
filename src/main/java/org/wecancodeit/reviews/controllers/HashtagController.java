package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.reposandstorage.HashtagRepository;
import org.wecancodeit.reviews.reposandstorage.RestaurantStorage;
import org.wecancodeit.reviews.pojos.Hashtag;
import org.wecancodeit.reviews.pojos.Restaurant;

@Controller
public class HashtagController {
    private HashtagRepository hashTagRepo;
    private RestaurantStorage restaurantStorage;

    public HashtagController(HashtagRepository hashTagRepo, RestaurantStorage restaurantStorage) {
        this.hashTagRepo = hashTagRepo;
        this.restaurantStorage = restaurantStorage;
    }

    @RequestMapping("hashtags")
    public String displayAllHashtags(Model model){
        Iterable<Hashtag> hashtags = hashTagRepo.findAll();
        model.addAttribute("hashtags", hashtags);
        return "hashtag-list";
    }

    @RequestMapping("hashtags/{selectedHashtag}")
    public String displaySingleHashtag(Model model, @PathVariable String selectedHashtag){
        Hashtag hashtag = hashTagRepo.findHashtagByHashName(selectedHashtag);
        Iterable<Restaurant> restaurants = restaurantStorage.retrieveAllRestaurantsByHashtag(hashtag);
        model.addAttribute("restaurants", restaurants);
        return "hashtag-view";
    }
}
