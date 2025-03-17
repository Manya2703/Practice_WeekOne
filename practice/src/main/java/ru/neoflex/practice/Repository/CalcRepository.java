package ru.neoflex.practice.Repository;

import ru.neoflex.practice.Model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CalcRepository extends JpaRepository<Calculation, Long> {
}