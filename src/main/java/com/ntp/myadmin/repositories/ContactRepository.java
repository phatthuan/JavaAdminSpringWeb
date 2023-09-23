package com.ntp.myadmin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntp.myadmin.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    
}
