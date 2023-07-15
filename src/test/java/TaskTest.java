import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testSimpleTaskIfGetTitle() {               // getTitle SimpleTask
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String expected = "Позвонить родителям";
        String actual = simpleTask.getTitle();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskIfMatches() {               // позитивный на SimpleTask
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskIfNotMatches() {               // негативный на SimpleTask
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("Написать");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicIfGetSubtasks() {               // GetSubtasks Epic
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        String[] expected = { "Молоко", "Яйца", "Хлеб" };
        String[] actual = epic.getSubtasks();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testEpicIfMatches() {               // позитивный на Epic
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicIfNotMatches() {               // негативный на Epic
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Масло");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingGet() {               // Get Meeting
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        String expectedT = "Выкатка 3й версии приложения";
        String actualT = meeting.getTopic();

        Assertions.assertEquals(expectedT, actualT);

        String expectedP = "Приложение НетоБанка";
        String actualP = meeting.getProject();

        Assertions.assertEquals(expectedP, actualP);

        String expectedS = "Во вторник после обеда";
        String actualS = meeting.getStart();

        Assertions.assertEquals(expectedS, actualS);
    }

    @Test
    public void testMeetingIfMatchesProject() {               // позитивный Project на Meeting
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Приложение");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingIfMatchesTopic() {               // позитивный Topic на Meeting
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingIfNotMatches() {               // негативный на Meeting
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expectedF = false;
        boolean actualF = meeting.matches("АльфаБанк");

        Assertions.assertEquals(expectedF, actualF);
    }
}
