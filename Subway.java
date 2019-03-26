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

  public Subway(int u, String i, int n, int p, char s, String d){
    this.setUnitNumber(u);
    this.setID(i);
    this.setNumOfCars(n);
    this.setPassengersPerCar(p);
    this.setOperationalStatus(s);
    this.setOperationalDate(d);

    this.setCapacity(this.getPassengersPerCar() * this.getNumOfCars());
  }

  public Subway(String info){
    int unitNumber = Integer.parseInt(info.substring(0, info.indexOf(",")));
    info = info.substring(info.indexOf(",") + 1);
    String id = info.substring(0, info.indexOf(","));
    info = info.substring(info.indexOf(",") + 1);
    int numOfCars = Integer.parseInt(info.substring(0, info.indexOf(",")));
    info = info.substring(info.indexOf(",") + 1);
    int passengersPerCar = Integer.parseInt(info.substring(0, info.indexOf(",")));
    info = info.substring(info.indexOf(",") + 1);
    char operationalStatus = info.substring(0, info.indexOf(",")).charAt(0);
    info = info.substring(info.indexOf(",") + 1);
    String operationalDate = info;

    this.setUnitNumber(unitNumber);
    this.setID(id);
    this.setNumOfCars(numOfCars);
    this.setPassengersPerCar(passengersPerCar);
    this.setOperationalStatus(operationalStatus);
    this.setOperationalDate(operationalDate);
    this.setCapacity(passengersPerCar * numOfCars);
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
    return  ("Unit: " + this.getUnitNumber() + ", " +
            "Capacity: " + this.getCapacity() + ", " +
            "ID: " + this.getID() + ", " +
            "Num of cars: " + this.getNumOfCars() + ", " +
            "Passengers per car: " + this.getPassengersPerCar() + ", " +
            "Operational Status: " + this.getOperationalStatus() + ", " +
            "Operational Date: " + this.getOperationalDate());
  }

}
