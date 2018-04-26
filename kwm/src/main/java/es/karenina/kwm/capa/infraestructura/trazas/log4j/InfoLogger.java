package es.karenina.kwm.capa.infraestructura.trazas.log4j;

public class InfoLogger extends AbstractLogger {

    public InfoLogger(byte level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        log.info("File::Logger: " + message);
    }
}
