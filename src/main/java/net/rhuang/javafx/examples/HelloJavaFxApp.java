package net.rhuang.javafx.examples;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJavaFxApp extends Application {

    private static final Logger logger = LoggerFactory.getLogger(HelloJavaFxApp.class);

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

        logger.info("Starting Hello JavaFX demonstration application");

        String fxmlFile = "/fxml/hellojavafx.fxml";
        logger.debug("Loading FXML for main view from: ", fxmlFile);
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));

        logger.debug("Showing JFX scene");
        Scene scene = new Scene(rootNode, 620, 400);
        scene.getStylesheets().add("/styles/styles.css");

        stage.setTitle("Hello JavaFX");
        stage.setScene(scene);

        Task task = new BackgroundTask((HelloController) loader.getController());
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();

        stage.show();
    }

    private static class BackgroundTask extends Task<Void> {
        private final HelloController controller;

        public BackgroundTask(HelloController controller) {
            this.controller = controller;
        }

        @Override
        public Void call() throws Exception {
            int i = 0;
            while (true) {
                final int finalI = i;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Date date = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
                        controller.appendText("Now is " + sdf.format(date) +". Want to say hello to somebody?\n");
                    }
                });
                i++;
                Thread.sleep(10000);
            }
        }
    }
}
