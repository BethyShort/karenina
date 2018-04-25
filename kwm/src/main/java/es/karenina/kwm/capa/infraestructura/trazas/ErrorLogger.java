package es.karenina.kwm.capa.infraestructura.trazas;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(byte level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        log.error("Error Console::Logger: " + message);
    }
}
