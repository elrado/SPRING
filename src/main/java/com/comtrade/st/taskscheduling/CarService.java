/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st.taskscheduling;

import java.util.List;

/**
 *
 * @author radoo
 */
public interface CarService {

	List<Car> findAll();

	Car save(Car car);

	void updateCarAgeJob();
}//end CarService
