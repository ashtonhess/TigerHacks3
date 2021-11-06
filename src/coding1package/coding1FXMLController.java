package coding1package;

        import java.beans.PropertyChangeEvent;
        import java.beans.PropertyChangeListener;
        import java.beans.PropertyChangeSupport;
        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;

/**
 *
 * @author ashtonhess
 */
public class coding1FXMLController implements Initializable, PropertyChangeListener {


    @FXML
    private Label textToChange;

    public coding1FXMLModel daModel;
    @FXML
    private Label label;
    @FXML
    private Button daButton;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        daModel = new coding1FXMLModel();
        daModel.addPropertyChangeListener(this);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals("textToChangePropertyChangeID")) {
            //System.out.println("Some shit");
            textToChange.setText((String)evt.getNewValue());
        }

    }

    @FXML
    private void handleDaButton(ActionEvent event) {
        daModel.changeDaText();
    }
}
