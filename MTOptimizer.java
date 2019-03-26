import java.io.*;
import java.util.*;

public class MTOptimizer {
  public static void main(String[] args){
    ArrayList<Bus> buses = readBuses();
    ArrayList<GoBus> gobuses = readGoBuses();
    ArrayList<Streetcar> streetcars = readStreetcars();
    ArrayList<Subway> subways = readSubways();
    ArrayList<GoTrain> gotrains = readGoTrains();
    Collections.sort(buses);
    Collections.sort(gobuses);
    Collections.sort(streetcars);
    Collections.sort(subways);
    Collections.sort(gotrains);

    ArrayList<Rider> riders = parseRidership();
    int[][] capacityRequired = generateCapacityRequired(riders);

    String finalString = "";

    finalString += (generateInOperationFleets(capacityRequired, buses, 0));
    finalString += (generateInOperationFleets(capacityRequired, gobuses, 1));
    finalString += (generateInOperationFleets(capacityRequired, streetcars, 2));
    finalString += (generateInOperationFleets(capacityRequired, subways, 3));
    finalString += (generateInOperationFleets(capacityRequired, gotrains, 4));

    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter("InOperationFleets.txt"));
      writer.write(finalString);
      writer.flush();
      writer.close();
    } catch (Exception e){
      System.out.println("Error in writing");
      System.out.println(e);
    }
  }

  /*
  Pretty straight forward, creates an array of riders after reading the ridership.txt file, and writes invalid writers
  onto errorship.txt. There are two errors to look for, the constructor returns an error because of mismatched
  parameters, or the parameters are the right types, but their values are invalid in this project. The second type is
  handled by Rider.validate().
  */
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
  This method is the piece de resistance of this whole project - It takes in the arrayLists of the vehicles (sorted by
  capacity), and the int[][] capacityRequired, that shows the required capacities of a vehicle type at every hour.

  The for loop goes through all the hours; 0 to 24. Then a while loop is entered, and the top entry from the array is
  pulled, and subtracted from the capacityRequired. Since the arrays are sorted, this is the optimal way of filling
  capacity.

  It returns a string that is written to file in the main, instead of writing right away, to avoid calling the writer
  too many times.
  */
  public static <T extends Vehicle> String generateInOperationFleets(int[][] capacityRequired, ArrayList<T> vehicles, int vehicleTypeNumber){

    String[] vehicleTypes = {"Buses", "GoBuses", "Streetcars", "Subways", "GoTrains"};
    String title = vehicleTypes[vehicleTypeNumber];

    String toReturn = "";

    toReturn += ("[" + title + "]" + "\n");
    for(int i = 0; i < 24; i++){
      toReturn += ("[Hour = " + (i+1) + "]" + "\n");
      int capacityNeeded = capacityRequired[i][vehicleTypeNumber];
      int count = 0;
      while(capacityNeeded > 0){
        capacityNeeded -= vehicles.get(count).getCapacity();
        toReturn += ("\t" + vehicles.get(count).toString() + "\n");
        count++;
      }
      toReturn += ("[Count = " + count + "]" + "\n");
    }
    return toReturn;
  }

  /*
  All of the methods below do the same thing; read the file for a transportation type, and fills an ArrayList full of
  that vehicle. I assume this could have been done with generics, but I couldn't figure out how, since instantiating
  an object was required. All of these methods are equal, so replacing the word "Buses" with "Subways" gives you the
  same method.
  */
  public static ArrayList<Bus> readBuses(){
    ArrayList<Bus> buses = new ArrayList<Bus>();
    try{
      BufferedReader reader = new BufferedReader(new FileReader("buses.txt"));
      for(int i = 0; i < 50; i++){
        String info = reader.readLine();
        Bus bus = new Bus(info);
        buses.add(bus);
      }
    } catch (Exception e){
      System.out.println("Error in readBuses:");
      System.out.println(e);
    }
    return buses;
  }


  public static ArrayList<GoBus> readGoBuses(){
    ArrayList<GoBus> gobuses = new ArrayList<GoBus>();
    try{
      BufferedReader reader = new BufferedReader(new FileReader("gobuses.txt"));
      for(int i = 0; i < 15; i++){
        String info = reader.readLine();
        GoBus gobus = new GoBus(info);
        gobuses.add(gobus);
      }
    } catch (Exception e){
      System.out.println("Error in readGoBuses:");
      System.out.println(e);
    }
    return gobuses;
  }

  public static ArrayList<Streetcar> readStreetcars(){
    ArrayList<Streetcar> streetcars = new ArrayList<Streetcar>();
    try{
      BufferedReader reader = new BufferedReader(new FileReader("streetcars.txt"));
      for(int i = 0; i < 30; i++){
        String info = reader.readLine();
        Streetcar streetcar = new Streetcar(info);
        streetcars.add(streetcar);
      }
    } catch (Exception e){
      System.out.println("Error in readStreetcars:");
      System.out.println(e);
    }
    return streetcars;
  }

  public static ArrayList<Subway> readSubways(){
    ArrayList<Subway> subways = new ArrayList<Subway>();
    try{
      BufferedReader reader = new BufferedReader(new FileReader("subways.txt"));
      for(int i = 0; i < 20; i++){
        String info = reader.readLine();
        Subway subway = new Subway(info);
        subways.add(subway);
      }
    } catch (Exception e){
      System.out.println("Error in readSubways:");
      System.out.println(e);
    }
    return subways;
  }

  public static ArrayList<GoTrain> readGoTrains(){
    ArrayList<GoTrain> gotrains = new ArrayList<GoTrain>();
    try{
      BufferedReader reader = new BufferedReader(new FileReader("gotrains.txt"));
      for(int i = 0; i < 10; i++){
        String info = reader.readLine();
        GoTrain gotrain = new GoTrain(info);
        gotrains.add(gotrain);
      }
    } catch (Exception e){
      System.out.println("Error in readBuses:");
      System.out.println(e);
    }
    return gotrains;
  }
}
