package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Choice extends Application {
    @Override
    public void start(Stage stage) {
        //设置窗体最大化
        stage.setMaximized(true);

        BorderPane root = new BorderPane();
        ImageView imageView = new ImageView(new Image(this.getClass().getResourceAsStream("/image/Sakura0.gif")));
        root.setCenter(imageView);
        root.setStyle("-fx-background:transparent;");

        Scene scene = new Scene(root);
        scene.setFill(null);

        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ESCAPE){
                stage.close();
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
        //设置按钮布局
        root.setLeft(vBox1);
        root.setRight(vBox2);
        //设置点击打开文本编辑器
        btn1.setOnMouseClicked(mouseEvent -> {
            Text text = new Text();
            try {
                text.start(new Stage());
                stage.hide();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //绘线
        Line line = new Line(540,325,325,325);
        line.setStroke(Color.PINK);
        line.setStrokeWidth(10);
        Line line1 = new Line(540,425,325,425);
        line1.setStroke(Color.PINK);
        line1.setStrokeWidth(10);
        Line line2 = new Line(540,525,325,525);
        line2.setStroke(Color.PINK);
        line2.setStrokeWidth(10);
        Line line3 = new Line(1110,325,1325,325);
        line3.setStroke(Color.PINK);
        line3.setStrokeWidth(10);
        Line line4 = new Line(1110,425,1325,425);
        line4.setStroke(Color.PINK);
        line4.setStrokeWidth(10);
        Line line5 = new Line(1110,525,1325,525);
        line5.setStroke(Color.PINK);
        line5.setStrokeWidth(10);
        Line line6 = new Line(540,325,540,525);
        line6.setStroke(Color.PINK);
        line6.setStrokeWidth(10);
        Line line7 = new Line(1110,325,1110,525);
        line7.setStroke(Color.PINK);
        line7.setStrokeWidth(10);
        Line line8 = new Line(540,425,740,425);
        line8.setStroke(Color.PINK);
        line8.setStrokeWidth(10);
        Line line9 = new Line(1110,425,940,425);
        line9.setStroke(Color.PINK);
        line9.setStrokeWidth(10);
        root.getChildren().addAll(line,line1,line2,line3,line4,line5,line6,line7,line8,line9);

        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
}
