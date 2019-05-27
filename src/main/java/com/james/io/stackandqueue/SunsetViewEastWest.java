package com.james.io.stackandqueue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Problem 9.6, east to west version
 */
public class SunsetViewEastWest {

    static class Building {
        int id;
        int height;

        Building(int id, int height) {
            this.id = id;
            this.height = height;
        }
    }

    public Deque<Building> getSunsetBuildings(Iterator<Integer> heights) {
        final Deque<Building> aux = new LinkedList<>();
        final Deque<Building> res =  new LinkedList<>();
        int id = 0;
        while (heights.hasNext()) {
            aux.addFirst(new Building(id++, heights.next()));
        }
        while (!aux.isEmpty()) {
            Building cur = aux.removeFirst();
            if (res.isEmpty() || res.peekFirst().height < cur.height) {
                res.addFirst(cur);
            }
        }
        return res;
    }
}
