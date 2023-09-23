package com.ntp.myadmin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntp.myadmin.models.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}
