package com.example.sisconledoc.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "Tipo_Trabalho")
public class TipoTrabalho implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "IDE_TIPO_TRABALHO", nullable = false)
  private Integer id;

  @Column(name = "DES_TIPO_TRABALHO")
  private String descricao;

  @Column(name = "IND_EXIGE_PROPOSICAO_LEGISLATIVA")
  private String indExigeProposicaoLegislativa;

  @Column(name = "IND_NIVEL_ACESSO")
  private String indNivelAcesso;

  @Column(name = "QTD_DIAS_CONCLUSAO", nullable = true)
  private Integer qtdDiasConclusao;

  @Column(name = "SIG_TIPO_PROPOSICAO", nullable = true)
  private String siglaTipoProposicao;

  @Column(name = "NOM_DIRETORIO", nullable = false)
  private String nomeDiretorio;

  @Column(name = "SIG_TIPO_TRABALHO", nullable = true)
  private String sigla;

  @Column(name = "DES_MASCARA_NOME_ARQUIVO", nullable = false)
  private String mascaraNomeArquivo;

  @Column(name = "IND_COMUM", nullable = false)
  private Boolean comum;

  @Column(name = "ind_exibicao_permissao_publicacao")
  private Boolean indPermitePublicacao;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDE_TIPO_TRABALHO_GRUPO")
  private AgrupadorTipoTrabalho agrupador;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "TIPO_TRABALHO_SOLICITANTE", joinColumns = @JoinColumn(name = "IDE_TIPO_TRABALHO"), inverseJoinColumns = @JoinColumn(name = "IDE_TIPO_SOLICITANTE"))
  @OrderBy("descricao")
  private Set<TipoSolicitante> tiposDeSolicitantes;

  @OneToMany(mappedBy = "tipoTrabalho", fetch = FetchType.LAZY)
  @OrderBy("descricao, nomeArquivo")
  private Set<ModeloDeDocumento> modelosDeDocumento;

  @Column(name = "DES_MASCARA_NOME_ARQUIVO")
  public String getMascaraNomeArquivo() {
    return mascaraNomeArquivo;
  }

  // @Transient
  // public String getDescricaoParaApresentacao() {
  // return sigla.trim() + " - " + descricao;
  // }

  // @Transient
  // public boolean isProposicaoDisponivel() {
  // if (getSiglaTipoProposicao() == null) {
  // return false;
  // }
  // return true;
  // }

  // /**
  // * Informa se um determinado tipo de trabalho exige ou n�o uma data de
  // discurso.
  // *
  // * @return
  // */
  // @Transient
  // public boolean exigeDataDeDiscurso() {

  // if (getSigla().trim().equals(Constantes.TIPO_TRABALHO_GRANDE_EXPEDIENTE)
  // || getSigla().trim().equals(Constantes.TIPO_TRABALHO_HOMENAGEM)) {
  // return true;
  // }
  // return false;

  // }

  // /**
  // * Retorna true se o TipoTrabalho da solicitacao tiver sigla igual � uma das
  // * passadas como par�metro. Retorna false
  // * caso contrario
  // *
  // * @param etapa
  // * @return
  // */
  // @Transient
  // public boolean isSiglaDesteTipoTrabalho(String... listaSiglas) {
  // try {
  // for (String sigla : listaSiglas) {
  // if (this.getSigla().equals(sigla)) {
  // return true;
  // }
  // }
  // } catch (Exception e) {
  // return false;
  // }
  // return false;
  // }

}
