package ru.yandex.practicum.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.yandex.practicum.model.Ordering;
import static io.restassured.RestAssured.given;

public class OrderSteps {
    public static final String ORDER_CREATE = "/api/v1/orders";

    @Step("Создание нового заказа")
    public ValidatableResponse orderCreate(Ordering orderCreate){
        return given()
                .body(orderCreate)
                .post(ORDER_CREATE)
                .then();
    }

    @Step("Получение списка заказов")
    public ValidatableResponse orderList(){
        return given()
                .get(ORDER_CREATE)
                .then();
    }
}
