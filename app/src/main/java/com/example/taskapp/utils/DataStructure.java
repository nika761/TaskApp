package com.example.taskapp.utils;

import android.util.Log;

public class DataStructure {

    private Node head;

    static class Node {

        private int data;
        private Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static DataStructure insert(DataStructure list, int data) {
        Node node = new Node(data);
        node.next = null;

        if (list.head == null) {
            list.head = node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
        }

        return list;
    }

    public static DataStructure deleteByKey(DataStructure list, int key) {
        Node currNode = list.head, prev = null;

        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;
            Log.e("O(1) time", key + " found and deleted");
            return list;
        }

        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }

        if (currNode != null) {
            prev.next = currNode.next;
            Log.e("O(1) time", key + " found and deleted");
        }

        if (currNode == null) {
            Log.e("O(1) time", key + " not found");
        }

        return list;
    }

    public static DataStructure deleteAtPosition(DataStructure list, int index) {
        Node currNode = list.head, prev = null;

        if (index == 0 && currNode != null) {
            list.head = currNode.next;
            Log.e("O(1) time", index + " position element deleted");
            return list;
        }

        int counter = 0;

        while (currNode != null) {

            if (counter == index) {
                prev.next = currNode.next;
                Log.e("O(1) time", index + " position element deleted");
                break;
            } else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        if (currNode == null) {
            Log.e("O(1) time", index + " position element deleted");
        }
        return list;
    }

}
