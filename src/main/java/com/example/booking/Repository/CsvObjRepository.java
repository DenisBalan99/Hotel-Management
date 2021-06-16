package com.example.booking.Repository;

import com.example.booking.Entity.csvObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CsvObjRepository extends JpaRepository<csvObj, Long> {
}
