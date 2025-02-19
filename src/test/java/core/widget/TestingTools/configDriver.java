package core.widget.TestingTools;

import com.codeborne.selenide.WebDriverRunner;
import core.OriginExpectations.CxBoxExpectations;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class configDriver {

    /**
     * Getting the id string from the url when editing or creating
     *
     * @return Long id
     */
    public static Long getRowIdFromUrl() {
        var waiting123 = new CxBoxExpectations();
        waiting123.getContextMenu();
        String url = WebDriverRunner.currentFrameUrl();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            log.info("Row id is {}", matcher.group());
            return Long.valueOf((matcher.group()));
        } else {
            log.error("Row id is not found");
            return null;
        }
    }
}
