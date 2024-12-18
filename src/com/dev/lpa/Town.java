package com.dev.lpa;

import java.util.Objects;

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
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Town town = (Town) obj;
        return km == town.km && name.equalsIgnoreCase(town.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, km);
//    }

}
