package br.com.tlmacedo.cafeperfeito.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.beans.property.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "EntradaCte")
@Table(name = "entrada_nfe")
public class EntradaNfe implements Serializable {
    private static final long serialVersionUID = 1L;

    private LongProperty id = new SimpleLongProperty();
    private ObjectProperty<EntradaProduto> entradaProduto = new SimpleObjectProperty<>();
    private StringProperty chave = new SimpleStringProperty();
    private StringProperty numero = new SimpleStringProperty();
    private StringProperty serie = new SimpleStringProperty();
    private IntegerProperty modelo = new SimpleIntegerProperty();
    private ObjectProperty<Empresa> fornecedor = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> dtEmissao = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> dtEntrada = new SimpleObjectProperty<>();
    private ObjectProperty<EntradaFiscal> entradaFiscal = new SimpleObjectProperty<>();

    public EntradaNfe() {
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

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    public EntradaProduto getEntradaProduto() {
        return entradaProduto.get();
    }

    public void setEntradaProduto(EntradaProduto entradaProduto) {
        this.entradaProduto.set(entradaProduto);
    }

    public ObjectProperty<EntradaProduto> entradaProdutoProperty() {
        return entradaProduto;
    }

    @Column(length = 44, nullable = false, unique = true)
    public String getChave() {
        return chave.get();
    }

    public void setChave(String chave) {
        this.chave.set(chave);
    }

    public StringProperty chaveProperty() {
        return chave;
    }

    @Column(length = 9, nullable = false)
    public String getNumero() {
        return numero.get();
    }

    public void setNumero(String numero) {
        this.numero.set(numero);
    }

    public StringProperty numeroProperty() {
        return numero;
    }

    @Column(length = 3, nullable = false)
    public String getSerie() {
        return serie.get();
    }

    public void setSerie(String serie) {
        this.serie.set(serie);
    }

    public StringProperty serieProperty() {
        return serie;
    }

    @Column(length = 1, nullable = false)
    public int getModelo() {
        return modelo.get();
    }

    public void setModelo(int modelo) {
        this.modelo.set(modelo);
    }

    public IntegerProperty modeloProperty() {
        return modelo;
    }

    @ManyToOne
    public Empresa getFornecedor() {
        return fornecedor.get();
    }

    public void setFornecedor(Empresa fornecedor) {
        this.fornecedor.set(fornecedor);
    }

    public ObjectProperty<Empresa> fornecedorProperty() {
        return fornecedor;
    }

    public LocalDate getDtEmissao() {
        return dtEmissao.get();
    }

    public void setDtEmissao(LocalDate dtEmissao) {
        this.dtEmissao.set(dtEmissao);
    }

    public ObjectProperty<LocalDate> dtEmissaoProperty() {
        return dtEmissao;
    }

    public LocalDate getDtEntrada() {
        return dtEntrada.get();
    }

    public void setDtEntrada(LocalDate dtEntrada) {
        this.dtEntrada.set(dtEntrada);
    }

    public ObjectProperty<LocalDate> dtEntradaProperty() {
        return dtEntrada;
    }

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    public EntradaFiscal getEntradaFiscal() {
        return entradaFiscal.get();
    }

    public void setEntradaFiscal(EntradaFiscal entradaFiscal) {
        this.entradaFiscal.set(entradaFiscal);
    }

    public ObjectProperty<EntradaFiscal> entradaFiscalProperty() {
        return entradaFiscal;
    }

    @Override
    public String toString() {
        return "EntradaNfe{" +
                "id=" + id +
                ", chave=" + chave +
                ", numero=" + numero +
                ", serie=" + serie +
                ", modelo=" + modelo +
                ", fornecedor=" + fornecedor +
                ", dtEmissao=" + dtEmissao +
                ", dtEntrada=" + dtEntrada +
                ", entradaFiscal=" + entradaFiscal +
                '}';
    }
}
