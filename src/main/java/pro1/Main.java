package pro1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

      File inputDir = new File("C:/data/input");
      File outputDir = new File("C:/data/output");

        File[] inputFiles = inputDir.listFiles();
        for(File inputFile : inputFiles){
            System.out.println("Reading "+  inputFile.getName());
            ExamRecord[] records = readInputFile(inputFile.toPath());
            outputData(inputFile.getName(),records,outputDir.toPath());
        }

    }

    private static ExamRecord[] readInputFile(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        List<ExamRecord> resultList = new ArrayList<>();
        for(String line : lines)
        {
            String[] split= line.split("[:=;]");
            String nameStudent = (split[0].endsWith(" "))? split[0].substring(0, split[0].length()-1) : split[0];
            resultList.add(new ExamRecord(
                    nameStudent,
                    Fraction.parse(split[1])
            ));
        }
        return resultList.toArray(new ExamRecord[0]);

    }

    private static void outputData(String school, ExamRecord[] recs, Path path){
        System.out.println(path.toString()+ "\\" + school);
        File file = new File(path.toString()+ "\\" + school);
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < recs.length; i++) {
                writer.write(recs[i].getName() +","+recs[i].getScore() + "\n");
            }
            writer.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}