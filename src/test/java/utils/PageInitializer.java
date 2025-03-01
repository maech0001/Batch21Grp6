package utils;

import Pages.DashboardPage;
import Pages.LoginPage;

public class PageInitializer {

    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;

    public static void initializePageObjects(){
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

    }
}
