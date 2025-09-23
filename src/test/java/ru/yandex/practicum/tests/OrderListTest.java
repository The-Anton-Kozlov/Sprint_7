package ru.yandex.practicum.tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.practicum.steps.OrderSteps;
import static org.hamcrest.CoreMatchers.notNullValue;

public class OrderListTest extends BaseTest  {

    private OrderSteps orderSteps = new OrderSteps();


    @Test
    @DisplayName("Получение списка заказов")
    public void orderList() {
        orderSteps
                .orderList()
                .statusCode(200)
                .body("orders", notNullValue());

    }
}