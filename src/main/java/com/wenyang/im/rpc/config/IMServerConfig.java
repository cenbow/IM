/*
 * Copyright (c) 2012-2017 The original author or authors
 * ------------------------------------------------------
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * The Apache License v2.0 is available at
 * http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package com.wenyang.im.rpc.config;

import com.wenyang.im.rpc.constants.BrokerConstants;

/**
 * Base interface for all configuration implementations (filesystem, memory or classpath)
 */
public abstract class IMServerConfig {

    public static final String DEFAULT_CONFIG = "classpath:wildfirechat.conf";

    public abstract void setProperty(String name, String value);

    public abstract String getProperty(String name);

    public abstract String getProperty(String name, String defaultValue);

    void assignDefaults() {
        setProperty(BrokerConstants.PORT_PROPERTY_NAME, Integer.toString(BrokerConstants.PORT));
        setProperty(BrokerConstants.HOST_PROPERTY_NAME, BrokerConstants.HOST);
        setProperty(BrokerConstants.AUTHORIZATOR_CLASS_NAME, "");
    }

    public abstract IResourceLoader getResourceLoader();

}