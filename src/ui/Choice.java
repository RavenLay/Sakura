package ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Choice extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //设置窗体最大化
        stage.setMaximized(true);

        BorderPane root = new BorderPane();
        root.setCenter(new ImageView(new Image("image/Sakura1.png")));

        Scene scene = new Scene(root);
        scene.setFill(null);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ESCAPE){
                    stage.close();
                }
            }
        });
        //设置选项按钮
        Button btn1 = new Button("文本编辑器");
        Button btn2 = new Button("");
        Button btn3 = new Button("");
        Button btn4 = new Button("");
        Button btn5 = new Button("");
        Button btn6 = new Button("");
        btn1.fontProperty().setValue(new Font(30));
        btn2.fontProperty().setValue(new Font(30));
        btn3.fontProperty().setValue(new Font(30));
        btn4.fontProperty().setValue(new Font(30));
        btn5.fontProperty().setValue(new Font(30));
        btn6.fontProperty().setValue(new Font(30));
        //设置竖向布局
        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(btn1,btn2,btn3);
        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(btn4,btn5,btn6);
        vBox1.setPadding(new Insets(100));
        vBox1.setSpacing(50);
        vBox2.setPadding(new Insets(100));
        vBox2.setSpacing(50);
        vBox1.setAlignment(Pos.CENTER);
        vBox2.setAlignment(Pos.CENTER);
        //设置横向布局
        HBox hBox = new HBox();
        hBox.getChildren().addAll(vBox1,vBox2);
        hBox.setAlignment(Pos.CENTER);

        root.setLeft(vBox1);
        root.setRight(vBox2);

        btn1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Text text = new Text();
                try {
                    text.start(new Stage());
                    stage.hide();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        stage.setOpacity(0.75);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
}
