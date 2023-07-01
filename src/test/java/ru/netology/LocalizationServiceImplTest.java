package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {
    @Test
    public void checkLocal(){
        final Country Russia = Country.RUSSIA;
        final Country USA = Country.USA;
        final Country Brazil = Country.BRAZIL;
        final Country Germany = Country.GERMANY;
        final String GreetingRussia = "Добро пожаловать";
        final String Greeting = "Welcome";

        LocalizationServiceImpl test = new LocalizationServiceImpl();

        Assertions.assertEquals(GreetingRussia, test.locale(Russia));
        Assertions.assertEquals(Greeting, test.locale(USA));
        Assertions.assertEquals(Greeting, test.locale(Germany));
        Assertions.assertEquals(Greeting, test.locale(Brazil));
    }
}
