package org.redischool.coursebookingsystem;

class Course {
    int courseId;
    String courseName;
    int openSpaces;
    Student[] studentList;

    Course(int courseId, String courseName, int openSpaces) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.openSpaces = openSpaces;
        this.studentList = new Student[openSpaces];
    }

    public String toString() {
        return "Course Id: " + courseId
                + " Course name: " + courseName
                + " # open spaces: " + openSpaces;
    }

    boolean book(Student student) {
        // Please complete the body of method book!
        if (openSpaces > 0) {
            Integer freeSpace = isThereSpace(student);
            if (freeSpace != null) {
                studentList[freeSpace] = student;
                openSpaces--;
                return true;
            }
        }
        return false;
    }

    private Integer isThereSpace(Student newComming) {
        for (int i = 0; i < studentList.length; i++) {
            Student alreadyThere = studentList[i];
            if (alreadyThere != null) {
                if (alreadyThere.name.equals(newComming.name)) {
                    return null;
                }
            } else {
                return i;
            }
        }
        return null;
    }

    String createParticipantList() {
        String participantList = "";
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null) {
                participantList = participantList + studentList[i].name + "\n";
            }
        }
        return participantList;
    }
    // Please complete the body of method createParticipantList!

}
