package co.com.onnovacion.util;

public enum Log4jValues {
    LOG4J_PROPERTIES_FILE_PATH("\\src\\main\\resources\\log4j2.properties"),
    USER_DIR(System.getProperty("user.dir"));

    private final String value;

    Log4jValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
