package org.example.hw5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

public class Program {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Необходимо разделить на горизонтальные уровни "Редактор 3D графики".
     * Один пользователь. Программа работает на одном компьютере без выхода в сеть.
     * <p>
     * Что видит пользователь, как взаимодействует? (Панель загрузки, блок редактирования, блок просмотра).
     * Какие задачи можно делать – функции системы? (Загрузить 3D модель, рассмотреть 3D модель, создать новую,
     * редактировать вершины, текстуры, сделать рендер, сохранить рендер).
     * Какие и где хранятся данные? (файлы 3D моделей, рендеры, анимация .., в файловой системе компьютера).
     * <p>
     * Предложить варианты связывания всех уровней – сценарии использования. 3-4 сценария.
     * Сквозная функция – создать новую 3D модель, сделать рендер для печати на принтере…
     */
    public static void main(String[] args) {
        Editor3D editor3D = new Editor3D();

        boolean f = true;
        while (f) {
            System.out.println("*** МОЙ 3D РЕДАКТОР ***");
            System.out.println("=======================");
            System.out.println("1. Отобразить все проекты");
            System.out.println("2. Создать новый проект");
            System.out.println("3. Сохранить проект");
            System.out.println("4. Отобразить параметры проекта");
            System.out.println("5. Отобразить все модели проекта");
            System.out.println("6. Отобразить все текстуры проекта");
            System.out.println("7. Поменять цвет текстуре");
            System.out.println("8. Выполнить рендер всех моделей");
            System.out.println("9. Выполнить рендер модели");
            System.out.println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ");
            System.out.print("Пожалуйста, выберите пункт меню: ");
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 0:
                            System.out.println("Завершение работы приложения");
                            f = false;
                            break;
                        case 1:
                            editor3D.showProjects();
                            break;
                        case 2:
                            System.out.print("Укажите наименование нового проекта: ");
                            String groupName = scanner.nextLine();
                            editor3D.openProject(groupName);
                            System.out.println("Проект успешно открыт.");
                            break;
                        case 3:
                            editor3D.saveProject();
                            System.out.println("Проект успешно сохранен.");
                            break;
                        case 4:
                            editor3D.showProjectSettings();
                            break;
                        case 5:
                            editor3D.printAllModels();
                            break;
                        case 6:
                            editor3D.printAllTextures();
                            break;
                        case 7:
                            editor3D.printAllTextures();
                            System.out.print("Укажите Id текстуры для изменения цвета: ");
                            int textureId = scanner.nextInt();
                            editor3D.showColor();
                            System.out.print("Укажите Id цвета для установки цвета: ");
                            int colorId = scanner.nextInt();
                            editor3D.changeTextureColor(textureId, colorId);
                            break;
                        case 8:
                            editor3D.renderAll();
                            break;
                        case 9:
                            System.out.print("Укажите номер модели: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3D.renderModel(modelNo);
                            } else {
                                System.out.println("Номер модели указан некорректно.");
                            }
                            break;
                        default:
                            System.out.println("Укажите корректный пункт меню.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Укажите корректный пункт меню.");
                scanner.nextLine();
            }
        }
    }
}

/**
 * UI (User Interface)
 */
class Editor3D implements UILayer {

    private ProjectFile projectFile;
    private BusinessLogicalLayer businessLogicalLayer;

    private DatabaseAccess databaseAccess;

    private Database database;


    private void initialize() {
        database = new EditorDatabase(projectFile);
        databaseAccess = new EditorDatabaseAccess(database);
        businessLogicalLayer = new EditorBusinessLogicalLayer(databaseAccess);
    }

    @Override
    public void showProjects() {
        // Предусловие
        checkProjectFile();
        System.out.println("Список проектов:");
        for (ProjectFile project : database.getProjects()) {
            System.out.printf("*** Project: %s ***\n", project.getFileName());
        }
    }

    @Override
    public void openProject(String fileName) {
        this.projectFile = new ProjectFile(fileName);
        if (database == null || databaseAccess == null || businessLogicalLayer == null) {
            initialize();
        }
    }

    @Override
    public void showProjectSettings() {

        // Предусловие
        checkProjectFile();

        System.out.printf("*** Project %s ***", projectFile.getFileName());
        System.out.println("******************");
        System.out.printf("fileName: %s\n", projectFile.getFileName());
        System.out.printf("setting1: %d\n", projectFile.getSetting1());
        System.out.printf("setting2: %s\n", projectFile.getSetting2());
        System.out.printf("setting3: %s\n", projectFile.getSetting3());
        System.out.println("******************");

    }

    private void checkProjectFile() {
        if (projectFile == null)
            throw new RuntimeException("Группа проектов не определена.");
    }

    @Override
    public void saveProject() {

        // Предусловие
        checkProjectFile();

        database.save(projectFile);
        System.out.println("Изменения успешно сохранены.");
    }

    @Override
    public void printAllModels() {

        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        for (int i = 0; i < models.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(models.get(i));
            for (Texture texture : models.get(i).getTextures()) {
                System.out.printf("\t%s\n", texture);
            }
        }

    }

    @Override
    public void printAllTextures() {

        // Предусловие
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>) businessLogicalLayer.getAllTextures();
        for (int i = 0; i < textures.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(textures.get(i));
        }
    }

    @Override
    public void renderAll() {
        // Предусловие
        checkProjectFile();

        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс.\n", endTime);
    }

    @Override
    public void renderModel(int i) {

        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size() - 1)
            throw new RuntimeException("Номер модели указан некорректною.");
        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderModel(models.get(i));
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс.\n", endTime);
    }

    @Override
    public void changeTextureColor(int textureId, int colorId) {

        // Предусловие
        checkProjectFile();

        for (Texture texture : businessLogicalLayer.getAllTextures()) {
            if (texture.getId() == textureId) {
                texture.setColor(colorId);
            }
        }

        System.out.println("Цвет успешно изменен.");
    }
    @Override
    public  void showColor() {
        ArrayList<Texture> textures = new ArrayList<>(businessLogicalLayer.getAllTextures());
        String[] colors = textures.get(0).getColorList();
        for (int i = 0; i < colors.length; i++) {
            System.out.println(String.format("*** %d. ", (i + 1)) + colors[i] + " ***");
        }
    }


}

/**
 * Интерфейс UI
 */
interface UILayer {
    void showProjects();

    void openProject(String fileName);


    void showProjectSettings();

    void saveProject();

    void printAllModels();

    void printAllTextures();

    void renderAll();

    void renderModel(int i);

    void changeTextureColor(int textureId, int colorId);

    void showColor();


}

/**
 * Реализация Business Logical Layer
 */
class EditorBusinessLogicalLayer implements BusinessLogicalLayer {

    private DatabaseAccess databaseAccess;


    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model : getAllModels())
            processRender(model);
    }

    private Random random = new Random();

    private void processRender(Model3D model) {
        try {
            Thread.sleep(2500 - random.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

/**
 * Интерфейс BLL (Business Logical Layer)
 */
interface BusinessLogicalLayer {
    Collection<Model3D> getAllModels();

    Collection<Texture> getAllTextures();

    void renderModel(Model3D model);

    void renderAllModels();
}

/**
 * Реализация DAC
 */
class EditorDatabaseAccess implements DatabaseAccess {

    private final Database editorDatabase;

    public EditorDatabaseAccess(Database editorDatabase) {
        this.editorDatabase = editorDatabase;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        Collection<Model3D> models = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Model3D) {
                models.add((Model3D) entity);
            }
        }
        return models;
    }

    @Override
    public Collection<Texture> getAllTextures() {
        Collection<Texture> models = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Texture) {
                models.add((Texture) entity);
            }
        }
        return models;
    }

    @Override
    public void addEntity(Entity entity) {
        editorDatabase.getAll().add(entity);
    }

    @Override
    public void removeEntity(Entity entity) {
        editorDatabase.getAll().remove(entity);
    }


}

/**
 * Интерфейс DAC
 */
interface DatabaseAccess {
    void addEntity(Entity entity);

    void removeEntity(Entity entity);

    Collection<Texture> getAllTextures();

    Collection<Model3D> getAllModels();
}

/**
 * Database
 */
class EditorDatabase implements Database {

    private Random random = new Random();
    private final ProjectFile projectFile;
    private Collection<Entity> entities;

    private ArrayList<ProjectFile> projects = new ArrayList<>();

    public EditorDatabase(ProjectFile projectFile) {
        this.projectFile = projectFile;
        load();
    }

    @Override
    public void load() {
        //TODO: Загрузка всех сущностей проекта (модели, текстуры и т. д)
    }

    @Override
    public void save(ProjectFile projectFile) {
        //TODO: Сохранение текущего состояния всех сущностей проекта
        projects.add(projectFile);

    }

    @Override
    public ArrayList<ProjectFile> getProjects() {
        return projects;
    }

    public Collection<Entity> getAll() {
        if (entities == null) {
            entities = new ArrayList<>();
            int entCount = random.nextInt(5, 11);
            for (int i = 0; i < entCount; i++) {
                generateModelAndTextures();
            }
        }
        return entities;
    }

    private void generateModelAndTextures() {
        Model3D model3D = new Model3D();
        int txCount = random.nextInt(3);
        for (int i = 0; i < txCount; i++) {
            Texture texture = new Texture();
            model3D.getTextures().add(texture);
            entities.add(texture);
        }
        entities.add(model3D);
    }

}

/**
 * Интерфейс БД
 */
interface Database {
    void load();

    void save(ProjectFile projectFile);

    ArrayList<ProjectFile> getProjects();

    Collection<Entity> getAll();
}

/**
 * 3D модель
 */
class Model3D implements Entity {

    private static int counter = 10000;
    private int id;

    private Collection<Texture> textures = new ArrayList<>();

    @Override
    public int getId() {
        return id;
    }

    {
        id = ++counter;
    }

    public Model3D() {

    }

    public Model3D(Collection<Texture> textures) {
        this.textures = textures;
    }

    public Collection<Texture> getTextures() {
        return textures;
    }

    @Override
    public String toString() {
        return String.format("3DModel #%s", id);
    }

}

/**
 * Текстура
 */
class Texture implements Entity {

    private String[] colorList = {"Черный", "Красный", "Зеленый", "Желтый", "Синий", "Фиолетовый", "Голубой", "Белый"};

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static int counter = 50000;

    private int color;

    private int id;

    {
        id = ++counter;
    }

    private String chooseColor() {
        switch (color) {
            case 1 -> {
                return ANSI_BLACK;
            }
            case 2 -> {
                return ANSI_RED;
            }
            case 3 -> {
                return ANSI_GREEN;
            }
            case 4 -> {
                return ANSI_YELLOW;
            }
            case 5 -> {
                return ANSI_BLUE;
            }
            case 6 -> {
                return ANSI_PURPLE;
            }
            case 7 -> {
                return ANSI_CYAN;
            }
            case 8 -> {
                return ANSI_WHITE;
            }
        }
        return "";
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String[] getColorList() {
        return colorList;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format(chooseColor() + "Texture #%s" + ANSI_RESET, id);
    }
}

/**
 * Сущность
 */
interface Entity {
    int getId();
}

/**
 * Файл проекта
 */
class ProjectFile {

    private String fileName;
    private int setting1;
    private String setting2;
    private boolean setting3;

    public ProjectFile(String fileName) {

        this.fileName = fileName;
        //TODO: Загрузка настроек проекта из файла

        setting1 = 1;
        setting2 = "...";
        setting3 = false;
    }

    public String getFileName() {
        return fileName;
    }

    public int getSetting1() {
        return setting1;
    }

    public String getSetting2() {
        return setting2;
    }

    public boolean getSetting3() {
        return setting3;
    }
}

