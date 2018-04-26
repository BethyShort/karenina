package es.karenina.kwm.capa.infraestructura.trazas.log4j;

public class DebugLogger extends AbstractLogger{

    DebugLogger(byte level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        log.debug("Error Console::Logger: " + message);
    }
}
