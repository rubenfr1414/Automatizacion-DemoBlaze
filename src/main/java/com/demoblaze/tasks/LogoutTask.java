package com.demoblaze.tasks;
/*
 * @(#) RegisterTask.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import com.demoblaze.interactions.SwichAlert;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.WebDriver;

import static com.demoblaze.ui.RegisterUI.*;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class LoginTask implements Task {
    private WebDriver driver;

    public LoginTask(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_LOGIN),
                Click.on(LOGIN_TXT_EMAIL),
                Enter.theValue("pepe3@yopmail.com").into(LOGIN_TXT_EMAIL),
                Click.on(LOGIN_TXT_PASSWORD),
                Enter.theValue("1234").into(LOGIN_TXT_PASSWORD),
                Click.on(BTN_LOGIN2),
                SwichAlert.onAlert(driver)
        );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static LoginTask on(WebDriver driver){

        return new LoginTask(driver) ;
    }
}
