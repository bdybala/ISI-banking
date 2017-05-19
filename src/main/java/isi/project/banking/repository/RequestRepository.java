package isi.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Request;

public interface RequestRepository extends JpaRepository<Request, Integer> {

}
