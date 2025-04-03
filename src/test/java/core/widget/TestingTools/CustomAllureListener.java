package core.widget.TestingTools;

import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;

public class CustomAllureListener implements TestLifecycleListener {

    /**
     * Converts an Allure test path to a Maven-style (java method FQN) identifier by replacing the last '.' with '#'.
     * <br>
     * Example: {@code application.Samples.Form.HintOnFormTest.filtration → application.Samples.Form.HintOnFormTest#filtration}
     * <br>
     * To use this llistener add file {@code io.qameta.allure.listener.TestLifecycleListener}
     * to folder {@code src/test/resources/META-INF/services/} and fill it with this listener
     * FQN: {@code core.widget.TestingTools.CustomAllureListener}.
     * <br>
     * @param result the test path
     * @return the transformed identifier
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