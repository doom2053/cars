package com.mark.example.demo;
import com.mark.example.demo.Car;
import com.mark.example.demo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cars")
public class CarController {
	@Autowired
	CarRepository carRepository;
	
	@GetMapping("")
	public List<Car> getAllCars() {
	    return carRepository.findAll();
	}
	@PostMapping("")
public Car createCar(@Valid @RequestBody Car car) throws Exception { 
		System.out.println("My new car name is:" + car.getName()); 
		Car savedCar= carRepository.save(car);
		System.out.println("Successfully saved the car:" + savedCar.getName());
		
		return savedCar;  
	}
	
	@GetMapping("/{id}")
	public Car getCarById(@PathVariable(value = "id") Long carId) throws Exception {
	    return carRepository.findById(carId)
	            .orElseThrow(() -> new Exception(String.format("Car %s is not found", carId)));
	}	
	@DeleteMapping("cars/{id}")
	public ResponseEntity<?> deleteCar(@PathVariable(value = "id") Long carId) throws Exception {
	    Car car = carRepository.findById(carId)
	            .orElseThrow(() -> new Exception(String.format("Car %s can not be deleted", carId)));

	    carRepository.delete(car);

	    return ResponseEntity.ok().build();  
}
}
