package com.payway.demochat.repository;

import com.payway.demochat.model.CS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CSRepository extends JpaRepository<CS, UUID> {

}
