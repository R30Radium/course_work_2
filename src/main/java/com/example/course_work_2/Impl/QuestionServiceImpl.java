package com.example.course_work_2.Impl;

import com.example.course_work_2.Model.Question;
import com.example.course_work_2.Service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final Set<Question> questions;
    private final Random random;

    public QuestionServiceImpl(Random random) {
        this.questions = new HashSet<>();
        this.random = random;
    }

    @Override
    public Question add(String question, String answer) {
        Question kto = new Question(question, answer);
        questions.add(kto);
        return kto;
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
