package br.com.uema.davimc.SafeUber.models.DTO;

import br.com.uema.davimc.SafeUber.models.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    private UUID id;
    private String name;

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
    }
}

