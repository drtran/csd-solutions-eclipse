package com.bemach.labguide;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ktran on 5/3/2015.
 */
public class JsfContextHelper {
    private static FacesContext facesContext;
    private static HttpServletResponse httpResponse;

    public static FacesContext getFacesContext() {
        return facesContext;
    }

    public static HttpServletResponse getHttpResponse() {
        return httpResponse;
    }

    public static Object getManagedBeanValue(String userSession) {
        return null;
    }
}
