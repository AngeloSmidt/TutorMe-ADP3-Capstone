package za.ac.cput.service;
/* Subject.java

     SubjectService POJO class

     Author: Keewan Titus (230778577)

     Date: 25 May 2025 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Subject;
import za.ac.cput.repository.SubjectRepository;

import java.util.List;

@Service
public class SubjectService implements ISubjectService {
    @Autowired
    private static ISubjectService service;

    private SubjectRepository repository;


    @Override
    public Subject create(Subject subject) {
        return this.repository.save(subject);
    }

    public Subject read(String subjectCode) {
        return this.repository.findById(subjectCode).orElse(null);
    }

    public Subject update(Subject subject) {
        return this.repository.save(subject);
    }

    @Override
    public boolean delete(String subjectCode) {
        this.repository.deleteById(subjectCode);
        return true;
    }

    @Override
    public List<Subject> getAll() {
        return this.repository.findAll();
    }
}