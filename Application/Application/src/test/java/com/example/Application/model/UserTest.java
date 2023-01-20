//package com.example.Application.model;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//import java.util.Collections;
//
//import com.example.Application.repository.UserRepository;
//import com.example.Application.
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.test.context.TestPropertySource;
//
//@RunWith(MockitoJUnitRunner.class)
//@Component
//@TestPropertySource(locations = "classpath:application-context.xml")
//public class UserTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    private UserService userService;
//
//    @Before
//    public void setUp() {
//        userService = new UserService(userRepository);
//    }
//
//    @Test
//    public void testCreate() {
//        User user = new User(null, "Name", "email@example.com", "password", Role.ROLE_USER, new Date());
//        when(userRepository.save(any(User.class))).thenReturn(user);
//        User created = userService.create(user);
//        assertEquals(user, created);
//    }
//
//    @Test
//    public void testGet() {
//        User user = new User(1, "Name", "email@example.com", "password", Role.ROLE_USER, new Date());
//        when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));
//        User retrieved = userService.get(1);
//        assertEquals(user, retrieved);
//    }
//
//    @Test
//    public void testGetByEmail() {
//        User user = new User(1, "Name", "email@example.com", "password", Role.ROLE_USER, new Date());
//        when(userRepository.getByEmail("email@example.com")).thenReturn(user);
//        User retrieved = userService.getByEmail("email@example.com");
//        assertEquals(user, retrieved);
//    }
//
//    @Test
//    public void testGetAll() {
//        User user = new User(1, "Name", "email@example.com", "password", Role.ROLE_USER, new Date());
//        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
//        assertEquals(Collections.singletonList(user), userService.getAll());
//    }
//
//    @Test
//    public void testUpdate() {
//        User user = new User(1, "Name", "email@example.com", "password", Role.ROLE_USER, new Date());
//        when(userRepository.save(any(User.class))).thenReturn(user);
//        User updated = userService.update(user);
//        assertEquals(user, updated);
//    }
//}
