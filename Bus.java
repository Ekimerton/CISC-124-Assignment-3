public class Bus extends Vehicle {

  //Constructors
  public Bus(){
    this.setUnitNumber(-1);
    this.setCapacity(-1);
    this.setID("");
  }

  public Bus(int u, int c, int i){
    this.setUnitNumber(u);
    this.setCapacity(c);
    this.setID("MB" + i);
  }

}
