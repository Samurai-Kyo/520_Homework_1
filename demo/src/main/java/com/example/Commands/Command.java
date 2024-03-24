package com.example.Commands;

import com.example.Shape;

public interface Command<t> {
    public Shape shape = null;

    public void execute(t argument);

    // public void execute(String args);
    public void undo();
}
