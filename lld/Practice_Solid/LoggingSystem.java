

enum LogLevel {
    INFO,
    ERROR,
    DEBUG 
}

interface ILogFormatter {
    String format(String message,LogLevel level);
}


interface ILogger {
    void log(String formattedMessage);
}

class SimpleFormatter implements ILogFormatter {
    public String format(String message,LogLevel level) {
        return level+":"+message;
    }
}

class JSONFormatter implements ILogFormatter {
    public String format(String message,LogLevel level) {
        return "{"+"level:"+level+", message:"+"'"+message+"'"+"}";
    }
}


class ConsoleLogger implements ILogger {
    public void log(String formattedMessage) {
        System.out.println(formattedMessage);
    }
}

class FileLogger implements ILogger {
    public void log(String formattedMessage) {
        System.out.println(formattedMessage);
    }
}

class DBLogger implements ILogger {
    public void log(String formattedMessage) {
        System.out.println(formattedMessage);
    }
}

class LoggerService {
    private ILogger logger;
    private ILogFormatter formatter;
    public LoggerService(ILogger logger,ILogFormatter formatter) {
        this.logger = logger;
        this.formatter = formatter;
    }

    public void log(String message,LogLevel level) {
        String formattedMessage = formatter.format(message, level);
        logger.log(formattedMessage);
    }
}

public class LoggingSystem {
    public static void main(String[] args) {
        LoggerService loggerService = new LoggerService(new ConsoleLogger(),new JSONFormatter());
        loggerService.log("Email Send", LogLevel.INFO);
    }
}
