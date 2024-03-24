package com.example;

import com.example.Commands.ChangeColorCommand;
import com.example.Commands.MoveCommand;
import com.example.Commands.GetNameCommand;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner; // Import the Scanner class

public class App {

    public App() {
    }

    public static void main(String[] args) {
        boolean looping = true;
        List<ShapeController> shapes = new ArrayList<ShapeController>();
        System.out.println("Welcome to the shape manager\n");
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String shapeName = "";
        String shapeNames = "";

        while (looping) {
            shapeNames = "";
            System.out.println("Current shapes:");
            for (ShapeController shapeController : shapes) {
                shapeNames += shapeController.getName() + " ";
            }
            System.out.println(shapeNames);
            System.out.println("Enter a command");
            System.out.println("1. Create a shape");
            System.out.println("2. Change shape color");
            System.out.println("3. Undo last color change");
            System.out.println("4. Move shape");
            System.out.println("5. Undo last move");
            System.out.println("6. Exit");

            input = scanner.nextLine();
            switch (input) {
                case "1":
                    System.out.println("What kind of shape");
                    shapeName = scanner.nextLine();
                    System.out.println("What color");
                    input = scanner.nextLine();
                    Shape shape = new Shape(input, shapeName);
                    MoveCommand moveCommand = new MoveCommand(shape);
                    ChangeColorCommand changeColorCommand = new ChangeColorCommand(shape);
                    GetNameCommand getNameCommand = new GetNameCommand(shape);
                    ShapeController ShapeController = new ShapeController(moveCommand, changeColorCommand,
                            getNameCommand);
                    shapes.add(ShapeController);
                    break;

                case "2":
                    System.out.println("Which shape");
                    shapeName = scanner.nextLine();
                    System.out.println("What color");
                    input = scanner.nextLine();
                    for (ShapeController shapeController : shapes) {
                        if (shapeController.getName().equals(shapeName)) {
                            shapeController.changeColor(input);
                        }
                    }
                    break;

                case "3":
                    System.out.println("Which shape");
                    shapeName = scanner.nextLine();
                    for (ShapeController shapeController : shapes) {
                        if (shapeController.getName().equals(shapeName)) {
                            shapeController.undoColor();
                        }
                    }
                    break;

                case "4":
                    System.out.println("Which shape");
                    shapeName = scanner.nextLine();
                    System.out.println("Enter x");
                    int x = scanner.nextInt();
                    System.out.println("Enter y");
                    int y = scanner.nextInt();
                    for (ShapeController shapeController : shapes) {
                        if (shapeController.getName().equals(shapeName)) {
                            shapeController.moveShape(x, y);
                        }
                    }
                    break;

                case "5":
                    System.out.println("Which shape");
                    shapeName = scanner.nextLine();
                    for (ShapeController shapeController : shapes) {
                        if (shapeController.getName().equals(shapeName)) {
                            shapeController.undoMove();
                        }
                    }
                    break;

                case "6":
                    System.out.println("Goodbye");
                    looping = false;
                    break;

                default:
                    System.out.println("Invalid command");
                    break;
            }

        }
        scanner.close();

    }
}
