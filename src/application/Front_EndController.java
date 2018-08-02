package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.chart.PieChart;

import javafx.scene.control.TextField;

import javafx.scene.control.ProgressBar;

import javafx.scene.control.TextArea;

import javafx.scene.chart.BarChart;

public class Front_EndController {
	@FXML
	private BarChart barchart;
	@FXML
	private PieChart pieChart;
	@FXML
	private TextField target_Path;
	@FXML
	private Button Select_Target;
	@FXML
	private TextField destination_path;
	@FXML
	private Button Select_Destination;
	@FXML
	private Button start;
	@FXML
	private ProgressBar progress_Bar;
	@FXML
	private TextArea text_info;

}
