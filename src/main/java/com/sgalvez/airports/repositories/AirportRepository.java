package com.sgalvez.airports.repositories;

import com.sgalvez.airports.models.Airport;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Created by sgalvez on 12/25/16.
 */
public interface AirportRepository extends CrudRepository<Airport, String>{
     List<Airport> findByAirportCode(String airportCode);
}
