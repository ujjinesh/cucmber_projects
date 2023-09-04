package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\LENOVO\\eclipse-workspace\\Yahoo_Cucumber\\src\\test\\java\\featurefile\\Yahoo.feature",
              glue="stetDefinitions",
                monochrome = true, 
                plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
                      )
public class runner {

	
}
