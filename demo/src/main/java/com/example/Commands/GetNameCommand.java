package com.example.Commands;
import com.example.Shape;

public class GetNameCommand {
    private Shape shape;

    public GetNameCommand(Shape shape) {
        this.shape = shape;
    }

    public String execute() {
        return shape.name;
    }

}
