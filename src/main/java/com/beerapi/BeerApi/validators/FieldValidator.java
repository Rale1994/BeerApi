package com.beerapi.BeerApi.validators;

import com.beerapi.BeerApi.entity.Beer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FieldValidator {

    public boolean validateExistBeer(List<Beer> beerList, Beer beer) {

        for (Beer bearDb : beerList) {
            if (bearDb.getName().equals(beer.getName()) || bearDb.getDescription().equals(beer.getDescription())) {
                return false;
            }
        }
        return true;
    }

}
