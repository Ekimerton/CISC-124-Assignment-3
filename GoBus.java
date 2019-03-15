public class GoBus extends Bus{

  public GoBus(){
    this.setUnitNumber(-1);
    this.setCapacity(-1);
    this.setID("");
  }

  public GoBus(int u, int c, int i){
    this.setUnitNumber(u);
    this.setCapacity(c);
    this.setID("GB" + i);
  }
}
