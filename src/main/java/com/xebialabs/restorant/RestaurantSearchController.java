package com.xebialabs.restorant;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantSearchController {

  public List<Restaurant> allRestaurants;

  public RestaurantSearchController() {
    allRestaurants = new ArrayList<Restaurant>();
    allRestaurants.add(new Restaurant("Anchor & Hope", "Once there was just St John, then former St John chefs started to create their own restaurants using the same template – head-to-tail ingredients in simple but artful combinations, served up in a relaxed setting. The Anchor &amp; Hope, which opened more than a decade ago, is still showing how it's done."));
    allRestaurants.add(new Restaurant("Jugged Hare", "After years of very thin pickings, the Barbican has recently acquired not one but two classy gastropubs. This, and the Chiswell Street Dining Rooms (opened in 2011) are both part of Ed and Tom Martin's ten-strong empire. The Jugged Hare was once called the King's Head; it's been handsomely remodelled, with a lovely oak floor, red leather seating and more than a scattering of stuffed and mounted animals."));
    allRestaurants.add(new Restaurant("Old Red Cow", "The old red cow herself, if she wasn't apocryphal, probably didn't have a pleasant visit to this pub's manor – Long Lane was an ancient cattle route to Smithfield meat market. You can see the cupolas, domes and reliefs of London's temple of butchery through the front windows of this refurbed Victorian site, which no longer uses its antique 'Ye Olde' prefix and has turned its focus to serving very good beer."));
  }

  @RequestMapping("/findrestaurants")
  public List<Restaurant> greeting(@RequestParam(value = "q", defaultValue = "") String q) {
    List<Restaurant> selectedRestaurants = new ArrayList<   Restaurant>();
    for(Restaurant r: allRestaurants) {
      if(r.matches(q)) {
        selectedRestaurants.add(r);
      }
    }
    return selectedRestaurants;
  }

}
