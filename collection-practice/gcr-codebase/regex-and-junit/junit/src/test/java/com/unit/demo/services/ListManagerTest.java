package com.unit.demo.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.unit.demo.files.ListManager;

import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    // listmanager class object created
    ListManager manager = new ListManager();

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 10);
        assertTrue(list.contains(10));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        manager.removeElement(list, 5);
        assertFalse(list.contains(5));
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, manager.getSize(list));
    }
}
