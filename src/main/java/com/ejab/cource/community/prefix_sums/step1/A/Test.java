package com.ejab.cource.community.prefix_sums.step1.A;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

public class Test {

    public static void main(String[] args) {
        printSourceFile(System.getProperty("user.dir"));
    }

    private static void printSourceFile(String absolutePath) {
        StringBuilder sb = new StringBuilder();
        String packagePath = Test.class.getCanonicalName().replace(".", "\\");//TODO take class name
        sb.append(absolutePath)
                .append("\\src\\main\\java\\")
                .append(packagePath)
                .append(".java");

        StringBuilder result = new StringBuilder();
        try(FileReader fileCurrent = new FileReader(sb.toString());
                FileReader fileTemplate = new FileReader(getFromTemplate("WhenIntWhenIntArrayThenLongArray.txt"));//TODO take fileName From Annotation
                ) {
            BufferedReader bufferedReaderCurrent = new BufferedReader(fileCurrent);
            BufferedReader bufferedReaderTemplate = new BufferedReader(fileTemplate);
            String line;

            readImportsFromTemplate(bufferedReaderTemplate, result);
            readUpToClassDeclaration(bufferedReaderCurrent, result);
            readFrom(bufferedReaderTemplate, result, Test.class.getSimpleName());//TODO take class name
            readFromCurrent(bufferedReaderCurrent, result);

            while ((line = bufferedReaderCurrent.readLine()) != null) {
                result.append(line).append("\n");
            }
            while ((line = bufferedReaderTemplate.readLine()) != null) {
                result.append(line).append("\n");
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        System.out.println(result);
    }

    private static void readFromCurrent(BufferedReader bufferedReaderCurrent, StringBuilder result) throws IOException {
        String line;
        while ((line = bufferedReaderCurrent.readLine()) != null) {
            result.append(line).append("\n");
        }
    }

    private static void readFrom(BufferedReader bufferedReaderTemplate, StringBuilder result, String className) throws IOException {
        String line;
        while ((line = bufferedReaderTemplate.readLine()) != null) {
            if ("@ClassName".equals(line.trim())) {
                line = bufferedReaderTemplate.readLine().replaceAll("\\*", className);
            }
            result.append(line).append("\n");
        }
    }

    private static void readUpToClassDeclaration(BufferedReader bufferedReaderCurrent, StringBuilder result)
            throws IOException {
        String line;
        bufferedReaderCurrent.readLine(); //throw package declaration
        while ((line = bufferedReaderCurrent.readLine()) != null) {
            result.append(line).append("\n");
            if (line.contains("class")) break;
        }
    }

    private static void readImportsFromTemplate(BufferedReader bufferedReaderTemplate, StringBuilder result) throws IOException {
        String line;
        while ((line = bufferedReaderTemplate.readLine()) != null) {
            if ("@StartMain".equals(line)) break;
            result.append(line).append("\n");
        }
    }

    private static File getFromTemplate(String templateFileName) throws URISyntaxException {
        var uriTemplate = Test.class.getClassLoader().getResource(templateFileName);//TODO take class name
        if (uriTemplate == null) throw new RuntimeException("CAN'T find template" + templateFileName);
        return new File(uriTemplate.toURI());
    }
}
