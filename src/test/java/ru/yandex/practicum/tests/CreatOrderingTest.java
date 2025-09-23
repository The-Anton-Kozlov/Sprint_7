package ru.yandex.practicum.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.model.Ordering;
import static org.hamcrest.CoreMatchers.notNullValue;
import ru.yandex.practicum.steps.OrderSteps;
import java.util.List;

@RunWith(Parameterized.class)
public class CreatOrderingTest extends BaseTest {

    private Ordering ordering;
    private OrderSteps orderSteps = new OrderSteps();
    private List<String> color;

    public CreatOrderingTest(List<String> color) {
        this.color = color;
    }

    @Parameterized.Parameters(name = "Цвет самоката - {0}")
    public static Object[][] dataGen() {
        return new Object[][]{
                {List.of("BLACK", "GREY")},
                {List.of("BLACK")},
                {List.of("GREY")},
                {List.of()}
        };
    }

    @Before
    public void setUp() {
        ordering = new Ordering(color);
    }


    @Test
    @DisplayName("Cоздания заказа с выбором цвета самоката")
    public void orderCreate() {
        orderSteps
                .orderCreate(ordering)
                .statusCode(201)
                .body("track", notNullValue());

    }
}

