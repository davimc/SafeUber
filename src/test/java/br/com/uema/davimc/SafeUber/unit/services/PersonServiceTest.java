package br.com.uema.davimc.SafeUber.unit.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import br.com.uema.davimc.SafeUber.models.DTO.PersonDTO;
import br.com.uema.davimc.SafeUber.models.Person;
import br.com.uema.davimc.SafeUber.repositories.PersonRepository;
import br.com.uema.davimc.SafeUber.services.PersonService;
import br.com.uema.davimc.SafeUber.services.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;


public class PersonServiceTest {

    private PersonRepository repository;
    private PersonService service;
    @BeforeEach
    public void setUp() {
        repository = mock(PersonRepository.class);
        service = new PersonService(repository);
    }

    @Test
    void testFindDTOById_SuccessWhenIdExist() {
        UUID id = UUID.randomUUID();
        Person person = new Person();
        person.setId(id);
        person.setName("John Doe");

        when(repository.findById(id)).thenReturn(Optional.of(person));

        PersonDTO result = service.findDTOById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("John Doe", result.getName());
    }
    @Test
    void testFindDTOById_FailedWhenIdNotExists() {
        UUID id = UUID.randomUUID();
        Person person = new Person();
        person.setId(id);
        person.setName("John Doe");

        when(repository.findById(id)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            service.findDTOById(id);
        });

        assertTrue(exception.getMessage().contains("Could not find object " +  person.getClass().getSimpleName() + "  for id: " + id));
    }
}
