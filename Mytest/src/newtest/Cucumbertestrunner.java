package newtest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features="Feturetest",glue={"Cucumbertest"})
public class Cucumbertestrunner {
	
}
