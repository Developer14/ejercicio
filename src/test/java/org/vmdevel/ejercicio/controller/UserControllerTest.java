package org.vmdevel.ejercicio.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.vmdevel.ejercicio.domain.User;
import org.vmdevel.ejercicio.dto.UserDto;
import org.vmdevel.ejercicio.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserControllerTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private UserService userService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void test() throws Exception {

        UserDto expected = new UserDto();
        expected.setName("dummy");
        expected.setPassword("Dummy20");
        expected.setEmail("dummy@mail.com");

        User user = new User();
        user.setName(expected.getName());
        user.setPassword(expected.getPassword());
        user.setEmail(expected.getEmail());

        Mockito.when(userService.createUser(new User())).thenReturn(user);
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
            .content(objectMapper.writeValueAsString(expected))
            .contentType(MediaType.APPLICATION_JSON))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("dummy")))
        .andReturn().getResponse().getContentAsString();

    }
}
