package com.dev.lpa;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static LinkedList<Town> towns = new LinkedList<>();

    public static void main(String[] args) {
        //LinkedList<Town>towns = new LinkedList<Town>();
        Town Sydney = createTown("Sydney", 0);
        Town Adelaide = createTown("Adelaide", 1374);
        Town AliceSprings = createTown("Alice Springs", 2771);
        Town Brisbane = createTown("Brisbane", 917);
        Town Darwin = createTown("Darwin", 3972);
        Town Melbourne = createTown("Melbourne", 877);

        addTown(towns, Sydney);
        addTown(towns, Adelaide);
        addTown(towns, AliceSprings);
        addTown(towns, Brisbane);
        addTown(towns, Darwin);
        addTown(towns, Sydney);
        addTown(towns, Adelaide);
        addTown(towns, AliceSprings);
        addTown(towns, Brisbane);
        addTown(towns, Darwin);
        addTown(towns, Melbourne);
        //System.out.println(towns);
        //printMenu();

        //input = scan.nextLine();
        boolean flag = true;
        while (flag) {
            System.out.println();
            printMenu();
            System.out.println();
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            switch (input) {
                case ("F"), ("f") -> showForward(towns);
                case ("B"), ("b") -> showBackward(towns);
                case ("L"), ("l") -> listPlaces(towns);
                case ("R"), ("r") -> removeTowns(towns);
                case ("M"), ("m") -> menuOption();
                default -> {
                    flag = false;
                    System.out.println("Good bye");
                }
            }
        }
    }

    private static Town createTown(String name, int km) {
        return new Town(name, km);
    }

    private static void addTown(LinkedList<Town> town, Town t) {
        if (!town.contains(t)) {
            town.add(t);
        }
        Collections.sort(town);
    }

    private static void showForward(LinkedList<Town> town) {
        for (Town value : town) {
            System.out.println(value);
        }
    }

    private static void showBackward(LinkedList<Town> town) {
        ListIterator<Town> iterate = town.listIterator();
        for (Town value : town) {
            iterate.next();
        }
        while (iterate.hasPrevious()) {
            System.out.println(iterate.previous());
        }

    }

    private static void listPlaces(LinkedList<Town> town) {
        System.out.println(town);
    }

    private static void removeTowns(LinkedList<Town> town) {
        System.out.println("Remove this town?");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ListIterator<Town> iterate = town.listIterator();
        while (iterate.hasNext()) {
            Town value = iterate.next();
            if (value.getName().equalsIgnoreCase(input)) {
                iterate.remove();
            }
        }
        System.out.println(town);
    }

    private static void printMenu() {
        String menu = """
                Available actions (select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (R)emove Towns
                (M)enu
                (Q)uit
                """;
        System.out.println(menu);
    }

    private static void menuOption() {
        String option = """
                create and add a town?
                (1st) create a town with name and km from Sydney
                (2nd) add a new town to the list""";
        System.out.println(option);
        Scanner scan = new Scanner(System.in);
        System.out.println("please input the name of the town");
        String townName = scan.nextLine();
        System.out.println("please input the distance from sydney");
        int kmFromSydney = Integer.parseInt(scan.nextLine());
        Town createdTown = createTown(townName, kmFromSydney);
        addTown(towns, createdTown);
    }
}
