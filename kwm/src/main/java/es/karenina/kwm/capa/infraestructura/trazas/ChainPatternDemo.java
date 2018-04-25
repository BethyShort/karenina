package es.karenina.kwm.capa.infraestructura.trazas;

public class ChainPatternDemo {
    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new InfoLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new FatalLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

        loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");

        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
    }
}
