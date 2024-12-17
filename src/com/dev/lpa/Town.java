package com.dev.lpa;

public class Town implements Comparable <Town>{
    private String name;
    private int km;

    public Town (String name, int km){
        this.name = name;
        this.km = km;
    }

    public String getName(){
        return name;
    }

    public int getKM(){
        return km;
    }
    @Override
    public String toString(){
        return name;
    }
    @Override
    public int compareTo(Town t){
        if(km > t.km){
            return 1;
        } else if (km == t.km){
            return 0;
        }
        return -1;
    }

}
