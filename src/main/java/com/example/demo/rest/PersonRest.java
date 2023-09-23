package com.example.demo.rest;

import com.example.demo.entity.PersonEntity;
import com.example.demo.services.IPersonaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Persona")
public class PersonRest {
    @Autowired
    private IPersonaService iPersonaService;

    @GetMapping("/test")
    private String Test() {
        return "Hola funciono";
    }

    @GetMapping("/listar")
    private ResponseEntity<List<PersonEntity>> ListarPersona() {
        return ResponseEntity.ok(iPersonaService.findAll());
    }


    @PostMapping("/crear")
    private ResponseEntity<PersonEntity> guardar(@Validated @RequestBody PersonEntity person) {
        try {
            iPersonaService.save(person);
            ResponseEntity.status(200);
            return ResponseEntity.ok(person);
        } catch (Exception e) {
            System.out.println("El error es: " + e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Object> EliminarByid(@PathVariable("id") Long id) {

        try {
            PersonEntity rese = iPersonaService.deletePerson(id);
            ResponseEntity.status(200);
            return ResponseEntity.ok(rese);
        } catch (EntityNotFoundException ex) {
            String errorMessage = "No se encuentran Personas asociados al ID : " + id;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }


    @PutMapping("/actualizar")
    private ResponseEntity<PersonEntity> actualizar(@RequestBody PersonEntity person) {
        PersonEntity temporal = iPersonaService.actualizar(person);

        try {
            return ResponseEntity.created(new URI(("/api/Persona/") + temporal.getId_persona())).body(temporal);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
