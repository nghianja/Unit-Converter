import converter.MainKt;
import org.hyperskill.hstest.v6.stage.BaseStageTest;
import org.hyperskill.hstest.v6.testcase.CheckResult;
import org.hyperskill.hstest.v6.testcase.TestCase;

import java.util.ArrayList;
import java.util.List;


public class ConverterTest extends BaseStageTest {
    public ConverterTest() {
        super(MainKt.class);
    }

    @Override
    public List<TestCase> generate() {
        List<TestCase> tests = new ArrayList<>();
        tests.add(new TestCase());
        return tests;
    }

    @Override
    public CheckResult check(String reply, Object clue) {
        if (!reply.trim().equals(
            "145 centimeters is 1.45 meters\n" +
            "2 miles is 3.2187 kilometers\n" +
            "5.5 inches is 139.7 millimeters\n" +
            "12 degrees Celsius is 53.6 degrees Fahrenheit\n" +
            "3 pounds is 1.360776 kilograms")) {

            return CheckResult.FALSE(
                "You should print lines exactly like in the example"
            );
        }
        return CheckResult.TRUE;
    }
}
