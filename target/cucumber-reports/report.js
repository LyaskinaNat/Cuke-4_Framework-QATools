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
  "status": "passed"
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
formatter.write("Executed by: natalialyaskina");
formatter.write("Platform: Mac OS X (x86_64) v.10.14.3");
formatter.write("Browser: CHROME v. 75.0.3770.100");
formatter.after({
  "status": "passed"
});
});