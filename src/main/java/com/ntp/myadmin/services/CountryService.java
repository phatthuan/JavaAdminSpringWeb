package com.ntp.myadmin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntp.myadmin.models.Country;
import com.ntp.myadmin.repositories.CountryRepository;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

    public void save(Country country){
        countryRepository.save(country);
    }

    public Optional<Country> findById(Integer id){
        return countryRepository.findById(id);
    }

    public void delete(Integer id){
        countryRepository.deleteById(id);
    }
}