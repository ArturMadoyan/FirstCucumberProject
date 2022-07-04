package GlobalQAPages;

import com.github.javafaker.Faker;

public class Constants {
    static Faker faker = new Faker();

    public static final String FIRST_PAGE_URL =
            "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    public static final String MANAGER_PAGE_URL_CONTAINS = "manager";
    public static final String ADDCUST_PAGE_URL_CONTAINS = "addCust";
    public static final String LIST_PAGE_URL_CONTAINS = "list";
    public static final String ALERT_TEXT_CONTAINS = "added successfully";
    public static final String firstName = faker.name().firstName();
    public static final String lastName = faker.name().lastName();
    public static final String postCode = faker.address().zipCode();
}
