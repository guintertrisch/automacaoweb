package utils;

import org.testng.*;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;

public class Listeners  implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("@Test: " + result.getName() + " >>>>>> Iniciado");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("@Test: " + result.getName() + " -> Passou ");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("@Test: " + result.getName() + " -> Falhou ");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + " -> Teste Pulou ");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println(context.getName() + ": Iniciado");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(context.getName() + ": Finalizado");

    }
}
