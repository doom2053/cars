package com.mark.example.demo;
import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.mark.example.demo.Car;
@Repository
//@RepositoryRestResource
//@CrossOrigin(origins = "http://localhost:4200")
@Transactional
public interface CarRepository extends JpaRepository<Car, Long> {
	
}