public class GoTrain extends Vehicle {

  public GoTrain (){
    this.setUnitNumber(-1);
    this.setCapacity(-1);
    this.setID("");
  }

  public GoTrain (int u, String i, int c){
    this.setUnitNumber(u);
    this.setCapacity(c);
    this.setID(i);
  }

  public GoTrain(String info){
    int unitNumber = Integer.parseInt(info.substring(0, info.indexOf(",")));
    info = info.substring(info.indexOf(",") + 1);
    String id = info.substring(0, info.indexOf(","));
    info = info.substring(info.indexOf(",") + 1);
    int capacity = Integer.parseInt(info);

    this.setUnitNumber(unitNumber);
    this.setCapacity(capacity);
    this.setID(id);
  }
}
