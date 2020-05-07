package edu.wpi.teamname;

import edu.wpi.N.SanitationRequest;
import edu.wpi.N.ServiceException;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App extends Application {

  @Override
  public void init() {
    log.info("Starting Up");
  }

  @Override
  public void start(Stage primaryStage) throws IOException, ServiceException {
    SanitationRequest request = new SanitationRequest();
    // request.run(0, 0, 1080, 720, null, 0);
    primaryStage.setTitle("Team N Sanitation Request API");
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("demo.fxml"));
    Pane pane = loader.load();
    Scene scene = new Scene(pane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  @Override
  public void stop() {
    log.info("Shutting Down");
  }
}
