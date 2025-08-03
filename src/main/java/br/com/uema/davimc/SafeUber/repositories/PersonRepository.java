package br.com.uema.davimc.SafeUber.repositories;

import br.com.uema.davimc.SafeUber.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Transactional(readOnly = true)
public interface PersonRepository extends JpaRepository<Person, UUID> {

}
