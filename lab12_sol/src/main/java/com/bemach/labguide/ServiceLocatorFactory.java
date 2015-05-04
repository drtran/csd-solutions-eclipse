package com.bemach.labguide;


/**
 * Created by ktran on 5/2/2015.
 *
 * SerivceLocator Factory is singleton initialize once.
 * Use this to inject dependencies into the application.
 *
 */
public class ServiceLocatorFactory {
    private ServiceLocator serviceLocator = null;
    private static ServiceLocatorFactory serviceLocatorFactory = null;

    private  ServiceLocatorFactory (ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public static void initialize(ServiceLocator serviceLocator) {
        if (serviceLocatorFactory == null) {
            serviceLocatorFactory = new ServiceLocatorFactory(serviceLocator);
        }
    }

    public static ServiceLocatorFactory getInstance() {
        return serviceLocatorFactory;
    }

    public ServiceLocator getServiceLocator() {
        return this.serviceLocator;
    }
}
