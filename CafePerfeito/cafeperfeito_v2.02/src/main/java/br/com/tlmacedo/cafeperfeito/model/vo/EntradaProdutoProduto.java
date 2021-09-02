package br.com.tlmacedo.cafeperfeito.model.vo;

import br.com.tlmacedo.cafeperfeito.model.enums.TipoCodigoCFOP;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.beans.property.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA.
 * User: thiagomacedo
 * Date: 2019-03-02
 * Time: 11:47
 */

@Entity(name = "EntradaProdutoProduto")
@Table(name = "entrada_produto_produto")
public class EntradaProdutoProduto implements Serializable {
    private static final long serialVersionUID = 1L;

    private LongProperty id = new SimpleLongProperty();
    private ObjectProperty<EntradaProduto> entradaProduto = new SimpleObjectProperty<>();
    private ObjectProperty<Produto> produto = new SimpleObjectProperty<>();
    private StringProperty codigo = new SimpleStringProperty();
    private StringProperty descricao = new SimpleStringProperty();
    private ObjectProperty<TipoCodigoCFOP> codigoCFOP = new SimpleObjectProperty<>();
    private StringProperty lote = new SimpleStringProperty();
    private ObjectProperty<LocalDate> dtValidade = new SimpleObjectProperty<>();

    private IntegerProperty qtd = new SimpleIntegerProperty();
    private ObjectProperty<BigDecimal> vlrUnitario = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> vlrBruto = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> vlrDesconto = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> vlrFrete = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> vlrImposto = new SimpleObjectProperty<>();

    private ObjectProperty<BigDecimal> vlrLiquido = new SimpleObjectProperty<>();
    private IntegerProperty estoque = new SimpleIntegerProperty();
    private IntegerProperty varejo = new SimpleIntegerProperty();
    private IntegerProperty volume = new SimpleIntegerProperty();

    public EntradaProdutoProduto() {
    }

    public EntradaProdutoProduto(Produto produto, TipoCodigoCFOP codigoCFOP) {
        this.produto = new SimpleObjectProperty<>(produto);
        this.codigo = getProduto().codigoProperty();
        this.descricao = getProduto().descricaoProperty();
        this.codigoCFOP = new SimpleObjectProperty<>(codigoCFOP);
        this.lote = new SimpleStringProperty("");
        this.dtValidade = new SimpleObjectProperty<>(LocalDate.now());
        this.qtd = new SimpleIntegerProperty(1);

        this.vlrUnitario = new SimpleObjectProperty<>(getProduto().precoCompraProperty().getValue());
        this.vlrBruto = new SimpleObjectProperty<>(vlrUnitarioProperty().getValue().multiply(BigDecimal.valueOf(qtdProperty().getValue())));
        this.vlrDesconto = new SimpleObjectProperty<>(BigDecimal.ZERO.setScale(2));
//        if (!codigoCFOP.equals(TipoCodigoCFOP.COMERCIALIZACAO)) {
//            this.vlrDesconto = new SimpleObjectProperty<>(vlrVendaProperty().getValue().multiply(BigDecimal.valueOf(qtdProperty().getValue())));
//        }
        this.vlrFrete = new SimpleObjectProperty<>(BigDecimal.ZERO);
        this.vlrImposto = new SimpleObjectProperty<>(BigDecimal.ZERO.setScale(2));
        this.vlrLiquido = new SimpleObjectProperty<>(vlrBrutoProperty().getValue().subtract(vlrDescontoProperty().getValue()));
        this.estoque = getProduto().tblEstoqueProperty();
        this.varejo = getProduto().varejoProperty();
        this.volume = new SimpleIntegerProperty(1);
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
    public EntradaProduto getEntradaProduto() {
        return entradaProduto.get();
    }

    public void setEntradaProduto(EntradaProduto entradaProduto) {
        this.entradaProduto.set(entradaProduto);
    }

    public ObjectProperty<EntradaProduto> entradaProdutoProperty() {
        return entradaProduto;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    public Produto getProduto() {
        return produto.get();
    }

    public void setProduto(Produto produto) {
        this.produto.set(produto);
    }

    public ObjectProperty<Produto> produtoProperty() {
        return produto;
    }

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

    @Column(length = 15, nullable = false)
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

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getVlrFrete() {
        return vlrFrete.get();
    }

    public void setVlrFrete(BigDecimal vlrFrete) {
        this.vlrFrete.set(vlrFrete);
    }

    public ObjectProperty<BigDecimal> vlrFreteProperty() {
        return vlrFrete;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getVlrImposto() {
        return vlrImposto.get();
    }

    public void setVlrImposto(BigDecimal vlrImposto) {
        this.vlrImposto.set(vlrImposto);
    }

    public ObjectProperty<BigDecimal> vlrImpostoProperty() {
        return vlrImposto;
    }

    @Transient
    @JsonIgnore
    public BigDecimal getVlrLiquido() {
        return vlrLiquido.get();
    }

    public void setVlrLiquido(BigDecimal vlrLiquido) {
        this.vlrLiquido.set(vlrLiquido);
    }

    public ObjectProperty<BigDecimal> vlrLiquidoProperty() {
        return vlrLiquido;
    }

    @Transient
    @JsonIgnore
    public int getEstoque() {
        return estoque.get();
    }

    public void setEstoque(int estoque) {
        this.estoque.set(estoque);
    }

    public IntegerProperty estoqueProperty() {
        return estoque;
    }

    @Transient
    @JsonIgnore
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
    @JsonIgnore
    public int getVolume() {
        return volume.get();
    }

    public void setVolume(int volume) {
        this.volume.set(volume);
    }

    public IntegerProperty volumeProperty() {
        return volume;
    }

    @JsonIgnore
    @Transient
    public Long getIdProd() {
        return produto.get().idProperty().getValue();
    }

    @Override
    public String toString() {
        return "EntradaProdutoProduto{" +
                "id=" + id +
//                ", entradaProduto=" + entradaProduto +
                ", produto=" + produto +
                ", codigo=" + codigo +
                ", descricao=" + descricao +
                ", codigoCFOP=" + codigoCFOP +
                ", lote=" + lote +
                ", dtValidade=" + dtValidade +
                ", qtd=" + qtd +
                ", vlrUnitario=" + vlrUnitario +
                ", vlrBruto=" + vlrBruto +
                ", vlrDesconto=" + vlrDesconto +
                ", vlrFrete=" + vlrFrete +
                ", vlrImposto=" + vlrImposto +
                ", vlrLiquido=" + vlrLiquido +
//                ", estoque=" + estoque +
                ", varejo=" + varejo +
                ", volume=" + volume +
                '}';
    }
}
