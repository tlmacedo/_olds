package br.com.tlmacedo.cafeperfeito.model.vo;

import br.com.tlmacedo.cafeperfeito.model.enums.SituacaoProduto;
import br.com.tlmacedo.cafeperfeito.model.enums.UndComercialProduto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.beans.property.*;
import javafx.scene.image.Image;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Produto")
@Table(name = "produto")
public class Produto implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    private LongProperty id = new SimpleLongProperty();
    private StringProperty codigo = new SimpleStringProperty();
    private StringProperty descricao = new SimpleStringProperty();
    private ObjectProperty<BigDecimal> peso = new SimpleObjectProperty<>();
    private ObjectProperty<UndComercialProduto> unidadeComercial = new SimpleObjectProperty<>();
    private ObjectProperty<SituacaoProduto> situacao = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> precoCompra = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> precoVenda = new SimpleObjectProperty<>();
    private IntegerProperty varejo = new SimpleIntegerProperty();
    private ObjectProperty<BigDecimal> ultImpostoSefaz = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> ultFrete = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> comissao = new SimpleObjectProperty<>();

    private ObjectProperty<Usuario> usuarioCadastro = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDateTime> dtCadastro = new SimpleObjectProperty<>();
    private ObjectProperty<Usuario> usuarioAtualizacao = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDateTime> dtAtualizacao = new SimpleObjectProperty<>();


    private StringProperty nfeGenero = new SimpleStringProperty();
    private StringProperty ncm = new SimpleStringProperty();
    private StringProperty cest = new SimpleStringProperty();
    private ObjectProperty<FiscalCstOrigem> fiscalCstOrigem = new SimpleObjectProperty<>();
    private ObjectProperty<FiscalIcms> fiscalIcms = new SimpleObjectProperty<>();
    private ObjectProperty<FiscalPisCofins> fiscalPis = new SimpleObjectProperty<>();
    private ObjectProperty<FiscalPisCofins> fiscalCofins = new SimpleObjectProperty<>();

    private Blob imgProduto, imgProdutoBack;

    private IntegerProperty tblEstoque = new SimpleIntegerProperty();
    private StringProperty tblLote = new SimpleStringProperty();
    private ObjectProperty<LocalDate> tblValidade = new SimpleObjectProperty<>();

    private List<ProdutoCodigoBarra> produtoCodigoBarraList = new ArrayList<>();

    private List<ProdutoEstoque> produtoEstoqueList = new ArrayList<>();

    public Produto() {
    }


    public Produto(Produto prod) {
        this.id = new SimpleLongProperty(prod.idProperty().getValue());
        this.codigo = new SimpleStringProperty(prod.codigoProperty().getValue());
        this.descricao = new SimpleStringProperty(prod.descricaoProperty().getValue());
        this.peso = new SimpleObjectProperty<>(prod.pesoProperty().getValue());
        this.unidadeComercial = prod.unidadeComercialProperty();
        this.situacao = prod.situacaoProperty();
        this.precoCompra = new SimpleObjectProperty<>(prod.precoCompraProperty().getValue());
        this.precoVenda = new SimpleObjectProperty<>(prod.precoVendaProperty().getValue());
        this.varejo = new SimpleIntegerProperty(prod.varejoProperty().getValue());
        this.ultImpostoSefaz = new SimpleObjectProperty<>(prod.ultImpostoSefazProperty().getValue());
        this.ultFrete = new SimpleObjectProperty<>(prod.ultFreteProperty().getValue());
        this.comissao = new SimpleObjectProperty<>(prod.comissaoProperty().getValue());
        this.usuarioCadastro = new SimpleObjectProperty<>(prod.usuarioCadastroProperty().getValue());
        this.dtCadastro = new SimpleObjectProperty<>(prod.dtCadastroProperty().getValue());
        this.usuarioAtualizacao = new SimpleObjectProperty<>(prod.usuarioAtualizacaoProperty().getValue());
        this.dtAtualizacao = new SimpleObjectProperty<>(prod.dtAtualizacaoProperty().getValue());
        this.nfeGenero = new SimpleStringProperty(prod.nfeGeneroProperty().getValue());
        this.ncm = new SimpleStringProperty(prod.ncmProperty().getValue());
        this.cest = new SimpleStringProperty(prod.cestProperty().getValue());
        this.fiscalCstOrigem = new SimpleObjectProperty<>(prod.fiscalCstOrigemProperty().getValue());
        this.fiscalIcms = new SimpleObjectProperty<>(prod.fiscalIcmsProperty().getValue());
        this.fiscalPis = new SimpleObjectProperty<>(prod.fiscalPisProperty().getValue());
        this.fiscalCofins = new SimpleObjectProperty<>(prod.fiscalCofinsProperty().getValue());
//        this.imgProduto = prod.getImgProduto();
//        this.imgProdutoBack = prod.getImgProdutoBack();
        this.tblEstoque = new SimpleIntegerProperty(prod.tblEstoqueProperty().getValue());
        this.tblLote = new SimpleStringProperty(prod.tblLoteProperty().getValue());
        this.tblValidade = new SimpleObjectProperty<>(prod.tblValidadeProperty().getValue());
        this.produtoCodigoBarraList = new ArrayList<>(prod.getProdutoCodigoBarraList());
        this.produtoEstoqueList = new ArrayList<>(prod.getProdutoEstoqueList());
    }

    public Produto(ProdutoEstoque estoque) {
        this.tblEstoque = new SimpleIntegerProperty(estoque.qtdProperty().getValue());
        this.tblLote = new SimpleStringProperty(estoque.loteProperty().getValue());
        this.tblValidade = new SimpleObjectProperty<>(estoque.dtValidadeProperty().getValue());
    }

//    public Produto(Integer qtdEstoq, String lote, LocalDate validade) {
//        this.tblEstoque = new SimpleIntegerProperty(qtdEstoq);
//        this.tblLote = new SimpleStringProperty(lote);
//        this.tblValidade = new SimpleObjectProperty<>(validade);
//    }

    @Override
    public Produto clone() throws CloneNotSupportedException {
        return (Produto) super.clone();
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
        if (id == null) id = new SimpleLongProperty(0);
        return id;
    }

    @Column(length = 15, nullable = false, unique = true)
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

    @Column(length = 19, scale = 3, nullable = false)
    public BigDecimal getPeso() {
        return peso.get();
    }

    public void setPeso(BigDecimal peso) {
        this.peso.set(peso);
    }

    public ObjectProperty<BigDecimal> pesoProperty() {
        return peso;
    }

    @Enumerated(EnumType.ORDINAL)
    public UndComercialProduto getUnidadeComercial() {
        return unidadeComercial.get();
    }

    public void setUnidadeComercial(UndComercialProduto unidadeComercial) {
        this.unidadeComercial.set(unidadeComercial);
    }

    public ObjectProperty<UndComercialProduto> unidadeComercialProperty() {
        return unidadeComercial;
    }

    @Enumerated(EnumType.ORDINAL)
    public SituacaoProduto getSituacao() {
        return situacao.get();
    }

    public void setSituacao(SituacaoProduto situacao) {
        this.situacao.set(situacao);
    }

    public ObjectProperty<SituacaoProduto> situacaoProperty() {
        return situacao;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getPrecoCompra() {
        return precoCompra.get();
    }

    public void setPrecoCompra(BigDecimal precoCompra) {
        this.precoCompra.set(precoCompra);
    }

    public ObjectProperty<BigDecimal> precoCompraProperty() {
        return precoCompra;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getPrecoVenda() {
        return precoVenda.get();
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda.set(precoVenda);
    }

    public ObjectProperty<BigDecimal> precoVendaProperty() {
        return precoVenda;
    }

    @Column(length = 2, nullable = false)
    public int getVarejo() {
        return varejo.get();
    }

    public void setVarejo(int varejo) {
        this.varejo.set(varejo);
    }

    public IntegerProperty varejoProperty() {
        return varejo;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getUltImpostoSefaz() {
        return ultImpostoSefaz.get();
    }

    public void setUltImpostoSefaz(BigDecimal ultImpostoSefaz) {
        this.ultImpostoSefaz.set(ultImpostoSefaz);
    }

    public ObjectProperty<BigDecimal> ultImpostoSefazProperty() {
        return ultImpostoSefaz;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getUltFrete() {
        return ultFrete.get();
    }

    public void setUltFrete(BigDecimal ultFrete) {
        this.ultFrete.set(ultFrete);
    }

    public ObjectProperty<BigDecimal> ultFreteProperty() {
        return ultFrete;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getComissao() {
        return comissao.get();
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao.set(comissao);
    }

    public ObjectProperty<BigDecimal> comissaoProperty() {
        return comissao;
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public Usuario getUsuarioAtualizacao() {
        return usuarioAtualizacao.get();
    }

    public void setUsuarioAtualizacao(Usuario usuarioAtualizacao) {
        this.usuarioAtualizacao.set(usuarioAtualizacao);
    }

    public ObjectProperty<Usuario> usuarioAtualizacaoProperty() {
        return usuarioAtualizacao;
    }

    @UpdateTimestamp
    public LocalDateTime getDtAtualizacao() {
        return dtAtualizacao.get();
    }

    public void setDtAtualizacao(LocalDateTime dtAtualizacao) {
        this.dtAtualizacao.set(dtAtualizacao);
    }

    public ObjectProperty<LocalDateTime> dtAtualizacaoProperty() {
        return dtAtualizacao;
    }

    @Column(length = 2, nullable = false)
    public String getNfeGenero() {
        return nfeGenero.get();
    }

    public void setNfeGenero(String nfeGenero) {
        this.nfeGenero.set(nfeGenero);
    }

    public StringProperty nfeGeneroProperty() {
        return nfeGenero;
    }

    @Column(length = 8)
    public String getNcm() {
        return ncm.get();
    }

    public void setNcm(String ncm) {
        this.ncm.set(ncm);
    }

    public StringProperty ncmProperty() {
        return ncm;
    }

    @Column(length = 7)
    public String getCest() {
        return cest.get();
    }

    public void setCest(String cest) {
        this.cest.set(cest);
    }

    public StringProperty cestProperty() {
        return cest;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public FiscalCstOrigem getFiscalCstOrigem() {
        return fiscalCstOrigem.get();
    }

    public void setFiscalCstOrigem(FiscalCstOrigem fiscalCstOrigem) {
        this.fiscalCstOrigem.set(fiscalCstOrigem);
    }

    public ObjectProperty<FiscalCstOrigem> fiscalCstOrigemProperty() {
        return fiscalCstOrigem;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public FiscalIcms getFiscalIcms() {
        return fiscalIcms.get();
    }

    public void setFiscalIcms(FiscalIcms fiscalIcms) {
        this.fiscalIcms.set(fiscalIcms);
    }

    public ObjectProperty<FiscalIcms> fiscalIcmsProperty() {
        return fiscalIcms;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public FiscalPisCofins getFiscalPis() {
        return fiscalPis.get();
    }

    public void setFiscalPis(FiscalPisCofins fiscalPis) {
        this.fiscalPis.set(fiscalPis);
    }

    public ObjectProperty<FiscalPisCofins> fiscalPisProperty() {
        return fiscalPis;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public FiscalPisCofins getFiscalCofins() {
        return fiscalCofins.get();
    }

    public void setFiscalCofins(FiscalPisCofins fiscalCofins) {
        this.fiscalCofins.set(fiscalCofins);
    }

    public ObjectProperty<FiscalPisCofins> fiscalCofinsProperty() {
        return fiscalCofins;
    }

    @JsonIgnore
    @SuppressWarnings("JpaAttributeTypeInspection")
    public Blob getImgProduto() {
        return imgProduto;
    }

    public void setImgProduto(Blob imgProduto) {
        this.imgProduto = imgProduto;
    }

    @JsonIgnore
    @Transient
    @SuppressWarnings("JpaAttributeTypeInspection")
    public Blob getImgProdutoBack() {
        return imgProdutoBack;
    }

    public void setImgProdutoBack(Blob imgProdutoBack) {
        this.imgProdutoBack = imgProdutoBack;
    }

    @JsonIgnore
    @Transient
    public Image getImagemProduto() {
        return null;
//        try {
//            return ServiceImageUtil.getImageFromInputStream(getImgProduto().getBinaryStream());
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
    }

    public void setImagemProduto(Image imagemProduto) {
//        try {
//            this.imgProduto = new SerialBlob(ServiceImageUtil.getInputStreamFromImage(imagemProduto).readAllBytes());
//        } catch (SQLException | IOException e) {
//            e.printStackTrace();
//        }
    }

    @JsonIgnore
    @Transient
    public Image getImagemProdutoBack() {
        return null;
//        try {
//            return ServiceImageUtil.getImageFromInputStream(getImgProdutoBack().getBinaryStream());
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
    }

    public void setImagemProdutoBack(Image imagemProdutoBack) {
//        try {
//            this.imgProdutoBack = new SerialBlob(ServiceImageUtil.getInputStreamFromImage(imagemProdutoBack).readAllBytes());
//        } catch (SQLException | IOException e) {
//            e.printStackTrace();
//        }
    }

    @Transient
    public int getTblEstoque() {
        return tblEstoque.get();
    }

    public void setTblEstoque(int tblEstoque) {
        this.tblEstoque.set(tblEstoque);
    }

    public IntegerProperty tblEstoqueProperty() {
        return tblEstoque;
    }

    @Transient
    public String getTblLote() {
        return tblLote.get();
    }

    public void setTblLote(String tblLote) {
        this.tblLote.set(tblLote);
    }

    public StringProperty tblLoteProperty() {
        return tblLote;
    }

    @Transient
    public LocalDate getTblValidade() {
        return tblValidade.get();
    }

    public void setTblValidade(LocalDate tblValidade) {
        this.tblValidade.set(tblValidade);
    }

    public ObjectProperty<LocalDate> tblValidadeProperty() {
        return tblValidade;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<ProdutoEstoque> getProdutoEstoqueList() {
        return produtoEstoqueList;
    }

    public void setProdutoEstoqueList(List<ProdutoEstoque> produtoEstoqueList) {
        this.produtoEstoqueList = produtoEstoqueList;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<ProdutoCodigoBarra> getProdutoCodigoBarraList() {
        return produtoCodigoBarraList;
    }

    public void setProdutoCodigoBarraList(List<ProdutoCodigoBarra> produtoCodigoBarraList) {
        this.produtoCodigoBarraList = produtoCodigoBarraList;
    }

    @Transient
    @JsonIgnore
    public String getCEAN() {
        if (produtoCodigoBarraList.size() > 0)
            return produtoCodigoBarraList.get(0).getCodigoBarra();
        return "";
    }

    @Override
    public String toString() {
        return descricaoProperty().get();
    }


//    @Override
//    public String toString() {
//        return "Produto{" +
//                "id=" + id +
//                ", codigo=" + codigo +
//                ", descricao=" + descricao +
//                ", peso=" + peso +
//                ", unidadeComercial=" + unidadeComercial +
//                ", situacao=" + situacao +
//                ", precoCompra=" + precoCompra +
//                ", precoVenda=" + precoVenda +
//                ", varejo=" + varejo +
//                ", ultImpostoSefaz=" + ultImpostoSefaz +
//                ", ultFrete=" + ultFrete +
//                ", comissao=" + comissao +
//                ", usuarioCadastro=" + usuarioCadastro +
//                ", dtCadastro=" + dtCadastro +
//                ", usuarioAtualizacao=" + usuarioAtualizacao +
//                ", dtAtualizacao=" + dtAtualizacao +
//                ", nfeGenero=" + nfeGenero +
//                ", ncm=" + ncm +
//                ", cest=" + cest +
////                ", fiscalCstOrigem=" + fiscalCstOrigem +
////                ", fiscalIcms=" + fiscalIcms +
////                ", fiscalPis=" + fiscalPis +
////                ", fiscalCofins=" + fiscalCofins +
////                ", imgProduto=" + imgProduto +
////                ", imgProdutoBack=" + imgProdutoBack +
//                ", tblEstoque_id=" + tblEstoque_id +
//                ", tblEstoque=" + tblEstoque +
//                ", tblLote=" + tblLote +
//                ", tblValidade=" + tblValidade +
//                ", tblDocEntrada=" + tblDocEntrada +
////                ", produtoCodigoBarraList=" + produtoCodigoBarraList +
//                ", produtoEstoqueList=" + produtoEstoqueList +
//                '}';
//    }
}
