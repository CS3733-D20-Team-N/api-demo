package edu.wpi.teamname;

import edu.wpi.N.SanitationRequest;
import edu.wpi.N.ServiceException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class DemoController implements Initializable {
  @FXML public AnchorPane pane;
  @FXML public Button refreshButton;
  @FXML public Button loadButton;
  @FXML public Button clearButton;
  @FXML public Button normalButton;
  @FXML public Button adminButton;
  @FXML public Button adminOnlyButton;
  @FXML public Button userOnlyButton;
  @FXML public Button embeddedButton;

  private SanitationRequest runner;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    runner = new SanitationRequest();
  }

  @FXML
  public void loadNodes(ActionEvent actionEvent) throws ServiceException {
    String[] longName = {"Cardio", "SevenEleven", "Total Wine"};
    String[] nodeId = {"10000", "100033", "ND5558J"};
    String[] arr = {nodeId[0], longName[0]};
    String[] arr1 = {nodeId[1], longName[1]};
    String[] arr2 = {nodeId[2], longName[2]};
    LinkedList<String[]> nodes = new LinkedList<>();
    nodes.add(arr);
    nodes.add(arr1);
    nodes.add(arr2);
    runner.loadNodes(nodes);
  }

  @FXML
  public void clearNodes(ActionEvent actionEvent) throws ServiceException {
    runner.loadNodes(new LinkedList<String[]>());
  }

  @FXML
  public void refreshDB(ActionEvent actionEvent) throws ServiceException {
    SanitationRequest.refreshDB();
  }

  @FXML
  public void runNormal(ActionEvent actionEvent) throws ServiceException {
    runner.run(100, 100, 1080, 720, null, 0);
  }

  @FXML
  public void runAdmin(ActionEvent actionEvent) throws ServiceException {
    runner.run(100, 100, 1080, 720, null, SanitationRequest.START_ON_ADMIN);
  }

  @FXML
  public void runAdminNoSwitch(ActionEvent actionEvent) throws ServiceException {
    runner.run(
        100,
        100,
        1080,
        720,
        null,
        SanitationRequest.DISABLE_SWITCHING | SanitationRequest.START_ON_ADMIN);
  }

  @FXML
  public void runNormalNoSwitch(ActionEvent actionEvent) throws ServiceException {
    runner.run(100, 100, 1080, 720, null, SanitationRequest.DISABLE_SWITCHING);
  }

  @FXML
  public void runPassNode(ActionEvent actionEvent) throws ServiceException {
    runner.run(100, 100, 1080, 720, "10000", 0);
  }

  @FXML
  public void runEmbed(ActionEvent actionEvent) throws ServiceException {
    try {
      runner.run(pane, null, 0);
    } catch (ServiceException e) {
      e.printStackTrace();
    }
  }
}
