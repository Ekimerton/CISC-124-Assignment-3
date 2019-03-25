public class Rider{
  private String id = "-1";
  private char transport = 'X';
  private char age = 'X';
  private int hour = -1;
  private String date = "yyyymmdd";

  private float personCount = 3.0f;

  public Rider(){
    id = "-1";
  }

  public Rider(String i, char t, char a, int h, String d){
    this.setID(i);
    this.setTransport(t);
    this.setAge(a);
    this.setHour(h);
    this.setDate(d);
  }

  public Rider(String info){
    String id = info.substring(0, info.indexOf(","));
    info = info.substring(info.indexOf(",") + 1);
    char transport = (info.substring(0, info.indexOf(","))).charAt(0);
    info = info.substring(info.indexOf(",") + 1);
    char age = (info.substring(0, info.indexOf(","))).charAt(0);
    info = info.substring(info.indexOf(",") + 1);
    int hour = Integer.parseInt(info.substring(0, info.indexOf(",")));
    info = info.substring(info.indexOf(",") + 1);
    String date = info;

    this.setID(id);
    this.setTransport(transport);
    this.setAge(age);
    this.setHour(hour);
    this.setDate(date);

    if(age == 'C'){
      this.setPersonCount(0.75f);
    } else if (age == 'A'){
      this.setPersonCount(1.0f);
    } else if (age == 'S'){
      this.setPersonCount(1.25f);
    }
  }

  //Setter and Getters
  public String getID(){
    return id;
  }

  public void setID(String i){
    id = i;
  }

  public char getTransport(){
    return transport;
  }

  public void setTransport(char t){
    transport = t;
  }

  public char getAge(){
    return age;
  }

  public void setAge(char a){
    age = a;
  }

  public int getHour(){
    return hour;
  }

  public void setHour(int h){
    hour = h;
  }

  public String getDate(){
    return date;
  }

  public void setDate(String d){
    date = d;
  }

  public float getPersonCount(){
    return personCount;
  }

  public void setPersonCount(float p){
    personCount = p;
  }

  //Methods
  public String validate(){
    String errorMessage = "";
    if(!validateId(this.getID())){
      errorMessage = errorMessage + "Invalid id";
    }

    if(!validateTransport(this.getTransport())){
      errorMessage = errorMessage + "Invalid transport method";
    }

    if(!validateAge(this.getAge())){
      errorMessage = errorMessage + "Invalid age group";
    }

    if(!validateHour(this.getHour())){
      errorMessage = errorMessage + "Invalid hour";
    }

    if(!validateDate(this.getDate())){
      errorMessage = errorMessage + "Invalid date";
    }
    return errorMessage;
  }

  public static boolean validateId(String id){
    if(id.equals("*")){
      return true;
    } else if (id.length() != 7 && id.length() != 16) {
      return false;
    }
      if(id.length() == 7){
      } else if (id.length() == 16){
        id = id.substring(1);
      }
      return isANumber(id);
  }

  public static boolean validateTransport(char t){
    if(t == 'S' || t == 'G' || t == 'X' || t == 'C' || t == 'D'){
      return true;
    } else {
      return false;
    }
  }

  public static boolean validateAge(char a){
    if(a == 'C' || a == 'A' || a == 'S'){
      return true;
    } else {
      return false;
    }
  }

  public static boolean validateHour(int h){
    if(h > -1 && h < 25){
      return true;
    } else {
      return false;
    }
  }

  public static boolean validateDate(String d){
    if(d.length() != 8){
      return false;
    }
    try{
      int year = Integer.parseInt(d.substring(0, 4));
      int month = Integer.parseInt(d.substring(4, 6));
      int day = Integer.parseInt(d.substring(6));
      if(year != 2018 && year != 2019){
        return false;
      }
      if(month < 1 || month > 12){
        return false;
      }
      if(day < 1 || day > 31){
        return false;
      }
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  public static boolean isANumber(String s){
    boolean isNumber = true;
    for (char c : s.toCharArray()){
      int charVal = (int) c;
      if(!(charVal > 47 && charVal < 58)){
        isNumber = false;
      }
    }
    return isNumber;
  }

  public String toString(){
    return  ("ID: " + this.getID() + "\n" +
            "Transport Mode: " + this.getTransport() + "\n" +
            "Age: " + this.getAge() + "\n" +
            "Hour: " + this.getHour() + "\n" +
            "Date: " + this.getDate() + "\n" +
            "Person Count: " + this.getPersonCount());
  }
}
