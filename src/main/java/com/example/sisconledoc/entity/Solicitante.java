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
@Table(name = "SOLICITANTE")
public class Solicitante implements Serializable {

  // public static String TIPOSOLICITANTE = "tipoSolicitante";

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "IDE_SOLICITANTE", nullable = false)
  private Integer id;

  @Column(name = "DES_SOLICITANTE")
  private String nome;

  @Column(name = "DES_SIGLA")
  private String sigla;

  @Column(name = "SIG_PARTIDO_POLITICO_DEPUTADO", nullable = true)
  private String legenda;

  @Column(name = "SIG_UF_PARTIDO_POLITICO_DEPUTADO", nullable = true)
  private String uf;

  // IdeCadastroSileg � a coluna que guarda o id �nico do deputado, no Sileg.
  // Tamb�m guardar� o codOrgao equivalente ao do sileg
  // (vwProposicoesEmentasOrgao)
  // para Comiss�es.
  @Column(name = "IDE_CADASTRO_DEPUTADO", nullable = true)
  private Integer ideCadastroSileg;

  @Column(name = "ind_ativo", nullable = false)
  private Boolean ativo = new Boolean(true);

  @Column(name = "NUM_RAMAL", nullable = true)
  private String numRamal;

  @Column(name = "DES_EMAIL", nullable = true)
  private String email;

  @Column(name = "DES_GABINETE_SALA", nullable = true)
  private String gabinete;

  @Column(name = "DES_ANEXO", nullable = true)
  private String anexo;

  @Column(name = "DES_COMPLEMENTO_ENDERECO", nullable = true)
  private String complemento;

  @Column(name = "URL")
  private String url;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "IDE_TIPO_SOLICITANTE")
  private TipoSolicitante tipoSolicitante;

  // /**
  // * Constroi um objeto com os atributos passados pelo par�metro
  // *
  // * @param depSolicitante
  // */
  // public Solicitante(DeputadoSolicitante depSolicitante)
  // {
  // this.setAnexo(depSolicitante.getDeputado().getPredioGabinete());
  // this.setComplemento(depSolicitante.getDeputado().getDescricaoPredioGabinete());
  // this.setEmail(depSolicitante.getDeputado().getEmail());
  // this.setGabinete(depSolicitante.getDeputado().getNumeroGabinete());
  // this.setIdeCadastroSileg(new
  // Integer(depSolicitante.getDeputado().getIdeCadastro()));
  // this.setLegenda(depSolicitante.getDeputado().getPartido().getSigla());
  // this.setNome(depSolicitante.getDeputado().getNome());
  // this.setNumRamal(depSolicitante.getDeputado().getRamal());
  // this.setTipoSolicitante(new
  // TipoSolicitante(Constantes.TIPO_SOLICITANTE_DEPUTADO));
  // this.setUf(depSolicitante.getDeputado().getUf());
  // this.setAtivo(new Boolean(true));
  // }

  // public String getNome()
  // {

  // if (!UtilModel.isEmpty(nome))
  // {
  // return UtilModel.formataCaixaTexto(nome);
  // }
  // return nome;
  // }

  // public String getEmail() {
  // if (this.getTipoSolicitante() == null)
  // return "";
  // // Se tem cadastro Sileg, � deputado. Nesse caso, h� um tratamento de email:
  // if (this.getTipoSolicitante().equals(Constantes.TIPO_SOLICITANTE_DEPUTADO) &&
  // email != null
  // && !email.contains("gab.")) {
  // // adicionar o email do gabinete:
  // try {
  // String emailGabinete = email.toLowerCase().replace("dep.", "gab.");
  // if (!email.equals(emailGabinete)) {
  // this.email = email + "; " + emailGabinete;
  // }
  // } catch (NullPointerException np) {
  // this.email = "n�o cadastrado";
  // }
  // // se o email n�o contiver o sufixo (indicado pelo @), � adicionado
  // if (!email.contains("@")) {
  // StringBuffer buffer = new StringBuffer();
  // StringTokenizer token = new StringTokenizer(email, ";");
  // while (token.hasMoreTokens()) {
  // buffer.append(token.nextToken());
  // buffer.append("@camara.leg.br;");
  // }
  // email = buffer.toString();
  // }
  // }
  // return email;
  // }

  // @Transient
  // public boolean isDeputado() {
  // return
  // (getTipoSolicitante().getCodigo().equals(Constantes.TIPO_SOLICITANTE_DEPUTADO));
  // }

  // @Transient
  // public boolean isLideranca() {
  // return
  // (getTipoSolicitante().getCodigo().equals(Constantes.TIPO_SOLICITANTE_LIDERANCA));
  // }

  // public boolean isComissao() {

  // if (getTipoSolicitante() == null || getTipoSolicitante().getCodigo() == null)
  // return false;

  // if
  // (getTipoSolicitante().getCodigo().equals(Constantes.TIPO_SOLICITANTE_COMISSAO))
  // {
  // return true;
  // }
  // if
  // (getTipoSolicitante().getCodigo().equals(Constantes.TIPO_SOLICITANTE_COMISSAO_ESPECIAL))
  // {
  // return true;
  // }
  // if
  // (getTipoSolicitante().getCodigo().equals(Constantes.TIPO_SOLICITANTE_COMISSAO_EXTERNA))
  // {
  // return true;
  // }
  // if
  // (getTipoSolicitante().getCodigo().equals(Constantes.TIPO_SOLICITANTE_COMISSAO_MISTA))
  // {
  // return true;
  // }
  // if
  // (getTipoSolicitante().getCodigo().equals(Constantes.TIPO_SOLICITANTE_COMISSAO_PARLAMENTAR_INQUERITO))
  // {
  // return true;
  // }

  // return false;
  // }

}
