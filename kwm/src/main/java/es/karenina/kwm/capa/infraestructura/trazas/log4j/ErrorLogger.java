package es.karenina.kwm.capa.infraestructura.trazas.log4j;

public class ErrorLogger extends AbstractLogger {

    ErrorLogger(byte level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        log.error("Error Console::Logger: " + message);
    }
}
