package com.example.demo;

import org.springframework.boot.SpringApplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static Wall wall() {
        Block block0 = new Block("red", "wood");
        Block block1 = new Block("red", "iron");
        Block block2 = new Block("blue", "wood");
        Block block3 = new Block("black", "aluminium");
        Block block4 = new Block("violet", "wood");

        List<Block> blocks = new ArrayList<>();
        blocks.add(block0);
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);
        blocks.add(block4);

        return new Wall(blocks);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        menu(wall());
    }

    private static void menu(Wall wall){
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
        
        What do you want:
        1. Find all block that are made of some material.
        2. Find block which some color.
        3. Count how many block there is.
        4. Quit
        
        """);

        try {
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("What material?");
                    scanner.nextLine();
                    System.out.println(wall.findBlocksByMaterial(scanner.nextLine().toLowerCase()));
                    break;

                case 2:
                    System.out.println("What color?");
                    scanner.nextLine();
                    System.out.println(wall.findBlockByColor(scanner.nextLine().toLowerCase()));
                    break;

                case 3:
                    System.out.println(wall.count());
                    break;

                case 4:
                    System.out.println("Bye");
                    System.exit(0);

                default:
                    System.out.println("Sorry I don't know what do you want. Pick one option from below.");
                    menu(wall());
            }
        } catch (InputMismatchException e) {
            System.out.println("Sorry I don't understand, please try again.");
            menu(wall());
        }
    }
}
