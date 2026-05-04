package com.example.todolist3;

public class Task {
    private String title;
    private String deadline;
    private boolean checked;

    public Task(String title, String deadline) {
        this.title = title;
        this.deadline = deadline;
        this.checked = false;
    }

    public Task(String title) {
        this.title = title;
        this.deadline = "";
        this.checked = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
