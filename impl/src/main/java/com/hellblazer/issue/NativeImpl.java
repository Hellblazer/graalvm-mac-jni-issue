/*
 * Copyright (c) 2022, salesforce.com, inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */
package com.hellblazer.issue;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.graalvm.nativeimage.IsolateThread;
import org.graalvm.nativeimage.c.function.CEntryPoint;
import org.graalvm.word.Pointer;

/**
 * @author hal.hildebrand
 *
 */
public class NativeImpl {

    @CEntryPoint(name = "Java_com_hellblazer_issue_Native_createIsolate", builtin = CEntryPoint.Builtin.CREATE_ISOLATE)
    public static native IsolateThread createIsolate();

    @CEntryPoint(name = "Java_com_hellblazer_issue_Native_testMe")
    private static int launch(Pointer jniEnv, Pointer clazz, @CEntryPoint.IsolateThreadContext long isolateId,
                              byte[] byteArray, char[] charArray) throws GeneralSecurityException, IOException {
        System.out.println("isolate: %s, byte[].length: %s, char[].length: %s".formatted(isolateId, byteArray.length,
                                                                                         charArray.length));
        return byteArray.length;
    }
}
