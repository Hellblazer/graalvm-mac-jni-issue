/*
 * Copyright (c) 2022, salesforce.com, inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */
package com.hellblazer.issue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author hal.hildebrand
 *
 */
public class TestMe {

    @Test
    public void smokin() throws Exception {
        var nat = new Native();

        final var byteArray = new byte[] { 6, 6, 6 };
        final var charArray = new char[] { 'f', 'o', 'o' };
        assertEquals(byteArray.length, nat.testMe(byteArray, charArray));
        Thread.sleep(1000);
    }
}
