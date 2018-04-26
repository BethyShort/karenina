package es.karenina.kwm.capa.infraestructura.trazas.log4j;

public class TraceLogger extends AbstractLogger {

    public TraceLogger(byte level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        log.info("File::Logger: " + message);
    }
}
