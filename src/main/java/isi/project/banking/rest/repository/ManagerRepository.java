package isi.project.banking.rest.repository;

import isi.project.banking.rest.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, String> {

}
