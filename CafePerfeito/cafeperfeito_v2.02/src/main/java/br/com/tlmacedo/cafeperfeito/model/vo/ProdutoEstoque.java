package br.com.tlmacedo.cafeperfeito.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.beans.property.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name = "ProdutoEstoque")
@Table(name = "produto_estoque")
public class ProdutoEstoque implements Serializable {
    private static final long serialVersionUID = 1L;

    private LongProperty id = new SimpleLongProperty();
    private ObjectProperty<Produto> produto = new SimpleObjectProperty<>();
    private IntegerProperty qtd = new SimpleIntegerProperty();
    private StringProperty lote = new SimpleStringProperty();
    private ObjectProperty<LocalDate> dtValidade = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> vlrUnitario = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> vlrDesconto = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> vlrFrete = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> vlrImposto = new SimpleObjectProperty<>();

    private ObjectProperty<Usuario> usuarioCadastro = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDateTime> dtCadastro = new SimpleObjectProperty<>();

    private StringProperty docEntrada = new SimpleStringProperty();
    private StringProperty docEntradaChaveNFe = new SimpleStringProperty();

    public ProdutoEstoque() {
    }

    public ProdutoEstoque(List<ProdutoEstoque> estoqueList) {
        this.id = new SimpleLongProperty(0);
        this.produto = estoqueList.get(0).produtoProperty();
        this.qtd = new SimpleIntegerProperty(estoqueList.stream().collect(Collectors.summingInt(ProdutoEstoque::getQtd)));
        this.lote = estoqueList.get(0).loteProperty();
        this.dtValidade = estoqueList.get(0).dtValidadeProperty();
        this.vlrUnitario = estoqueList.get(0).vlrUnitarioProperty();
        this.vlrDesconto = estoqueList.get(0).vlrDescontoProperty();
        this.vlrFrete = estoqueList.get(0).vlrFreteProperty();
        this.vlrImposto = estoqueList.get(0).vlrImpostoProperty();
        this.usuarioCadastro = estoqueList.get(0).usuarioCadastroProperty();
        this.dtCadastro = estoqueList.get(0).dtCadastroProperty();
        this.docEntrada = estoqueList.get(0).docEntradaProperty();
        this.docEntradaChaveNFe = estoqueList.get(0).docEntradaChaveNFeProperty();
    }

    public ProdutoEstoque(EntradaProdutoProduto entradaProdutoProduto) {
        this.produto = entradaProdutoProduto.produtoProperty();
        this.qtd = entradaProdutoProduto.qtdProperty();
        this.lote = entradaProdutoProduto.loteProperty();
        this.dtValidade = entradaProdutoProduto.dtValidadeProperty();
        this.vlrUnitario = entradaProdutoProduto.vlrUnitarioProperty();
        if (produtoProperty().getValue().precoCompraProperty().getValue().compareTo(vlrUnitarioProperty().getValue()) != 0) //{
            calculaNovoPrecoVenda();
//        } else if (produtoProperty().getValue().precoCompraProperty().getValue().compareTo(vlrUnitarioProperty().getValue()) > 0) {
//            setAlertMensagem(new ServiceAlertMensagem());
//            getAlertMensagem().setCabecalho("Pre??o diferente");
//            getAlertMensagem().setContentText("Pre??o de compra est?? menor que o do cadastro;\ndeseja abaixar o pre??o de venda para manter a mesma margem?");
//            ButtonType retorno = getAlertMensagem().alertYesNoCancel().get();
//            if (retorno == ButtonType.YES) {
//                calculaNovoPrecoVenda();
//            } else if (retorno == ButtonType.NO) {
//                produtoProperty().getValue().precoCompraProperty().setValue(vlrUnitarioProperty().getValue());
//            }
//        }

        this.vlrDesconto = new SimpleObjectProperty<>(entradaProdutoProduto.vlrDescontoProperty().getValue()
                .divide(new BigDecimal(getQtd()), RoundingMode.HALF_UP));
        this.vlrFrete = new SimpleObjectProperty<>(entradaProdutoProduto.vlrFreteProperty().getValue()
                .divide(new BigDecimal(getQtd()), RoundingMode.HALF_UP));
        this.vlrImposto = new SimpleObjectProperty<>(entradaProdutoProduto.vlrImpostoProperty().getValue()
                .divide(new BigDecimal(getQtd()), RoundingMode.HALF_UP));
        this.usuarioCadastro = UsuarioLogado.usuarioProperty();
        this.docEntrada = entradaProdutoProduto.entradaProdutoProperty().getValue()
                .getEntradaNfe().numeroProperty();
        this.docEntradaChaveNFe = entradaProdutoProduto.entradaProdutoProperty().getValue()
                .getEntradaNfe().chaveProperty();
        entradaProdutoProduto.produtoProperty().getValue()
                .ultFreteProperty().setValue(vlrFreteProperty().getValue());
        entradaProdutoProduto.produtoProperty().getValue()
                .ultImpostoSefazProperty().setValue(vlrImpostoProperty().getValue());
    }

    private void calculaNovoPrecoVenda() {
        BigDecimal margem = produtoProperty().getValue().precoVendaProperty().getValue()
                .divide(produtoProperty().getValue().precoCompraProperty().getValue(), 4, RoundingMode.HALF_UP);
        produtoProperty().getValue().precoCompraProperty().setValue(vlrUnitarioProperty().getValue());
        produtoProperty().getValue().precoVendaProperty().setValue(vlrUnitarioProperty().getValue()
                .multiply(margem).setScale(4, RoundingMode.HALF_UP));
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
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Produto getProduto() {
        return produto.get();
    }

    public void setProduto(Produto produto) {
        this.produto.set(produto);
    }

    public ObjectProperty<Produto> produtoProperty() {
        return produto;
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public Usuario getUsuarioCadastro() {
        return usuarioCadastro.get();
    }

    public void setUsuarioCadastro(Usuario usuarioCadastro) {
        this.usuarioCadastro.set(usuarioCadastro);
    }

    public ObjectProperty<Usuario> usuarioCadastroProperty() {
        return usuarioCadastro;
    }

    @CreationTimestamp
    @Column(nullable = false)
    public LocalDateTime getDtCadastro() {
        return dtCadastro.get();
    }

    public void setDtCadastro(LocalDateTime dtCadastro) {
        this.dtCadastro.set(dtCadastro);
    }

    public ObjectProperty<LocalDateTime> dtCadastroProperty() {
        return dtCadastro;
    }

    @Column(length = 15, nullable = false)
    public String getDocEntrada() {
        return docEntrada.get();
    }

    public void setDocEntrada(String docEntrada) {
        this.docEntrada.set(docEntrada);
    }

    public StringProperty docEntradaProperty() {
        return docEntrada;
    }

    @Column(length = 44, nullable = false)
    public String getDocEntradaChaveNFe() {
        return docEntradaChaveNFe.get();
    }

    public void setDocEntradaChaveNFe(String docEntradaChaveNFe) {
        this.docEntradaChaveNFe.set(docEntradaChaveNFe);
    }

    public StringProperty docEntradaChaveNFeProperty() {
        return docEntradaChaveNFe;
    }

    @Override
    public String toString() {
        return "ProdutoEstoque{" +
                "id=" + id +
                ", produto=" + produto +
                ", qtd=" + qtd +
                ", lote=" + lote +
                ", dtValidade=" + dtValidade +
                ", vlrUnitario=" + vlrUnitario +
                ", vlrDesconto=" + vlrDesconto +
                ", vlrFrete=" + vlrFrete +
                ", vlrImposto=" + vlrImposto +
                ", usuarioCadastro=" + usuarioCadastro +
                ", dtCadastro=" + dtCadastro +
                ", docEntrada=" + docEntrada +
                ", docEntradaChaveNFe=" + docEntradaChaveNFe +
                '}';
    }
}
