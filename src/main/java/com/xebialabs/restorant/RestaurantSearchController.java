package com.xebialabs.restorant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantSearchController {

  @Autowired
  RestaurantDao dao;

  @RequestMapping("/findrestaurants")
  public List<Restaurant> greeting(@RequestParam(value = "q", defaultValue = "") String q) {
    List<Restaurant> selectedRestaurants = new ArrayList<   Restaurant>();
    for(Restaurant r: dao.getAllRestaurants()) {
      if(r.matches(q)) {
        selectedRestaurants.add(r);
      }
    }
    return selectedRestaurants;
  }

}
