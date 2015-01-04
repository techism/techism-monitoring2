package org.techism.monitoring.domain;

import java.util.List;

import org.springframework.data.repository.Repository;


public interface PageCheckRepository extends Repository<PageCheck, Long> {
	
    public List<PageCheck> findAll();
	
}
