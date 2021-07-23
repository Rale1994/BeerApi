package com.beerapi.BeerApi.controller;

import com.beerapi.BeerApi.entity.Beer;
import com.beerapi.BeerApi.exception.BeerException;
import com.beerapi.BeerApi.service.BeerService;
import com.beerapi.BeerApi.validators.FieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BeerController {

    @Autowired
    private BeerService beerService;

    @Autowired
    private FieldValidator fieldValidator;

    @PostMapping("/beer")
    public ResponseEntity<?> addBeer(@Valid @RequestBody Beer beer)throws MethodArgumentNotValidException {
        List<Beer> beerList = beerService.allBeers();

        if (beerList.size() >= 10) {
            return new ResponseEntity<String>("Can not insert beer, we already have 10 in database!", HttpStatus.NOT_ACCEPTABLE);
        }

        try {
            if (!fieldValidator.validateExistBeer(beerList, beer)) {
                return new ResponseEntity<String>("Can not insert beer, we already have beer with name: " + beer.getName() + " and description: " + beer.getDescription() + " in database!", HttpStatus.NOT_ACCEPTABLE);
            }

            Beer newBeer = beerService.saveBeer(beer);

            return new ResponseEntity<Beer>(newBeer, HttpStatus.CREATED);

        } catch (BeerException b) {
            throw new BeerException(b.getMessage());
        }
    }


    @GetMapping("/beer")
    public List<Beer> allBeers() {
        return beerService.allBeers();
    }

    @GetMapping("/beer/{id}")
    public ResponseEntity<?> getBeerById(@PathVariable int id) {
        Beer beer = beerService.getOneBeer(id);
        if (beer == null) {
            return new ResponseEntity<String>("Beer with id " + id + " has not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Beer>(beer, HttpStatus.OK);
    }

    @PutMapping("/beer")
    public ResponseEntity<?> updateBeer(@Valid @RequestBody Beer beer) {
        List<Beer> beerList = beerService.allBeers();

        if (fieldValidator.validateExistBeer(beerList, beer)) {
            return new ResponseEntity<String>("You need to change some fields if want to update beer information!", HttpStatus.NOT_ACCEPTABLE);
        }

        Beer updatedBeer = beerService.updateBeer(beer);

        return new ResponseEntity<Beer>(updatedBeer, HttpStatus.OK);
    }

    @DeleteMapping("/beer/{id}")
    public String deleteBeer(@PathVariable int id) {
        Beer beer = beerService.getOneBeer(id);

        if (beer == null) {
            return "Beer with id " + id + " has not found! We can not delete!";
        }
        return beerService.deleteBeer(id);
    }

}
