package com.example.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    
    // -------------
    // API Constants
    // -------------
    public static final String BASE_URL = "https://gorest.co.in/public/v1";
    public static final String ACCESS_TOKEN = "01d89304ceea08edb0327f87fb20b526b8202d607af75af9ef6d4ebcbff9a794";

    // ---------
    // Endpoints
    // ---------
    public static final String USERS_ENDPOINT = "/users";

    // -----------------
    // Default user data
    // -----------------
    public static final Map<String, String> DEFAULT_USER_DATA = new HashMap<String, String>() {{
        put("email", "umut@gmail.com");
        put("name", "test");
        put("gender", "male");
        put("status", "active");
    }};

    // -------------------------------------
    // UI Constants for Search Functionality
    // -------------------------------------
    public static final String LELY_BASE_URL = "https://www.lely.com/en";
    public static final String SEARCH_BUTTON_CSS = "div.header-navigation-button[data-do='trigger-search']";
    public static final String SEARCH_BOX_CSS = "input#global-search";
    public static final String SEARCH_RESULTS_CSS = "div.page-section-even li.item .item-description";
    public static final String SEARCH_KEYWORD = "happy";

    // ---------------------------------------
    // UI Constants for TechDocs Functionality
    // ---------------------------------------
    public static final String TECHDOCS_URL = "https://www.lely.com/techdocs/";
    public static final String DOWNLOAD_DIR = System.getProperty("user.dir") + "/downloads";
    public static final String DROPDOWN_ID = "select2-id_q-container"; // Dropdown ID
    public static final String LUNA_OPTION_CSS = "li.select2-results__option"; // LUNA EUR option CSS
    public static final String CATALOG_HEADER_CSS = ".item:nth-of-type(1) .result-item-title"; // Catalog header CSS
    public static final String VIEW_DOCUMENT_LINK_CSS = ".item:nth-of-type(1) [target]"; // View document link CSS
    public static final String DOWNLOAD_BUTTON_CSS = ".item:nth-of-type(1) .button-secondary"; // Download button CSS
    public static final String COOKIE_ACCEPT_BUTTON_ID = "cookienotice-button-accept"; // Cookie accept button ID
    public static final String EXPECTED_URL_FRAGMENT = "TechDocHandler.aspx"; // Expected URL fragment
    public static final String DROPDOWN_INPUT_CSS = "input.select2-search__field"; // Dropdown input CSS
}
