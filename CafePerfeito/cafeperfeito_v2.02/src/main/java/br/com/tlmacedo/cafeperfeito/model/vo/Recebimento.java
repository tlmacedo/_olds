package br.com.tlmacedo.cafeperfeito.model.vo;

import br.com.tlmacedo.cafeperfeito.model.enums.PagamentoModalidade;
import br.com.tlmacedo.cafeperfeito.model.enums.PagamentoSituacao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.beans.property.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Recebimento")
@Table(name = "recebimento")
public class Recebimento implements Serializable {
    private static final long serialVersionUID = 1L;

    private LongProperty id = new SimpleLongProperty();
    private ObjectProperty<ContasAReceber> contasAReceber = new SimpleObjectProperty<>();
    private ObjectProperty<PagamentoSituacao> pagamentoSituacao = new SimpleObjectProperty<>();
    private StringProperty documento = new SimpleStringProperty();
    private ObjectProperty<PagamentoModalidade> pagamentoModalidade = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> valor = new SimpleObjectProperty<>();

    private ObjectProperty<Usuario> usuarioPagamento = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> dtPagamento = new SimpleObjectProperty<>();

    private ObjectProperty<Usuario> usuarioCadastro = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDateTime> dtCadastro = new SimpleObjectProperty<>();

    private ObjectProperty<Empresa> emissorRecibo = new SimpleObjectProperty<>();

    public Recebimento() {
    }

    public Recebimento(ContasAReceber contasAReceber) {
        this.contasAReceber = new SimpleObjectProperty<>(contasAReceber);
        this.pagamentoSituacao = new SimpleObjectProperty<>(PagamentoSituacao.PENDENTE);
        this.documento = new SimpleStringProperty("");
        this.pagamentoModalidade = new SimpleObjectProperty<>(PagamentoModalidade.DINHEIRO);
        this.valor = new SimpleObjectProperty<>(
                contasAReceber.valorProperty().getValue()
                        .subtract(contasAReceber.getRecebimentoList().stream()
                                .map(Recebimento::getValor).reduce(BigDecimal.ZERO, BigDecimal::add))
        );
        this.usuarioPagamento = new SimpleObjectProperty<>(UsuarioLogado.getUsuario());
        this.dtPagamento = new SimpleObjectProperty<>(contasAReceber.dtVencimentoProperty().getValue());
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
    public ContasAReceber getContasAReceber() {
        return contasAReceber.get();
    }

    public void setContasAReceber(ContasAReceber contasAReceber) {
        this.contasAReceber.set(contasAReceber);
    }

    public ObjectProperty<ContasAReceber> contasAReceberProperty() {
        return contasAReceber;
    }

    @Enumerated(EnumType.ORDINAL)
    public PagamentoSituacao getPagamentoSituacao() {
        return pagamentoSituacao.get();
    }

    public void setPagamentoSituacao(PagamentoSituacao pagamentoSituacao) {
        this.pagamentoSituacao.set(pagamentoSituacao);
    }

    public ObjectProperty<PagamentoSituacao> pagamentoSituacaoProperty() {
        return pagamentoSituacao;
    }

    @Column(length = 18, nullable = false)
    public String getDocumento() {
        return documento.get();
    }

    public void setDocumento(String documento) {
        this.documento.set(documento);
    }

    public StringProperty documentoProperty() {
        return documento;
    }

    @Enumerated(EnumType.ORDINAL)
    public PagamentoModalidade getPagamentoModalidade() {
        return pagamentoModalidade.get();
    }

    public void setPagamentoModalidade(PagamentoModalidade pagamentoModalidade) {
        this.pagamentoModalidade.set(pagamentoModalidade);
    }

    public ObjectProperty<PagamentoModalidade> pagamentoModalidadeProperty() {
        return pagamentoModalidade;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getValor() {
        return valor.get();
    }

    public void setValor(BigDecimal valor) {
        this.valor.set(valor);
    }

    public ObjectProperty<BigDecimal> valorProperty() {
        return valor;
    }

    @JsonIgnore
    @ManyToOne
    public Usuario getUsuarioPagamento() {
        return usuarioPagamento.get();
    }

    public void setUsuarioPagamento(Usuario usuarioPagamento) {
        this.usuarioPagamento.set(usuarioPagamento);
    }

    public ObjectProperty<Usuario> usuarioPagamentoProperty() {
        return usuarioPagamento;
    }

    public LocalDate getDtPagamento() {
        return dtPagamento.get();
    }

    public void setDtPagamento(LocalDate dtPagamento) {
        this.dtPagamento.set(dtPagamento);
    }

    public ObjectProperty<LocalDate> dtPagamentoProperty() {
        return dtPagamento;
    }

    @JsonIgnore
    @ManyToOne
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
    public LocalDateTime getDtCadastro() {
        return dtCadastro.get();
    }

    public void setDtCadastro(LocalDateTime dtCadastro) {
        this.dtCadastro.set(dtCadastro);
    }

    public ObjectProperty<LocalDateTime> dtCadastroProperty() {
        return dtCadastro;
    }

    @Transient
    @JsonIgnore
    public Empresa getEmissorRecibo() {
        return emissorRecibo.get();
    }

    public void setEmissorRecibo(Empresa emissorRecibo) {
        this.emissorRecibo.set(emissorRecibo);
    }

    public ObjectProperty<Empresa> emissorReciboProperty() {
        return emissorRecibo;
    }

    @Override
    public String toString() {
        return "Recebimento{" +
                "id=" + id +
//                ", contasAReceber=" + contasAReceber +
                ", pagamentoSituacao=" + pagamentoSituacao +
                ", documento=" + documento +
                ", pagamentoModalidade=" + pagamentoModalidade +
                ", valor=" + valor +
                ", usuarioPagamento=" + usuarioPagamento +
                ", dtPagamento=" + dtPagamento +
                ", usuarioCadastro=" + usuarioCadastro +
                ", dtCadastro=" + dtCadastro +
                ", emissorRecibo=" + emissorRecibo +
                '}';
    }
}
