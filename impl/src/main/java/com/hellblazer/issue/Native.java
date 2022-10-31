/*
 * Copyright (c) 2022, salesforce.com, inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */
package com.hellblazer.issue;

import java.io.IOException;

import org.scijava.nativelib.NativeLoader;

/**
 * @author hal.hildebrand
 *
 */
public class Native {
    private static final String SHARED_LIB_NAME = "native";
    static {
        try {
            NativeLoader.loadLibrary(SHARED_LIB_NAME);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot load shared library: " + SHARED_LIB_NAME, e);
        }
    }

    private static native long createIsolate();

    private static native int testMe(long isolateId, byte[] byteArray, char[] charArray);

    private final long isolate;

    public Native() {
        isolate = createIsolate();
    }

    public int testMe(byte[] byteArray, char[] charArray) {
        return testMe(isolate, byteArray, charArray);
    }
}
