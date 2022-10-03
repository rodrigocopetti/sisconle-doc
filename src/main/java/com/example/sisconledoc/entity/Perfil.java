package com.example.sisconledoc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "PERFIL_ACESSO")
public class Perfil implements java.io.Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "IDE_PERFIL_ACESSO", nullable = false)
  private Integer id;

  @Column(name = "DES_PERFIL_ACESSO", nullable = false)
  private String descricao;

  @Column(name = "IND_PERFIL_FUNCIONAL", nullable = false)
  private Boolean indPerfilFuncional;

}