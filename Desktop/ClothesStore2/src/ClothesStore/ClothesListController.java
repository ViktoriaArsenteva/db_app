package ClothesStore;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ClothesListController {

    private ObservableList<Clothes> clothesData = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Clothes> clothesTable;

    @FXML
    private TableColumn<Clothes, Integer> idCol;

    @FXML
    private TableColumn<Clothes, String> vendorCodeCol;

    @FXML
    private TableColumn<Clothes, String> categoryCol;

    @FXML
    private TableColumn<Clothes, String> nameCol;

    @FXML
    private TableColumn<Clothes, String> colorCol;

    @FXML
    private TableColumn<Clothes, String> sizeCol;

    @FXML
    private TableColumn<Clothes, Integer> amountCol;

    @FXML
    private Button remove;

    @FXML
    private Button backBtn;

    @FXML
    private void initialize() {
        try {
            initData();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // устанавливаем тип и значение которое должно хранится в колонке
        idCol.setCellValueFactory(new PropertyValueFactory<Clothes, Integer>("id"));
        vendorCodeCol.setCellValueFactory(new PropertyValueFactory<Clothes, String>("vendorCode"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<Clothes, String>("category"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Clothes, String>("name"));
        colorCol.setCellValueFactory(new PropertyValueFactory<Clothes, String>("color"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<Clothes, String>("size"));
        amountCol.setCellValueFactory(new PropertyValueFactory<Clothes, Integer>("amount"));

        // заполняем таблицу данными
        clothesTable.setItems(clothesData);
    }

    // подготавливаем данные для таблицы
    private void initData() throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String data = dbHandler.getAllClothes();
        try (PreparedStatement prSt = dbHandler.getDbConnection().prepareStatement(data)) {
            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                int dbId =resultSet.getInt("id");
                String dbVendorCode = resultSet.getString("vendorCode");
                String dbCategory = resultSet.getString("category");
                String dbName = resultSet.getString("name");
                String dbColor = resultSet.getString("color");
                String dbSize = resultSet.getString("size");
                int dbAmount =resultSet.getInt("amount");
                clothesData.add(new Clothes(dbId,dbVendorCode, dbCategory, dbName, dbColor, dbSize, dbAmount));
   }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void comeBack(ActionEvent actionEvent){
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.close();
    }

    public void removeItem() throws ClassNotFoundException, SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        int selectedIndex = clothesTable.getSelectionModel().getSelectedIndex();//значение в таблице
        Clothes clothes = clothesTable.getSelectionModel().getSelectedItem();
        int id = clothes.getId();//значение в базе данных
        clothesTable.getItems().remove(selectedIndex); //удаление данных из таблицы
        dbHandler.deleteItem(id); //удаление из базы данных
    }

    


}
    
        


