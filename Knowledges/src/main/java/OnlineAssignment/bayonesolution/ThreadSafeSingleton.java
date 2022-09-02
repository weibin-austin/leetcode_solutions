package OnlineAssignment.bayonesolution;

import java.util.List;

public class ThreadSafeSingleton {

}

class DemoStudent {
    private String name;
    private List<String> courses;
    public DemoStudent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { // delete
        this.name = name;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) { // delete
        this.courses = courses;
    }
}

class DemoStudentThreadSafe {
    private volatile String name;
    private volatile List<String> courses;
    private static volatile DemoStudent instance = null;

    private DemoStudentThreadSafe(){}

    public static DemoStudent getInstance(){
        if(instance == null){
            synchronized (DemoStudent.class){
                if(instance == null){
                    instance = new DemoStudent();
                }
            }
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public List<String> getCourses() {
        return courses;
    }
}
