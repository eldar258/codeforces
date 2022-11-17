package collector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Collector {

    private final static String absolutePathAnswersFolder = System.getProperty("user.dir") + "\\answers\\";

    public static void createAnswer(Class<?> clazz, String mainMethodTemplateFileName) {
        String dirProject = System.getProperty("user.dir");
        String packagePath = clazz.getCanonicalName().replace(".", "\\");
        String filePath = packagePath + ".java";

        String absolutePath = dirProject
                + "\\src\\main\\java\\"
                + filePath;

        StringBuilder result = new StringBuilder();
        try(FileReader fileCurrent = new FileReader(absolutePath);
                FileReader fileTemplate = new FileReader(getFromTemplate(mainMethodTemplateFileName))
        ) {
            BufferedReader bufferedReaderCurrent = new BufferedReader(fileCurrent);
            BufferedReader bufferedReaderTemplate = new BufferedReader(fileTemplate);

            readImportsFromTemplate(bufferedReaderTemplate, result);
            readUpToClassDeclaration(bufferedReaderCurrent, result);
            readFromTemplate(bufferedReaderTemplate, result, clazz.getSimpleName());
            readFromCurrent(bufferedReaderCurrent, result);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        createFile(result, absolutePathAnswersFolder + filePath);
    }

    private static File getFromTemplate(String templateFileName) throws URISyntaxException {
        var uriTemplate = Collector.class.getClassLoader().getResource(templateFileName);
        if (uriTemplate == null) throw new RuntimeException("CAN'T find template" + templateFileName);
        return new File(uriTemplate.toURI());
    }

    private static void readImportsFromTemplate(BufferedReader bufferedReaderTemplate, StringBuilder result) throws IOException {
        String line;
        while ((line = bufferedReaderTemplate.readLine()) != null) {
            if ("@StartMain".equals(line)) break;
            result.append(line).append("\n");
        }
    }

    private static void readUpToClassDeclaration(BufferedReader bufferedReaderCurrent, StringBuilder result) throws IOException {
        String line;
        bufferedReaderCurrent.readLine(); //throw package declaration
        while ((line = bufferedReaderCurrent.readLine()) != null) {
            if (line.matches("(^import collector|^@).*")) continue; //throw annotations declaration
            result.append(line).append("\n");
            if (line.contains("class")) break;
        }
    }

    private static void readFromTemplate(BufferedReader bufferedReaderTemplate, StringBuilder result, String className) throws IOException {
        String line;
        while ((line = bufferedReaderTemplate.readLine()) != null) {
            if (line.matches(" *@ClassName *")) {
                result.append(bufferedReaderTemplate.readLine().replaceFirst("\\*", className)).append("\n");
                break;
            } else result.append(line).append("\n");
        }

        while ((line = bufferedReaderTemplate.readLine()) != null) {
            result.append(line).append("\n");
        }
    }

    private static void readFromCurrent(BufferedReader bufferedReaderCurrent, StringBuilder result) throws IOException {
        String line;
        while ((line = bufferedReaderCurrent.readLine()) != null) {
            result.append(line).append("\n");
        }
    }

    private static void createFile(StringBuilder content, String absoluteFilePath) {
        Path path = Path.of(absoluteFilePath);

        try {
            Files.createDirectories(path.getParent());
            Files.deleteIfExists(path);
            Files.writeString(path, content, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
