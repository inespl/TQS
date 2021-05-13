package tqs.Air_Quality;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.TimeUnit;

import static org.apache.tomcat.jni.Time.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class CacheTest {
    Cache c = new Cache(1000);
    Cache c2 = new Cache(1000);

    String s1 = WebController.callGetAirQualityInLocation(38.7452, -9.1604);
    String s2 = WebController.callGetAirQualityInLocation(41.1333, -8.6167);
    String s3 = WebController.callGetAirQualityInLocation(41.1495, -8.6108);

    @BeforeEach
    void setUp() {
        c2.put("38.7452,-9.1604", s1);
        c2.put("41.1333,-8.6167", s2);
        c2.put("41.1495,-8.6108", s3);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testPut() {
        System.out.println("Size before put" + c.size());
        c.put("38.7452,-9.1604", s1);
        c.put("41.1333,-8.6167", s2);
        c.put("41.1495,-8.6108", s3);
        System.out.println("Size after put" + c.size());
        assertThat(c.size(), is(3));
    }

    @Test
    void testGet() {
        assertThat(c2.get("38.7452,-9.1604"), is(s1));
        assertThat(c2.get("41.1333,-8.6167"), is(s2));
        assertThat(c2.get("41.1495,-8.6108"), is(s3));
    }

    @Test
    void testGetAfterTTL() throws InterruptedException{
        c.put("38.7452,-9.1604", s1);

        TimeUnit.MILLISECONDS.sleep(500);
        c.put("41.1333,-8.6167", s2);

        TimeUnit.MILLISECONDS.sleep(505);
        assertThat(c.get("38.7452,-9.1604"), not(s1));
        assertThat(c.get("41.1333,-8.6167"), is(s2));

        TimeUnit.MILLISECONDS.sleep(500);
        assertThat(c.get("41.1333,-8.6167"), not(s2));
    }
}