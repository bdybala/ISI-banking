package isi.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

}
