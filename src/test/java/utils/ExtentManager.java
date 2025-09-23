package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Raport Teste Automatizate");
            spark.config().setReportName("Rezultate Teste Selenium + JUnit");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
