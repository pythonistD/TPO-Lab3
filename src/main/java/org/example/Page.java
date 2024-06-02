package org.example;

import java.sql.Driver;

public abstract class Page {
    private Driver driver;

    public Page(Driver driver) {
        this.driver = driver;
    }
}
