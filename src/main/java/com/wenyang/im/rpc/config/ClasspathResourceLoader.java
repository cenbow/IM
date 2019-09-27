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

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

@Slf4j
public class ClasspathResourceLoader implements IResourceLoader {


    private final String defaultResource;
    private final ClassLoader classLoader;

    public ClasspathResourceLoader() {
        this(IMServerConfig.DEFAULT_CONFIG);
    }

    public ClasspathResourceLoader(String defaultResource) {
        this(defaultResource, Thread.currentThread().getContextClassLoader());
    }

    public ClasspathResourceLoader(String defaultResource, ClassLoader classLoader) {
        this.defaultResource = defaultResource;
        this.classLoader = classLoader;
    }

    @Override
    public Reader loadDefaultResource() {
        return loadResource(defaultResource);
    }

    @Override
    public Reader loadResource(String relativePath) {
        log.info("Loading resource. RelativePath = {}.", relativePath);
        InputStream is = this.classLoader.getResourceAsStream(relativePath);
        return is != null ? new InputStreamReader(is) : null;
    }

    @Override
    public String getName() {
        return "classpath resource";
    }

}