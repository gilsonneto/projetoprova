package com.gigi.prova.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gigi.prova.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
