package isi.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, String> {

}
