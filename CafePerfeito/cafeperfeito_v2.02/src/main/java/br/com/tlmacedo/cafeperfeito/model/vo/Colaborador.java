package br.com.tlmacedo.cafeperfeito.model.vo;


import br.com.tlmacedo.cafeperfeito.model.dao.EmpresaDAO;
import br.com.tlmacedo.cafeperfeito.model.enums.SituacaoColaborador;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.beans.property.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.time.LocalDateTime;

@Entity(name = "Colaborador")
@Table(name = "colaborador")
@Inheritance(strategy = InheritanceType.JOINED)
public class Colaborador implements Serializable {


    private static final long serialVersionUID = 1L;

    private LongProperty id = new SimpleLongProperty();
    private StringProperty nome = new SimpleStringProperty();
    private StringProperty apelido = new SimpleStringProperty();
    private StringProperty ctps = new SimpleStringProperty();
    private ObjectProperty<LocalDateTime> dtAdmisao = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> salario = new SimpleObjectProperty<>();
    private SituacaoColaborador situacao;

    private ObjectProperty<Empresa> lojaAtivo = new SimpleObjectProperty<>();

    private Blob imagem, imagemBack;


    public Colaborador() {
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

    @Column(length = 120, nullable = false, unique = true)
    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    @Column(length = 30, nullable = false, unique = true)
    public String getApelido() {
        return apelido.get();
    }

    public void setApelido(String apelido) {
        this.apelido.set(apelido);
    }

    public StringProperty apelidoProperty() {
        return apelido;
    }

    @Column(length = 30, nullable = false, unique = true)
    public String getCtps() {
        return ctps.get();
    }

    public void setCtps(String ctps) {
        this.ctps.set(ctps);
    }

    public StringProperty ctpsProperty() {
        return ctps;
    }

    @Column(nullable = false)
    public LocalDateTime getDtAdmisao() {
        return dtAdmisao.get();
    }

    public void setDtAdmisao(LocalDateTime dtAdmisao) {
        this.dtAdmisao.set(dtAdmisao);
    }

    public ObjectProperty<LocalDateTime> dtAdmisaoProperty() {
        return dtAdmisao;
    }

    @Column(length = 19, scale = 4, nullable = false)
    public BigDecimal getSalario() {
        return salario.get();
    }

    public void setSalario(BigDecimal salario) {
        this.salario.set(salario);
    }

    public ObjectProperty<BigDecimal> salarioProperty() {
        return salario;
    }

    @Enumerated(EnumType.ORDINAL)
    public SituacaoColaborador getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoColaborador situacao) {
        this.situacao = situacao;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    public Empresa getLojaAtivo() {
        return lojaAtivoProperty().get();
    }

    public void setLojaAtivo(Empresa lojaAtivo) {
        lojaAtivoProperty().set(lojaAtivo);
    }

    public ObjectProperty<Empresa> lojaAtivoProperty() {
        if (lojaAtivo == null) lojaAtivo = new SimpleObjectProperty<>(new EmpresaDAO().getById(Empresa.class, 0L));
        return lojaAtivo;
    }

    @JsonIgnore
    @SuppressWarnings("JpaAttributeTypeInspection")
    public Blob getImagem() {
        return imagem;
    }

    public void setImagem(Blob imagem) {
        this.imagem = imagem;
    }

    @JsonIgnore
    @Transient
    public Blob getImagemBack() {
        return imagemBack;
    }

    public void setImagemBack(Blob imagemBack) {
        this.imagemBack = imagemBack;
    }


}
