package br.com.tlmacedo.cafeperfeito.model.vo;

import br.com.tlmacedo.cafeperfeito.model.dao.EmpresaDAO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.beans.property.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDateTime;

@Entity(name = "SaidaProdutoNfe")
@Table(name = "saida_produto_nfe")
public class SaidaProdutoNfe implements Serializable {
    private static final long serialVersionUID = 1L;

    private LongProperty id = new SimpleLongProperty();
    private BooleanProperty cancelada = new SimpleBooleanProperty(false);
    private ObjectProperty<SaidaProduto> saidaProduto = new SimpleObjectProperty<>();
    private StringProperty chave = new SimpleStringProperty();
    private IntegerProperty statusSefaz = new SimpleIntegerProperty();
    private IntegerProperty naturezaOperacao = new SimpleIntegerProperty();
    private IntegerProperty modelo = new SimpleIntegerProperty();
    private IntegerProperty serie = new SimpleIntegerProperty();
    private IntegerProperty numero = new SimpleIntegerProperty();
    private ObjectProperty<LocalDateTime> dtHoraEmissao = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDateTime> dtHoraSaida = new SimpleObjectProperty<>();
    private IntegerProperty destinoOperacao = new SimpleIntegerProperty();
    private IntegerProperty impressaoTpImp = new SimpleIntegerProperty();
    private IntegerProperty impressaoTpEmis = new SimpleIntegerProperty();
    private IntegerProperty impressaoFinNFe = new SimpleIntegerProperty();
    private BooleanProperty impressaoLtProduto = new SimpleBooleanProperty(false);
    private IntegerProperty consumidorFinal = new SimpleIntegerProperty();
    private IntegerProperty indicadorPresenca = new SimpleIntegerProperty();
    private IntegerProperty modFrete = new SimpleIntegerProperty();
    private ObjectProperty<Empresa> transportador;
    private StringProperty cobrancaNumero = new SimpleStringProperty();
    private IntegerProperty pagamentoIndicador = new SimpleIntegerProperty();
    private IntegerProperty pagamentoMeio = new SimpleIntegerProperty();
    private StringProperty informacaoAdicional = new SimpleStringProperty();
    private StringProperty digVal = new SimpleStringProperty();
    private ObjectProperty<Blob> xmlAssinatura = new SimpleObjectProperty<>();
    private ObjectProperty<Blob> xmlConsRecibo = new SimpleObjectProperty<>();
    private ObjectProperty<Blob> xmlProtNfe = new SimpleObjectProperty<>();

    public SaidaProdutoNfe() {
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

    public boolean isCancelada() {
        return cancelada.get();
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada.set(cancelada);
    }

    public BooleanProperty canceladaProperty() {
        return cancelada;
    }

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public SaidaProduto getSaidaProduto() {
        return saidaProduto.get();
    }

    public void setSaidaProduto(SaidaProduto saidaProduto) {
        this.saidaProduto.set(saidaProduto);
    }

    public ObjectProperty<SaidaProduto> saidaProdutoProperty() {
        return saidaProduto;
    }

    @Column(length = 47, nullable = false, unique = true)
    public String getChave() {
        return chave.get();
    }

    public void setChave(String chave) {
        this.chave.set(chave);
    }

    public StringProperty chaveProperty() {
        return chave;
    }

    @Column(length = 3, nullable = false)
    public int getStatusSefaz() {
        return statusSefaz.get();
    }

    public void setStatusSefaz(int statusSefaz) {
        this.statusSefaz.set(statusSefaz);
    }

    public IntegerProperty statusSefazProperty() {
        return statusSefaz;
    }

    @Column(length = 1, nullable = false)
    public int getNaturezaOperacao() {
        return naturezaOperacao.get();
    }

    public void setNaturezaOperacao(int naturezaOperacao) {
        this.naturezaOperacao.set(naturezaOperacao);
    }

    public IntegerProperty naturezaOperacaoProperty() {
        return naturezaOperacao;
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

    @Column(length = 3, nullable = false)
    public int getSerie() {
        return serie.get();
    }

    public void setSerie(int serie) {
        this.serie.set(serie);
    }

    public IntegerProperty serieProperty() {
        return serie;
    }

    @Column(length = 9, nullable = false)
    public int getNumero() {
        return numero.get();
    }

    public void setNumero(int numero) {
        this.numero.set(numero);
    }

    public IntegerProperty numeroProperty() {
        return numero;
    }

    @Column(nullable = false)
    public LocalDateTime getDtHoraEmissao() {
        return dtHoraEmissao.get();
    }

    public void setDtHoraEmissao(LocalDateTime dtHoraEmissao) {
        this.dtHoraEmissao.set(dtHoraEmissao);
    }

    public ObjectProperty<LocalDateTime> dtHoraEmissaoProperty() {
        return dtHoraEmissao;
    }

    @Column(nullable = false)
    public LocalDateTime getDtHoraSaida() {
        return dtHoraSaida.get();
    }

    public void setDtHoraSaida(LocalDateTime dtHoraSaida) {
        this.dtHoraSaida.set(dtHoraSaida);
    }

    public ObjectProperty<LocalDateTime> dtHoraSaidaProperty() {
        return dtHoraSaida;
    }

    @Column(length = 1, nullable = false)
    public int getDestinoOperacao() {
        return destinoOperacao.get();
    }

    public void setDestinoOperacao(int destinoOperacao) {
        this.destinoOperacao.set(destinoOperacao);
    }

    public IntegerProperty destinoOperacaoProperty() {
        return destinoOperacao;
    }

    @Column(length = 1, nullable = false)
    public int getConsumidorFinal() {
        return consumidorFinal.get();
    }

    public void setConsumidorFinal(int consumidorFinal) {
        this.consumidorFinal.set(consumidorFinal);
    }

    public IntegerProperty consumidorFinalProperty() {
        return consumidorFinal;
    }

    @Column(length = 2, nullable = false)
    public int getIndicadorPresenca() {
        return indicadorPresenca.get();
    }

    public void setIndicadorPresenca(int indicadorPresenca) {
        this.indicadorPresenca.set(indicadorPresenca);
    }

    public IntegerProperty indicadorPresencaProperty() {
        return indicadorPresenca;
    }

    @Column(length = 2, nullable = false)
    public int getModFrete() {
        return modFrete.get();
    }

    public void setModFrete(int modFrete) {
        this.modFrete.set(modFrete);
    }

    public IntegerProperty modFreteProperty() {
        return modFrete;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public Empresa getTransportador() {
        return transportadorProperty().get();
    }

    public void setTransportador(Empresa transportador) {
        transportadorProperty().set(transportador);
    }

    public ObjectProperty<Empresa> transportadorProperty() {
        if (transportador == null)
            transportador = new SimpleObjectProperty<>(new EmpresaDAO().getById(Empresa.class, 0L));
        return transportador;
    }

    @Column(length = 10, nullable = false)
    public String getCobrancaNumero() {
        return cobrancaNumero.get();
    }

    public void setCobrancaNumero(String cobrancaNumero) {
        this.cobrancaNumero.set(cobrancaNumero);
    }

    public StringProperty cobrancaNumeroProperty() {
        return cobrancaNumero;
    }

    @Column(length = 1, nullable = false)
    public int getPagamentoIndicador() {
        return pagamentoIndicador.get();
    }

    public void setPagamentoIndicador(int pagamentoIndicador) {
        this.pagamentoIndicador.set(pagamentoIndicador);
    }

    public IntegerProperty pagamentoIndicadorProperty() {
        return pagamentoIndicador;
    }

    @Column(length = 2, nullable = false)
    public int getPagamentoMeio() {
        return pagamentoMeio.get();
    }

    public void setPagamentoMeio(int pagamentoMeio) {
        this.pagamentoMeio.set(pagamentoMeio);
    }

    public IntegerProperty pagamentoMeioProperty() {
        return pagamentoMeio;
    }

    @Column(length = 5000, nullable = false)
    public String getInformacaoAdicional() {
        return informacaoAdicional.get();
    }

    public void setInformacaoAdicional(String informacaoAdicional) {
        this.informacaoAdicional.set(informacaoAdicional);
    }

    public StringProperty informacaoAdicionalProperty() {
        return informacaoAdicional;
    }

    @Column(length = 28, unique = true)
    public String getDigVal() {
        return digVal.get();
    }

    public void setDigVal(String digVal) {
        this.digVal.set(digVal);
    }

    public StringProperty digValProperty() {
        return digVal;
    }

    @JsonIgnore
    @SuppressWarnings("JpaAttributeTypeInspection")
    public Blob getXmlAssinatura() {
        return xmlAssinatura.get();
    }

    public void setXmlAssinatura(Blob xmlAssinatura) {
        this.xmlAssinatura.set(xmlAssinatura);
    }

    public ObjectProperty<Blob> xmlAssinaturaProperty() {
        return xmlAssinatura;
    }

    @JsonIgnore
    @SuppressWarnings("JpaAttributeTypeInspection")
    public Blob getXmlConsRecibo() {
        return xmlConsRecibo.get();
    }

    public void setXmlConsRecibo(Blob xmlConsRecibo) {
        this.xmlConsRecibo.set(xmlConsRecibo);
    }

    public ObjectProperty<Blob> xmlConsReciboProperty() {
        return xmlConsRecibo;
    }

    @JsonIgnore
    @SuppressWarnings("JpaAttributeTypeInspection")
    public Blob getXmlProtNfe() {
        return xmlProtNfe.get();
    }

    public void setXmlProtNfe(Blob xmlProtNfe) {
        this.xmlProtNfe.set(xmlProtNfe);
    }

    public ObjectProperty<Blob> xmlProtNfeProperty() {
        return xmlProtNfe;
    }

    @Column(length = 1, nullable = false)
    public int getImpressaoTpImp() {
        return impressaoTpImp.get();
    }

    public void setImpressaoTpImp(int impressaoTpImp) {
        this.impressaoTpImp.set(impressaoTpImp);
    }

    public IntegerProperty impressaoTpImpProperty() {
        return impressaoTpImp;
    }

    @Column(length = 1, nullable = false)
    public int getImpressaoTpEmis() {
        return impressaoTpEmis.get();
    }

    public void setImpressaoTpEmis(int impressaoTpEmis) {
        this.impressaoTpEmis.set(impressaoTpEmis);
    }

    public IntegerProperty impressaoTpEmisProperty() {
        return impressaoTpEmis;
    }

    @Column(length = 1, nullable = false)
    public int getImpressaoFinNFe() {
        return impressaoFinNFe.get();
    }

    public void setImpressaoFinNFe(int impressaoFinNFe) {
        this.impressaoFinNFe.set(impressaoFinNFe);
    }

    public IntegerProperty impressaoFinNFeProperty() {
        return impressaoFinNFe;
    }

    @Column(length = 1, nullable = false)
    public boolean isImpressaoLtProduto() {
        return impressaoLtProduto.get();
    }

    public void setImpressaoLtProduto(boolean impressaoLtProduto) {
        this.impressaoLtProduto.set(impressaoLtProduto);
    }

    public BooleanProperty impressaoLtProdutoProperty() {
        return impressaoLtProduto;
    }

    @Override
    public String toString() {
        return "SaidaProdutoNfe{" +
                "id=" + id +
                ", saidaProduto=" + saidaProduto +
                ", chave=" + chave +
                ", statusSefaz=" + statusSefaz +
                ", naturezaOperacao=" + naturezaOperacao +
                ", modelo=" + modelo +
                ", serie=" + serie +
                ", numero=" + numero +
                ", dtHoraEmissao=" + dtHoraEmissao +
                ", dtHoraSaida=" + dtHoraSaida +
                ", destinoOperacao=" + destinoOperacao +
                ", impressaoTpImp=" + impressaoTpImp +
                ", impressaoTpEmis=" + impressaoTpEmis +
                ", impressaoFinNFe=" + impressaoFinNFe +
                ", impressaoLtProduto=" + impressaoLtProduto +
                ", consumidorFinal=" + consumidorFinal +
                ", indicadorPresenca=" + indicadorPresenca +
                ", modFrete=" + modFrete +
                ", transportador=" + transportador +
                ", cobrancaNumero=" + cobrancaNumero +
                ", pagamentoIndicador=" + pagamentoIndicador +
                ", pagamentoMeio=" + pagamentoMeio +
                ", informacaoAdicional=" + informacaoAdicional +
                ", xmlAssinatura=" + xmlAssinatura +
                ", xmlProtNfe=" + xmlProtNfe +
                '}';
    }
}
