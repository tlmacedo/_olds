package br.com.tlmacedo.cafeperfeito.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.beans.property.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: thiagomacedo
 * Date: 2019-02-26
 * Time: 11:27
 */

@Entity(name = "EntradaProduto")
@Table(name = "entrada_produto")
//@JsonSerialize(using = EntradaProdutoSerializer.class)
//@JsonDeserialize(using = EntradaProdutoDeserializer.class)
public class EntradaProduto implements Serializable {
    private static final long serialVersionUID = 1L;

    private LongProperty id = new SimpleLongProperty();
    private IntegerProperty situacao = new SimpleIntegerProperty();

    private ObjectProperty<Empresa> loja = new SimpleObjectProperty<>();

    private ObjectProperty<Usuario> usuarioCadastro = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDateTime> dtCadastro = new SimpleObjectProperty<>(LocalDateTime.now());

    private ObjectProperty<EntradaNfe> entradaNfe = new SimpleObjectProperty<>();
    private ObjectProperty<EntradaCte> entradaCte = new SimpleObjectProperty<>();

    private List<EntradaProdutoProduto> entradaProdutoProdutoList = new ArrayList<>();

    public EntradaProduto() {
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

    @Column(length = 1, nullable = false)
    public int getSituacao() {
        return situacao.get();
    }

    public void setSituacao(int situacao) {
        this.situacao.set(situacao);
    }

    public IntegerProperty situacaoProperty() {
        return situacao;
    }

    @ManyToOne
    public Empresa getLoja() {
        return loja.get();
    }

    public void setLoja(Empresa loja) {
        this.loja.set(loja);
    }

    public ObjectProperty<Empresa> lojaProperty() {
        return loja;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

    @OneToOne(mappedBy = "entradaProduto", cascade = CascadeType.ALL, orphanRemoval = true)
    public EntradaNfe getEntradaNfe() {
        return entradaNfe.get();
    }

    public void setEntradaNfe(EntradaNfe entradaNfe) {
        this.entradaNfe.set(entradaNfe);
    }

    public ObjectProperty<EntradaNfe> entradaNfeProperty() {
        return entradaNfe;
    }

    @OneToOne(mappedBy = "entradaProduto", cascade = CascadeType.ALL, orphanRemoval = true)
    public EntradaCte getEntradaCte() {
        return entradaCte.get();
    }

    public void setEntradaCte(EntradaCte entradaCte) {
        this.entradaCte.set(entradaCte);
    }

    public ObjectProperty<EntradaCte> entradaCteProperty() {
        return entradaCte;
    }

    @OneToMany(mappedBy = "entradaProduto", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<EntradaProdutoProduto> getEntradaProdutoProdutoList() {
        return entradaProdutoProdutoList;
    }

    public void setEntradaProdutoProdutoList(List<EntradaProdutoProduto> entradaProdutoProdutoList) {
        this.entradaProdutoProdutoList = entradaProdutoProdutoList;
    }

//    @Override
//    public String toString() {
//        return "EntradaProduto{" +
//                "id=" + id +
//                ", situacao=" + situacao +
//                ", loja=" + loja +
//                ", usuarioCadastro=" + usuarioCadastro +
//                ", dtCadastro=" + dtCadastro +
//                ", entradaProdutoProdutoList=" + entradaProdutoProdutoList +
//                '}';
//    }


    @Override
    public String toString() {
        return "EntradaProduto{" +
                "id=" + id +
                ", situacao=" + situacao +
                ", loja=" + loja +
                ", usuarioCadastro=" + usuarioCadastro +
                ", dtCadastro=" + dtCadastro +
                ", entradaNfe=" + entradaNfe +
                ", entradaCte=" + entradaCte +
                ", entradaProdutoProdutoList=" + entradaProdutoProdutoList +
                '}';
    }
}
