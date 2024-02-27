package com.fahad.behavioral.template;

import java.util.Map;
import java.util.HashMap;

public class Computer {
    private Map<String, String> computerParts = new HashMap<>();

    public Computer(Map<String, String> computerParts) {
        this.computerParts = computerParts;
    }

    public Map<String, String> getComputerParts() {
        return computerParts;
    }
}
