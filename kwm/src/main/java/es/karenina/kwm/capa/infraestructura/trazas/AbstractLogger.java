package es.karenina.kwm.capa.infraestructura.trazas;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * @author sorel
 *
 */
public abstract class AbstractLogger {

    protected static final Logger log =Logger.getLogger(AbstractLogger.class);
    protected byte level;
    
    public static final byte OFF   = 0;
    public static final byte TRACE = 1;
    public static final byte DEBUG = 2;
    public static final byte INFO  = 3;
    public static final byte WARN  = 4;
    public static final byte ERROR = 5;
    public static final byte FATAL = 6;
    

    public AbstractLogger() {
        init();
    }

    public void init() {
        PropertyConfigurator.configure("");
    }
    // siguiente elemento en la caden ade responsabilidad
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level)
            write(message);
        else if (nextLogger != null)
            nextLogger.logMessage(level, message);
    }

    abstract protected void write(String message);
}
