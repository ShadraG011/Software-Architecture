package org.example.hw2;

/**
 * Класс реализующий паттерн Singleton
 */
public class ProgramLogger {

    private static ProgramLogger programLogger;

    private static String logFile = "Logs: \n\n";

    public static ProgramLogger getProgramLogger(){
        if(programLogger == null) {
            programLogger = new ProgramLogger();
        }
        return programLogger;
    }

    private ProgramLogger() {}

    public void addLogInfo(String logInfo){
        logFile += logInfo + "\n";
    }

    public void showLogFile(){
        System.out.println(logFile);
    }

}
