package com.example.sisconledoc.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "Usuario_Afastamento")
public class UsuarioAfastamento implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "IDE_USUARIO_AFASTAMENTO", nullable = false)
  private Integer id;

  @Column(name = "DAT_INICIO", nullable = false)
  private Date dataInicio;

  @Column(name = "DAT_FIM", nullable = false)
  private Date dataFim;

  @Column(name = "DES_JUSTIFICATIVA_AFASTAMENTO")
  private String justificativa;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDE_USUARIO")
  private Usuario usuario;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDE_USUARIO_SUBSTITUTO")
  private Usuario substituto;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDE_MOTIVO_AFASTAMENTO")
  private MotivoAfastamento motivoAfastamento;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDE_GRUPO_SUBSTITUTO")
  private Grupo grupoSubstituto;

}
