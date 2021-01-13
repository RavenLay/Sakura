package ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        //布局
        BorderPane root = new BorderPane();
        //设置动态图片
        root.getChildren().add(new ImageView(new Image("image/Sakura.png")));
        //设置Scene
        Scene scene = new Scene(root,200,249);
        scene.setFill(null);
        //按Esc退出
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ESCAPE){
                    stage.close();
                }
            }
        });
        //点击动态图片进入新窗口
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Choice choice = new Choice();
                try {
                    choice.start(new Stage());
                    stage.hide();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        stage.setScene(scene);
        //消除边框和背景
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}
