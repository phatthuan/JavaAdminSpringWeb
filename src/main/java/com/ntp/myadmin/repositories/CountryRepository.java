package com.ntp.myadmin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntp.myadmin.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{
    
}
