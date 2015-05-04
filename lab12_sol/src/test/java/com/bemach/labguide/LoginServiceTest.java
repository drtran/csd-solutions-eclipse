package com.bemach.labguide;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ktran on 4/30/2015.
 */
public class LoginServiceTest {
    private LoginService loginService;
    private static ServiceLocator mockServiceLocator;

    // 1. Should create an object successfully using Factory Method.
    // 2. Should allow login with good user id and password.
    // 3. Should throw exception if bad user id and/or password is presented.
    // 4. Should say account is locked after three attempt.

    @BeforeClass
    public static void setupBeforeClass() {
        mockServiceLocator = TestUtil.getMpckServiceLocator();
    }

    @Before
    public void setUp() {
        loginService = LoginServiceImpl.getInstance();
    }

    @Test
    public void shouldInstantiate() {
        assertNotNull("Cannot create instance!", loginService);
    }

    /**
     * In this test, we are testing the login method with a credential.
     * We are mocking these classes:
     * - ServiceLocator
     * - LoginUser
     * - UserInfo
     */
    @Test
    public void shouldAllowLoginGivenValidUserIdAndPassword() {
        UserCredential userCredential = arrangeStubsForLogin();
        LoginUser actualLoginUser = loginService.login(userCredential);

        assertEquals("Login failed!", userCredential, actualLoginUser.getUserInfo().getUserCredential());
    }

    private UserCredential arrangeStubsForLogin() {
        loginService = LoginServiceImpl.getInstance();
        LoginUser mockLoginUser = mock(LoginUser.class);
        UserInfo mockUserInfo = mock(UserInfo.class);
        UserCredential userCredential = UserCredential.getInstance("userId", "password");
        when(mockServiceLocator.getLoginUser(any(UserCredential.class))).thenReturn(mockLoginUser);
        when(mockLoginUser.getUserInfo()).thenReturn(mockUserInfo);
        when(mockUserInfo.getUserCredential()).thenReturn(userCredential);
        return userCredential;
    }
}
