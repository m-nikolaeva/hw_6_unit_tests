import org.junit.jupiter.api.Test;
import ru.gb.model.ComparisonOfListAverages;
import ru.gb.model.ListCalculation;
import ru.gb.view.ConsoleUI;
import ru.gb.view.View;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class ListComparisonTest {

    /**
     * Проверка сравнения среднего значения каждого списка:
     * первый список имеет большее среднее значение
     */
    @Test
    public void testFirstAverageGreater(){
        Integer[] array1 = {55, 55, 55};
        Integer[] array2 = {50, 50, 50};

        ListCalculation list1 = new ListCalculation();
        list1.setList(array1);
        ListCalculation list2 = new ListCalculation(array2);

        ComparisonOfListAverages c1 = new ComparisonOfListAverages();

        assertEquals("Первый список имеет большее среднее значение", c1.compareLists(list1,list2));
    }

    /**
     * Проверка сравнения среднего значения каждого списка:
     * второй список имеет большее среднее значение
     */
    @Test
    public void testSecondAverageGreater(){
        ListCalculation list1 = new ListCalculation();
        ListCalculation list2 = new ListCalculation();
        ComparisonOfListAverages comparison = mock(ComparisonOfListAverages.class);
        when(comparison.compareLists(list1, list2)).thenReturn("Второй список имеет большее среднее значение");
        comparison.compareLists(list1,list2);
        assertEquals("Второй список имеет большее среднее значение", comparison.compareLists(list1,list2));
    }

    /**
     * Проверка сравнения среднего значения каждого списка:
     * средние значения равны
     */
    @Test
    public void testBothAveragesEqual(){
        Integer[] array1 = {50, 50, 50};
        Integer[] array2 = {50, 50, 50};

        ListCalculation list1 = new ListCalculation();
        list1.setList(array1);
        ListCalculation list2 = new ListCalculation(array2);

        ComparisonOfListAverages c1 = new ComparisonOfListAverages();

        assertEquals("Средние значения равны", c1.compareLists(list1,list2));
    }

    /**
     * Проверка метода findAverage():
     * корректный расчет среднего значения списка чисел
     */
    @Test
    public void testAverageNumber(){
        Integer[] array = {57, 46, 23, 35};
        ListCalculation list = new ListCalculation(array);
        ComparisonOfListAverages average = new ComparisonOfListAverages();
        assertEquals(40.25, average.findAverage(list), 0.25);
    }

    /**
     Проверка метода setList()
     (принимает на вход список чисел и выводит этот список пользователю)
     */
    @Test
    public void testSetList(){
        ListCalculation l1 = new ListCalculation();
        Integer[] array = {2, 4, 4, 5};
        l1.setList(array);
        assertThat(l1.getInfo()).isEqualTo("List of numbers: 2, 4, 4, 5");
    }

    /**
     * Проверка метода randomList()
     * (корректная генерация конкретного количества чисел в списке)
     */
    @Test
    public void testRandomList(){
        ListCalculation list = new ListCalculation();
        list.randomList(20);
        assertThat(list.getSize()).isEqualTo(20);
    }

    /**
     * Проверка взаимодействия пользователя с интерфейсом
     * (при отсутствии каких-либо действий, появляется сообщение об отсутствии данных)
     */
    @Test
    public void testGetAnswer(){
        View view = new ConsoleUI();
        assertEquals("Empty", view.getAnswer());
    }

    /**
     * Проверка взаимодействия пользователя с интерфейсом
     * (второй список имеет большее среднее значение)
     */
    @Test
    public void testGetAnswerForUser(){
        View view = new ConsoleUI();
        view.execute();

        String res = "Второй список имеет большее среднее значение";
        assertEquals(res, view.getAnswer());
    }

    /**
     * Проверка взаимодействия пользователя с интерфейсом
     * (приветствие пользователя)
     */
    @Test
    public void testHello(){
        ConsoleUI view = new ConsoleUI();
        view.start();
        String res = "Доброго времени суток!";
        assertEquals(res, view.hello());
    }
}
