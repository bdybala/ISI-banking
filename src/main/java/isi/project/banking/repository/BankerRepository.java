package isi.project.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Banker;

public interface BankerRepository extends JpaRepository<Banker, String> {

}
