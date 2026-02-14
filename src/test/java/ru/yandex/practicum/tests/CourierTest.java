package ru.yandex.practicum.tests;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.model.Courier;
import ru.yandex.practicum.steps.CourierSteps;
import static org.hamcrest.CoreMatchers.is;

public class CourierTest extends BaseTest {
    private CourierSteps courierSteps = new CourierSteps();
    private Courier courier;

    @Before
    public void setUp() {
        courier = new Courier();
        courier.setLogin(RandomStringUtils.randomAlphabetic(12));
        courier.setPassword(RandomStringUtils.randomAlphabetic(12));
    }

    @Test
    @DisplayName("Создание нового курьера")
    public void createNewCourierTest() {
        courierSteps
                .createCourier(courier)
                .statusCode(201)
                .body("ok", is(true));
    }

    @Test
    @DisplayName("Попытка создать двух одинаковых курьеров")
    public void duplicateCourierCreationTest() {
        courierSteps
                .createCourier(courier)
                .statusCode(201);
        courierSteps
                .createCourier(courier)
                .statusCode(409)
                .body("message", is("Этот логин уже используется"));
    }

    @Test
    @DisplayName("Создание курьера без логина")
    public void createCourierWithoutLoginTest() {
        Courier invalidCourier = new Courier();
        invalidCourier.setPassword(courier.getPassword());
        courierSteps
                .createCourier(invalidCourier)
                .statusCode(400)
                .body("message", is("Недостаточно данных для создания учетной записи"));
    }

    @Test
    @DisplayName("Создание курьера без пороля")
    public void createCourierWithoutPasswordTest() {
        Courier invalidCourier = new Courier();
        invalidCourier.setLogin(courier.getLogin());
        courierSteps
                .createCourier(invalidCourier)
                .statusCode(400)
                .body("message", is("Недостаточно данных для создания учетной записи"));
    }

    @After
    public void tearDown() {
        Integer id = courierSteps.login(courier).extract().body().path("id");
        if (id != null && id > 0) {
            courier.setId(id);
            courierSteps.deleteCourier(courier);
        }
    }
}