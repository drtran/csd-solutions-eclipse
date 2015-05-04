package com.bemach.labguide;

/**
 * Created by ktran on 5/1/2015.
 */
public class LoginServiceImpl implements LoginService {
    private ServiceLocator svcLoc = ServiceLocatorFactory.getInstance().getServiceLocator();

    private LoginServiceImpl() {

    }

    public static LoginService getInstance() {
        return new LoginServiceImpl();
    }

    /**
     * This method does the following to login a user:
     * - verify user credential
     * - if invalid, return a LoginUser as a NullObject.
     * @param userCredential
     * @return
     */
    public LoginUser login(UserCredential userCredential) {
        LoginUser loginUser = svcLoc.getLoginUser(userCredential);
        return loginUser;
    }

    public void logout(LoginUser loginUser) {

    }
}
