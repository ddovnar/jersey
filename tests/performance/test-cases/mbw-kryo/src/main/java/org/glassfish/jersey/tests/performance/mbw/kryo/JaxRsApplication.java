/*
 * Copyright (c) 2015, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package org.glassfish.jersey.tests.performance.mbw.kryo;

import org.glassfish.jersey.kryo.KryoFeature;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.core.Application;

/**
 * Test case JAX-RS application.
 *
 * @author Libor Kramolis
 */
public class JaxRsApplication extends Application {

    static final Set<Class<?>> APP_CLASSES = new HashSet<Class<?>>() {{
        add(PersonResource.class);
    }};

    @Override
    public Set<Class<?>> getClasses() {
        return APP_CLASSES;
    }

    @Override
    public Set<Object> getSingletons() {
        return Collections.singleton(KryoFeature.registrationRequired(false));
    }
}