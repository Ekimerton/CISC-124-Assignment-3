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

    System.out.println(Rider.validateDate("20121769"));
  }

  public static void parseRidership(){
    try{
      BufferedReader reader = new BufferedReader(new FileReader("ridership.txt"));
      for(int i = 0; i < 66105; i++){
        String info = reader.readLine();

      }
    } catch (Exception e){
      System.out.println("Error in parseRidership");
      System.out.println(e);
    }
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
