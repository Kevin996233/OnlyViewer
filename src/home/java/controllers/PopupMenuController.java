package home.java.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import home.java.components.DeleteDialogController;
import home.java.components.ImageBox;
import home.java.model.ImageModel;
import home.java.model.SelectedModel;

import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class PopupMenuController implements Initializable {

    @FXML
    private JFXListView<?> popupList;

    private ImageModel im;
    private ImageBox imageBox;
    private JFXDialog dialog;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //将本类的实例添加到全局映射中
        Util.controllers.put(this.getClass().getSimpleName(), this);
    }

    public PopupMenuController(ImageBox imageBox) {
        this.imageBox = imageBox;
        this.im = imageBox.getIm();
    }

    public void setImageBox(ImageBox imageBox){
        this.imageBox = imageBox;
        this.im = imageBox.getIm();
    }

    @FXML
    private void action() {
        switch (popupList.getSelectionModel().getSelectedIndex()) {
            case 0:
                System.out.println("点击复制 复制图片源:" + im.getImageFilePath());
                SelectedModel.sourceImage(im.getImageFilePath());
                imageBox.getPopUpMenu().hide();
                break;
            case 1:
                System.out.println("点击剪切 剪切图片源:" + im.getImageFilePath());
                SelectedModel.sourceImage(im.getImageFilePath());
                imageBox.getPopUpMenu().hide();
                break;
            case 2:
                System.out.println("点击重命名 重命名图片源:" + im.getImageFilePath());
                // TODO 重命名输入名字
                imageBox.getPopUpMenu().hide();
                break;
            case 3:
                //TODO 弹窗修改为Material Design样式
                System.out.println("点击删除 删除图片源:" + im.getImageFilePath());
                HomeController hc = (HomeController) Util.controllers.get(HomeController.class.getSimpleName());
                System.out.println(hc);
                hc.callDeleteDialog(im);
                imageBox.getPopUpMenu().hide();
                break;
            default:
        }
    }
}
