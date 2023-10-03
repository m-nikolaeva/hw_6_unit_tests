package ru.gb.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListCalculation {
    private List<Integer> list;
    public ListCalculation(){
        list= new ArrayList<>();
    }
    public ListCalculation(Integer[] list){
        this.list = Arrays.asList(list);
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(Integer[] list) {
        this.list = Arrays.asList(list);

    }

    public  List<Integer> randomList(int size){
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            int num = rnd.nextInt(50);
            list.add(num);
        }
        return list;
    }

    public int getSize(){
        return list.size();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("List of numbers: ");
            for (int i = 0; i < list.size() - 1; i++) {
                sb.append(list.get(i)).append(", ");
            }
        sb.append(list.get(list.size() - 1));

        return sb.toString();
    }
}
