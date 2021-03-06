package br.com.tlmacedo.cafeperfeito.model.vo;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "Uf")
@Table(name = "uf")
public class Uf implements Serializable {
    private static final long serialVersionUID = 1L;

    private LongProperty id = new SimpleLongProperty();
    private StringProperty descricao = new SimpleStringProperty();
    private StringProperty sigla = new SimpleStringProperty();

    public Uf() {
    }

    @Id
    public long getId() {
        return id.get();
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public LongProperty idProperty() {
        return id;
    }

    @Column(length = 50, nullable = false)
    public String getDescricao() {
        return descricao.get();
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }

    public StringProperty descricaoProperty() {
        return descricao;
    }

    @Column(length = 2, nullable = false)
    public String getSigla() {
        return sigla.get();
    }

    public void setSigla(String sigla) {
        this.sigla.set(sigla);
    }

    public StringProperty siglaProperty() {
        return sigla;
    }

    @Override
    public String toString() {
        return siglaProperty().get();
    }
}
