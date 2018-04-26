package es.karenina.kwm.capa.infraestructura.trazas.log4j;

public class WarnLogger extends AbstractLogger{

    public WarnLogger(byte level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        log.warn("File::Logger: " + message);
    }
}
