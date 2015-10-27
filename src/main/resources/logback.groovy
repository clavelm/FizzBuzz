statusListener(OnConsoleStatusListener)

final CONSOLE_APPENDER_NAME = "CONSOLE"

appender(CONSOLE_APPENDER_NAME, ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%date{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %message%n"
    }
}

root(DEBUG, [CONSOLE_APPENDER_NAME])