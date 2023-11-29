package classes.subject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SubjectList {

    private ArrayList<Subject> subjects;

    public SubjectList() {
        subjects = new ArrayList<>();
        loadDataFromFile(Constant.dataPath.SubjectList_File);
    }

    private void loadDataFromFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // Skip the header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
            	String id = scanner.next();
    			String name = scanner.nextLine();
    			Subject sub = new Subject(id);
    			subjects.add(sub);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addSubject(String id, String name) {
       
        subjects.add(new Subject(id));

        writeToFile(Constant.dataPath.SubjectList_File);
    }

    private void writeToFile(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);

            for (Subject subject : subjects) {
                writer.write(subject.getId() + "\t" + subject.getName() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSubjectNameById(String id) {
        for (Subject subject : subjects) {
            if (subject.getId().equals(id)) {
                return subject.getName();
            }
        }
        return null; 
    }

    public ArrayList<String[]> getIdAndNames() {
        ArrayList<String[]> idAndNames = new ArrayList<>();
        for (Subject subject : subjects) {
            String[] idAndName = {subject.getId(), subject.getName()};
            idAndNames.add(idAndName);
        }
        return idAndNames;
    }
}