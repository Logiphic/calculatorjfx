package com.example.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static com.example.calculator.calculations.addStack;
import static com.example.calculator.calculations.calc;

public class HelloApplication extends Application {

    int width =50;
    int height = 50;
    @Override
    public void start(Stage stage) throws IOException {

        VBox root = new VBox(10); // 10 is spacing between children
        root.setAlignment(Pos.CENTER); // center both children vertically and horizontally

        TextField textField = new TextField("0");
        textField.setPrefSize(width,height-10);
        textField.setMaxWidth(215);
        textField.setEditable(false);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);



        String []op =new String[]{"-","+","=","x","/","Del"};
        Button [] bt=new Button[16];
        int k=0;
        for(int i=0; i<bt.length; i++){
            bt[i]=new Button();
            bt[i].setPrefSize(width, height);
            bt[i].setStyle("-fx-font-size: 15; -fx-background-color: rgba(0, 0, 0, 0.3); -fx-text-fill: white;  -fx-border-radius: 8px; -fx-background-radius: 8px");
            if(i>9){
                bt[i].setText(op[k++]);
            }
            else
                bt[i].setText(String.valueOf(i));
        }

        int index=9;
        for(int i=1;i<4;i++){
            for(int j=0;j<3;j++){
                gridPane.add(bt[index--],j,i);
            }
        }
        gridPane.add(bt[0],3,3);

        for(int i=0;i<4;i++){
            gridPane.add(bt[15-i],i,0);
            if(i>0 && i<3)
                gridPane.add(bt[12-i],3,i);

        }

        //calculator Logic
        for(Button b:bt){
            b.setOnAction(e->{
                String s ;
                if(textField.getText().equals("0"))
                    s="";
                else
                    s=textField.getText();
                switch(b.getText()){
                    case "0":
                        textField.setText(s+"0");

                        break;
                    case "1":
                        textField.setText(s+"1");

                        break;
                    case "2":
                        textField.setText(s+"2");

                        break;
                    case "3":
                        textField.setText(s+"3");

                        break;
                    case "4":
                        textField.setText(s+"4");

                        break;
                    case "5":
                        textField.setText(s+"5");

                        break;
                    case "6":
                        textField.setText(s+"6");

                        break;
                    case "7":
                        textField.setText(s+"7");

                        break;
                    case "8":
                        textField.setText(s+"8");

                        break;
                    case "9":
                        textField.setText(s+"9");

                        break;
                    case "+":
                        textField.setText(s+"+");

                        break;
                    case "-":
                        textField.setText(s+"-");

                        break;
                    case "/":
                        textField.setText(s+"/");

                        break;
                    case "x":
                        textField.setText(s+"x");

                        break;
                    case "=":
                        textField.setText(calc());

                        break;
                    case "Del":
                        textField.setText("0");
                        break;
                    default:

                }
            });

        }
        //end of logic


        root.getChildren().addAll(textField,gridPane);
        root.setStyle("-fx-background-color: linear-gradient(from 22% 0% to 50% 100%, #2ea1ff,#05439e);");


        Scene scene = new Scene(root, 270, 300);

        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}