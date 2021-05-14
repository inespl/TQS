package tqs.AirQuality;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WebControllerTest {

  double lat = 40.4;
  double lon = -8.5;
  @Mock
     WebController wc;

  @BeforeEach
  void setUp(){
      wc = mock(WebController.class);
      when(wc.callGetAirQualityByLatLon(lat, lon)).thenReturn("{\"data\":[{\"mold_level\":1,\"aqi\":41,\"pm10\":3," +
              "\"co\":235.5,\"o3\":88,\"predominant_pollen_type\":\"Molds\",\"so2\":0,\"pollen_level_tree\":1," +
              "\"pollen_level_weed\":1,\"no2\":1,\"pm25\":0.874739,\"pollen_level_grass\":1}],\"city_name\":\"Mealhada\"," +
              "\"lon\":-8.5,\"timezone\":\"Europe\\/Lisbon\",\"lat\":40.4,\"country_code\":\"PT\",\"state_code\":\"02\"}\n");
  }

  @Test
  void testAPICall(){
      assertThat(wc.callGetAirQualityByLatLon(lat, lon), is("{\"data\":[{\"mold_level\":1,\"aqi\":41,\"pm10\":3," +
              "\"co\":235.5,\"o3\":88,\"predominant_pollen_type\":\"Molds\",\"so2\":0,\"pollen_level_tree\":1," +
              "\"pollen_level_weed\":1,\"no2\":1,\"pm25\":0.874739,\"pollen_level_grass\":1}],\"city_name\":\"Mealhada\"," +
              "\"lon\":-8.5,\"timezone\":\"Europe\\/Lisbon\",\"lat\":40.4,\"country_code\":\"PT\",\"state_code\":\"02\"}\n"));
  }

  @Test
    void testQuality(){
      Quality q = new Quality(wc.callGetAirQualityByLatLon(lat, lon));
      assertThat(q.moldLevel, is(1));
      assertThat(q.aqi, is(41));
      assertThat(q.pm10, is(3.0));
      assertThat(q.co, is(235.5));
      assertThat(q.predominantPollenType, is("Molds"));
      assertThat(q.pollenLevelTree, is(1));
      assertThat(q.pollenLevelWeed, is(1));
      assertThat(q.no2, is(1.0));
      assertThat(q.pm25, is(0.874739));
      assertThat(q.pollenLevelGrass, is(1));
      assertThat(q.cityName, is("Mealhada"));
      assertThat(q.lon, is(-8.5));
      assertThat(q.timezone, is("Europe/Lisbon"));
      assertThat(q.lat, is(40.4));
      assertThat(q.countryCode, is("PT"));
      assertThat(q.stateCode, is("02"));
  }
}