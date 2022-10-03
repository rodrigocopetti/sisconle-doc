package com.example.sisconledoc.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GRUPO")
public class Grupo implements java.io.Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "IDE_GRUPO", nullable = false)
  private Integer id;

  @Column(name = "DES_GRUPO", nullable = false)
  private String descricao;

  @Column(name = "DES_SIGLA_GRUPO", nullable = false)
  private String sigla;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "IDE_PERFIL_ACESSO")
  private Perfil perfil;

  @ManyToMany(targetEntity = Usuario.class, mappedBy = "grupos")
  @OrderBy("ponto")
  private Set<Usuario> usuarios;

  @Column(name = "num_ordenacao", nullable = false)
  private Integer ordenacao;

  // @Transient
  // public String getDescricaoCompleta()
  // {
  // return getDescricaoCompleta(true);
  // }

  // @Transient
  // public String getDescricaoCompleta(boolean abreviar)
  // {

  // // como a descricao de algumas �reas � muito grande, ela � reduzida por conta
  // de espa�o dispon�vel na tela
  // String descricao = this.getDescricao();
  // if (abreviar) {
  // if (this.getPerfil().getDescricao().startsWith("Coor") && descricao.length()
  // > 37)
  // {
  // descricao = descricao.substring(0, 37) + "...";
  // }
  // else if (this.getPerfil().getDescricao().startsWith("Cons") &&
  // descricao.length() > 48)
  // {
  // descricao = descricao.substring(0, 48) + "...";
  // }
  // }
  // return this.getSigla() + " - " + descricao + " - " +
  // this.getPerfil().getDescricao() + " ";
  // }

  // @Transient
  // public String getSiglaComDescricao()
  // {
  // if (this.getSigla() == null)
  // {
  // return this.getDescricao();
  // }
  // else
  // {
  // return this.getSigla() + "-" + this.getDescricao();
  // }

  // }

  // @Transient
  // public List<Usuario> getUsuariosAtivos()
  // {

  // List<Usuario> ativos = new ArrayList<Usuario>();
  // if (usuarios == null || usuarios.isEmpty()) return ativos;

  // for (Usuario u : usuarios)
  // {
  // if (u.getAtivo().equals("1"))
  // {
  // ativos.add(u);
  // }
  // }

  // return ativos;
  // }

}