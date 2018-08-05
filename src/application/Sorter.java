package application;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;

import javafx.scene.chart.XYChart;

public class Sorter {

	private Map<String, Integer> extensions = new HashMap<>();
	
	public void listFiles(String targetPath) {
		File targetFolder = new File(targetPath);
		for(File file: targetFolder.listFiles()) {
			if(file.isDirectory()) {
				listFiles(file.getPath()); 
			//	System.out.println(file.getPath());
			}else {
			//	System.out.println(file.getName());
				processFileExtension(file);
			}
		}
	}
	
	public void processFileExtension(File file) {
		String extension =FilenameUtils.getExtension(file.getPath());
		if(extensions.containsKey(extension)) {
		extensions.put(extension, extensions.get(extension)+1);
		}else {
			extensions.put(extension, 1);
		}
	}

	public Map<String, Integer> getExtensions() {
		return extensions;
	}
 
	public XYChart.Series getBarChartData(){
		XYChart.Series fileExtensions = new XYChart.Series();
		Set<String> keys= extensions.keySet();
		for(String key: keys) {
			fileExtensions.getData().add(new XYChart.Data(key, extensions.get(key)));
		}
		 
		return fileExtensions;
	}
	
	 
}
