public class GoBus extends Bus{

  public GoBus(){
    this.setUnitNumber(-1);
    this.setCapacity(-1);
    this.setID("");
  }

  public GoBus(int u, String i, int c){
    this.setUnitNumber(u);
    this.setCapacity(c);
    this.setID(i);
  }

  public GoBus (String s){
    int unitNumber = Integer.parseInt(s.substring(0, s.indexOf(",")));
    s = s.substring(s.indexOf(",") + 1);
    String id = s.substring(0, s.indexOf(","));
    s = s.substring(s.indexOf(",") + 1);
    int capacity = Integer.parseInt(s);

    this.setUnitNumber(unitNumber);
    this.setCapacity(capacity);
    this.setID(id);
  }
}
