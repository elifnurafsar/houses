import Houses.House;
import Util.ObjectCreater;
import Util.Service;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        ObjectCreater creater = new ObjectCreater();
        List<House> list = creater.createAll();
        Service service = new Service();

        // Current Houses
        System.out.println("List of Houses:");
        list.forEach(house -> System.out.println(house.getType() + ": Price=" + house.getPrice() + ", Rooms=" + house.getNum_rooms() + ", Halls=" + house.getNum_halls() + ", Area=" + house.getM2()));

        // The results of each method in the Service class
        System.out.println("\nTotal Price of all houses: " + service.getTotalPrice(list));
        System.out.println("Total Price of Ev: " + service.getTotalPriceOfEv(list));
        System.out.println("Total Price of Villa: " + service.getTotalPriceOfVilla(list));
        System.out.println("Total Price of Yazlik: " + service.getTotalPriceOfYazlik(list));
        System.out.println("Average Area of all houses: " + service.getAverageAreaOfAll(list));
        System.out.println("Average Area of Villa: " + service.getAverageAreaOfGivenType(list, "Villa"));

        // Filter houses based on rooms and halls and print the filtered list
        System.out.println("\nFiltered List of Houses with at least 3 rooms and 2 halls:");
        List<House> filteredList = service.filterByRoomsAndHalls(list, 3, Integer.MAX_VALUE, 2, Integer.MAX_VALUE);
        filteredList.forEach(house -> System.out.println(house.getType() + ": Price=" + house.getPrice() + ", Rooms=" + house.getNum_rooms() + ", Halls=" + house.getNum_halls() + ", Area=" + house.getM2()));

        System.out.println("\nFiltered List of Houses with 1 rooms and 1 halls:");
        List<House> filteredList2 = service.filterByRoomsAndHalls(list, 1,1, 1, 1);
        filteredList2.forEach(house -> System.out.println(house.getType() + ": Price=" + house.getPrice() + ", Rooms=" + house.getNum_rooms() + ", Halls=" + house.getNum_halls() + ", Area=" + house.getM2()));

    }
}
