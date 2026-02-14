package ru.yandex.practicum.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.yandex.practicum.model.Courier;
import static io.restassured.RestAssured.given;


public class CourierSteps {
    public static final String COUREIER = "/api/v1/courier";
    public static final String LOGIN = "/api/v1/courier/login";
    public static final String COUREIER_ID = "/api/v1/courier/{id}";

    @Step("Создание нового курьера")
    public ValidatableResponse createCourier(Courier courier) {
        return given()
                .body(courier)
                .post(COUREIER)
                .then();
    }

    @Step("Авторизация курьера")
    public ValidatableResponse login(Courier courier) {
        return given()
                .body(courier)
                .when()
                .post(LOGIN)
                .then();
    }

    @Step("Удаление курьера")
    public ValidatableResponse deleteCourier(Courier courier) {
        return given()
                .pathParam("id", courier.getId())
                .when()
                .delete(String.format(COUREIER_ID, courier.getId()))
                .then();
    }
}
