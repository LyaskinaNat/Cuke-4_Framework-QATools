$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/functionalTests/End2End_Test.feature");
formatter.feature({
  "name": "Automated End2End Tests",
  "description": "  Description: The purpose of this feature is to test End 2 End integration.",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Customer place an order by purchasing an item from search",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "name": "he search for \"dress\"",
  "keyword": "When "
});
formatter.step({
  "name": "choose to buy the first item",
  "keyword": "And "
});
formatter.step({
  "name": "moves to checkout from mini cart",
  "keyword": "And "
});
formatter.step({
  "name": "enter \u003ccustomer\u003e personal details on checkout page",
  "keyword": "And "
});
formatter.step({
  "name": "place the order",
  "keyword": "And "
});
formatter.step({
  "name": "verify the order details",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "customer"
      ]
    },
    {
      "cells": [
        "Natalia"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Customer place an order by purchasing an item from search",
  "description": "",
  "keyword": "Scenario Outline"
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
  "status": "passed"
});
formatter.step({
  "name": "enter Natalia personal details on checkout page",
  "keyword": "And "
});
formatter.match({
  "location": "CheckoutPageSteps.enter_personal_details_on_checkout_page(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "place the order",
  "keyword": "And "
});
formatter.match({
  "location": "CheckoutPageSteps.place_the_order()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify the order details",
  "keyword": "Then "
});
formatter.match({
  "location": "ConfirmationPageSteps.verify_the_order_details()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});