package com.beerapi.BeerApi.service;

import com.beerapi.BeerApi.entity.Beer;
import com.beerapi.BeerApi.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;

    public Beer saveBeer(Beer beer) {
        return beerRepository.save(beer);
    }

    public Beer saveBeer(List<Beer> beers) {
        return (Beer) beerRepository.saveAll(beers);
    }

    public List<Beer> allBeers() {
        return beerRepository.findAll();
    }

    public Beer updateBeer(Beer beer) {
        Beer existingBeer = beerRepository.findById(beer.getId()).orElse(null);
        existingBeer.setName(beer.getName());
        existingBeer.setDescription(beer.getDescription());
        existingBeer.setTemperature(beer.getTemperature());
        return beerRepository.save(existingBeer);
    }

    public Beer getOneBeer(int id) {
        return beerRepository.findById(id).orElse(null);
    }

    public String deleteBeer(int id) {
        beerRepository.deleteById(id);
        return "Beer with id " + id + " is deleted!";
    }


}
