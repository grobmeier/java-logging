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
package de.grobmeier.manning.logging.systemlogger;

public class AirportApp {
    System.Logger logger = System.getLogger(AirportApp.class.getName());

    public void execute(String lang) {
        logger.log(System.Logger.Level.INFO, "Started Airport App");

        if (lang == null) {
            lang = "en";
            logger.log(
                System.Logger.Level.WARNING,
            "Language was null, setting to default: " + lang);
        }

        AirportService instance = AirportService.getInstance();
        if (instance == null) {
            logger.log(System.Logger.Level.ERROR, "Did not receive Airport service instance, returning");
            return;
        }

        instance.performLogic();

        if (logger.isLoggable(System.Logger.Level.INFO)) {
            logger.log(System.Logger.Level.INFO, "Ended Airport app");
            logger.log(System.Logger.Level.INFO, "For real.");
        }

    }
    
    public static void main(String[] args) {
        // null added on purpose
        new AirportApp().execute(null);
    }
}
