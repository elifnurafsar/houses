package Util;

import Houses.Ev;
import Houses.House;
import Houses.Villa;
import Houses.Yazlik;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectCreater {

    private int randInt(int low, int high){
        Random r = new Random();
        return r.nextInt(high-low) + low;
    }

    private double randDouble(int low, int high){
        Random r = new Random();
        double randomValue = r.nextDouble() * (high - low) + low;
        return Math.round(randomValue * 100.0) / 100.0;
    }

    private List<Ev> createEv(){
        List<Ev> list = new ArrayList<>();
        int num_of_ev = randInt(3, 9);
        for(int i=0; i<num_of_ev; i++){
            int rooms = randInt(1, 4);
            int halls = 1;
            double m2 = randDouble(100, 500);
            int room_price = randInt(300000, 800000);
            int hall_price = randInt(500000, 1000000);
            int price = room_price * rooms + hall_price * halls;
            Ev ev = new Ev(rooms, halls, m2, price);
            list.add(ev);
        }
        return list;
    }

    private List<Villa> createVilla(){
        List<Villa> list = new ArrayList<>();
        int num_of_villa = randInt(3, 9);
        for(int i=0; i<num_of_villa; i++){
            int halls = randInt(1, 5);
            int rooms = randInt(halls, 12);
            double m2 = randDouble(500, 10000);
            int room_price = randInt(350000, 900000);
            int hall_price = randInt(500000, 1000000);
            int price = room_price * rooms + hall_price * halls;
            Villa villa = new Villa(rooms, halls, m2, price);
            list.add(villa);
        }
        return list;
    }

    private List<Yazlik> createYazlik(){
        List<Yazlik> list = new ArrayList<>();
        int num_of_villa = randInt(3, 9);
        for(int i=0; i<num_of_villa; i++){
            int halls = randInt(1, 5);
            int rooms = randInt(halls, 12);
            double m2 = randDouble(500, 10000);
            int room_price = randInt(500000, 1000000);
            int hall_price = randInt(1000000, 4000000);
            int price = room_price * rooms + hall_price * halls;
            Yazlik yazlik = new Yazlik(rooms, halls, m2, price);
            list.add(yazlik);
        }
        return list;
    }

    public List<House> createAll(){
        List<House> list = new ArrayList<>();
        List<Ev> evler = createEv();
        List<Yazlik> yazliklar = createYazlik();
        List<Villa> villalar = createVilla();

        list.addAll(evler);
        list.addAll(yazliklar);
        list.addAll(villalar);

        return list;
    }
}
