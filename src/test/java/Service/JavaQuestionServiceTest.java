package Service;

import com.example.course_work_2.Exception.QuestionAlreadyExistException;
import com.example.course_work_2.Model.Question;
import com.example.course_work_2.Service.Implements.JavaQuestionService;
import com.example.course_work_2.Service.QuestionService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class JavaQuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();

    @ParameterizedTest
    @MethodSource("question")
    public void add1Test (Question question) {
        questionService.add(question);
        assertThatExceptionOfType(QuestionAlreadyExistException.class)
                .isThrownBy(() -> questionService.add(question));
        assertThat(questionService.getAll()).containsExactlyInAntOrder(question);
    }

    @ParameterizedTest
    @MethodSource("question1")
    public void add2Test (String question, String answer) {
        questionService.add(question, answer);
        assertThatExceptionOfType(QuestionAlreadyExistException.class)
                .isThrownBy(() -> questionService.add(question, answer));
        assertThat(questionService.getAll()).containsExactlyInAnyOrder
                (new Question(question, answer));
    }

    @ParameterizedTest
    @MethodSource("question2")
    public void removeTest (Question question) {
        questionService.add(question);
        questionService.remove(question);
        assertThat(questionService.getAll()).isEmpty();
        assertThatExceptionOfType(QuestionAlreadyExistException.class).isThrownBy(() ->
                questionService.remove(question));
    }

    @ParameterizedTest
    @MethodSource("questions")
    public void getRandomQuestionTest (Set<Question> questions) {
       questions.forEach(questionService::add);
        assertThat(questionService.getAll()).hasSize(questions.size());
        assertThat(questionService.getRandomQuestion().isIn(questionService.getAll());
        assertThatExceptionOfType(QuestionAlreadyExistException.class).isThrownBy(() ->
                questionService.remove(question));
    }


    public static Stream<Arguments> question1() {
        return Stream.of(
                Arguments.of(new Question("Question", "Answer" ))
        );
    }

    public static Stream<Arguments> question2() {
        return Stream.of(
                Arguments.of(new Question("Question", "Answer" ))
        );
    }

    public static Stream<Arguments> questions() {
        return Stream.of(
                Arguments.of(Set.of(new Question("question1","answer1"),
                        new Question("question2","answer2"),
                        new Question("question3","answer3"),
                        new Question("question4","answer4"))));
    }
}
