package com.example.Application.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.Application.model.Role;
import com.example.Application.model.User;
import com.example.Application.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@Component
@TestPropertySource(locations = "classpath:application-context.xml")
class MainControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private MainController mainController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    void testAddNewUser() throws Exception {
        when(userRepository.save(any(User.class))).thenReturn(new User(1, "test", "test@example.com", " ", new Date()));

        mockMvc.perform(post("/demo/add")
                        .param("name", "test")
                        .param("email", "test@example.com")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(content().string("Saved"))
                .andDo(print());
    }

//    @Test
//    void testGetAllUsers() throws Exception {
//        when(userRepository.findAll()).thenReturn(List.of(new User(1, "test", "test@example.com", " ", new Date()));
//
//        mockMvc.perform(get("/demo/all"))
//                .andExpect(status().isOk())
//                .andExpect(content().json("[{'id': 1, 'name': 'test', 'email': 'test@example.com'}]"))
//                .andDo(print());
//    }

}
