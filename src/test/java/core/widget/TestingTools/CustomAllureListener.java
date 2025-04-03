package core.widget.TestingTools;

import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;

public class CustomAllureListener implements TestLifecycleListener {

    /**
     * The method transforms the standard allure (application.Samples.Form.HintOnFormTest.filtration)
     * in a convenient mvn form (application.Samples.Form.HintOnFormTest#filtration)
     * The method takes the result {result},
     * extracts the full name of the path to the test from it,
     * and changes the last one . on #
     */
    @Override
    public void beforeTestStop(TestResult result) {
        String name = result.getFullName();
        int lastDotIndex = name.lastIndexOf('.');
        if (lastDotIndex != -1) {
            name = name.substring(0, lastDotIndex) + "#" + name.substring(lastDotIndex + 1);

            result.setFullName(name);
        }
    }
}