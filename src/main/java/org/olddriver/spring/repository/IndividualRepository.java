package org.olddriver.spring.repository;

import org.olddriver.spring.bean.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Integer>{
	
}
