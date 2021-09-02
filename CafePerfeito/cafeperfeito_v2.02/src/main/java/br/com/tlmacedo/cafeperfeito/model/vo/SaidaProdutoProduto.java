package br.com.tlmacedo.cafeperfeito.model.vo;

import br.com.tlmacedo.cafeperfeito.model.enums.TipoCodigoCFOP;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.beans.property.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "SaidaProdutoProduto")
@Table(name = "saida_produto_produto")
public class SaidaProdutoProduto implements Serializable {
    private static final long serialVersionUID = 1L;

    private LongProperty id = new SimpleLongProperty();
    private ObjectProperty<SaidaProduto> saidaProduto = new SimpleObjectProperty<>();
    private ObjectProperty<Produto> produto = new SimpleObjectProperty<>();
    private StringProperty codigo = new SimpleStringProperty();
    private StringProperty descricao = new SimpleStringProperty();
    private ObjectProperty<TipoCodigoCFOP> codigoCFOP = new SimpleObjectProperty<>();
    private StringProperty lote = new SimpleStringProperty();
    private ObjectProperty<LocalDate> dtValidade = new SimpleObjectProperty<>();

    private IntegerProperty qtd = new SimpleIntegerProperty();
    private ObjectProperty<BigDecimal> vlrEntrada = new SimpleObjectProperty<>(BigDecimal.ZERO);
    private ObjectProperty<BigDecimal> vlrEntradaBruto = new SimpleObjectProperty<>(BigDecimal.ZERO);
    private ObjectProperty<BigDecimal> vlrUnitario = new SimpleObjectProperty<>(BigDecimal.ZERO);
    private ObjectProperty<BigDecimal> vlrBruto = new SimpleObjectProperty<>(BigDecimal.ZERO);
    private ObjectProperty<BigDecimal> vlrDesconto = new SimpleObjectProperty<>(BigDecimal.ZERO);

    private ObjectProperty<BigDecimal> vlrLiquido = new SimpleObjectProperty<>(BigDecimal.ZERO);
    private IntegerProperty estoque = new SimpleIntegerProperty();
    private IntegerProperty varejo = new SimpleIntegerProperty();
    private IntegerProperty volume = new SimpleIntegerProperty();

    public SaidaProdutoProduto() {
    }

    public SaidaProdutoProduto(ProdutoEstoque produtoEstoque, TipoCodigoCFOP codigoCFOP, Integer qtd) {
        this.produto = produtoEstoque.produtoProperty();
        this.codigo = produtoProperty().getValue().codigoProperty();
        this.descricao = produtoProperty().getValue().descricaoProperty();
        this.codigoCFOP = new SimpleObjectProperty<>(codigoCFOP);
        this.lote = produtoEstoque.loteProperty();
        this.dtValidade = produtoEstoque.dtValidadeProperty();
        this.qtd = new SimpleIntegerProperty(qtd == null ? 1 : qtd);
        this.vlrEntrada = new SimpleObjectProperty<>((produtoEstoque.vlrUnitarioProperty().getValue()
                .add(produtoEstoque.vlrImpostoProperty().getValue())
                .add(produtoEstoque.vlrFreteProperty().getValue()))
                .subtract(produtoEstoque.vlrDescontoProperty().getValue()));
        this.vlrEntradaBruto = new SimpleObjectProperty<>(vlrEntradaProperty().getValue()
                .multiply(new BigDecimal(qtdProperty().getValue())));
        this.vlrUnitario = produtoEstoque.produtoProperty().getValue().precoVendaProperty();
//        if (BigDecimal.ZERO.compareTo(vlrUnt) != 0 || vlrUnt == null)
//            this.vlrUnitario = new SimpleObjectProperty<>(vlrUnt);
        this.vlrBruto = new SimpleObjectProperty<>(vlrUnitarioProperty().getValue()
                .multiply(new BigDecimal(qtdProperty().getValue())));
        this.vlrDesconto = new SimpleObjectProperty<>(BigDecimal.ZERO.setScale(2));
//        if (BigDecimal.ZERO.compareTo(vlrDesc) != 0 || vlrDesc == null)
//            this.vlrDesconto = new SimpleObjectProperty<>(vlrDesc);
        if (!codigoCFOP.equals(TipoCodigoCFOP.COMERCIALIZACAO))
            this.vlrDesconto = new SimpleObjectProperty<>(vlrUnitarioProperty().getValue().multiply(new BigDecimal(qtdProperty().getValue())));
        this.vlrLiquido = new SimpleObjectProperty<>(vlrBrutoProperty().getValue().subtract(vlrDescontoProperty().getValue()));
        this.estoque = produtoEstoque.qtdProperty();
        this.varejo = produtoEstoque.produtoProperty().getValue().varejoProperty();
        this.volume = new SimpleIntegerProperty(Double.valueOf(qtdProperty().doubleValue() / produtoProperty().getValue().varejoProperty().doubleValue()).intValue() + 1);
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
    @ManyToOne(fetch = FetchType.LAZY)
    public SaidaProduto getSaidaProduto() {
        return saidaProduto.get();
    }

    public void setSaidaProduto(SaidaProduto saidaProduto) {
        this.saidaProduto.set(saidaProduto);
    }

    public ObjectProperty<SaidaProduto> saidaProdutoProperty() {
        return saidaProduto;
    }

//    @Column(length = 20, nullable = false)
//    public long getIdProd() {
//        return idProd.get();
//    }
//
//    public LongProperty idProdProperty() {
//        return idProd;
//    }
//
//    public void setIdProd(long idProd) {
//        this.idProd.set(idProd);
//    }

    @Column(length = 15, nullable = false)
    public String getCodigo() {
        return codigo.get();
    }

    public void setCodigo(String codigo) {
        this.codigo.set(codigo);
    }

    public StringProperty codigoProperty() {
        return codigo;
    }

    @Column(length = 120, nullable = false)
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
    public TipoCodigoCFOP getCodigoCFOP() {
        return codigoCFOP.get();
    }

    public void setCodigoCFOP(TipoCodigoCFOP codigoCFOP) {
        this.codigoCFOP.set(codigoCFOP);
    }

    public ObjectProperty<TipoCodigoCFOP> codigoCFOPProperty() {
        return codigoCFOP;
    }

    @Column(length = 15)
    public String getLote() {
        return lote.get();
    }

    public void setLote(String lote) {
        this.lote.set(lote);
    }

    public StringProperty loteProperty() {
        return lote;
    }

    public LocalDate getDtValidade() {
        return dtValidade.get();
    }

    public void setDtValidade(LocalDate dtValidade) {
        this.dtValidade.set(dtValidade);
    }

    public ObjectProperty<LocalDate> dtValidadeProperty() {
        return dtValidade;
    }

    @Column(length = 5, nullable = false)
    public int getQtd() {
        return qtd.get();
    }

    public void setQtd(int qtd) {
        this.qtd.set(qtd);
    }

    public IntegerProperty qtdProperty() {
        return qtd;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getVlrEntrada() {
        return vlrEntrada.get();
    }

    public void setVlrEntrada(BigDecimal vlrEntrada) {
        this.vlrEntrada.set(vlrEntrada);
    }

    public ObjectProperty<BigDecimal> vlrEntradaProperty() {
        return vlrEntrada;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getVlrEntradaBruto() {
        return vlrEntradaBruto.get();
    }

    public void setVlrEntradaBruto(BigDecimal vlrEntradaBruto) {
        this.vlrEntradaBruto.set(vlrEntradaBruto);
    }

    public ObjectProperty<BigDecimal> vlrEntradaBrutoProperty() {
        return vlrEntradaBruto;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getVlrUnitario() {
        return vlrUnitario.get();
    }

    public void setVlrUnitario(BigDecimal vlrUnitario) {
        this.vlrUnitario.set(vlrUnitario);
    }

    public ObjectProperty<BigDecimal> vlrUnitarioProperty() {
        return vlrUnitario;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getVlrBruto() {
        return vlrBruto.get();
    }

    public void setVlrBruto(BigDecimal vlrBruto) {
        this.vlrBruto.set(vlrBruto);
    }

    public ObjectProperty<BigDecimal> vlrBrutoProperty() {
        return vlrBruto;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getVlrDesconto() {
        return vlrDesconto.get();
    }

    public void setVlrDesconto(BigDecimal vlrDesconto) {
        this.vlrDesconto.set(vlrDesconto);
    }

    public ObjectProperty<BigDecimal> vlrDescontoProperty() {
        return vlrDesconto;
    }

    @Transient
    public int getEstoque() {
        return estoque.get();
    }

    public void setEstoque(int estoque) {
        this.estoque.set(estoque);
    }

    public IntegerProperty estoqueProperty() {
        return estoque;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public Produto getProduto() {
        return produto.get();
    }

    public void setProduto(Produto produto) {
        this.produto.set(produto);
    }

    public ObjectProperty<Produto> produtoProperty() {
        return produto;
    }

//    @JsonIgnore
//    @Transient
//    public Long getIdProd() {
//        return produto.get().idProperty().getValue();
//    }

    @Transient
    public BigDecimal getVlrLiquido() {
        return vlrLiquido.get();
    }

    public void setVlrLiquido(BigDecimal vlrLiquido) {
        this.vlrLiquido.set(vlrLiquido);
    }

    @Transient
    public BigDecimal getValorLiquido() {
        return vlrBrutoProperty().getValue().subtract(vlrDescontoProperty().getValue());
    }

    public ObjectProperty<BigDecimal> vlrLiquidoProperty() {
        return vlrLiquido;
    }

    @Transient
    public int getVarejo() {
        return varejo.get();
    }

    public void setVarejo(int varejo) {
        this.varejo.set(varejo);
    }

    public IntegerProperty varejoProperty() {
        return varejo;
    }

    @Transient
    public int getVolume() {
        return volume.get();
    }

    public void setVolume(int volume) {
        this.volume.set(volume);
    }

    public IntegerProperty volumeProperty() {
        return volume;
    }

    @Transient
    public long getProdId() {
        return produtoProperty().getValue().idProperty().getValue();
    }

    public void setProdId(long prodId) {
        this.produtoProperty().getValue().idProperty().setValue(prodId);
    }

    //    @Override
//    public String toString() {
//        return "SaidaProdutoProduto{" +
//                "id=" + id +
////                ", saidaProduto=" + saidaProduto +
////                ", produto=" + produto +
//                ", codigo=" + codigo +
//                ", descricao=" + descricao +
//                ", codigoCFOP=" + codigoCFOP +
//                ", lote=" + lote +
//                ", dtValidade=" + dtValidade +
//                ", qtd=" + qtd +
//                ", vlrEntrada=" + vlrEntrada +
//                ", vlrEntradaBruto=" + vlrEntradaBruto +
//                ", vlrUnitario=" + vlrUnitario +
//                ", vlrBruto=" + vlrBruto +
//                ", vlrDesconto=" + vlrDesconto +
//                ", vlrLiquido=" + vlrLiquido +
//                ", estoque=" + estoque +
//                ", varejo=" + varejo +
//                ", volume=" + volume +
//                '}';
//    }

    @Override
    public String toString() {
        return "SaidaProdutoProduto{" +
                "id=" + id.getValue() +
//                ", saidaProduto=" + saidaProduto +
//                ", produto=" + produto +
                ", codigo=" + codigo.getValue() +
                ", descricao=" + descricao.getValue() +
                ", codigoCFOP=" + codigoCFOP.getValue() +
                ", lote=" + lote.getValue() +
                ", dtValidade=" + dtValidade.getValue() +
                ", qtd=" + qtd.getValue() +
                ", vlrEntrada=" + vlrEntrada.getValue() +
                ", vlrEntradaBruto=" + vlrEntradaBruto.getValue() +
                ", vlrUnitario=" + vlrUnitario.getValue() +
                ", vlrBruto=" + vlrBruto.getValue() +
                ", vlrDesconto=" + vlrDesconto.getValue() +
                ", vlrLiquido=" + vlrLiquido.getValue() +
                ", estoque=" + estoque.getValue() +
                ", varejo=" + varejo.getValue() +
                ", volume=" + volume.getValue() +
                '}';
    }
}
