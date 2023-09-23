package com.example.demo.services;

import com.example.demo.entity.PersonEntity;
import com.example.demo.repo.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements IPersonaService {
    @Autowired
    private PersonRepository personRepository;
    @Override
    public List<PersonEntity> findAll() {
        return personRepository.findAll();
    }



    @Override
    @Transactional
    public void save(PersonEntity person) {
        personRepository.save( person);
    }
    @Override
    @Transactional
    public PersonEntity actualizar (PersonEntity  person) {
        return personRepository.save( person);
    }

    @Override
    @Transactional
    public PersonEntity deletePerson(Long id) {
        PersonEntity PerAux= personRepository.findByIdRepository(id);
        if (PerAux == null) {
            throw new EntityNotFoundException();
        }
        personRepository.delete(PerAux);
        return PerAux;

    }
}

