package com.bemach.labguide;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"html:target/cucumber-html","junit:target/cucumber-junit/Webpage.xml", "pretty"},
				 features = "src/test/resources/com/bemach/labguide/restful"
				 //,tags = "@several-customers"
				 )
public class RunCukesTest {

}