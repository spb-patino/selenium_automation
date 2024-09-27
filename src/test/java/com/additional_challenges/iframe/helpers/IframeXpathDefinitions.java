package com.additional_challenges.iframe.helpers;

public class IframeXpathDefinitions {
    public static final String iframe                = "//div[@id = 'main']/descendant::iframe";
    public static final String burgerMenuIframe      = "//div[@id = 'sidebar']/descendant::a[@class='toggle']";
    public static final String anchorAccordionIframe = "//div[@id = 'sidebar']/descendant::nav[@id = 'menu']/descendant::a[@href = 'accordion.html' and text() = 'Accordion']";
    public static final String burgerMenuMain        = "//div[@id = 'sidebar']/descendant::a[@class='toggle']";
    public static final String menuMain              = "//div[@id = 'main']/following-sibling::div[@id = 'sidebar']";
}