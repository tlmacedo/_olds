package br.com.tlmacedo.cafeperfeito.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.beans.property.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "EntrdaCte")
@Table(name = "entrada_cte")
public class EntradaCte implements Serializable {
    private static final long serialVersionUID = 1L;

    private LongProperty id = new SimpleLongProperty();
    private ObjectProperty<EntradaProduto> entradaProduto = new SimpleObjectProperty<>();
    private StringProperty chave = new SimpleStringProperty();
    private IntegerProperty tomadorServico = new SimpleIntegerProperty();
    private StringProperty numero = new SimpleStringProperty();
    private StringProperty serie = new SimpleStringProperty();
    private IntegerProperty modelo = new SimpleIntegerProperty();
    private ObjectProperty<LocalDate> dtEmissao = new SimpleObjectProperty<>();
    private ObjectProperty<Empresa> transportadora = new SimpleObjectProperty<>();
    private ObjectProperty<FiscalFreteSituacaoTributaria> situacaoTributaria = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> vlrCte = new SimpleObjectProperty<>(BigDecimal.ZERO);
    private IntegerProperty qtdVolume = new SimpleIntegerProperty();
    private ObjectProperty<BigDecimal> pesoBruto = new SimpleObjectProperty<>(BigDecimal.ZERO);
    private ObjectProperty<BigDecimal> vlrFreteBruto = new SimpleObjectProperty<>(BigDecimal.ZERO);
    private ObjectProperty<BigDecimal> vlrTaxas = new SimpleObjectProperty<>(BigDecimal.ZERO);
    private ObjectProperty<BigDecimal> vlrColeta = new SimpleObjectProperty<>(BigDecimal.ZERO);
    private ObjectProperty<BigDecimal> vlrImpostoFrete = new SimpleObjectProperty<>(BigDecimal.ZERO);
    private ObjectProperty<EntradaFiscal> entradaFiscal = new SimpleObjectProperty<>();

    public EntradaCte() {
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

    @Column(length = 1, nullable = false)
    public int getTomadorServico() {
        return tomadorServico.get();
    }

    public void setTomadorServico(int tomadorServico) {
        this.tomadorServico.set(tomadorServico);
    }

    public IntegerProperty tomadorServicoProperty() {
        return tomadorServico;
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

    @Column(length = 2, nullable = false)
    public int getModelo() {
        return modelo.get();
    }

    public void setModelo(int modelo) {
        this.modelo.set(modelo);
    }

    public IntegerProperty modeloProperty() {
        return modelo;
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

    @ManyToOne//(fetch = FetchType.LAZY)
    public Empresa getTransportadora() {
        return transportadora.get();
    }

    public void setTransportadora(Empresa transportadora) {
        this.transportadora.set(transportadora);
    }

    public ObjectProperty<Empresa> transportadoraProperty() {
        return transportadora;
    }

    @ManyToOne//(fetch = FetchType.LAZY)
    public FiscalFreteSituacaoTributaria getSituacaoTributaria() {
        return situacaoTributaria.get();
    }

    public void setSituacaoTributaria(FiscalFreteSituacaoTributaria situacaoTributaria) {
        this.situacaoTributaria.set(situacaoTributaria);
    }

    public ObjectProperty<FiscalFreteSituacaoTributaria> situacaoTributariaProperty() {
        return situacaoTributaria;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getVlrCte() {
        return vlrCte.get();
    }

    public void setVlrCte(BigDecimal vlrCte) {
        this.vlrCte.set(vlrCte);
    }

    public ObjectProperty<BigDecimal> vlrCteProperty() {
        return vlrCte;
    }

    @Column(length = 4, nullable = false)
    public int getQtdVolume() {
        return qtdVolume.get();
    }

    public void setQtdVolume(int qtdVolume) {
        this.qtdVolume.set(qtdVolume);
    }

    public IntegerProperty qtdVolumeProperty() {
        return qtdVolume;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getPesoBruto() {
        return pesoBruto.get();
    }

    public void setPesoBruto(BigDecimal pesoBruto) {
        this.pesoBruto.set(pesoBruto);
    }

    public ObjectProperty<BigDecimal> pesoBrutoProperty() {
        return pesoBruto;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getVlrFreteBruto() {
        return vlrFreteBruto.get();
    }

    public void setVlrFreteBruto(BigDecimal vlrFreteBruto) {
        this.vlrFreteBruto.set(vlrFreteBruto);
    }

    public ObjectProperty<BigDecimal> vlrFreteBrutoProperty() {
        return vlrFreteBruto;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getVlrTaxas() {
        return vlrTaxas.get();
    }

    public void setVlrTaxas(BigDecimal vlrTaxas) {
        this.vlrTaxas.set(vlrTaxas);
    }

    public ObjectProperty<BigDecimal> vlrTaxasProperty() {
        return vlrTaxas;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getVlrColeta() {
        return vlrColeta.get();
    }

    public void setVlrColeta(BigDecimal vlrColeta) {
        this.vlrColeta.set(vlrColeta);
    }

    public ObjectProperty<BigDecimal> vlrColetaProperty() {
        return vlrColeta;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getVlrImpostoFrete() {
        return vlrImpostoFrete.get();
    }

    public void setVlrImpostoFrete(BigDecimal vlrImpostoFrete) {
        this.vlrImpostoFrete.set(vlrImpostoFrete);
    }

    public ObjectProperty<BigDecimal> vlrImpostoFreteProperty() {
        return vlrImpostoFrete;
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
        return "EntradaCte{" +
                "id=" + id +
                ", entradaProduto=" + entradaProduto +
                ", chave=" + chave +
                ", tomadorServico=" + tomadorServico +
                ", numero=" + numero +
                ", serie=" + serie +
                ", modelo=" + modelo +
                ", dtEmissao=" + dtEmissao +
                ", transportadora=" + transportadora +
                ", situacaoTributaria=" + situacaoTributaria +
                ", vlrCte=" + vlrCte +
                ", qtdVolume=" + qtdVolume +
                ", pesoBruto=" + pesoBruto +
                ", vlrFreteBruto=" + vlrFreteBruto +
                ", vlrTaxas=" + vlrTaxas +
                ", vlrColeta=" + vlrColeta +
                ", vlrImpostoFrete=" + vlrImpostoFrete +
                ", entradaFiscal=" + entradaFiscal +
                '}';
    }
}
