package com.dotis.charakas.services;

import java.util.*;

public interface AuthService {
    boolean login();
    boolean logout();
    boolean register();
}