
/**
 * Created by Ирина on 07.03.2017.
 */
public class SingletonDoubleAccessLock {
    private static final Logger logger = Logger.getLogger(FilePropertiesDAO.class);
    private static volatile Properties mailSettings;
    private static final String PROPERTIES_PATH = "settings/mailsettings.properties";

    public static Properties getSettings() throws DataAccessException {
        if (null == mailSettings) {
            synchronized (TemplateConverter.class) {
                if (null == mailSettings) {
                    mailSettings = new Properties();
                    try {
                        final InputStream resourceAsStream = TemplateConverter.class.getClassLoader().getResourceAsStream
                                (PROPERTIES_PATH);
                        mailSettings.load(resourceAsStream);
                    } catch (IOException e) {
                        logger.error(e);
                        throw new DataAccessException("Не удалось получить настройки почты из файла " + PROPERTIES_PATH);
                    }
                }
            }
        }
        return mailSettings;
    }
}
