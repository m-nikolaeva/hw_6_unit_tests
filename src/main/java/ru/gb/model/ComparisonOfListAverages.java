package ru.gb.model;

public class ComparisonOfListAverages extends ListCalculation {
    private double average;

    public double getAverage() {
        return average;
    }

    public double findAverage(ListCalculation list) {
        double sum = 0;
        for (int i = 0; i < list.getSize(); i++) {
            sum += list.getList().get(i);
        }
        average = sum / list.getSize();
        return average;
    }

    public String compareLists(ListCalculation listCalc1, ListCalculation listCalc2) {
        double average1 = findAverage(listCalc1);
        double average2 = findAverage(listCalc2);

        if (average1 > average2) {
            return "Первый список имеет большее среднее значение";
        } else if (average2 > average1) {
            return "Второй список имеет большее среднее значение";
        } else {
            return "Средние значения равны";
        }
    }
}
