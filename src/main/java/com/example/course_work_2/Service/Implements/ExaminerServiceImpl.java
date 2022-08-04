package com.example.course_work_2.Service.Implements;

import com.example.course_work_2.Exception.NotEnoughQuestionException;
import com.example.course_work_2.Model.Question;
import com.example.course_work_2.Service.ExaminerService;
import com.example.course_work_2.Service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;

    private final Random random;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;

        this.random = new Random();
    }


    public Collection<Question> getQuestions(int amount) throws NotEnoughQuestionException {
        List<Object> questionServices = List.of(javaQuestionService);
        if (amount <= 0 || amount > questionServices.stream().map(QuestionService::getAll).mapToInt
                (Collection::size).sum()) {
            throw new NotEnoughQuestionException();
        }
        Set<Question> result = new HashSet<>(amount);
        while (result.size() < amount) {
            int indexOfService = random.nextInt(questionServices.size());
            result.add(questionServices.get(indexOfService).getRandomQuestion());
        }
        return result;
    }

    public Collection<Question> getQuestion(int amount) {
        return null;
    }
}
