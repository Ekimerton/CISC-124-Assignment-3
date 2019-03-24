public class Streetcar extends Vehicle {

  private char type = 'X';

  public Streetcar(){
    this.setUnitNumber(-1);
    this.setCapacity(-1);
    this.setID("");
    this.setType('X');
  }

  public Streetcar(int u, String i, char t){
    this.setUnitNumber(u);
    this.setID(i);
    this.setType(t);
    if(t == 'S'){
      this.setCapacity(40);
    } else if (t == 'D') {
      this.setCapacity(80);
    } else {
      System.out.println("Streetcar type wrong");
    }
  }

  public Streetcar(String info){
    int unitNumber = Integer.parseInt(info.substring(0, info.indexOf(",")));
    info = info.substring(info.indexOf(",") + 1);
    String id = info.substring(0, info.indexOf(","));
    info = info.substring(info.indexOf(",") + 1);
    char type = info.charAt(0);

    this.setUnitNumber(unitNumber);
    this.setID(id);
    this.setType(type);
    if(type == 'S'){
      this.setCapacity(40);
    } else if (type == 'D') {
      this.setCapacity(80);
    } else {
      System.out.println("Streetcar type wrong");
    }
  }

  //Setters and Getters
  public char getType(){
    return type;
  }

  public void setType(char t){{}
    type = t;
  }

  //toString
  public String toString(){
    return  ("Unit: " + this.getUnitNumber() + "\n" +
            "Capacity: " + this.getCapacity() + "\n" +
            "ID: " + this.getID() + "\n" +
            "Type: " + this.getType());
  }
}
