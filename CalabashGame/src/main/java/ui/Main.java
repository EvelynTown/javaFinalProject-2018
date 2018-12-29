package ui;

import java.io.File;

import constants.Constants;
import formation.Formation;
import ground.Ground;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * 
 * 程序入口
 * 
 * @author TangSiyi
 * 
 */

public class Main extends Application implements Constants {
	private StackPane stackPane = new StackPane();
	private GridPane gridPane = new GridPane();
	private Ground ground = new Ground();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		ground.initImages(gridPane);
		ground.initFormation(gridPane, Formation.CRANE);
		stackPane.getChildren().add(background);
		stackPane.getChildren().add(gridPane);
		stackPane.getChildren().add(ground.getTextArea());
		Scene scene = new Scene(stackPane, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				try {
					switch (event.getCode()) {
					case DIGIT1:
						ground.initFormation(gridPane, Formation.CRANE);
						break;
					case DIGIT2:
						ground.initFormation(gridPane, Formation.GOOSE);
						break;
					case DIGIT3:
						ground.initFormation(gridPane, Formation.YOKE);
						break;
					case DIGIT4:
						ground.initFormation(gridPane, Formation.FISH);
						break;
					case DIGIT5:
						ground.initFormation(gridPane, Formation.SQUARE);
						break;
					case DIGIT6:
						ground.initFormation(gridPane, Formation.MOON);
						break;
					case DIGIT7:
						ground.initFormation(gridPane, Formation.FRONT);
						break;
					case L:
						FileChooser fileChooser = new FileChooser();
						FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("txt(*.txt)", "*.txt");
						fileChooser.getExtensionFilters().add(extFilter);
						File file = fileChooser.showOpenDialog(primaryStage);
						ground.readFile(file, gridPane);
						System.out.println(file);
						break;
					case SPACE:
						ground.startThreads();
						break;
					default:
						break;
					}
				} catch (Exception e) {
					System.out.println("error when get key code");
					e.printStackTrace();
				}
			}
		});
		primaryStage.setTitle("葫芦娃大战蝎子精和他的小弟们");
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/hedgehog.png")));
		primaryStage.show();
	}

	public void initLabel() {

	}
}