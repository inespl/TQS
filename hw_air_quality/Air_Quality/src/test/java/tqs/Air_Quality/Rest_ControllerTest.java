package tqs.Air_Quality;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;

import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class Rest_ControllerTest {

    MockMvc mockMvc;

    @Mock
    Rest_Controller rest_controller;

    @BeforeEach
    void setUp() throws IOException {
        rest_controller = new Rest_Controller();

        mockMvc = MockMvcBuilders.standaloneSetup(rest_controller).build();
    }

    @Test
    void testGetCityInfo() throws Exception {
        mockMvc.perform(get("http://localhos:8080/api")
                .param("lat","40.4")
                .param("lon", "-8.5"))
                .andExpect(content().string(containsString("\"city_name\":\"Mealhada\",\"lon\":-8.5,\"timezone\":\"Europe\\/Lisbon\",\"lat\":40.4,\"country_code\":\"PT\",\"state_code\":\"02\"")))
                .andExpect(status().isOk());
    }

    @Test
    void testGetStatisticsInfo() throws Exception {
        mockMvc.perform(get("http://localhos:8080/api/statistics"))
                .andExpect(content().string(containsString("\"hits\"")))
                .andExpect(content().string(containsString("\"misses\"")))
                .andExpect(content().string(containsString("\"requests\"")))
                .andExpect(content().string(containsString("\"ttl\"")))
                .andExpect(status().isOk());
    }

    @Test
    void testGetCache() throws Exception {
        mockMvc.perform(get("http://localhos:8080/api/cache"))
                .andExpect(content().string(containsString("\"data\"")))
                .andExpect(status().isOk());

    }
}