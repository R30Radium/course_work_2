package com.example.course_work_2.Service.Implements;

import com.example.course_work_2.Exception.QuestionAlreadyExistException;
import com.example.course_work_2.Model.Question;
import com.example.course_work_2.Service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;
    private final Random random;

    public JavaQuestionService() {
        this.random = new Random();
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
       return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyExistException();
        }
        questions.add(question);
        return question;
    }

    public Collection<Question> getAll()
    {return Collections.unmodifiableCollection(questions);}

    @Override
    public Question remove(Question question) {
        if(!questions.contains(question)) {
            throw new QuestionAlreadyExistException();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Question getRandomQuestion() {
        Function<? super Object, ? extends Collection<Question>> questions = getAll();
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }
}
