package com.example.libraryManagementProject.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuedBooksRepository extends JpaRepository<IssuedBooks, Integer> {

}
