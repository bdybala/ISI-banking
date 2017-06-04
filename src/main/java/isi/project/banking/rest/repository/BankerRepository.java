package isi.project.banking.rest.repository;

import isi.project.banking.rest.model.Banker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankerRepository extends JpaRepository<Banker, String> {

}
