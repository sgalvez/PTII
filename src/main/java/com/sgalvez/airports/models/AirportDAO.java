package com.sgalvez.airports.model;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by sgalvez on 12/17/16.
 */

//TODO: Documentar anotaciones
@Repository
@Transactional
public class AirportDAO {

    @SuppressWarnings("unchecked")
    public List<Airport> getAll(){
        return entityManager.createQuery("from Airport").getResultList();
    }

    public Airport getByAirportCode(String airportcode){
        return (Airport) (entityManager.createQuery("from Airport where airportcode = :airportcode")
                .setParameter("airportcode", airportcode).getSingleResult());
    }

    @PersistenceContext
    private EntityManager entityManager;
}
