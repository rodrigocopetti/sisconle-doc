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
@Table(name = "TIPO_TRABALHO_GRUPO")
public class AgrupadorTipoTrabalho implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "IDE_TIPO_trabalho_grupo", nullable = false)
  private Integer id;

  @Column(name = "DES_TIPO_TRABALHO_GRUPO", nullable = false)
  private String descricao;

}
