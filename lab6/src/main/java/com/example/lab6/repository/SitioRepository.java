package com.example.lab6.repository;

import com.example.lab6.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SitioRepository extends JpaRepository<Site, Integer> {
}
