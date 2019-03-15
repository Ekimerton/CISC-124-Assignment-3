public class Subway extends Vehicle {

  private int numOfCars = -1;
  private int passengersPerCar = -1;
  private char operationalStatus = 'x';
  private String operationalDate = "";

  public Subway(){
    this.setUnitNumber(-1);
    this.setCapacity(-1);
    this.setID("");
    this.setNumOfCars(-1);
    this.setPassengersPerCar(-1);
    this.setOperationalStatus('x');
    this.setOperationalDate("1111111");
  }

  public Subway(int u, int i, int n, int p, char s, String d){
    this.setUnitNumber(u);
    this.setID("" + i);
    this.setNumOfCars(n);
    this.setPassengersPerCar(p);
    this.setOperationalStatus(s);
    this.setOperationalDate(d);

    this.setCapacity(this.getPassengersPerCar() * this.getNumOfCars());
  }

  //Setters and Getters

  public int getNumOfCars(){
    return numOfCars;
  }

  public int getPassengersPerCar(){
    return passengersPerCar;
  }

  public char getOperationalStatus(){
    return operationalStatus;
  }

  public String getOperationalDate(){
    return operationalDate;
  }

  public void setNumOfCars(int n){
    numOfCars = n;
  }

  public void setPassengersPerCar(int p){
    passengersPerCar = p;
  }

  public void setOperationalStatus(char s){
    operationalStatus = s;
  }

  public void setOperationalDate(String d){
    operationalDate = d;
  }

  //toString
  public String toString(){
    return  ("Unit: " + this.getUnitNumber() + "\n" +
            "Capacity: " + this.getCapacity() + "\n" +
            "ID: " + this.getID() + "\n" +
            "Num of cars: " + this.getNumOfCars() + "\n" +
            "Passengers per car: " + this.getPassengersPerCar() + "\n" +
            "Operational Status: " + this.getOperationalStatus() + "\n" +
            "Operational Date: " + this.getOperationalDate());
  }

}
