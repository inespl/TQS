package tqs.Air_Quality;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.TimeUnit;

import static org.apache.tomcat.jni.Time.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class CacheTest {

    @BeforeEach
    void setUp() {
        /*Cache c = new Cache(1000);
        Cache c2 = new Cache(2000);

        c2.put("38.7452,-9.1604", WebController.callGetAirQualityInLocation(38.7452, -9.1604));
        c2.put("41.1333,-8.6167", WebController.callGetAirQualityInLocation(41.1333, -8.6167));
        c2.put("41.1495,-8.6108", WebController.callGetAirQualityInLocation(41.1495, -8.6108));*/
    }

    @Test
    void testPut() {
        Cache c = new Cache(1000);

        System.out.println("Size before put" + c.size());
        c.put("38.7452,-9.1604", WebController.callGetAirQualityInLocation(38.7452, -9.1604));
        c.put("41.1333,-8.6167", WebController.callGetAirQualityInLocation(41.1333, -8.6167));
        c.put("41.1495,-8.6108", WebController.callGetAirQualityInLocation(41.1495, -8.6108));
        System.out.println("Size after put" + c.size());
        assertThat(c.size(), is(3));
    }

    @Test
    void testGet() {
        Cache c2 = new Cache(1000);
        String s1 = WebController.callGetAirQualityInLocation(38.7452, -9.1604);
        String s2 = WebController.callGetAirQualityInLocation(41.1333, -8.6167);
        String s3 = WebController.callGetAirQualityInLocation(41.1495, -8.6108);

        c2.put("38.7452,-9.1604", s1);
        c2.put("41.1333,-8.6167", s2);
        c2.put("41.1495,-8.6108", s3);

        assertThat(c2.get("38.7452,-9.1604"), is(s1));
        assertThat(c2.get("41.1333,-8.6167"), is(s2));
        assertThat(c2.get("41.1495,-8.6108"), is(s3));
    }

    @Test
    void testGetAfterTTL() throws InterruptedException{
        Cache c2 = new Cache(1000);
        String s1 = WebController.callGetAirQualityInLocation(38.7452, -9.1604);
        String s2 = WebController.callGetAirQualityInLocation(41.1333, -8.6167);

        c2.put("38.7452,-9.1604", s1);

        TimeUnit.MILLISECONDS.sleep(500);
        c2.put("41.1333,-8.6167", s2);

        TimeUnit.MILLISECONDS.sleep(500);
        assertThat(c2.get("38.7452,-9.1604"), not(s1));
        assertThat(c2.get("41.1333,-8.6167"), is(s2));

        TimeUnit.MILLISECONDS.sleep(500);
        assertThat(c2.get("41.1333,-8.6167"), not(s2));
    }

    @Test
    void testGetHits() {
    }

    @Test
    void testGetMisses() {
    }
}