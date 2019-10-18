/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.swing;

/**
 * Interface that converts an object to an XML file.
 * @author toky
 */
public interface XMLizable {
    /**
    * converts the object to a string that adheres to XML format. This method
    * is implemented in each class that implements {@code XMLizable}.
    * 
    * @return a string that represents the object in XML format.
    */
    public String toXML ();
}
