package com.codeforgeyt.onetomanywebservice.repository;

import com.codeforgeyt.onetomanywebservice.model.Disciplina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends CrudRepository<Disciplina, Long> {
}
