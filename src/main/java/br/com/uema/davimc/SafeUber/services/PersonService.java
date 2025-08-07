package br.com.uema.davimc.SafeUber.services;

import br.com.uema.davimc.SafeUber.models.DTO.PersonDTO;
import br.com.uema.davimc.SafeUber.models.Person;
import br.com.uema.davimc.SafeUber.repositories.PersonRepository;
import br.com.uema.davimc.SafeUber.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }
    private Person findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(id, Person.class));
    }

    public PersonDTO findDTOById(UUID id) {
        return new PersonDTO(findById(id));
    }
}
