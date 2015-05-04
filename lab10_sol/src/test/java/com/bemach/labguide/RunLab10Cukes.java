package com.bemach.labguide;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by ktran on 4/26/2015.
 *
 * NOTE:
 * - To run all scenario from a command line, use this at a window prompt:
 *   mvn -Dtest=RunLab10Cukes clean test
 *   make sure to comment out the tags if you want to run 'all' features.
 *
 * - A basic report is provided under target/cucumber-html directory.
 *
 * - A prettier report can be generated using sandwidch tool that can be downloaded from here:
 *   http://www.masterthought.net/section/cucumber-reporting-downloads
 *   You must make sure to have this format option declared in @CucumberOptions:
 *   "json:target/cucumber-json/cucumber.json"
 *   You need to go to the location of the Java jar file for sandwitch software:
 *   C:\csd2015\bin\sandwich>java -jar original_cucumber-sandwich.jar -f c:/csd2015/java-ws/lab10_sol/target/cucumber-json -o c:/csd2015/
 java-ws/lab10_sol/target/cucumber-sandwich
 *
 * - You can view the report under target/cucumber-sandwich/cucumber-html-reports:
 *   tag-overview.htmnl and feature-overview.html
 */

@RunWith(Cucumber.class)
@CucumberOptions(format = {"html:target/cucumber-html","junit:target/cucumber-junit/Webpage.xml", "json:target/cucumber-json/cucumber.json"},
        features = "src/test/resources/com/bemach/labguide"
        //, tags = {"@no-payment-info"}
        )
public class RunLab10Cukes {
}
