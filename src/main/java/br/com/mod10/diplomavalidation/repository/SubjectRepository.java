package br.com.mod10.diplomavalidation.repository;

import br.com.mod10.diplomavalidation.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
