package P06SoftUnisStudents;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return data.size();
    }

    public String insert(Student student) {
        String output = "";
        if (data.contains(student)) {
            output = "Student is already in the hall.";
        } else if (data.size() >= capacity) {
            output = "The hall is full.";
        } else {
            data.add(student);
            output = String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
        }
        return output;
    }

    public String remove(Student student){
        String output = "";
        if (!data.contains(student)){
            output = "Student not found.";
        }else{
            output = String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
            data.remove(student);
        }
        return output;
    }

    public Student getStudent(String firstName, String lastName){
        return data.stream().filter(student -> student.getFirstName()
                .equals(firstName) && student.getLastName().equals(lastName)).findFirst().orElse(null);
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hall size: %d%n", getCount()));
        for (Student student : data) {
            sb.append(student.toString());
        }
        return sb.toString();
    }
}
