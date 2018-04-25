package es.karenina.kwm.capa.infraestructura.trazas;

public class DebugLogger extends AbstractLogger{

    public DebugLogger(byte level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        log.debug("Error Console::Logger: " + message);
    }
}
