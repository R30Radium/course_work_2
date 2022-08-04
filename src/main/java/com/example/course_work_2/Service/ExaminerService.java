package com.example.course_work_2.Service;

import com.example.course_work_2.Exception.NotEnoughQuestionException;
import com.example.course_work_2.Model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount) throws NotEnoughQuestionException;




}
