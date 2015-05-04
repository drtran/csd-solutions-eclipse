package com.bemach.labguide;

import static org.mockito.Mockito.mock;

/**
 * Created by ktran on 5/2/2015.
 */
public class TestUtil {
    private static ServiceLocator mockServiceLocator;
    static {
        mockServiceLocator = mock(ServiceLocator.class);
        ServiceLocatorFactory.initialize(mockServiceLocator);
    }
    public static ServiceLocator getMpckServiceLocator() {
        return mockServiceLocator;
    }
}
