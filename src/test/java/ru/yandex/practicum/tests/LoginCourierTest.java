package ru.yandex.practicum.tests;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.model.Courier;
import ru.yandex.practicum.steps.CourierSteps;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class LoginCourierTest extends BaseTest {
    private CourierSteps courierSteps = new CourierSteps();
    private Courier courier;

    @Before
    public void setUp() {
        courier = new Courier();
        courier.setLogin(RandomStringUtils.randomAlphabetic(12));
        courier.setPassword(RandomStringUtils.randomAlphabetic(12));
    }

    @Test
    @DisplayName("Авторизация курьера")
    public void checkCourierAuthorizationTest() {
        courierSteps
                .createCourier(courier);
        courierSteps
                .login(courier)
                .statusCode(200)
                .body("id",notNullValue());
    }

    @Test
    @DisplayName("Авторизация курьера, используя несуществующие данные")
    public void authorizationWithInvalidDataTest() {
        Courier invalidCourier = new Courier();
        invalidCourier.setLogin("nonexistent_login");
        invalidCourier.setPassword("invalid_password");
        courierSteps
                .login(invalidCourier)
                .statusCode(404)
                .body("message", is("Учетная запись не найдена"));
    }

    @Test
    @DisplayName("Авторизация курьера без логина")
    public void loginWithoutLoginTest() {
        courierSteps
                .createCourier(courier);
        Courier invalidCourier = new Courier();
        invalidCourier.setPassword(courier.getPassword());
        courierSteps
                .login(invalidCourier)
                .statusCode(400)
                .body("message", is("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Авторизация курьера без пароля")
    public void loginWithoutPasswordTest() {
        courierSteps
                .createCourier(courier);
        Courier invalidCourier = new Courier();
        invalidCourier.setLogin(courier.getLogin());
        courierSteps
                .login(invalidCourier)
                .statusCode(400)
                .body("message", is("Недостаточно данных для входа"));
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