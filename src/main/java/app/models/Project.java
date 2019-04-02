package app.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    //Maximum Number of students
    private int numberStudents;

    // Increased Column Size due to serialized objects
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User supervisor;

    //Current Students participating in Project
    @OneToMany(mappedBy = "program")
    private List<User> students;
    //private List<User> students;

    //Required Program for Students Participating
    @ManyToMany
    private List<Program> restrictions;
    //private ArrayList<Program> restrictions;

    //Status of the project
    private enum Status {ACTIVE, INACTIVE}
    private Status status;

    public Project() {

    }

    public Project(String name, String description, int numberStudents, User supervisor, ArrayList<User> students, ArrayList<Program> restrictions) {
        this.name = name;
        this.description = description;
        this.numberStudents = numberStudents;
        this.supervisor = supervisor;
        this.students = students;
        this.restrictions = restrictions;
        this.status = Status.ACTIVE;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberStudents() {
        return numberStudents;
    }

    public void setNumberStudents(int numberStudents) {
        this.numberStudents = numberStudents;
    }

    public User getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(User supervisor) {
        this.supervisor = supervisor;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<User> students) {
        this.students = students;
    }

    public List<Program> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(ArrayList<Program> restrictions) {
        this.restrictions = restrictions;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }


    public boolean addStudent(User student){
        if(this.getNumberStudents() == this.students.size()){
            return false;
        }
        for (User s : students) {
            if (s.getUsername().equals(student.getUsername())) {
                return false;
            }
        }
        this.students.add(student);
        return true;
    }

    public void activate(){
        this.status = Status.ACTIVE;
    }

    public void deactivate(){
        this.status = Status.INACTIVE;
    }

    public boolean isActive(){
        return this.status == Status.ACTIVE;
    }
}

