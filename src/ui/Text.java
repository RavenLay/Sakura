package ui;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.File;

public class Text extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        //文本域
        TextArea textArea = new TextArea();
        root.setCenter(textArea);
        //设置文本域占据窗口大小
        Rectangle2D screenRectangle = Screen.getPrimary().getBounds();
        textArea.setMinSize(screenRectangle.getWidth()-200,screenRectangle.getHeight()-200);
        textArea.setEditable(true);

        //菜单栏
        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(stage.widthProperty());
        root.setTop(menuBar);
        //菜单
        //文件
        Menu fileMenu = new Menu("文件");
        MenuItem newMenuItem = new MenuItem("新建文件");
        MenuItem openMenuItem = new MenuItem("打开文件");
        MenuItem saveMenuItem = new MenuItem("保存文件");
        MenuItem saveAsMenuItem = new MenuItem("另存为");
        MenuItem exitMenuItem = new MenuItem("退出");
        fileMenu.getItems().addAll(newMenuItem,openMenuItem,saveMenuItem,saveAsMenuItem,exitMenuItem);
        newMenuItem.setOnAction(actionEvent -> util.File.newFile());
        openMenuItem.setOnAction(actionEvent -> util.File.openFile());
        saveMenuItem.setOnAction(actionEvent -> util.File.savaFile());
        saveAsMenuItem.setOnAction(actionEvent -> util.File.saveAsFile());
        exitMenuItem.setOnAction(actionEvent -> util.File.exit(stage));
        //设置
        Menu setMenu = new Menu("设置");
        MenuItem typefaceMenuItem = new MenuItem("设置字体");
        MenuItem sizeMenuItem = new MenuItem("设置字体大小");
        MenuItem colorMenuItem = new MenuItem("设置字体颜色");
        setMenu.getItems().addAll(typefaceMenuItem,sizeMenuItem,colorMenuItem);
        typefaceMenuItem.setOnAction(actionEvent -> util.Set.typeface());
        sizeMenuItem.setOnAction(actionEvent -> util.Set.size());
        colorMenuItem.setOnAction(actionEvent -> util.Set.color());
        //功能
        Menu functionMenu = new Menu("功能");
        MenuItem imageMenuItem = new MenuItem("插入图片");
        MenuItem musicMenuItem = new MenuItem("插入音乐");
        functionMenu.getItems().addAll(imageMenuItem,musicMenuItem);
        imageMenuItem.setOnAction(actionEvent -> util.Image.insertImage());
        musicMenuItem.setOnAction(actionEvent -> util.Music.insertMusic());
        //添加到菜单栏
        menuBar.getMenus().addAll(fileMenu,setMenu,functionMenu);
        //设置右键菜单
        ContextMenu contextMenu = new ContextMenu();
        MenuItem imageMenuItem1 = new MenuItem("插入图片");
        MenuItem musicMenuItem1 = new MenuItem("插入音乐");
        contextMenu.getItems().addAll(imageMenuItem1,musicMenuItem1);
        textArea.setContextMenu(contextMenu);
        imageMenuItem1.setOnAction(actionEvent -> util.Image.insertImage());
        musicMenuItem1.setOnAction(actionEvent -> util.Music.insertMusic());

        Scene scene = new Scene(root);
        scene.getAccelerators().put(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN), File::newFile);
        scene.getAccelerators().put(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN), File::openFile);
        scene.getAccelerators().put(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN), File::savaFile);
        scene.getAccelerators().put(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN), File::saveAsFile);
        scene.getAccelerators().put(new KeyCodeCombination(KeyCode.ESCAPE), () -> File.exit(stage));

        stage.setScene(scene);
        stage.setTitle("Sakura文本编辑器");
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
    }
}
