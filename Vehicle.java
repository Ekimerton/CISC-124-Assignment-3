public class Vehicle {
  private int unitNumber = -1;
  private int capacity = -1;
  private String id = "";

  public Vehicle (){
    this.setUnitNumber(-1);
    this.setCapacity(-1);
    this.setID("");
  }

  public Vehicle (int u, int c, String i){
    this.setUnitNumber(u);
    this.setCapacity(c);
    this.setID(i);
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
            "Capacity: " + this.getCapacity() + "\n" +
            "ID: " + this.getID());
  }

}
