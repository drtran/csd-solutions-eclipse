package com.bemach.labguide;

import org.apache.log4j.Logger;

import javax.faces.application.FacesMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ktran on 5/3/2015.
 */
public class LoginBean2 {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(LoginBean.class);
    public static boolean debug = true;

    private String username;
    private String password;

    public LoginBean2() {}

    public Logger getLogger() {
        return log;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        RestClient client = null;
        AuthenticationDTO authenticationDTO = null;
        int count = 0;
        while (true) {
            try {
                authenticationDTO = authenticate();
                if (isNotAuthenticated(authenticationDTO)) {
                    this.username = username.trim();
                    count++;
                    if (count < 10) {
                        continue;
                    }
                    else {
                        log.error("Passed Number of retries to authenticate user");
                        JsfContextHelper.getFacesContext().addMessage(null, new FacesMessage("Failed to authenticate user"));
                        return null;
                    }
                }
                break;
            }
            catch (Exception e) {
                log.error("login error", e);
                String errorMessage = "Failed to authenticate user!";
                JsfContextHelper.getFacesContext().addMessage(null, new FacesMessage(errorMessage));
                return null;
            }
        }
        if (authenticationDTO == null) {
            String errorMessage = "Your login/password does not work; try again.";
            JsfContextHelper.getFacesContext().addMessage(null, new FacesMessage(errorMessage));
            return null;
        }

        String authToken = authenticationDTO.getUserToken().get(0);
        log.info("AUTHENTICATION TOKEN: " + authToken);
        if (authToken != null) {
            HttpServletResponse httpRes = JsfContextHelper.getHttpResponse();
            if (httpRes != null) {
                httpRes.addCookie(new Cookie(LoginFilter.AUTHENTICATION_COOKIE_NAME, authToken));
            }
        }

        UserSession uSession = (UserSession) JsfContextHelper.getManagedBeanValue("userSession");
        uSession.setUserDTO(authenticationDTO);

        String mainPageURL = "/pages/calendar.jsf?faces-redirect=true";

        return mainPageURL;
    }

    private boolean isNotAuthenticated(AuthenticationDTO authenticationDTO) {
        return authenticationDTO == null && !StringUtility.isNullOrEmpty(username);
    }

    private AuthenticationDTO authenticate() {
        RestClient client;
        AuthenticationDTO authenticationDTO;
        client = new RestClient(Services.URL_FOR_SERVICE_AUTHENTICATION_VALIDATE);
        client.getRootWebResource(this.username, this.password, null, null);
        authenticationDTO = client.getAuthenticationDTO();
        return authenticationDTO;
    }
}
