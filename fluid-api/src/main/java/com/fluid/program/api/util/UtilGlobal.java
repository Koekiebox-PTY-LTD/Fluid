/*
 * Koekiebox CONFIDENTIAL
 *
 * [2012] - [2017] Koekiebox (Pty) Ltd
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of Koekiebox and its suppliers, if any. The intellectual and
 * technical concepts contained herein are proprietary to Koekiebox
 * and its suppliers and may be covered by South African and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material is strictly
 * forbidden unless prior written permission is obtained from Koekiebox.
 */

package com.fluid.program.api.util;

/**
 * Global utility class for the {@code com.fluid.program.api.util} package.
 *
 * @author jasonbruwer on 2016/03/09.
 * @since 1.0
 */
public class UtilGlobal {

    public static final String EMPTY = "";

    /**
     * The field type id mappings.
     */
    public static class FieldTypeId
    {
        public static final int _1_TEXT = 1;
        public static final int _2_TRUE_FALSE = 2;
        public static final int _3_PARAGRAPH_TEXT = 3;
        public static final int _4_MULTI_CHOICE = 4;
        public static final int _5_DATE_TIME = 5;
        public static final int _6_DECIMAL = 6;
        public static final int _7_TABLE_FIELD = 7;

        //TODO public static final int _8_TEXT_ENCRYPTED = 8;
    }
}
