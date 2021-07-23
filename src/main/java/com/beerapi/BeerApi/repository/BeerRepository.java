package com.beerapi.BeerApi.repository;

import com.beerapi.BeerApi.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BeerRepository extends JpaRepository<Beer, Integer> {

}
