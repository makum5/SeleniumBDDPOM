//package TestRunner;
//
//import org.junit.runner.RunWith;
//
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/main/java/Features/login.feature", //path to feature file
//                 glue = { "stepdefinition" },  //path to step definition file
//                 format= {"pretty","html:test-output/html","json:test-output/json/cucumber.json","junit:test-output/xml/cucumber.xml"}, //to generate different output format
//                 dryRun = false, //to verify the mapping of feature files with step def files
//                 monochrome=true, //display the console output in readable format
//                 strict = true //it will fail the test case if any step is pending in step def
//                 //tags={"@End2EndTest", "@RegressionTest"}         
//		)
//public class TestRunner {
//
//}
//
////OR : tags = {"@Test1,@Test2"}
////And : tags = {"@Test1", "@Test2"}
//// ~ = to ignore