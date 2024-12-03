package starter.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.events.AfterScenario;
import net.serenitybdd.core.annotations.events.BeforeScenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import starter.pages.SamplePage;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SampleSteps {
    SamplePage samplePage;

    @Given("^I am on homepage")
    public void I_am_on_homepage() throws Throwable {
        System.out.println("I am on homepage");
        samplePage.createDriver();
    }

    @When("^I click on Search Wikipedia")
    public void I_click_on_search_wikipedia() throws Throwable {
        System.out.println("I click on Search Wikipedia");
        samplePage.selectSearchElement("Search Wikipedia");
        Thread.sleep(15000);
    }

    @Then("^I search with keyword BrowserStack")
    public void I_search_with_browserstack() throws Throwable {
        System.out.println("I click on Search Wikipedia");

        samplePage.insertText("BrowserStack");


        Thread.sleep(2000);
        samplePage.takeScreenshot();
//        assertTrue(false);
    }

    @Then("the search results should be listed")
    public void the_search_results_should_be_listed() {
        List<WebElement> searchResults = samplePage.getSearchResults();
        assertTrue(searchResults.size() > 0);
    }

    @Then("the test should fail")
    public void test_should_fail() {
        assertTrue(false);
    }

    @Before
    public void before() {
        System.out.println("Before hook");
    }

    @After
    public void after() {
        System.out.println("After hook");
    }

    @BeforeScenario
    public void beforeScenario() {
        System.out.println("Before scenario hook");
    }

    @AfterScenario
    public void afterScenario() {
        System.out.println("After scenario hook");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all hook");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all hook");
    }
}