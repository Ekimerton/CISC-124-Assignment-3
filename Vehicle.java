import java.io.*;
import java.util.*;

abstract class Vehicle implements Comparable<Vehicle>{
  private int unitNumber = -1;
  private int capacity = -1;
  private String id = "";

  static int FLEET_SIZE = 1;
  static String FILE = "hello.txt";

  //Default Constuctor
  public Vehicle (){
    this.setUnitNumber(-1);
    this.setCapacity(-1);
    this.setID("");
  }

  //Constuctor for specific inputs, mostly used for testing
  public Vehicle (int u, String i, int c){
    this.setUnitNumber(u);
    this.setCapacity(c);
    this.setID(i);
  }

  //Constuctor used in the actual program, parses string line into bits.
  public Vehicle (String s){
    int unitNumber = Integer.parseInt(s.substring(0, s.indexOf(",")));
    s = s.substring(s.indexOf(",") + 1);
    String id = s.substring(0, s.indexOf(","));
    s = s.substring(s.indexOf(",") + 1);
    int capacity = Integer.parseInt(s);

    this.setUnitNumber(unitNumber);
    this.setCapacity(capacity);
    this.setID(id);
  }

  //Setters and Getters
  public int getUnitNumber(){
    return unitNumber;
  }

  public int getCapacity(){
    return capacity;
  }

  public String getID(){
    return id;
  }

  public void setUnitNumber(int u){
    unitNumber = u;
  }

  public void setCapacity(int c){
    capacity = c;
  }

  public void setID(String s){
    id = s;
  }

  //toString
  public String toString(){
    return  ("Unit: " + this.getUnitNumber() + ", " +
            "ID: " + this.getID() + ", " +
            "Capacity: " + this.getCapacity());
  }

  /*
  This method teaches the Collections.sort() that will be used in MTOptimizer.java to look at the capacities when comparing.
  */
  public int compareTo(Vehicle v2){
    int compareCapacity = ((Vehicle) v2).getCapacity();

    return compareCapacity - this.getCapacity();
  }

}
