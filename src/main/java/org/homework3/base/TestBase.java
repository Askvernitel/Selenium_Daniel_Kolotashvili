package org.homework3.base;

import org.homework3.utils.Config;
import org.homework3.utils.DriverFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    @BeforeClass
    public void setup(ITestContext testContext) {
        Config.initConfig(testContext);
        DriverFactory.initDriverOf(Config.DEFAULT_BROWSER);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
