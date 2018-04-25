package es.karenina.kwm.capa.infraestructura.trazas;

public class FatalLogger extends AbstractLogger {
    
    public FatalLogger(byte level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        log.fatal("Standard Console::Logger: " + message);
    }
}
