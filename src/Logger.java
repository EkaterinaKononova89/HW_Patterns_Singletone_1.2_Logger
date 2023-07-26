import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger logger;
    protected int num = 1;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    private Logger() {
    }

    public void log(String msg) {
        System.out.println("[" + LocalDate.now() + " " + LocalTime.now().format(dtf) + " " + num++ + "] " + msg);
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }
}
