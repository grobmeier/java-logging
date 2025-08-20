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
package de.grobmeier.manning.appenders;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoggingConfiguration {
    private LogLevel minLogLevel;
    private boolean turnOn = true;

    private Map<String, Appender> appenderMapping = new HashMap<>();

    private ConsoleAppender consoleAppender;
    private FileAppender fileAppender;

    public LoggingConfiguration(LogLevel minLogLevel) {
        this.minLogLevel = minLogLevel;
        consoleAppender = new ConsoleAppender();
        try {
            fileAppender = new FileAppender("log.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Appender receiveAppenderByLoggerName(String loggerName) {
        return appenderMapping.get(loggerName);
    }

    public void map(String loggerName, String appenderName) {
            appenderMapping.put(loggerName, receiveAppender(appenderName));
    }

    public Appender receiveAppender(String appenderName) {
        if ("file".equals(appenderName)) {
            return fileAppender;
        }

        return consoleAppender;
    }

    public boolean shouldLog(LogLevel logLevel) {
        if (minLogLevel == LogLevel.OFF) {
            return false;
        }

        return logLevel.getWeight() >= minLogLevel.getWeight();
    }

    public void setMinimumLogLevel(LogLevel minLogLevel) {
            this.minLogLevel = minLogLevel;
    }

    public void setTurnOn(boolean turnOn) {
        this.turnOn = turnOn;
    }

    public boolean isTurnOn() {
        return this.turnOn;
    }
}