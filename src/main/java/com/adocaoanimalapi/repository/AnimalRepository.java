package com.adocaoanimalapi.repository;

import com.adocaoanimalapi.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
