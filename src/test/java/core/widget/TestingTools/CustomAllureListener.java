package core.widget.TestingTools;

import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;

public class CustomAllureListener implements TestLifecycleListener {
    @Override
    public void beforeTestStop(TestResult result) {
        String name = result.getFullName();
        if (name.contains(".")) {
            name = name.replaceFirst("\\.([^.]+)$", "#$1");
            result.setFullName(name);
        }
    }
}