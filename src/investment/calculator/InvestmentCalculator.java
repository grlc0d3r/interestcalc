/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investment.calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Karyn
 */
public class InvestmentCalculator extends Application 
{
    // setup labels, textfield and button variables
    private Label amount = new Label("Investment amount: ");
    private TextField inputAmount = new TextField();
    private Label years = new Label("Number of Years: ");
    private TextField inputNumYears = new TextField();
    private Label rate = new Label("Annual Interest Rate: ");
    private TextField inputAnnualRate = new TextField();
    private Label futureVal = new Label("Future Value: ");
    private TextField outputFuture = new TextField();
    private Button calc = new Button("Calculate");
    
    
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane(); // sets up a grid with COLUMN and ROW indices - column is set first; then row when elems are added
        pane.setVgap(5);
        pane.setHgap(5);
        
        pane.add(amount, 0, 0); // no shift (0); first line of pane (0)
        pane.add(inputAmount, 1, 0); // shift over 1; first line of pane
        pane.add(years, 0, 1);
        pane.add(inputNumYears, 1, 1);
        pane.add(rate, 0, 2);
        pane.add(inputAnnualRate, 2, 2);
        pane.add(futureVal, 0, 4);
        pane.add(outputFuture, 4, 4);
        outputFuture.setEditable(false);
        pane.add(calc, 1, 3);
        
        // now to set up positioning of the pane and its stuff within the grid - kinda like aligning left or right in PPT
        pane.setAlignment(Pos.CENTER); // sets the WHOLE PANE to a center alignment
        pane.setPadding(new Insets(15, 15, 15, 15)); // sets the space around the pane
        inputAmount.setAlignment(Pos.BOTTOM_RIGHT);
        inputNumYears.setAlignment(Pos.BOTTOM_RIGHT);
        inputAnnualRate.setAlignment(Pos.BOTTOM_RIGHT);
        outputFuture.setAlignment(Pos.BOTTOM_RIGHT);
        calc.setAlignment(Pos.BOTTOM_CENTER);
        
        // onclick, the button . . .
        calc.setOnAction(e -> calculateFutureValue());
        
        // now put the pane inside the scene
        Scene scene = new Scene(pane);
        // set up the stage
        primaryStage.setTitle("Investment Calculator");
        // stick the scene ON the stage
        primaryStage.setScene(scene);
        primaryStage.show(); // show time!!

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    // this is what will run when the button is clicked
    private void calculateFutureValue() {
        double investmentAmount = Double.parseDouble(inputAmount.getText());
        int years = Integer.parseInt(inputNumYears.getText());
        double monthlyIntRate = Double.parseDouble(inputAnnualRate.getText()) / 12 / 100;
        
        outputFuture.setText(String.format("$%.2f", (investmentAmount * Math.pow(1 + monthlyIntRate, years * 12))));
    }
}
