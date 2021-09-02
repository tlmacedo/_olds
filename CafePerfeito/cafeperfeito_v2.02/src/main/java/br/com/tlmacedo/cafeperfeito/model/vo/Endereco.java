package br.com.tlmacedo.cafeperfeito.model.vo;

import br.com.tlmacedo.cafeperfeito.model.enums.TipoEndereco;
import javafx.beans.property.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Endereco")
@Table(name = "endereco")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    private LongProperty id = new SimpleLongProperty();
    private TipoEndereco tipo;
    private StringProperty cep = new SimpleStringProperty();
    private StringProperty logradouro = new SimpleStringProperty();
    private StringProperty numero = new SimpleStringProperty();
    private StringProperty complemento = new SimpleStringProperty();
    private StringProperty bairro = new SimpleStringProperty();
    private StringProperty pontoReferencia = new SimpleStringProperty();

    private ObjectProperty<Municipio> municipio = new SimpleObjectProperty<>();

    public Endereco() {
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

    @Enumerated(EnumType.ORDINAL)
    public TipoEndereco getTipo() {
        return tipo;
    }

    public void setTipo(TipoEndereco tipo) {
        this.tipo = tipo;
    }

    @Column(length = 8, nullable = false)
    public String getCep() {
        return cep.get();
    }

    public void setCep(String cep) {
        this.cep.set(cep);
    }

    public StringProperty cepProperty() {
        return cep;
    }

    @Column(length = 120, nullable = false)
    public String getLogradouro() {
        return logradouro.get();
    }

    public void setLogradouro(String logradouro) {
        this.logradouro.set(logradouro);
    }

    public StringProperty logradouroProperty() {
        return logradouro;
    }

    @Column(length = 10, nullable = false)
    public String getNumero() {
        return numero.get();
    }

    public void setNumero(String numero) {
        this.numero.set(numero);
    }

    public StringProperty numeroProperty() {
        return numero;
    }

    @Column(length = 80)
    public String getComplemento() {
        return complemento.get();
    }

    public void setComplemento(String complemento) {
        this.complemento.set(complemento);
    }

    public StringProperty complementoProperty() {
        return complemento;
    }

    @Column(length = 50, nullable = false)
    public String getBairro() {
        return bairro.get();
    }

    public void setBairro(String bairro) {
        this.bairro.set(bairro);
    }

    public StringProperty bairroProperty() {
        return bairro;
    }

    @Column(length = 80)
    public String getPontoReferencia() {
        return pontoReferencia.get();
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia.set(pontoReferencia);
    }

    public StringProperty pontoReferenciaProperty() {
        return pontoReferencia;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Municipio getMunicipio() {
        return municipio.get();
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio.set(municipio);
    }

    public ObjectProperty<Municipio> municipioProperty() {
        return municipio;
    }

    @Override
    public String toString() {
        return getTipo().getDescricao();
    }
}
