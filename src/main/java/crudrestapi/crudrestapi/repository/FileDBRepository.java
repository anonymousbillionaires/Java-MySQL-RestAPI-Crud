package crudrestapi.crudrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import crudrestapi.crudrestapi.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}