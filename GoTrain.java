public class GoTrain extends Vehicle {

  public GoTrain (){
    this.setUnitNumber(-1);
    this.setCapacity(-1);
    this.setID("");
  }

  public GoTrain (int u, int c, int i){
    this.setUnitNumber(u);
    this.setCapacity(c);
    this.setID("G" + i);
  }
}
