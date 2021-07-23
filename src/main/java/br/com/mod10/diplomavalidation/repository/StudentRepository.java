package br.com.mod10.diplomavalidation.repository;

import br.com.mod10.diplomavalidation.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    public Student findByName(String name);
}
