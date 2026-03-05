//package core.widget.newWidget.field;
//
//import com.codeborne.selenide.Condition;
//import com.codeborne.selenide.SelenideElement;
//import core.widget.newWidget.NewWidget;
//import lombok.RequiredArgsConstructor;
//
//import java.time.Duration;
//
//
//@RequiredArgsConstructor
//public class BaseNewField<E> {
//    final NewWidget newWidget;
//    final String title;
//    final String fieldType;
//
//    public SelenideElement getFieldByName(Integer element) {
//        return newWidget.getWidget()
//                .$$("div[data-test-field-type='" + fieldType + "'][data-test-field-title='" + title + "']")
//                .get(element - 1)
//                .scrollIntoView("{block: \"center\"}")
//                .shouldBe(Condition.enabled, Duration.ofSeconds(5));
//    }
//}
