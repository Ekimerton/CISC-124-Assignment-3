import java.io.*;
import java.util.*;

public class MTOptimizer {
  public static void main(String[] args){
    //ArrayList<Vehicle> buses = readFile("buses.txt");
    Bus[] buses = readBuses();
    GoBus[] gobuses = readGoBuses();
    Streetcar[] streetcars = readStreetcars();
    Subway[] subways = readSubways();
    GoTrain[] gotrains = readGoTrains();

    ArrayList<Rider> riders = parseRidership();

    int[][] capacityRequired = generateCapacityRequired(riders);
    for(int i = 0; i < 24; i++){
      System.out.println("Hour " + i + ": " + Arrays.toString(capacityRequired[i]));
    }
    //ArrayList<Subway> subways = new ArrayList<Subway>();
    //subways = Subway.sortByCapacity(subways);
    parseRidership();
  }

  public static ArrayList<Rider> parseRidership(){
    ArrayList<Rider> riders = new ArrayList<Rider>();
    try{
      BufferedReader reader = new BufferedReader(new FileReader("ridership.txt"));
      BufferedWriter writer = new BufferedWriter(new FileWriter("errorlog.txt"));
      for(int i = 0; i < 66105 - 1; i++){
        String info = reader.readLine();
        try{
          Rider rider = new Rider(info);
          if(!(rider.validate().equals(""))){
            writer.write("line " + (i+1) + ": " + info + " - " + rider.validate() + "\n");
          } else {
            riders.add(rider);
          }
        } catch (Exception e){
          writer.write("line " + (i+1) + ": " + info + " - Invalid parameters" + "\n");
        }
      }
      writer.flush();
      writer.close();
    } catch (Exception e){
      System.out.println("Error in parseRidership");
      System.out.println(e);
    }
    return riders;
  }

  /*
  This array is very important so i've decided to make the comments multi-line. Basically, this is what stores the
  amount of people riding anything anytime. The 2D table has an x-axis, from 0 - 23, that stores the hours of the day.
  The y-axis, from 0-4, corresponds to a type of vehicle:
  (0: Bus), (1: GoBus), (2: Streetcar), (3: Subway), (4: GoTrain)

  So, the int at capacityRequired[11][3] would be the number of people who rode the subway at 10:00. (The hours are
  shifted back by 1, so that hour 24 isn't the first entry of the day.)
  */
  public static int[][] generateCapacityRequired(ArrayList<Rider> riders){
    int[][] capacityRequired = new int[24][5];
    for(Rider rider : riders){
      int pointer = -1;
      if(rider.getTransport() == 'C'){
        pointer = 0;
      } else if (rider.getTransport() == 'D'){
        pointer = 1;
      } else if (rider.getTransport() == 'X'){
        pointer = 2;
      } else if (rider.getTransport() == 'S'){
        pointer = 3;
      } else if (rider.getTransport() == 'G'){
        pointer = 4;
      }
      capacityRequired[rider.getHour() - 1][pointer] += rider.getPersonCount();
    }
    return capacityRequired;
  }
/*
  public static <T> ArrayList<T> readFile(String fileName, int fleetSize, T vehicle){
    ArrayList<T> vehicles = new ArrayList<>();
    System.out.println("Read from: " + fileName);
    try{
      BufferedReader reader = new BufferedReader(new FileReader(fileName));
      for(int i = 0; i < fleetSize; i++){
        String info = reader.readLine();
        Class<T> vehicle = new Class<T>(info);
        vehicles.add(vehicle);
      }
    } catch (Exception e){
      System.out.println("Error in reading");
      System.out.println(e);
    }
    return vehicles;
  }
*/
  //Parsing the txt files into the vehicles

  public static Bus[] readBuses(){
    Bus[] buses = new Bus[50];
    try{
      BufferedReader reader = new BufferedReader(new FileReader("buses.txt"));
      for(int i = 0; i < 50; i++){
        String info = reader.readLine();
        Bus bus = new Bus(info);
        buses[i] = bus;
      }
    } catch (Exception e){
      System.out.println("Error in readBuses:");
      System.out.println(e);
    }
    return buses;
  }


  public static GoBus[] readGoBuses(){
    GoBus[] gobuses = new GoBus[15];
    try{
      BufferedReader reader = new BufferedReader(new FileReader("gobuses.txt"));
      for(int i = 0; i < 15; i++){
        String info = reader.readLine();
        GoBus gobus = new GoBus(info);
        gobuses[i] = gobus;
      }
    } catch (Exception e){
      System.out.println("Error in readGoBuses:");
      System.out.println(e);
    }
    return gobuses;
  }

  public static Streetcar[] readStreetcars(){
    Streetcar[] streetcars = new Streetcar[30];
    try{
      BufferedReader reader = new BufferedReader(new FileReader("streetcars.txt"));
      for(int i = 0; i < 30; i++){
        String info = reader.readLine();
        Streetcar streetcar = new Streetcar(info);
        streetcars[i] = streetcar;

      }
    } catch (Exception e){
      System.out.println("Error in readStreetcars:");
      System.out.println(e);
    }
    return streetcars;
  }

  public static Subway[] readSubways(){
    Subway[] subways = new Subway[20];
    try{
      BufferedReader reader = new BufferedReader(new FileReader("subways.txt"));
      for(int i = 0; i < 20; i++){
        String info = reader.readLine();
        Subway subway = new Subway(info);
        subways[i] = subway;

      }
    } catch (Exception e){
      System.out.println("Error in readSubways:");
      System.out.println(e);
    }
    return subways;
  }

  public static GoTrain[] readGoTrains(){
    GoTrain[] gotrains = new GoTrain[10];
    try{
      BufferedReader reader = new BufferedReader(new FileReader("gotrains.txt"));
      for(int i = 0; i < 10; i++){
        String info = reader.readLine();
        GoTrain gotrain = new GoTrain(info);
        gotrains[i] = gotrain;
      }
    } catch (Exception e){
      System.out.println("Error in readBuses:");
      System.out.println(e);
    }
    return gotrains;
  }
}
