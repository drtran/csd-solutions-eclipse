package com.bemach.labguide;

import org.apache.log4j.Logger;

import javax.faces.application.FacesMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class LoginBean implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(LoginBean.class);
    public static boolean debug = true;

    private String username;
    private String password;

    public LoginBean() {}

    public Logger getLogger() {
        return log;
    }

    public void debug(String s) {
        if (debug) {
            getLogger().debug(s);
            // System.out.println(s);
        }
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
        debug("LoginBean.login()..............................................");

        debug("this.username=" + this.username);
        debug("this.password=" + this.password);

        RestClient client = null;
        AuthenticationDTO authenticationDTO = null;
        int count = 0;
        while (true) {
            try {
                client = new RestClient(Services.URL_FOR_SERVICE_AUTHENTICATION_VALIDATE);
                client.getRootWebResource(this.username, this.password, null, null);
                authenticationDTO = client.getAuthenticationDTO();
                if (authenticationDTO == null && !StringUtility.isNullOrEmpty(username)) {
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
                debug(errorMessage);
                JsfContextHelper.getFacesContext().addMessage(null, new FacesMessage(errorMessage));
                return null;
            }
        }
        if (authenticationDTO == null) {
            String errorMessage = "Your login/password does not work; try again.";
            debug(errorMessage);
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
        debug("Successfully retrived user's AuthenticationDTO. UserSession.userId=" + uSession.getUserId());

        String mainPageURL = "/pages/calendar.jsf?faces-redirect=true";
        debug("go to page: " + mainPageURL);

        return mainPageURL;
    }
}
