package es.karenina.kwm.capa.infraestructura.trazas.log4j;

import es.karenina.kwm.capa.infraestructura.trazas.interfaces.ILoggerAplicacion;
import es.karenina.kwm.capa.infraestructura.trazas.interfaces.FactoriaLogger;

public class Log4JLogger implements FactoriaLogger{
    
    ILoggerAplicacion logger;
    
    public Log4JLogger() {
        init();
    }
    
    private void init() {
        AbstractLogger fatalLogger = new FatalLogger(AbstractLogger.FATAL);
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger warnLogger = new WarnLogger(AbstractLogger.WARN);
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
        AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger traceLogger = new TraceLogger(AbstractLogger.TRACE);

        fatalLogger.setNextLogger(errorLogger);
        errorLogger.setNextLogger(warnLogger);
        warnLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(traceLogger);

        logger=fatalLogger;
    }

    @Override
    public ILoggerAplicacion getLogger() {
        return logger;
    }
}

