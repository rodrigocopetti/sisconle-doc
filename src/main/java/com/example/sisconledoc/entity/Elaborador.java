package com.example.sisconledoc.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
@Table(name = "COLABORADOR_SOLICITACAO_TRABALHO")
public class Elaborador implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "IDE_COLABORADOR_SOLICITACAO_TRABALHO", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDE_USUARIO")
  private Usuario usuario;

  @Column(name = "DAT_inclusao", nullable = true)
  private Calendar dataCriacao;

  @Column(name = "DAT_exclusao", nullable = true)
  private Calendar dataExclusao;

  @Column(name = "DAT_FIM_ELABORACAO", nullable = true)
  private Calendar dataConclusao;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDE_EQUIPE_SOLICITACAO_TRABALHO")
  @NotFound(action = NotFoundAction.IGNORE)
  private Equipe equipe;

  @Column(name = "ind_responsavel", nullable = false)
  private Boolean responsavel;

  // @ManyToOne(fetch = FetchType.EAGER)
  // @JoinColumn(name = "IDE_TIPO_ETAPA_ELABORACAO")
  // private TipoEtapaElaboracao etapaElaboracao;

  @Column(name = "tex_Orientacoes_Elaboracao")
  private String orientacoesParaElaboracao;

  // public Elaborador() {

  // }

  // public Elaborador(Usuario usuario) {
  // this.usuario = usuario;
  // }

  // public TipoEtapaElaboracao getEtapaElaboracao()
  // {
  // return etapaElaboracao;
  // }

  // public void setEtapaElaboracao(TipoEtapaElaboracao etapaElaboracao)
  // {
  // this.etapaElaboracao = etapaElaboracao;
  // }

  // public String getAtrasos()
  // {

  // Integer dias = getEtapaElaboracao().getDiasPrazo();

  // // logger.info("Solicitacao: " + getSolicitacaoTrabalho().getId() +
  // // " com TipoEtapa: " + getTipoEtapa());
  // // logger.info("Dias de prazo: " + dias);

  // Calendar dataLimite = (Calendar) getDataCriacao().clone();

  // if (getEtapaElaboracao().equals(Constantes.ETAPA_ELABORACAO_EM_ELABORACAO))
  // {
  // // Para etapa de elabora��o de trabalho, o prazo a ser considerado
  // // � a previs�o de conclusao, informada na distribui��o:
  // dataLimite = getEquipe().getSolicitacaoTrabalho().getDataPrevisaoConclusao();
  // if (dataLimite == null)
  // {
  // return (Constantes.DESCRICAO_PRAZO_SEM_PRAZO_FIXO);
  // }
  // // Se etapa n�o foi conclu�da:
  // if
  // (getEtapaElaboracao().getId().compareTo(Constantes.iETAPA_ELABORACAO_PRONTO_PARA_CONSOLIDACAO)
  // < 0)
  // {
  // // Se a data limite j� passou, ent�o est� atrasado:
  // if (dataLimite.before(Calendar.getInstance()))
  // {
  // return Constantes.DESCRICAO_PRAZO_ATRASADO;
  // }
  // else
  // {
  // // Se n�o, ainda est� no prazo:
  // return Constantes.DESCRICAO_PRAZO_NO_PRAZO;
  // }
  // }
  // else
  // {
  // // Se j� concluiu etapa, ver se concluiu com atraso ou no prazo:
  // // if (dataLimite.before(getFimEtapa())) {
  // // return Constantes.DESCRICAO_PRAZO_CONCLUIDO_COM_ATRASO;
  // // } else {
  // return Constantes.DESCRICAO_PRAZO_NO_PRAZO;
  // // }
  // }
  // }

  // if (dias == null)
  // {
  // return (Constantes.DESCRICAO_PRAZO_SEM_PRAZO_FIXO);
  // }
  // else
  // {
  // dataLimite.add(Calendar.DATE, dias);
  // }

  // // Se esta etapa n�o foi conclu�da:
  // if
  // (getEtapaElaboracao().getId().compareTo(Constantes.iETAPA_ELABORACAO_PRONTO_PARA_CONSOLIDACAO)
  // < 0)
  // {
  // // E a data limite j� passou, ent�o est� atrasado:
  // if (dataLimite.before(Calendar.getInstance()))
  // {
  // return Constantes.DESCRICAO_PRAZO_ATRASADO;

  // }
  // else
  // {
  // return Constantes.DESCRICAO_PRAZO_NO_PRAZO;
  // }
  // }

  // // Se etapa J� foi conclu�da e a data limite era antes da data de
  // // conclus�o, ent�o foi conclu�da com atraso:
  // if
  // (getEtapaElaboracao().getId().compareTo(Constantes.iETAPA_ELABORACAO_PRONTO_PARA_CONSOLIDACAO)
  // >= 0)
  // {
  // return Constantes.DESCRICAO_PRAZO_CONCLUIDO_COM_ATRASO;
  // }

  // return Constantes.DESCRICAO_PRAZO_NO_PRAZO;
  // }

}
