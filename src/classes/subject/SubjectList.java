package classes.subject;

import java.util.ArrayList;

import classes.user.Account;

public class SubjectList {
    private ArrayList<Subject> subjects;

    public SubjectList() {
    }

    public SubjectList(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }
    
    public static void setName(Subject abc)
    {
        if(abc.getId().equalsIgnoreCase("01"))
        {
            abc.setName("toan roi rac");
        }
        else if(abc.getId().equalsIgnoreCase("02"))
        {
            abc.setName("cau truc du lieu va giai thuat");
        }
    }
}
