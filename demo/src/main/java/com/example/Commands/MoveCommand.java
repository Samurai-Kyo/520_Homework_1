package com.example.Commands;

import com.example.Shape;

public class MoveCommand implements Command<int[]> {
    private Shape shape;
    private int[] oldArgs = new int[] { 0, 0 };

    public MoveCommand(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void execute(int args[]) {
        oldArgs[0] = shape.x;
        oldArgs[1] = shape.y;
        shape.x = args[0];
        shape.y = args[1];
        System.out.println("Moving " + shape.name + " up to " + shape.x + " " + shape.y);
    }

    @Override
    public void undo() {
        shape.x = oldArgs[0];
        shape.y = oldArgs[1];
        System.out.println("Move undone. Shape " + shape.name + " is back at " + shape.x + " " + shape.y);
    }
}
