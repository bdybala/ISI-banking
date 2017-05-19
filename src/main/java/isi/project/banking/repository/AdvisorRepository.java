package isi.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Advisor;

public interface AdvisorRepository extends JpaRepository<Advisor, String> {

}
