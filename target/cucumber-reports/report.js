$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/functionalTests/End2End_Test.feature");
formatter.feature({
  "name": "Automated End2End Tests",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.scenario({
  "name": "Customer place an order by purchasing an item from search - customer details are taken from DataTable",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePageSteps.user_is_on_Home_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he search for \"dress\"",
  "keyword": "When "
});
formatter.match({
  "location": "HomePageSteps.he_search_for(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "choose to buy the first item",
  "keyword": "And "
});
formatter.match({
  "location": "ProductPageSteps.choose_to_buy_the_first_item()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "moves to checkout from mini cart",
  "keyword": "And "
});
formatter.match({
  "location": "CartPageSteps.moves_to_checkout_from_mini_cart()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Unable to find the WebElement, Exception: null\n\tat org.junit.Assert.fail(Assert.java:89)\n\tat utils.Wait.WaitForElementUsingCustomTimeout(Wait.java:23)\n\tat pageObjects.CartPage.clickOn_Cart(CartPage.java:28)\n\tat stepDefinitions.CartPageSteps.moves_to_checkout_from_mini_cart(CartPageSteps.java:30)\n\tat ✽.moves to checkout from mini cart(src/test/resources/functionalTests/End2End_Test.feature:24)\n",
  "status": "failed"
});
formatter.step({
  "name": "enter customer personal details  as follows on checkout page",
  "rows": [
    {
      "cells": [
        "first_name",
        "last_name",
        "country",
        "street_address",
        "town",
        "postcode",
        "phone_number",
        "email_address"
      ]
    },
    {
      "cells": [
        "Natalia",
        "Lyaskina",
        "United Kingdom (UK)",
        "29 Duchess Street",
        "Newcastle",
        "NE12 7PE",
        "07815111222",
        "test@test.com"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "CheckoutPageSteps.enter_customer_personal_details_as_follows_on_checkout_page(CustomerDataType\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "place the order",
  "keyword": "And "
});
formatter.match({
  "location": "CheckoutPageSteps.place_the_order()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "verify the order details",
  "keyword": "Then "
});
formatter.match({
  "location": "ConfirmationPageSteps.verify_the_order_details()"
});
formatter.result({
  "status": "skipped"
});
formatter.write("Taking a screenshot for a failing step");
formatter.write("\u003cbr\u003e");
formatter.write("\u003ca target\u003d\"_blank\", href\u003d/Users/natalialyaskina/IdeaProjects/toolsqatutorial/test-output/Screenshots/12_7_2019_17_7.png\u003e\u003cimg src\u003d/Users/natalialyaskina/IdeaProjects/toolsqatutorial/test-output/Screenshots/12_7_2019_17_7.png height\u003d200 width\u003d300\u003e\u003c/img\u003e\u003c/a\u003e");
formatter.write("Executed by: natalialyaskina");
formatter.write("Platform: Mac OS X (x86_64) v.10.14.3");
formatter.write("Browser: CHROME v. 75.0.3770.100");
formatter.after({
  "status": "passed"
});
});