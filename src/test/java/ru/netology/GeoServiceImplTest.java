package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {
    @Test
    public void checkLocation(){
        GeoServiceImpl testLocation = new GeoServiceImpl();
        Location Moscow = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Location New_York = new Location("New York", Country.USA, " 10th Avenue", 32);

        Assertions.assertEquals("Moscow", testLocation.byIp("172.0.54.16").getCity());
        Assertions.assertEquals("New York", testLocation.byIp("96.45.222.777").getCity());
        Assertions.assertEquals(Moscow.getStreet(), testLocation.byIp(GeoServiceImpl.MOSCOW_IP).getStreet());
        Assertions.assertEquals(New_York.getStreet(), testLocation.byIp(GeoServiceImpl.NEW_YORK_IP).getStreet());
    }
}
