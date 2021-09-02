package br.com.tlmacedo.cafeperfeito.model.vo;

import br.com.tlmacedo.cafeperfeito.model.enums.TipoEmailHomePage;
import javafx.beans.property.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "EmailHomePage")
@Table(name = "email_home_page")
public class EmailHomePage implements Serializable {
    private static final long serialVersionUID = 1L;

    private LongProperty id = new SimpleLongProperty();
    private StringProperty descricao = new SimpleStringProperty();
    private TipoEmailHomePage tipoEmailHomePage;

    private BooleanProperty principal = new SimpleBooleanProperty();


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

    @Column(length = 150, nullable = false)
    public String getDescricao() {
        return descricao.get();
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }

    public StringProperty descricaoProperty() {
        return descricao;
    }

    @Enumerated(EnumType.ORDINAL)
    public TipoEmailHomePage getTipoEmailHomePage() {
        return tipoEmailHomePage;
    }

    public void setTipoEmailHomePage(TipoEmailHomePage tipoEmailHomePage) {
        this.tipoEmailHomePage = tipoEmailHomePage;
    }

    @Column(length = 1, nullable = false)
    public boolean isPrincipal() {
        return principal.get();
    }

    public void setPrincipal(boolean principal) {
        this.principal.set(principal);
    }

    public BooleanProperty principalProperty() {
        return principal;
    }

    @Override
    public String toString() {
        return "EmailHomePage{" +
                "id=" + id +
                ", descricao=" + descricao +
                ", tipoEmailHomePage=" + tipoEmailHomePage +
                ", principal=" + principal +
                '}';
    }
}
