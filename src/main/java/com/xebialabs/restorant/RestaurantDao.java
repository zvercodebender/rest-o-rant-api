package com.xebialabs.restorant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestaurantDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Restaurant> getAllRestaurants(){

        List<Restaurant> allRestaurants = new ArrayList<>();

        jdbcTemplate.query(
                "SELECT name, snippet FROM restaurant",
                (rs, rowNum) -> new Restaurant(rs.getString("name"), rs.getString("snippet"))
        ).forEach(restaurant -> allRestaurants.add(restaurant));

        return allRestaurants;
    }
}
