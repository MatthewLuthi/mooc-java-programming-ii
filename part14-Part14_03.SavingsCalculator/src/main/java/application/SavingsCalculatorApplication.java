package application;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane layout = new BorderPane();

        Label monthlySavingsText = new Label("25");
        Label interestRateText = new Label("0");

        BorderPane monthlySavingsDisplay = new BorderPane();
        monthlySavingsDisplay.setLeft(new Label("Monthly savings"));
        Slider monthlySavings = new Slider();
        monthlySavings.setMin(25);
        monthlySavings.setMax(250);
        monthlySavings.setValue(25);
        monthlySavings.setShowTickLabels(true);
        monthlySavings.setShowTickMarks(true);
        monthlySavingsDisplay.setCenter(monthlySavings);
        monthlySavingsDisplay.setRight(monthlySavingsText);
        monthlySavingsDisplay.setPadding(new Insets(10));

        BorderPane interestRateDisplay = new BorderPane();
        interestRateDisplay.setLeft(new Label("Yearly interest rate"));
        Slider interestRate = new Slider();
        interestRate.setMin(0);
        interestRate.setMax(10);
        interestRate.setShowTickLabels(true);
        interestRate.setShowTickMarks(true);
        interestRateDisplay.setCenter(interestRate);
        interestRateDisplay.setRight(interestRateText);

        VBox sliderDisplay = new VBox();
        sliderDisplay.getChildren().add(monthlySavingsDisplay);
        sliderDisplay.getChildren().add(interestRateDisplay);
        sliderDisplay.setPadding(new Insets(10));
        sliderDisplay.setSpacing(10);
        layout.setTop(sliderDisplay);

        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();

        LineChart<Number, Number> savingsLineChart = new LineChart<>(xAxis, yAxis);
        savingsLineChart.setAnimated(false);
        //savingsLineChart.setLegendVisible(false);
        savingsLineChart.setTitle("Savings Calculator");
        layout.setCenter(savingsLineChart);

        XYChart.Series savingsData = new XYChart.Series();
        savingsData.setName("Savings");
        XYChart.Series savingsWithInterestData = new XYChart.Series();
        savingsWithInterestData.setName("Savings with interest");

        savingsLineChart.getData().add(savingsData);
        savingsLineChart.getData().add(savingsWithInterestData);

        //#.00 is equal to 2 decimal places
        DecimalFormat df = new DecimalFormat("#");
        df.setRoundingMode(RoundingMode.DOWN);

        monthlySavings.setOnMouseReleased(e -> {
            String monthlySavingsTextUpdate = df.format(monthlySavings.getValue()); // ("" + monthlySavings.getValue()) will convert double to variable of type String
            monthlySavingsDisplay.setRight(new Label(monthlySavingsTextUpdate));
            updateChart(monthlySavings.getValue(), interestRate.getValue(), savingsData, savingsWithInterestData);
        });

        interestRate.setOnMouseReleased(e -> {
            String interestRateTextUpdate = df.format(interestRate.getValue());
            interestRateDisplay.setRight(new Label(interestRateTextUpdate));
            updateChart(monthlySavings.getValue(), interestRate.getValue(), savingsData, savingsWithInterestData);
        });

        Scene view = new Scene(layout, 640, 480); //640 ,480 or 320, 300

        window.setScene(view);
        window.show();
    }

    public void updateChart(double monthlySavings, double interestRate, XYChart.Series savings, XYChart.Series savingsWithInterest) {
        savings.getData().clear();
        savingsWithInterest.getData().clear();
        
        savings.getData().add(new XYChart.Data(0, 0)); // Set intial data points at origin x: 0, y: 0
        savingsWithInterest.getData().add(new XYChart.Data(0, 0));
        
        double previous = 0;
        
        for (int year = 1; year <= 30; year++) {
            savings.getData().add(new XYChart.Data(year, year * monthlySavings * 12.0));
            
            previous += monthlySavings * 12.0;
            previous *= (1 + (interestRate / 100.0));
            
            savingsWithInterest.getData().add(new XYChart.Data(year, previous));
        }
    }
}
