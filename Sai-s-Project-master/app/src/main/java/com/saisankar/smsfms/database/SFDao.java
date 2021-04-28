package com.saisankar.smsfms.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.saisankar.smsfms.database.facultydb.Faculty;
import com.saisankar.smsfms.database.studentdb.Student;

import java.util.List;

@Dao
public interface SFDao {

    @Query("SELECT * FROM FacultyData")
    LiveData<List<Faculty>> readFacultyData();


    @Query("SELECT * FROM StudentData")
    LiveData<List<Student>> readStudentData();

    @Insert
    void insertFaculty(Faculty faculty);

    @Insert
    void insertStudent(Student student);

    @Query("SELECT mailid FROM StudentData WHERE mailid LIKE :word ")
    String findWord(String word);

}
