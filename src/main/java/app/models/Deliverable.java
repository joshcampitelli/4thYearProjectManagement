package app.models;

import javax.persistence.Entity;
import java.io.File;
import java.util.Date;

@Entity
public class Deliverable {
    // Date the deliverable is due
    private Date dueDate;

    private String title;
    private String description;

    // File to store the submission
    private File file;
    private Date submissionDate;

    public Deliverable(Date dueDate, String title, String description) {
        this.dueDate = dueDate;
        this.title = title;
        this.description = description;
    }

    public void submit(Date currentDate, File file) {
        this.submissionDate = currentDate;
        this.file = file;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }
}