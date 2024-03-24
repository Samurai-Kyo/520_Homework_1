package com.example;

import com.example.Commands.ChangeColorCommand;
import com.example.Commands.GetNameCommand;
import com.example.Commands.MoveCommand;

public class ShapeController {
    // commands
    private MoveCommand move;
    private ChangeColorCommand changeColor;
    private GetNameCommand getName;

    public ShapeController(MoveCommand move, ChangeColorCommand changeColor, GetNameCommand getName) {
        this.move = move;
        this.changeColor = changeColor;
        this.getName = getName;
    }

    public void moveShape(int x, int y) {
        move.execute(new int[]{x, y});
    }

    public void undoMove() {
        move.undo();
    }

    public void changeColor(String color) {
        changeColor.execute(color);
    }

    public void undoColor() {
        changeColor.undo();
    }

    public String getName () {
        return getName.execute();
    }
}
