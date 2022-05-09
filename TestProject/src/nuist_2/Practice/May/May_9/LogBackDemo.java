package nuist_2.Practice.May.May_9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Eliot
 */
public class LogBackDemo {

    public static final Logger LOGGER = LoggerFactory.getLogger("LogBackDemo.class");

    public static void main(String[] args) {
        LOGGER.debug("第一个日志");
    }
}
