public class Streetcar extends Vehicle {

  private char type = 'X';

  public Streetcar(){
    this.setUnitNumber(-1);
    this.setCapacity(-1);
    this.setID("");
    this.setType('X');
  }

  public Streetcar(int u, int c, int i, char t){
    this.setUnitNumber(u);
    this.setCapacity(c);
    this.setID("SC" + i);
    this.setType(t);
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
