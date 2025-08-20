/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.grobmeier.manning.logging;

public class SystemLoggingWithDefaults {
    public static void main(String[] args) {
        System.Logger logger = System.getLogger(SystemLoggingWithDefaults.class.getName());

        // These levels work:
        logger.log(System.Logger.Level.INFO, "Info");
        logger.log(System.Logger.Level.WARNING, "Warning");
        logger.log(System.Logger.Level.ERROR, "Error");

        // Weird, isn't it? This yields an output:
        logger.log(System.Logger.Level.OFF, "Off");

        // These levels don't work, because the JUL default configuration is used (and that's using INFO)
        logger.log(System.Logger.Level.DEBUG, "Debug");
        logger.log(System.Logger.Level.TRACE, "Trace");
        logger.log(System.Logger.Level.ALL, "All");
    }
}
