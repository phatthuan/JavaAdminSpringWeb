package com.ntp.myadmin.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ntp.myadmin.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
