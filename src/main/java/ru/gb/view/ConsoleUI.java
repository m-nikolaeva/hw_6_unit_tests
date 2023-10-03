package ru.gb.view;

import ru.gb.model.ComparisonOfListAverages;
import ru.gb.model.ListCalculation;

public class ConsoleUI implements View{

    final ComparisonOfListAverages comparison;
    final ListCalculation l1;
    final ListCalculation l2;

    public ConsoleUI(){
        this.comparison = new ComparisonOfListAverages();
        this.l1 = new ListCalculation();
        this.l2 = new ListCalculation();
    }

    @Override
    public void execute() {
        Integer[] array1 = {47, 37, 63, 54, 4};
        Integer[] array2 = {95, 41, 80, 82, 68};
        l1.setList(array1);
        l2.setList(array2);
        comparison.compareLists(l1,l2);
    }

    @Override
    public String getAnswer() {
        StringBuilder st = new StringBuilder();
        if (l1.getSize() == 0 || l2.getSize() == 0||comparison.getAverage()==0.0){
            st.append("Empty");
        }else {
            st.append(comparison.compareLists(l1, l2));
        }
        return st.toString();
    }

    public String hello() {
        return "Доброго времени суток!";
    }

    public void start() {
            System.out.println(hello());
            execute();
    }
}
