package br.com.tlmacedo.cafeperfeito.model.vo;

import javafx.beans.property.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "MenuPrincipal")
@Table(name = "menu_principal")
public class MenuPrincipal implements Serializable {
    private static final long serialVersionUID = 1L;

    private LongProperty id = new SimpleLongProperty();
    private StringProperty menu = new SimpleStringProperty();
    private StringProperty menuLabel = new SimpleStringProperty();
    private IntegerProperty menuPai_id = new SimpleIntegerProperty();
    private StringProperty icoMenu = new SimpleStringProperty();
    private BooleanProperty tabPane = new SimpleBooleanProperty();
    private StringProperty teclaAtalho = new SimpleStringProperty();

    public MenuPrincipal() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id.get();
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public LongProperty idProperty() {
        return id;
    }

    @Column(length = 45, nullable = false)
    public String getMenu() {
        return menu.get();
    }

    public void setMenu(String menu) {
        this.menu.set(menu);
    }

    public StringProperty menuProperty() {
        return menu;
    }

    @Transient
    public String get_menu() {
        return menu.get().toLowerCase();
    }

    @Column(length = 45, nullable = false)
    public String getMenuLabel() {
        return menuLabel.get();
    }

    public void setMenuLabel(String menuLabel) {
        this.menuLabel.set(menuLabel);
    }

    public StringProperty menuLabelProperty() {
        return menuLabel;
    }

    @Transient
    public String get_menu_label() {
        return menuLabel.get().toLowerCase();
    }

    @Column(length = 2, nullable = false)
    public int getMenuPai_id() {
        return menuPai_id.get();
    }

    public void setMenuPai_id(int menuPai_id) {
        this.menuPai_id.set(menuPai_id);
    }

    public IntegerProperty menuPai_idProperty() {
        return menuPai_id;
    }

    @Column(length = 80)
    public String getIcoMenu() {
        return icoMenu.get();
    }

    public void setIcoMenu(String icoMenu) {
        this.icoMenu.set(icoMenu);
    }

    public StringProperty icoMenuProperty() {
        return icoMenu;
    }

    @Column(length = 1, nullable = false)
    public boolean isTabPane() {
        return tabPane.get();
    }

    public void setTabPane(boolean tabPane) {
        this.tabPane.set(tabPane);
    }

    public BooleanProperty tabPaneProperty() {
        return tabPane;
    }

    @Column(length = 45)
    public String getTeclaAtalho() {
        return teclaAtalho.get().toLowerCase();
    }

    public void setTeclaAtalho(String teclaAtalho) {
        this.teclaAtalho.set(teclaAtalho);
    }

    public StringProperty teclaAtalhoProperty() {
        return teclaAtalho;
    }

    @Override
    public String toString() {
        return menuLabelProperty().get();
    }
}
