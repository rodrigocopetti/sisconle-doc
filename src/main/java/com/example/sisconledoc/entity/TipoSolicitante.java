package com.example.sisconledoc.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "TIPO_SOLICITANTE")
public class TipoSolicitante implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "IDE_TIPO_SOLICITANTE", nullable = false)
  private Integer id;

  @Column(name = "COD_TIPO_SOLICITANTE", nullable = false)
  private String codigo;

  @Column(name = "DES_TIPO_SOLICITANTE", nullable = false)
  private String descricao;

  @ManyToMany(mappedBy = "tiposDeSolicitantes")
  @OrderBy("descricao")
  private Set<TipoTrabalho> tiposDeTrabalho;

  // @Transient
  // private Boolean selecionado = false;

}
