package com.company.Bonus;

public class MyList {
    private static class Node {
        Node next;
        int data;
    }
    private Node head;

    public Node getNode(int num) {
        Node current = head;
        int i = -1;
        do {
            current = current.next;
            i++;
        }while(i != num);
        return current;
    }
    public void insertNode(int num, Node node) {

        Node current = head;
        do {
            current = current.next;
        } while(current.next != head.next);
        if (num == 0) {
            node.next = head.next;
            head.next = node;
            current.next = head.next;
            return;
        }
        node.next = getNode(num - 1).next;
        getNode(num - 1).next = node;
    }
    public MyList() {
        head = new Node();
        head.next = head;
    }

    public void setNumIntTheEnd(int value) {
        Node current = head;
        Node temp = new Node();
        temp.data = value;
       do{
           current = current.next;
       }while(current.next != head.next);
       current.next = temp;
       current=current.next;
       current.next = head.next;
    }
    public int getSize() {
        Node current = head;
        int result = 0;
        do {
            result++;
            current = current.next;
        }while(current.next != head.next);
        return result;
    }
    public void insertNum(int num, int value) {
        num--;
        if(num < 0 || num > getSize()) {
            throw new IllegalArgumentException("Такого элемента нет");
        }
        Node current = new Node();
        current.data = value;
        if(getSize() == 1) {
            head.next.data = current.data;
            return;
        }
        insertNode(num, current);

    }
    public void removeNum(int num) {
        num--;
        if(num < 0 || num > getSize()) {
            throw new IllegalArgumentException("Такого элемента нет");
        }
        if(getSize() == 1) {
            head.next=head;
        }
        Node current = head;
        do {
            current = current.next;
        } while(current.next != head.next);
        if(num == 0) {
            head.next = head.next.next;
            current.next = head.next;
            return;
        }
        getNode(num-1).next= getNode(num-1).next.next;
    }
    public String printList() {
        String result = "";
        if(head == null || head.next == null || head.next.data == 0) {
            result = "Список пуст";
            return result;
        }
        for(int i = 0; i < getSize(); i++) {
            result += String.valueOf(getNode(i).data) +" ";
        }
        return result;
    }
    public boolean compare(MyList myListOne, MyList myListTwo) {
        if (myListOne.getSize() != myListTwo.getSize()) {
            return false;
        }
        for(int i = 0; i != myListTwo.getSize(); i++) {
            if(myListOne.getNode(i).data != myListTwo.getNode(i).data) {
                return false;
            }
        }
        return true;
    }
    public void sortMyList() {
        if(head == null || head.next == null) {
           System.out.println("Список пуст");
        }
        Node[] result = new Node[getSize()];
        Node current = head;
        current = current.next;
        for(int i = 0; i < getSize(); i++) {
            result[i] = current;
            current = current.next;
        }

        for(int i = getSize()-1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(result[j].data > result[j+1].data) {
                   Node temp = new Node();
                   temp.data = result[j].data;
                    result[j].data = result[j+1].data;
                    result[j+1].data = temp.data;
                }
            }
        }
        current = head;
        current = current.next;
        for(int i = 0; i < getSize(); i++) {
            current = result[i];
            current = current.next;
        }

    }
    public void deleteList() {
        if(head == null || head.next == null) {
            System.out.println("Список пуст");
        }
        Node current = head.next;
        do {
            Node temp = current.next;
            current.next = null;
            current = temp;
        } while(current.next != null);
        current = null;
        head = null;
    }
}
