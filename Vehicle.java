import java.io.*;
import java.util.*;

abstract class Vehicle {
  private int unitNumber = -1;
  private int capacity = -1;
  private String id = "";

  static int FLEET_SIZE = 1;
  static String FILE = "hello.txt";

  public Vehicle (){
    this.setUnitNumber(-1);
    this.setCapacity(-1);
    this.setID("");
  }

  public Vehicle (int u, String i, int c){
    this.setUnitNumber(u);
    this.setCapacity(c);
    this.setID(i);
  }

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
    return  ("Unit: " + this.getUnitNumber() + "\n" +
            "ID: " + this.getID() + "\n" +
            "Capacity: " + this.getCapacity());
  }

  public static Vehicle[] sortByCapacity(Vehicle[] array){
    return array;
  }
}
