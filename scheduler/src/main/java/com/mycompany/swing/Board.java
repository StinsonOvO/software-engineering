/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.swing;

import java.util.ArrayList;
import java.util.List;

/**
 * Board of a Planner.
 * 
 * A Planner can be divided in different boards and each board ({@code Board}) objects 
 * are named and can contain ({@code Section}) objects.
 * 
 * 
 * @see Planner
 * @see Section
 *
 * @author Stinson
 */

public class Board implements XMLizable {

    private final String name;
    private final List<Section> sections;
    
    /**
     * Constructs a Board. To initialize a board, specify the name of the
     * board. An empty list of sections that belong to this board will
     * also be initialized.
     * 
     * @param name the name of the board.
     */
    Board(String name) {
        this.sections = new ArrayList<>();
        this.name = name;
    }
    
    /**
     * Retrieves the name of the board.
     * @return name the name of the board.
     */
    String getName(){
        return name;
    }
    
    /**
     * Retrieves the sections that belong to the board. These sections are 
     * stored in a list.
     * 
     * @return sections a list of sections that belong to the board.
     */
    List<Section> getSections() {
        return sections;
    }
    void addSection(Section t) {
      this.sections.add(t);
    }
    
    /**
     * Converts the sections that belong to the board to a string that adheres
     * to XML format.
     * 
     * @return a string that represents the sections that belong to the 
     * board in XML format.
     */
    @Override
    public String toXML() {
        String sectionStr = "";
        for (Section s : sections) {
            sectionStr += s.toXML();
        }
        String res = "<board name='" + this.name + "'>\n" + sectionStr + "</board>\n";
        return res;
    }

  
    
}
