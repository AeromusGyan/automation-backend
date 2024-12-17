package com.automation.automation.repo;

import com.automation.automation.model.Educator;
import org.springframework.data.repository.CrudRepository;

public interface EducatorRepository extends CrudRepository<Educator, Long> {

    public Educator findByUsername(String username);

    public  Educator findByEmail(String email);
}
