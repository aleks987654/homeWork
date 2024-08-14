package ru.gb.FamilyTree;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException  {
        FamilyTree familyTree = new FamilyTree();
        
        if (!Files.isRegularFile(Path.of("familyTree.out"))) {
            getDefault(familyTree);
            System.out.println("Сreated for the first time: " + "\n");
        } else {
            familyTree = readFromFile();
            System.out.println("Restored: " + "\n");
        }
        System.out.println(familyTree);

        writeToFile(familyTree);

    }

    private static void writeToFile(FamilyTree familyTree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                 new FileOutputStream("familyTree.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }

    private static FamilyTree readFromFile() throws IOException, ClassNotFoundException {
        FamilyTree familyTree;
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("familyTree.out"));
        familyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return familyTree;
    }

    private static void getDefault(FamilyTree familyTree) {
        Human human1 = new Human(1, "Александр", Gender.Male, LocalDate.of(1960, 10, 10));
        Human human2 = new Human(2, "Екатерина", Gender.Female, LocalDate.of(1965, 05, 05));
        Human human3 = new Human(3, "Михаил", Gender.Male, LocalDate.of(1985, 06, 15));
        Human human4 = new Human(4, "Евгения", Gender.Female, LocalDate.of(1990, 12, 25));
        Human human5 = new Human(5, "Геннадий", Gender.Male, LocalDate.of(2015, 7, 7));

        human1.setChildren(List.of(human3));
        human2.setChildren(List.of(human3));
        human3.setParents(List.of(human1, human2));
        human3.setChildren(List.of(human5));
        human4.setChildren(List.of(human5));
        human5.setParents(List.of(human3, human4));
        human2.setDeathDate(LocalDate.of(2020, 3, 25));

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
    }


}
