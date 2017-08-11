/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comtrade.st;

import java.beans.PropertyEditorSupport;
import javax.annotation.Resource;
import org.springframework.beans.propertyeditors.ByteArrayPropertyEditor;
import org.springframework.stereotype.Service;

/**
 *
 * @author radoo
 */
@Service
public class PropertyEditorBean extends ByteArrayPropertyEditor  {
	private byte[] bytes;

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		System.out.println("Adding " + bytes.length + " bytes");
		this.bytes = bytes;		
	}
}
