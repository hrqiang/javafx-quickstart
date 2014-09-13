package net.rhuang.javafx.examples;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelloController
{
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @FXML private TextField nameText;
    @FXML private TextArea helloText;

    public void sayHello() {
        logger.debug("Button is press...");
        String name = nameText.getText();
        if (!StringUtils.isEmpty(name)) {
            logger.debug("Append to end of text box.");
            helloText.appendText("Hello, " + name + "!\n");
        }
        nameText.clear();

    }

    public void appendText(String text) {
        helloText.appendText(text);
    }

}
