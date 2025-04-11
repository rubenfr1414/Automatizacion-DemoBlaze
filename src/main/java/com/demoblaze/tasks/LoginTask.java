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
public class RegisterTask implements Task {
    private WebDriver driver;

    public RegisterTask(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("pepe@yopmail.com").into(TXT_EMAIL),
                Enter.theValue("1234").into(TXT_PASSWORD),
                Click.on(BTN_SIGN_UP),
                SwichAlert.onAlert(driver)
        );
    }

    public static RegisterTask on(WebDriver driver){

        return new RegisterTask(driver) ;
    }
}
