package com.example.sisconledoc.entity;

import java.io.Serializable;

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
@Table(name = "Motivo_Afastamento")
public class MotivoAfastamento implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "IDE_MOTIVO_AFASTAMENTO")
  private Integer id;

  @Column(name = "DES_MOTIVO_AFASTAMENTO")
  private String descricao;

  /**
   * Indica se o motivo de afastamento tem a op��o de exibir um campo de texto
   * aberto
   */
  @Column(name = "IND_JUSTIFICATIVA_AFASTAMENTO", nullable = false)
  private Boolean indJustificativaAfastamento = new Boolean(false);

}
