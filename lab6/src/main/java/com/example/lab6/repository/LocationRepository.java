package com.example.lab6.repository;

import com.example.lab6.dto.LocationCountryCity;
import com.example.lab6.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {


    @Query(nativeQuery = true, value = "SELECT locationId, concat(Country, '-',City) as loc FROM gticslab6.location;")
    List<LocationCountryCity> obtenerComboBoxSitio();

}
