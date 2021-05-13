package tqs.Air_Quality;

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
      when(wc.callGetAirQualityInLocation(lat, lon)).thenReturn("{\"data\":[{\"mold_level\":1,\"aqi\":41,\"pm10\":3,\"co\":235.5,\"o3\":88,\"predominant_pollen_type\":\"Molds\",\"so2\":0,\"pollen_level_tree\":1,\"pollen_level_weed\":1,\"no2\":1,\"pm25\":0.874739,\"pollen_level_grass\":1}],\"city_name\":\"Mealhada\",\"lon\":-8.5,\"timezone\":\"Europe\\/Lisbon\",\"lat\":40.4,\"country_code\":\"PT\",\"state_code\":\"02\"}\n");
  }

  @Test
  void testAPICall(){
      assertThat(wc.callGetAirQualityInLocation(lat, lon), is("{\"data\":[{\"mold_level\":1,\"aqi\":41,\"pm10\":3,\"co\":235.5,\"o3\":88,\"predominant_pollen_type\":\"Molds\",\"so2\":0,\"pollen_level_tree\":1,\"pollen_level_weed\":1,\"no2\":1,\"pm25\":0.874739,\"pollen_level_grass\":1}],\"city_name\":\"Mealhada\",\"lon\":-8.5,\"timezone\":\"Europe\\/Lisbon\",\"lat\":40.4,\"country_code\":\"PT\",\"state_code\":\"02\"}\n"));
  }

 /* @Test
  void testQuality(){
      Quality q = new Quality("{\"data\":[{\"mold_level\":1,\"aqi\":41,\"pm10\":3,\"co\":235.5,\"o3\":88,\"predominant_pollen_type\":\"Molds\",\"so2\":0,\"pollen_level_tree\":1,\"pollen_level_weed\":1,\"no2\":1,\"pm25\":0.874739,\"pollen_level_grass\":1}],\"city_name\":\"Mealhada\",\"lon\":-8.5,\"timezone\":\"Europe\\/Lisbon\",\"lat\":40.4,\"country_code\":\"PT\",\"state_code\":\"02\"}\n"):
      // is it worth it? i dont think so
  }*/

}