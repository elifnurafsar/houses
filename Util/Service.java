package Util;

import Houses.House;

import java.util.*;
import java.util.stream.Collectors;


public class Service {

    public long getTotalPrice(List<House> list){
        long sum = 0;
        for(int i=0; i<list.size(); i++){
            sum += list.get(i).getPrice();
        }
        return sum;
    }

    public long getTotalPriceOfEv(List<House> list){
        long sum = list.stream().filter(o -> o.getType().equalsIgnoreCase("ev")).mapToInt(o -> o.getPrice()).sum();
        return sum;
    }

    public long getTotalPriceOfVilla(List<House> list){
        long sum = list.stream().filter(o -> o.getType().equalsIgnoreCase("villa")).mapToInt(o -> o.getPrice()).sum();
        return sum;
    }

    public long getTotalPriceOfYazlik(List<House> list){
        long sum = list.stream().filter(o -> o.getType().equalsIgnoreCase("yazlik")).mapToInt(o -> o.getPrice()).sum();
        return sum;
    }

    public double getAverageAreaOfAll(List<House> list){
        double sum = list.stream().mapToDouble(o -> o.getM2()).sum();
        int sze = list.size();
        return sum/(sze*1.0);
    }

    public double getAverageAreaOfGivenType(List<House> list, String type) {
        Summary obj = list.stream()
                .filter(house -> house.getType().equalsIgnoreCase(type))
                .collect(
                        Collectors.teeing(
                                Collectors.counting(),
                                Collectors.summingDouble(House::getM2),
                                Summary::new
                        )
                );

        double averageArea = obj.totalArea / obj.count;

        return averageArea;
    }

    public List<House> filterByRoomsAndHalls(List<House> list, int minRooms, int maxRooms, int minHalls, int maxHalls) {
        return list.stream()
                .filter(house -> house.getNum_rooms() >= minRooms && house.getNum_rooms() <= maxRooms && house.getNum_halls() >= minHalls && house.getNum_halls() <= maxHalls)
                .collect(Collectors.toList());
    }
}
