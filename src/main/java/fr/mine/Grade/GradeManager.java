package fr.mine.Grade;

import java.util.HashMap;

public class GradeManager {

    private HashMap<String, Grade> gradelist = new HashMap<String, Grade>();

    public GradeManager(){
        this.gradelist.put("Host", new Grade("Host", "§b[Host]", "grade.host"));
        this.gradelist.put("CoHost", new Grade("CoHost", "§d[CoHost]", "grade.cohost"));
        this.gradelist.put("Moderateur", new Grade("Moderateur", "§e[Moderateur]","grade.moderateur"));

    }

    public HashMap<String, Grade> getGradelist() {
        return gradelist;
    }

    public void addGrade(String gradeName, String gradePrefix){
        this.gradelist.put(gradeName, new Grade(gradeName, gradePrefix,"grade." + gradeName));
    }
    public void removeGrade(String gradeName){
        this.gradelist.remove(gradeName);
    }
}
