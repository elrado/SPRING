/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comtrade.st.taskscheduling;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
/**
 *
 * @author radoo
 */
public interface CarRepository extends CrudRepository<Car, Long> {

}//end CarRepository
