package com.example.Commands;

import com.example.Shape;

public class ChangeColorCommand implements Command<String> {
    private Shape shape;
    private String oldColor;

    public ChangeColorCommand(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void execute(String color) {
        oldColor = shape.color;
        shape.color = color;
        System.out.println(shape.name + " is now " + shape.color);
    }

    @Override
    public void undo() {
        shape.color = oldColor;
        System.out.println("Color undone. " + shape.name + " is back to " + shape.color);
    }

}
