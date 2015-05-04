package com.bemach.labguide;

import com.bemach.labguide.dao.UserInfoDAO;
import com.bemach.labguide.dao.UserInfoDAOImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by ktran on 5/2/2015.
 *
 * Should write this test first to avoid complexity later.
 * We want to mock DAO to avoid going to the database and/or over the network.
 *
 * Feathers: Unit test should NOT:
 * - access database
 * - access network
 * - access file
 * - access any objects that requires above accesses.
 * - any special configuration for an environment.
 *
 */
public class UserInfoTest {

    private static ServiceLocator mockServiceLocator;
    private UserInfo userInfo;
    private UserCredential userCredential;

    @BeforeClass
    public static void setupBeforeClass() {
        mockServiceLocator = TestUtil.getMpckServiceLocator();
    }

    @Before
    public void setUp() {
        userCredential = UserCredential.getInstance("userId", "password");
    }

    @Test
    public void shouldGetGoodUserInfoObject() {
        UserInfo expectedUserInfo = arrangeStubForUserInfoObjects(getGoodUserInfoStub());

        UserInfo actualUserInfo = UserInfo.getInstance(userCredential);
        assertEquals("Failed to create UserInfo Object!", expectedUserInfo, actualUserInfo);
    }

    @Test
    public void shouldGetBadUserInfoObject() {
        UserInfo expectedUserInfo = arrangeStubForUserInfoObjects(getBadUserInfoStub());

        UserInfo actualUserInfo = UserInfo.getInstance(userCredential);
        assertTrue("Failed to create bad UserInfo Object!", actualUserInfo.isNil());
    }

    /**
     * In this test, we are spying on the SUT.
     * We are making sure that getInstance calls UserInfoDAO.read()
     * method only one time; thus times(1). times(1) is default and
     * need not metion as below.
     */
    @Test
    public void shouldSpyUserInfoDAOCall() {
        UserInfoDAO  userInfoDAO = UserInfoDAOImpl.getInstance();
        UserInfoDAO spyDao = spy(userInfoDAO);
        when(mockServiceLocator.getUserInfoDAO(any(UserCredential.class))).thenReturn(spyDao);
        UserInfo expectedUserInfo = getGoodUserInfoStub();
        when(spyDao.read(anyString())).thenReturn(expectedUserInfo);
        UserInfo actualUserInfo = UserInfo.getInstance(userCredential);
        verify(spyDao, times(1)).read(anyString());
    }

    /**
     * In this test, we are making a spy dao object by implementing
     * the UserInfoDAO interface. In this implementation, we are recording
     * parameters that we are interested in to make sure that SUT is calling
     * the the method with the expected values.
     *
     */
    @Test
    public void shouldSpyUserInfoDAOCallParameters() {
        UserInfo expectedUserInfo = getGoodUserInfoStub();
        UserInfoDAOSpy spyDao = new UserInfoDAOSpy();
        spyDao.setMockUserInfo(expectedUserInfo);
        when(mockServiceLocator.getUserInfoDAO(any(UserCredential.class))).thenReturn(spyDao);
        UserInfo actualUserInfo = UserInfo.getInstance(userCredential);
        assertEquals("Incorrect parameters!", spyDao.getMockUserInfo(), expectedUserInfo);
        assertEquals("Incorrect parameters!", spyDao.getUserId(), userCredential.getUserId());
    }

    private UserInfo arrangeStubForUserInfoObjects(UserInfo expectedUserInfo) {
        UserInfoDAO mockUserInfoDAO = mock(UserInfoDAO.class);
        when(mockServiceLocator.getUserInfoDAO(any(UserCredential.class))).thenReturn(mockUserInfoDAO);
        when(mockUserInfoDAO.read(anyString())).thenReturn(expectedUserInfo);
        return expectedUserInfo;
    }

    /**
     * Here we are making fake objects for testing.
     * We could have used configurable test double here, too.
     * But hard-coded is fine for simple tests.
     * @return
     */
    private UserInfo getGoodUserInfoStub() {
        UserInfo userInfo = new UserInfo(userCredential, "Colonel", "John Murphy", "My Profile",
                null, null, null, true, true, null, null, null, null, null, null, null, null);
        return userInfo;
    }

    private UserInfo getBadUserInfoStub() {
        UserInfo userInfo = new UserInfo(null, "Colonel", "John Murphy", "My Profile",
                null, null, null, true, true, null, null, null, null, null, null, null, null);
        return userInfo;
    }

}
