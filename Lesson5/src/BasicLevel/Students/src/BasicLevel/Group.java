package BasicLevel.Students.src.BasicLevel;

import BasicLevel.Students.src.BasicLevel.Exceptions.GroupOverflowException;
import BasicLevel.Students.src.BasicLevel.Exceptions.StudentNotFoundException;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
    private String groupName;
    private Student[] students = new Student[10];

    public Group(String groupName, Student[] students) {
        this.groupName = groupName;
        this.students = students;
    }

    public Group() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        for(int i = 0; i < students.length; i++) {
            if(students[i] == null) {
                if (student.getGroupName().equals(this.groupName)) {
                    students[i] = student;
                    System.out.println("BasicLevel.Student added");
                } else {
                    System.out.println("Student group name does not match");
                }
                return;
            }
        }
        throw new GroupOverflowException();
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (Student student : students) {
            if(student != null && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        throw new StudentNotFoundException();
    }

    public boolean removeStudentByID(int id) {
        Student[] newStudents = new Student[10];
        boolean remove = false;
        int j = 0;
        for (int i = 0; i < students.length; i++) {
            if(students[i] != null) {
                if(students[i].getId() != id) {
                    newStudents[j] = students[i];
                    j++;
                } else {
                    remove = true;
                    continue;
                }
            }
        }
        System.arraycopy(newStudents, 0, students, 0, students.length);
        return remove;
    }

    public Student[] sortStudentsByLastName() {
        Arrays.sort(students, Comparator.nullsLast(new StudentLastNameComparator()));
        return students;
    }

    @Override
    public String toString() {
        return "BasicLevel.Group{" + "groupName='" + groupName + '\'' + ", students=" + Arrays.toString(sortStudentsByLastName()) + '}';
    }
}
