package org.example.hw2;

public class Client {
    public static void main(String[] args) {
        /**
         * Проверка работы паттерна singleton (все экземпляры класса одинаковые)
         */
        System.out.println(ProgramLogger.getProgramLogger().toString());
        System.out.println(ProgramLogger.getProgramLogger().toString());
        System.out.println(ProgramLogger.getProgramLogger().toString());
        System.out.println(ProgramLogger.getProgramLogger().toString());
        System.out.println(ProgramLogger.getProgramLogger().toString());
        System.out.println(ProgramLogger.getProgramLogger().toString());


        /**
         * Запись логов в файл логов
         */
        ProgramLogger.getProgramLogger().addLogInfo("Log one:.....");
        ProgramLogger.getProgramLogger().addLogInfo("Log two:.....");
        ProgramLogger.getProgramLogger().addLogInfo("Log three:.....");
        ProgramLogger.getProgramLogger().addLogInfo("Log four:.....");

        /**
         * Просмотр файла логов
         */
        System.out.println();
        ProgramLogger.getProgramLogger().showLogFile();
    }
}
