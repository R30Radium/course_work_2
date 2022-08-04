package Service;

import com.example.course_work_2.Exception.NotEnoughQuestionException;
import com.example.course_work_2.Model.Question;
import com.example.course_work_2.Service.ExaminerService;
import com.example.course_work_2.Service.Implements.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import java.util.List;
import java.util.ArrayList;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

 @Mock
    private JavaQuestionService javaQuestionService;

    private Question questions;
    @InjectMocks
    private ExaminerService examinerService;

    public ExaminerServiceImplTest() {
    }

    @Test
    public void getQuestionSNegativeTest() {
        assertThatExceptionOfType(NotEnoughQuestionException.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));

        assertThatExceptionOfType(NotEnoughQuestionException.class)
                .isThrownBy(() -> examinerService.getQuestions(+1));
    }

    @Test
    public void getQuestionPositiveTest() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Q1", "A1"));
        questions.add(new Question("Q2", "A2"));
        questions.add(new Question("Q3", "A3"));
        questions.add(new Question("Q4", "A4"));
        questions.add(new Question("Q5", "A5"));

        when(javaQuestionService.getAll()).thenReturn(questions);

        when(javaQuestionService.getRandomQuestion()).thenReturn(questions.get(0),questions.get(2),
                questions.get(0),questions.get(1),questions.get(3));
        assertThat(examinerService.getQuestions(5).containsE xactlyInAnyOrder(questions.get(0),
                questions.get(1),questions.get(2)));


        when(javaQuestionService.getRandomQuestion()).thenReturn(questions.get(0),questions.get(2),
                questions.get(0),questions.get(1),questions.get(3));
        assertThat(examinerService.getQuestions(5).containsExactlyInAnyOrder(questions.get(0),
                questions.get(1),questions.get(2)));
    }
}