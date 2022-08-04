package com.example.course_work_2.Controller;

import com.example.course_work_2.Model.Question;
import com.example.course_work_2.Service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {

     private final QuestionService questionService;

    public JavaQuestionController(@Qualifier("javaQuestionService" ) QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question,
                        @RequestParam String answer) {
    return questionService.add(question, answer);
    }

    @GetMapping("/find")
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }




}
