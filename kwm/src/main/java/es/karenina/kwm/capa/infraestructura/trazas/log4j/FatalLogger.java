package es.karenina.kwm.capa.infraestructura.trazas.log4j;

public class FatalLogger extends AbstractLogger {
    
    FatalLogger(byte level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        log.fatal("Standard Console::Logger: " + message);
    }
}
