/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.taskscheduling;

import com.google.common.collect.Lists;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radoo
 */
@Service("carService")
@Repository
@Transactional
public class CarServiceImpl implements CarService {

	final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);
	@Autowired
	CarRepository carRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Car> findAll() {
		return Lists.newArrayList(carRepository.findAll());
	}

	@Override
	public Car save(Car car) {
		return carRepository.save(car);
	}

	@Override
	@Scheduled(fixedRate = 5000)/*Pomoje bi bilo bolje da je to v Config-u???*/
	public void updateCarAgeJob() {
		System.out.println("***************************************TASK TRIGGERED***********************************************");
		List<Car> cars = findAll();
		DateTime currentDate = DateTime.now();
		logger.info("Car age update job started");
		for (Car car : cars) {
			int age
				= Years.yearsBetween(car.getManufactureDate(), currentDate).getYears();
			car.setAge(age);
			save(car);
			logger.info("Car age update--- " + car);
		}
		logger.info("Car age update job completed successfully");
		System.out.println("***************************************TASK FINISHED***********************************************");
	}
}//end CarServiceImpl
