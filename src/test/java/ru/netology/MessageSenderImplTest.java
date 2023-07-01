package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTest {
    @Test
    public void checkMessage1(){
        final Location l = new Location("Moscow", Country.RUSSIA, null, 0);
        final String message = "Добро пожаловать";

        GeoServiceImpl geo = Mockito.mock(GeoServiceImpl.class);
        Mockito.when((geo.byIp("172.0.32.11")))
                .thenReturn(l);

        LocalizationServiceImpl local = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(local.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        Map<String,String> test_data = new HashMap<>();
        test_data.put("x-real-ip", "172.0.32.11");

        MessageSenderImpl test = new MessageSenderImpl(geo,local);
        Assertions.assertEquals(message, test.send(test_data));
    }

    @Test
    public void checkMessage2(){
        final Location l = new Location("New York", Country.USA, null,  0);
        final String message = "Welcome";

        GeoServiceImpl geo = Mockito.mock(GeoServiceImpl.class);
        Mockito.when((geo.byIp("96.44.183.149")))
                .thenReturn(l);

        LocalizationServiceImpl local = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(local.locale(Country.USA))
                .thenReturn("Welcome");

        Map<String,String> test_data = new HashMap<>();
        test_data.put("x-real-ip", "96.44.183.149");

        MessageSenderImpl test = new MessageSenderImpl(geo,local);
        Assertions.assertEquals(message, test.send(test_data));
    }

    @Test
    public void checkMessage3(){
        final Location l = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        final String message = "Добро пожаловать";

        GeoServiceImpl geo = Mockito.mock(GeoServiceImpl.class);
        Mockito.when((geo.byIp(GeoServiceImpl.MOSCOW_IP)))
                .thenReturn(l);

        LocalizationServiceImpl local = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(local.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        Map<String,String> test_data = new HashMap<>();
        test_data.put("x-real-ip", GeoServiceImpl.MOSCOW_IP);

        MessageSenderImpl test = new MessageSenderImpl(geo,local);
        Assertions.assertEquals(message, test.send(test_data));
    }

    @Test
    public void checkMessage4(){
        final Location l = new Location("New York", Country.USA, " 10th Avenue", 32);
        final String message = "Welcome";

        GeoServiceImpl geo = Mockito.mock(GeoServiceImpl.class);
        Mockito.when((geo.byIp(GeoServiceImpl.NEW_YORK_IP)))
                .thenReturn(l);

        LocalizationServiceImpl local = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(local.locale(Country.USA))
                .thenReturn("Welcome");

        Map<String,String> test_data = new HashMap<>();
        test_data.put("x-real-ip", GeoServiceImpl.NEW_YORK_IP);

        MessageSenderImpl test = new MessageSenderImpl(geo,local);
        Assertions.assertEquals(message, test.send(test_data));
    }

    @Test
    public void checkMessage5(){
        final Location l = new Location(null, null, null, 0);

        GeoServiceImpl geo = Mockito.mock(GeoServiceImpl.class);
        Mockito.when((geo.byIp(GeoServiceImpl.LOCALHOST)))
                .thenReturn(l);

        LocalizationServiceImpl local = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(local.locale(Country.USA))
                .thenReturn("Welcome");

        Map<String,String> test_data = new HashMap<>();
        test_data.put("x-real-ip", GeoServiceImpl.LOCALHOST);

        MessageSenderImpl test = new MessageSenderImpl(geo,local);
        Assertions.assertEquals(null, test.send(test_data));
    }
}
