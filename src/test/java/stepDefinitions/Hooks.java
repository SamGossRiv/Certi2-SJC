package stepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @Before
    public void beforeScenario() {
        System.out.println("Iniciando navegador...");

        // Inicializa el WebDriver desde el DriverManager
        driver = DriverManager.getInstance().getDriver();

        // Configuración de reportes
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/SparkReport/Spark.html");
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/HtmlReport/Extent.html");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter, htmlReporter);

        test = extent.createTest("SauceDemo Test", "Test de funcionalidad SauceDemo");

        // Navegar a la URL principal de la prueba
        driver.get("https://www.saucedemo.com/");
    }

    @After
    public void afterScenario() {
        System.out.println("Cerrando navegador...");

        // Cierra el WebDriver
        DriverManager.getInstance().quitDriver();

        // Guardar el reporte final
        extent.flush();
    }
}
