package com.dotis.charakas;

import java.util.*;
import com.dotis.charakas.services.impl.InterpreterServiceImpl;

public class App {
    public static void main(String[] args) {
        Host host = new Host(new InterpreterServiceImpl());
        host.run();
    }
}