/*
 * Copyright (C) 2020 Oscar Arenas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package modelo;

import java.util.EmptyStackException;

/**
 *
 * @author Oscar Arenas
 */
public class LinkedStack {

    private Node top;
    private int n;

    public void push(double item) {
        top = new Node(item, top);
        n++;
    }

    public double pop() throws EmptyStackException {
        if (top == null) {
            throw new EmptyStackException();
        }
        double item = top.item;
        top = top.next;
        n--;
        return item;
    }

    public double peek() throws EmptyStackException {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.item;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return n;
    }

    @Override
    public String toString() {
        String text = "";

        if (top != null) {
            Node current = top;

            while (current.next != null) {
                text += current.item + ", ";
                current = current.next;
            }
            text += current.item;
        }
        return "[" + text + "]";
    }

    private class Node {

        double item;
        Node next;

        public Node(double item, Node next) {
            this.item = item;
            this.next = next;
        }

        public Node(double item) {
            this.item = item;
            next = null;
        }

        public double getItem() {
            return item;
        }

        public void setItem(int item) {
            this.item = item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
