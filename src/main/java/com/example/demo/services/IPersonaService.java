package com.example.demo.services;

import com.example.demo.entity.PersonEntity;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    public List<PersonEntity> findAll();
    public PersonEntity deletePerson(Long id);
    public PersonEntity actualizar(PersonEntity person );
    public void save(PersonEntity person);

}
