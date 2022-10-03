package com.example.sisconledoc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MODELO_DOCUMENTO")
public class ModeloDeDocumento implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "IDE_MODELO_DOCUMENTO", nullable = false)
  private Integer id;

  @Column(name = "DES_MODELO_DOCUMENTO")
  private String descricao;

  @Column(name = "NOM_ARQUIVO")
  private String nomeArquivo;

  @Column(name = "NOM_DIRETORIO")
  private String nomeDiretorio;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDE_TIPO_TRABALHO")
  private TipoTrabalho tipoTrabalho;

  // public String getDescricao()
  // {
  // TODO comentado temporariamente
  // if (UtilModel.isEmpty(descricao))
  // {
  // return this.nomeArquivo;
  // }
  // return descricao;
  // }

  // @Transient
  // public String getExtensao()
  // {
  // int posicaoPonto = this.nomeArquivo.lastIndexOf(".");
  // return this.nomeArquivo.substring(posicaoPonto + 1);
  // }

  // @Transient
  // public String getDescricaoComSiglaTipoTrabalho() {
  // // TODO Auto-generated method stub
  // return this.getDescricao() + (getTipoTrabalho()!=null? " (" +
  // getTipoTrabalho().getSigla() + ")" : "");
  // }
}