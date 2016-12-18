package com.sgalvez.airports.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by sgalvez on 12/18/16.
 */
@RepositoryRestResource(collectionResourceRel = "airport", path = "airport")
public interface AirportRepository extends PagingAndSortingRepository<Airport, Long> {

    List<Airport> findByAirportCode(@Param("cityname") String cityname);

}