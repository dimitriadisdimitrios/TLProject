package org.tl2project;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.tl2project.service.UserService;
import static org.mockito.Mockito.*;

public class UserServiceTest {

	public String username = "admin";
	public String password = "admin"; 
	public String email ="email";
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	private UserService userService;
	
	
	@Test
	public void LoginTest() {
		when(userService.login(username,password)).thenReturn(true);
		assertEquals(true,userService.login(username ,password));
	}
	@Test
	public void LoginTest2() {
		when(userService.login(username,password)).thenReturn(false);
		assertEquals(false,userService.login(username ,password));
	}
	
	@Test
	public void LoginVerification() {
		userService.login(null, password);
		verify(userService).login(anyString(),eq(password));	
	}
	@Test
	public void LoginVerification2() {
		userService.login(username, null);
		verify(userService).login(eq(username),anyString());		
	}
	@Test
	public void RegisterTest(){
		when(userService.register(username, email, password)).thenReturn(true);
		assertEquals(true,userService.register(username,email,password));
	}
	@Test
	public void RegisterTest2(){
		when(userService.register(username, email, password)).thenReturn(false);
		assertEquals(false,userService.register(username,email,password));
	}	
	@Test
	public void RegisterVerification() {
		userService.register(username, null,password);
		verify(userService).register(eq(username),anyString(),eq(password));		
	}
	@Test
	public void RegisterVerification2() {
		userService.register(null, email,password);
		verify(userService).register(anyString(),eq(email),eq(password));		
	}
	@Test
	public void RegisterVerification3() {
		userService.register(username,email,null);
		verify(userService).register(eq(username),eq(email),anyString());		
	}
}
