package application;

import java.io.File;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.TextField;

import javafx.scene.control.ProgressBar;

import javafx.scene.control.TextArea;

import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.scene.chart.BarChart;

public class Front_End_Controller {
	@FXML
	private BarChart<String,Number> barchart;
	@FXML
	private PieChart pieChart;
	@FXML
	private TextField target_Path;
	@FXML
	private Button select_Target;
	@FXML
	private TextField destination_path;
	@FXML
	private Button select_Destination;
	@FXML
	private Button start;
	@FXML
	private ProgressBar progress_Bar;
	@FXML
	private TextArea text_info;

	Task copyWorker;
	
	public Front_End_Controller(){
	 
	}
	
	
	
	
	// Event Listener on Button[#select_Target].onMouseClicked
	@FXML
	public void selectTarget(MouseEvent event) {
		DirectoryChooser chooser = new DirectoryChooser();
		chooser.setTitle("Chose Target Folder");
		File defaultDirectory = new File("c:");
		chooser.setInitialDirectory(defaultDirectory);
		target_Path.setText(chooser.showDialog(select_Target.getScene().getWindow()).getPath());
	 
	}
	// Event Listener on Button[#select_Destination].onMouseClicked
	@FXML
	public void select_Desctination(MouseEvent event) {
		DirectoryChooser chooser = new DirectoryChooser();
		chooser.setTitle("Chose Destination Folder");
		File defaultDirectory = new File("c:");
		chooser.setInitialDirectory(defaultDirectory);
		destination_path.setText(chooser.showDialog(select_Destination.getScene().getWindow()).getPath());
	}
	// Event Listener on Button[#start].onMouseClicked
	@FXML
	public void start(MouseEvent event) {
		progress_Bar.setDisable(true);
		progress_Bar.setProgress(0); 
        copyWorker = createWorker();
        progress_Bar.progressProperty().unbind();
        progress_Bar.progressProperty().bind(copyWorker.progressProperty());
          new Thread(copyWorker).start();
      	Sorter sort = new Sorter();
          Platform.runLater(() -> {
        	  sort.listFiles(target_Path.getText());
        	  barchart.getData().addAll(sort.getBarChartData());
        	  
        	});
      }
	
	public Task createWorker() {
	    return new Task() {
	    
	      @Override
	      protected Object call() throws Exception {
	     
	        for (int i = 0; i < 10; i++) {
	          Thread.sleep(20000); 
	          updateProgress(i + 1, 20);
	          
	        }
	        return true;
	      }
	    };
	  }
}
