package skrr;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

class AlertBox {
    static Applicant display(String title) {
        Stage window = new Stage();
        Applicant newEntry = new Applicant();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Label regNumber = new Label("Registration number: ");
        TextField regNumberInput = new TextField();
        regNumberInput.setMaxWidth(200);

        Label educationLevel = new Label("Level of education: ");
        TextField educationLevelInput = new TextField();
        educationLevelInput.setMaxWidth(200);

        Label speciality = new Label("Speciality: ");
        TextField specialityInput = new TextField();
        specialityInput.setMaxWidth(200);

        Label durationOfWork = new Label("Duration of work: ");
        TextField durationOfWorkInput = new TextField();
        durationOfWorkInput.setMaxWidth(200);

        Label dateOfDismissal = new Label("Date of dismissal: ");
        TextField dateOfDismissalInput = new TextField();
        dateOfDismissalInput.setMaxWidth(200);

        Label specialityWanted = new Label("Speciality wanted: ");
        TextField specialityWantedInput = new TextField();
        specialityWantedInput.setMaxWidth(200);

        Label workingConditions = new Label("Working conditions: ");
        TextField workingConditionsInput = new TextField();
        workingConditionsInput.setMaxWidth(200);

        Label minimumSalary = new Label("Minimum salary: ");
        TextField minimumSalaryInput = new TextField();
        minimumSalaryInput.setMaxWidth(200);

        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #42adf4");
        submitButton.setOnAction(e -> {
            newEntry.setRegistrationNumber(regNumberInput.getText());
            newEntry.setEducation(educationLevelInput.getText());
            newEntry.setSpeciality(specialityInput.getText());
            newEntry.setExperience(durationOfWorkInput.getText());
            newEntry.setDateOfDismissal(dateOfDismissalInput.getText());
            newEntry.setSpecialityWanted(specialityWantedInput.getText());
            newEntry.setWorkingConditions(workingConditionsInput.getText());
            newEntry.setMinimumSalary(minimumSalaryInput.getText());
            window.close();
        });

        VBox layout = new VBox();
        layout.setSpacing(4);
        layout.setPadding(new Insets(8, 10, 10, 10));
        layout.getChildren().addAll(regNumber, regNumberInput, educationLevel, educationLevelInput,
                                    speciality, specialityInput, durationOfWork, durationOfWorkInput,
                                    dateOfDismissal, dateOfDismissalInput, specialityWanted, specialityWantedInput,
                                    workingConditions,workingConditionsInput, minimumSalary, minimumSalaryInput, submitButton);

        layout.setAlignment(Pos.CENTER_LEFT);

        Scene scene= new Scene(layout, 250,435);
        window.setScene(scene);
        window.showAndWait();

        return newEntry;
    }

}
