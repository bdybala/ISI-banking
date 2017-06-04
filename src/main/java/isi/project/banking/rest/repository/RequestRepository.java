package isi.project.banking.rest.repository;

import isi.project.banking.rest.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Integer> {

}
