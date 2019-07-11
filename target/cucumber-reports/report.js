$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/functionalTests/End2End_Test.feature");
formatter.feature({
  "name": "Automated End2End Tests",
  "description": "  Description: The purpose of this feature is to test End 2 End integration.",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Customer place an order by purchasing an item from search - customer details are taken from JSON file",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@wip"
    }
  ]
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
    },
    {
      "cells": [
        "Tyler"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Customer place an order by purchasing an item from search - customer details are taken from JSON file",
  "description": "",
  "keyword": "Scenario Outline",
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
  "error_message": "org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document\n  (Session info: chrome\u003d75.0.3770.100)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/stale_element_reference.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027OCS071-MacBook-Pro.local\u0027, ip: \u0027fe80:0:0:0:1491:ab03:4fc3:d94c%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.14.3\u0027, java.version: \u00271.8.0_201\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 75.0.3770.100, chrome: {chromedriverVersion: 75.0.3770.8 (681f24ea911fe7..., userDataDir: /var/folders/fc/tvgtgbf1093...}, goog:chromeOptions: {debuggerAddress: localhost:52343}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: MAC, platformName: MAC, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}\nSession ID: 94fcfe9c15092447df60161db0046182\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:84)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:51)\n\tat com.sun.proxy.$Proxy17.click(Unknown Source)\n\tat pageObjects.CartPage.clickOn_Cart(CartPage.java:34)\n\tat stepDefinitions.CartPageSteps.moves_to_checkout_from_mini_cart(CartPageSteps.java:19)\n\tat ✽.moves to checkout from mini cart(src/test/resources/functionalTests/End2End_Test.feature:8)\n",
  "status": "failed"
});
formatter.step({
  "name": "enter Natalia personal details on checkout page",
  "keyword": "And "
});
formatter.match({
  "location": "CheckoutPageSteps.enter_personal_details_on_checkout_page(String)"
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
formatter.write("\u003ca target\u003d\"_blank\", href\u003d/Users/natalialyaskina/IdeaProjects/toolsqatutorial/test-output/Screenshots/11_7_2019_14_13.png\u003e\u003cimg src\u003d/Users/natalialyaskina/IdeaProjects/toolsqatutorial/test-output/Screenshots/11_7_2019_14_13.png height\u003d200 width\u003d300\u003e\u003c/img\u003e\u003c/a\u003e");
formatter.write("Executed by: natalialyaskina");
formatter.write("Platform: Mac OS X (x86_64) v.10.14.3");
formatter.write("Browser: CHROME v. 75.0.3770.100");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Customer place an order by purchasing an item from search - customer details are taken from JSON file",
  "description": "",
  "keyword": "Scenario Outline",
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
  "name": "enter Tyler personal details on checkout page",
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
formatter.write("Executed by: natalialyaskina");
formatter.write("Platform: Mac OS X (x86_64) v.10.14.3");
formatter.write("Browser: CHROME v. 75.0.3770.100");
formatter.after({
  "status": "passed"
});
});