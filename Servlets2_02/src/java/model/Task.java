
package model;

import java.util.ArrayList;

public class Task {
    
    public static ArrayList<Task> list = new ArrayList<>();
    public String title;

    public Task() {
        this.setTitle("[Novo]");
    }

    public Task(String title) {
        this.title = title;
    }

    public static ArrayList<Task> getList() {
        return list;
    }

    public static void setList(ArrayList<Task> list) {
        Task.list = list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
    
}
