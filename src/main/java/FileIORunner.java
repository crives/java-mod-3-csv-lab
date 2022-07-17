import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileIORunner {
    static String readFromFile(String fileName) throws IOException {
        String returnString = new String();
        Scanner fileReader = null;
        try {
            File myFile = new File(fileName);
            fileReader = new Scanner(myFile);
            while (fileReader.hasNextLine()) {
                returnString += fileReader.nextLine();
//                if (addNewLine)
//                    returnString += "\n";
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (fileReader != null)
                fileReader.close();
        }

        return returnString;
    }

    static void writeToFile(String fileName, String text) throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.write(text);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (fileWriter != null)
                fileWriter.close();
        }
    }

    public static void writeCsv(String fileName, List<Person> personList) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName);) {
            //add a header to csv file.
            fileWriter.write("FirstName, LastName\n");
            //For each person inside of personlist write them to fileWriter.
            for (Person person : personList) {
                fileWriter.write(person.toString() + "\n");
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

//        StringBuffer stringBuffer = new StringBuffer();
//
//        //add a header to csv file.
//        stringBuffer.append("PersonID, FirstName, LastName\n");
//
//        //For each student inside of students write them to fileWriter.
//        for (Person person : personList) {
//            stringBuffer.append(person.toString() + "\n");
//        }
//        fileName = "sb" + fileName;
//        try (FileWriter fileWriter = new FileWriter(fileName);) {
//            //add a header to csv file.
//            fileWriter.write(stringBuffer.toString());
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//        Person testPerson = new Person("Soraya", "Rabots", 1990, 12, 19);
//        System.out.println(testPerson);
//        String personCSV = testPerson.formatAsCSV();
//        FileIORunner.writeToFile("person.csv", personCSV);
    }
}