package com.example.uppgift_11a_regformular;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Printer {


    // Prints the object from the new list to a separate .txt file (If the list contains an object)
    public void printTofile(String string) {

        String filename = "src/com/example/uppgift_11a_regformular/formulär.txt";
        Path writeToFilePath = Paths.get(filename);

//----------------------------------------------------------------------------------------------------------------------

        boolean newFile = !Files.exists(writeToFilePath);

//T-------------------------------------------SKRIVER TILL FIL-------------------------------------------------------

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true))) {

            bufferedWriter.write(string);
//--------------------------------------------FELHANTERING---------------------------------------------------------

        } catch (
                FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();

        } catch (
                IOException e) {
            System.out.println("Could not write to file");
            e.printStackTrace();

        } catch (
                Exception e) {
            System.out.println("Oops! Something went wrong");
            e.printStackTrace();
        }
    }
}
