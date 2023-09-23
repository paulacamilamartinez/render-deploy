package com.example.demo.repo;

import com.example.demo.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    @Query("SELECT r FROM PersonEntity r WHERE r.id = :id")
    public PersonEntity findByIdRepository(Long id);
}
