package com.learning.datastructures;

public class ULinkedList<X> {
    private static class Node<X>{
        private Node<X> prev = null;
        private Node<X> next = null;
        private X data = null;

        Node(){
            prev = null;
            next = null;
            data = null;
        }
        Node(X data){
            this.data = data;
        }
        Node(X data, Node<X> prev,Node<X> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return this.data.toString();
        }
    }

    private Node<X> head;
    private Node<X> tail;
    private Integer size = 0;

    private void init(X data){
        Node<X> newNode = new Node<>(data);
        head = newNode;
        tail = newNode;
        size ++;
    }


    /**
     *
     * @param data
     * Appends the data
     */
    void add(X data){
        if(head == null){
            init(data);
            return;
        }
        Node<X> newNode = new Node<X>(data);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size ++;
    }

    private void checkIndexInRange(int index){
        if(index<0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     *
     * @param index
     * @param data
     * can add element at index belongs to [0,size)
     */
    void add(int index, X data){
        checkIndexInRange(index);

        Node<X> newNode = new Node<>(data);
        if(index==0){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        else {
            Node<X> ptr = head;
            for (int i = 0; i < index; i++) {
                ptr = ptr.next;
            }
            newNode.prev = ptr.prev;
            newNode.next = ptr;
            ptr.prev.next = newNode;
            ptr.prev = newNode;
        }
        size ++;
    }

    /**
     *
     * @param index
     * Removes elements at index belongs to [0,size)
     */
    void remove(int index){
        checkIndexInRange(index);

        //size 1 then we need to handle with care
        if(size==1){
            head = tail = null;
            size --;
            return;
        }
        if(index == 0) {//corner case
            head.next.prev = null;
            head = head.next;
        }
        else if(index == size-1) {//corner case
            tail.prev.next = null;
            tail = tail.prev;
        }
        else{
            Node<X> ptr = head;
            for(int i = 0; i < index;i++){
                ptr = ptr.next;
            }
            ptr.prev.next = ptr.next;
            ptr.next.prev = ptr.prev;
        }
        size --;
    }

    public void remove(){
        remove(this.size-1);
    }

    X get(int index){
        checkIndexInRange(index);
        Node<X> ptr = head;
        for(int i = 0; i < index;i++){
            ptr = ptr.next;
        }
        return ptr.data;
    }

    int size(){
        return this.size;
    }

    /**
     *
     * @return
     * Returns the String Version of LinkedList object
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("{");
        Node<X> ptr = head;
        while(ptr != null){
            str.append(ptr.toString());
            ptr = ptr.next;
            if(ptr != null){
                str.append(" --> ");
            }
        }
        str.append("}");
        return str.toString();
    }

    public static void main(String[] args) {
        ULinkedList<String> uLinkedList = new ULinkedList<>();
        uLinkedList.add("Mihir");
        uLinkedList.add("Manas");
        uLinkedList.add(1,"Dhaval");
        uLinkedList.add("Chandresh");
        uLinkedList.add(2,"Deven");
        System.out.println(uLinkedList);
        uLinkedList.remove(1);
        uLinkedList.remove(3);
        System.out.println(uLinkedList);

        ULinkedList<Car> uLinkedList1 = new ULinkedList<>();
        uLinkedList1.add(new Car(4,"Mihir"));
        uLinkedList1.add(new Car(6,"Manas"));
        uLinkedList1.add(1,new Car(10,"Dhaval"));
        uLinkedList1.add(new Car(16,"Chandresh"));
        uLinkedList1.add(2,new Car(4,"Deven"));
        System.out.println(uLinkedList1);
        uLinkedList1.remove(1);
        uLinkedList1.remove(3);
        System.out.println(uLinkedList1);
    }
}

class Car{
    private int tyres;
    private String numberPlate;
    public Car(int tyres, String numberPlate){
        this.tyres = tyres;
        this.numberPlate = numberPlate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "tyres=" + tyres +
                ", numberPlate='" + numberPlate + '\'' +
                '}';
    }
}