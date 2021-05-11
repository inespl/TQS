package tqs.Air_Quality;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CacheTest {

    @BeforeEach
    void setUp() {
        Cache c = new Cache(1000);
    }

    @Test
    void testPut() {
        Cache c = new Cache(1000);
        c.put("11");
    }

    @Test
    void testGet() {
    }

    @Test
    void testGetHits() {
    }

    @Test
    void testGetMisses() {
    }
}