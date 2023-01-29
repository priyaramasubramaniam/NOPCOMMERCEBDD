package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class BaseClass {

    public static String randomEmail()
    {
        return RandomStringUtils.randomAlphabetic(5).toLowerCase()+"@gmail.com";
    }
}
