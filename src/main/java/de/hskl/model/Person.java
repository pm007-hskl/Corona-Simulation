package de.hskl.model;

import processing.core.PApplet;
import processing.core.PVector;

enum condi {INF, HEALTHY, DEAD}

public class Person {
    PApplet p;
    PVector position;
    PVector move;
    // condi -> 1:healthy 2:inf 3:dead
    String accualCondition;

    public Person(PApplet p) {
        this.p = p;
        //inialer Zustand is healty
        accualCondition = String.valueOf(condi.HEALTHY);

        move = new PVector(p.random(-0.5f, 0.5f), p.random(-0.5f, 0.5f));
    }


    public String getCondition() {
        return accualCondition;
    }

    public void setcondition(String condition) {
        accualCondition = condition;
    }

    public void generatePosition() {
        position = new PVector(p.random(0, p.width), p.random(0, p.height));
    }

    public void movement() {
        position.x += move.x;
        position.y += move.y;
        if (accualCondition.equals("DEAD")) {
            move.x = 0;
            move.y = 0;
        }
        outOfBounce();

    }

    public void outOfBounce() {
        if (position.x >= p.width || position.x <= 0) {
            move.x = move.x * -1;
        } else if (position.y >= p.height || position.y <= 0) {
            move.y = move.y * -1;
        }
    }

    public void show() {
        if (accualCondition.equals("HEALTHY")) {
            p.stroke(0, 247, 0);
            p.point(position.x, position.y);
        } else if (accualCondition.equals("INF")) {
            p.stroke(255, 255, 0);
            p.point(position.x, position.y);
        } else {
            p.stroke(255, 0, 0);
            p.point(position.x, position.y);
        }

    }
}

