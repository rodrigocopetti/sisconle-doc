package com.example.sisconledoc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "servidores_camaranet")
public class ServidorCamaranet implements Serializable {

  @Id
  @Column(name = "ALIAS", nullable = false)
  private String ponto;

  @Column(name = "exibir")
  private String nomeCompleto; // exibir;

  @Column(name = "endereco")
  private String endereco; // endereco

  @Column(name = "nome")
  private String nome; // nome;

  @Column(name = "sobrenome")
  private String sobrenome; // sobrenome;

  @Column(name = "cargo")
  private String cargo; // cargo;

  @Column(name = "telefone")
  private String telefone; // telefone;

  @Column(name = "departamento")
  private String departamento; // departamento;

  @Column(name = "cod_departamento")
  private Integer codDepartamento; // cod_departamento;

  @Column(name = "escritorio")
  private String escritorio; // escritorio;

  @Column(name = "cod_escritorio")
  private Integer codEscritorio; // cod_escritorio;

  @Column(name = "cpf")
  private String cpf; // cpf;

  @Column(name = "sig_departamento_portal")
  private String siglaDepartamentoPortal; // sig_departamento_portal;

  @Column(name = "sig_unidade_camara_portal")
  private String siglaUnidadeCamaraPortal; // sig_unidade_camara_portal;

  @Column(name = "nom_unidade_camara_portal")
  private String nomeUnidadeCamaraPortal; // nom_unidade_camara_portal;

  @Column(name = "dt_nascimento_portal")
  @Temporal(TemporalType.DATE)
  private Date dataNascimento; // dt_nascimento_portal;

  @Column(name = "dat_exercicio_portal")
  @Temporal(TemporalType.DATE)
  private Date dataExercicio; // dat_exercicio_portal;

  @Column(name = "nome_funcao_portal")
  private String nomeFuncaoComissionada; // nome_funcao_portal;

  @Column(name = "funcao_portal")
  private String funcao; // funcao_portal;

  @Column(name = "dat_nomeacao_funcao_portal")
  @Temporal(TemporalType.DATE)
  private Date dataNomeacao; // dat_nomeacao_funcao_portal

  @Column(name = "nom_cargo_efetivo_portal")
  private String nomeCargoEfetivo; // nom_cargo_efetivo_portal

  @Column(name = "desc_grupo_funcional_portal")
  private String nomeGrupoFuncional; // desc_grupo_funcional_portal;

  @Column(name = "cod_sexo")
  private String sexo; // nome_funcao_portal;

  // public String getFuncao() {

  // // O c�digo abaixo foi inclu�do em 10/11/2014 pois a view ServidoresCamaranet
  // // foi alterada e passou a apresentar
  // // os nomes das fun�oes
  // // com tra�o no lugar do zero(0).
  // if (funcao != null) {
  // funcao = funcao.replace('-', '0');
  // // Espera-se devolver algo como "FC03".
  // }

  // return funcao;
  // }

}
