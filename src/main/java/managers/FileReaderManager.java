package managers;

import dataProviders.ConfigFileReader;
import dataProviders.ExtentReportConfigReader;
import dataProviders.JsonDataReader;

// FileReader Manager is implemented as a Singleton
// The Singleton’s purpose is to control object creation, limiting the number of objects to only one

public class FileReaderManager {

    // The FileReaderManager class maintains a static reference to its own instance and returns that reference from the static getInstance() method

    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;
    private static JsonDataReader jsonDataReader;
    private static ExtentReportConfigReader extentReportConfigReader;

    // FileReaderManager implements a private constructor so clients cannot instantiate FileReaderManager instances
    private FileReaderManager() {
    }

    public static FileReaderManager getInstance( ) {
        return fileReaderManager;
    }

    // getConfigReader() method returns the instance of the ConfigFileReader but this method is not static.
    // So that client has to use the getInstance() method to access other public methods of the FileReaderManager
    // like FileReaderManager.getInstance().getConfigReader()

    public ConfigFileReader getConfigReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }

    public ExtentReportConfigReader getExtentReportConfigReader() {
        return (extentReportConfigReader == null) ? new ExtentReportConfigReader() : extentReportConfigReader;
    }

    public JsonDataReader getJsonReader(){
        return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
    }
}
