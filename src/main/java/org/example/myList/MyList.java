package org.example.myList;

import org.example.exceptions.NotFindException;
import org.example.exceptions.NotIndexException;

import java.util.List;

public class MyList {
    private String[] MyArray;
    private int capacity;
    private int size = 5;

    public MyList(){
        capacity = 5;
        MyArray = new String[capacity];

    }

    public MyList(String value){
        if(MyArray == null){
            MyArray = new String[size];
            MyArray[0] = value;
            capacity++;
        }else{
            MyArray[0] = value;
            capacity++;
        }
    }

    public String add(String item) {
        if (capacity < size){
            MyArray[capacity] = item;
            capacity++;
            return  item ;
        }else{
            MyArray = toArray();
            MyArray[capacity] = item;
            capacity++;
            return  item ;
        }
    }

    public String add(String item, int index) throws NotIndexException {
        if(index > size - 1|| index < 0){
            throw new NotIndexException(" неверный индекс");
        }else{
            MyArray = toArray();
            MyArray[index] = item;
            if(index>capacity){ capacity++;}
            return item;
        }
    }

    public String remove(String value)throws NotFindException {
        int k =0;
        for (int i = 0; i < MyArray.length; i++) {
            if(MyArray[i] == value){
                MyArray[i] = null;
                capacity--;
                String[] newArr = new String[capacity];
                for (int j = 0; j <= capacity; j++) {

                    if (MyArray[j] != null) {
                        newArr[k++] = MyArray[j];
                    }
                }
                for (int i1 = 0; i1 < newArr.length; i1++) {
                    MyArray[i1] = newArr[i1];
                }

                return value;
            }
        }
        throw new NotFindException("Такого индекса нет");
    }

    public String remove(int index)throws NotIndexException {
        if (index > capacity && index < 0) {
            throw new NotIndexException("Такого индекса нет");
        }else{
            return MyArray[index];
        }

    }

    public boolean  contains(String index){
        for(var a : MyArray) {
            if (a == index) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(String item) {
        for (int i = 0; i < MyArray.length; i++) {
            if(MyArray[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String item) {
        for (int i = MyArray.length - 1; i >= 0; i--) {
            if(MyArray[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public String[] toArray(){
        size *= 1.6;
        String[] newArray = new String[size];
        for(int i = 0; i<capacity;i++){
            newArray[i] = MyArray[i];
        }
        return newArray;
    }

    public String getIndex(int index) throws NotIndexException {
        if (index >= 0 && index < size) {
            return MyArray[index];
        }else{
            throw new NotIndexException("неверный индекс");
        }
    }

    public boolean equals(List<String> otherList) {
        for (int i = 0; i < capacity; i++) {
            if (MyArray[i] != otherList.get(i)) {
                return false;
            }
        }
        return true;
    }
    public int size(){
        return capacity;
    }
    public boolean isEmpty(){
        if (capacity == 0) {
            return false;
        }
        return true;
    }
    public void  clear(){
        capacity = 0;
        String[] newArr = new String[capacity];
        MyArray = newArr;
    }

    public String[] getMyArray() {
        return MyArray;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void toString1(){
        for(var i : MyArray){
            if(i == null)continue;
            System.out.println(i);
        }
    }
}
