package com.learning.datastructures;

import java.util.ArrayList;

/**
 * Below is replica of dynamic array which resizes itself when adding elements
 * */
public class DArray<T> {
//    ArrayList

    private Object []arr;
    private Integer indexPtr = 0;
    private Integer currentCapacity = 0;

    DArray(){
        currentCapacity = 1;
        arr = new Object[currentCapacity];
        indexPtr = 0;
    }

    public void add(T obj){
        if(indexPtr == currentCapacity){
            grow();
        }
        arr[indexPtr++] = (T)obj;
    }

    void add(int index, T obj){
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        this.add(this.get(this.size()-1));
        for(int i = indexPtr-1;i > index;i--){
            arr[i] = arr[i-1];
        }
        arr[index] = obj;
    }

    void remove(int index){
        if(index<0 || index>=this.size())
            throw new IndexOutOfBoundsException();
        for(int i = index;i < indexPtr-1;i++){
            arr[i] = arr[i+1];
        }
        indexPtr--;
    }

    void removeAtTail(){
        remove(this.size()-1);
    }

    private void grow() {

        if(currentCapacity == Integer.MAX_VALUE)
            throw new OutOfMemoryError("Required array size is too large");
        currentCapacity <<= 1;

        //copying elements to new increased size array
        Object[] tempArr = new Object[currentCapacity];
        for(int i = 0;i < indexPtr;i++){
            tempArr[i] = arr[i];
        }
        arr = null;
        arr = tempArr;

    }

    public Integer getCapacity(){
        return this.currentCapacity;
    }

    public Integer size(){
        return this.indexPtr;
    }

    public T get(int i){
        if(i<0 || i>=indexPtr)
            throw new IndexOutOfBoundsException();
        return (T)this.arr[i];
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        for(int i = 0;i < size();i++) {
            str.append(arr[i]);
            if(i < size()-1)
                str.append(",");
        }
        str.append("]");
        return str.toString();
    }

    public static void main(String[] args) {
        DArray<String> arr = new DArray<>();
        arr.add("Mihir");
        System.out.println(arr.size());
        arr.add("Manas");
        System.out.println(arr.size());
        arr.add("Dhaval");
        System.out.println(arr.size());
        arr.add("Chandresh");
        System.out.println(arr.size());
        arr.add("Deven");
        System.out.println(arr.size());
        System.out.println(arr.getCapacity());
        System.out.println(arr.get(0));
        System.out.println(arr);
        arr.remove(0);
        System.out.println(arr);
        arr.add(2,"P");
        System.out.println(arr);
        arr.add(0,"OP");
        System.out.println(arr);
    }
}
