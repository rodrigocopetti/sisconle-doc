package com.example.sisconledoc.entity;

import java.util.Calendar;

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
@Table(name = "SOLICITACAO_TRABALHO")
public class SolicitacaoTrabalho {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "IDE_SOLICITACAO_TRABALHO", nullable = false)
  private Integer id;

  @Column(name = "TEX_DETALHAMENTO", nullable = true)
  private String detalhamento;

  @Column(name = "DAT_CADASTRO", nullable = false)
  private Calendar dataCadastro;

  @Column(name = "DAT_CONCLUSAO", nullable = true)
  private Calendar dataConclusao;

  @Column(name = "DAT_RECEBIMENTO", nullable = true)
  private Calendar dataRecebimento;

  @Column(name = "DAT_DISCURSO", nullable = true)
  private Calendar dataDiscurso;

  @Column(name = "num_Ponto_Usuario_Cadastro", nullable = true)
  private String numPontoUsuarioCadastro;

  @Column(name = "nom_Usuario_Cadastro", nullable = true)
  private String nomeUsuarioCadastro;

  @Column(name = "NOM_CONTATO", nullable = true)
  private String nomeContato;

  @Column(name = "NUM_TELEFONE_CONTATO", nullable = true)
  private String telefoneContato;

  @Column(name = "DES_EMAIL_CONTATO", nullable = true)
  private String emailContato;

  @Column(name = "IND_NIVEL_ACESSO")
  private String indNivelAcesso;

  @Column(name = "IND_CONTATO_PREVIO", nullable = false)
  private Boolean indContatoPrevio;

  @Column(name = "IND_URGENCIA", nullable = false)
  private Boolean indUrgencia;

  @Column(name = "IND_ANALISE_NECESSARIA", nullable = false)
  private Boolean indAnaliseNecessaria;;

  @Column(name = "IND_CONSELHO_EDITORIAL", nullable = true)
  private Boolean indConselhoEditorial;

  @Column(name = "dat_previsao_conclusao", nullable = true)
  private Calendar dataPrevisaoConclusao;

  @Column(name = "dat_previsao_conle", nullable = true)
  private Calendar dataPrevisaoConle;

  @Column(name = "ANO_SOLICITACAO_TRABALHO", nullable = true)
  private Integer anoSolicitacaoTrabalho;

  @Column(name = "NUM_SOLICITACAO_TRABALHO", nullable = true)
  private Integer numSolicitacaoTrabalho;

  @Column(name = "ANO_SILEG", nullable = true)
  private Integer anoSileg;

  @Column(name = "NUM_SILEG", nullable = true)
  private Integer numeroSileg;

  @Column(name = "OBS_SILEG", nullable = true)
  private String observacaoSileg;

  @Column(name = "tex_Assunto_Trabalho")
  private String assunto;

  @Column(name = "tex_Orientacao_Elaboracao")
  private String orientacoesParaElaboracao;

  @Column(name = "tex_Orientacao_Edicao")
  private String orientacoesParaEdicao;

  @Column(name = "tex_Informacao_expedicao")
  private String informacaoParaExpedicao;

  @Column(name = "OBS_JUSTIFICATIVA_NAO_ACOLHIMENTO", nullable = true)
  private String observacaoJustificativaNaoRecebimento;

  @Column(name = "OBS_JUSTIFICATIVA_CANCELAMENTO ", nullable = true)
  private String observacaoJustificativaCancelamento;

  @Column(name = "IND_EXISTENCIA_ANEXO_PAPEL", nullable = false)
  private Boolean indExistenciaAnexoPapel;

  @Column(name = "IND_DEVOLUCAO_ANEXO_PAPEL", nullable = false)
  private Boolean indDevolverAnexoPapel;

  @Column(name = "IND_LIBERACAO_CONDICIONADA", nullable = true)
  private Boolean indLiberacaoCondicionada;

  @Builder.Default
  @Column(name = "IND_ENVIAR_POR_EMAIL", nullable = true)
  private Boolean indEnviarTrabalhosPorEmail = true;

  @Column(name = "IND_PRODUZIU_TRABALHO", nullable = true)
  private Boolean indProduziuTrabalho;

  @Builder.Default
  @Column(name = "IND_RESULTADO_ASSESSORAMENTO", nullable = false)
  private Boolean indResultadoAssessoramento = true;

  @Builder.Default
  @Column(name = "IND_RESULTADO_AVALIACAO")
  private Boolean indResultadoAvaliacao = true;

}
