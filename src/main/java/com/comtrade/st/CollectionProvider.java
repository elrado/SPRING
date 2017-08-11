/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author radoo
 */
@Service("collectionProvider")
public class CollectionProvider {
	private List<String> list;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
}
