package com.example.sisconledoc.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "EQUIPE_SOLICITACAO_TRABALHO")
public class Equipe implements Serializable {

  // @Transient
  // private String nucleosDaEquipe;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "IDE_EQUIPE_SOLICITACAO_TRABALHO", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDE_GRUPO_COORDENACAO_AREA")
  private Grupo grupo;

  @Column(name = "ind_Responsavel", nullable = false)
  private Boolean responsavel = new Boolean(false);

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "IDE_SOLICITACAO_TRABALHO")
  private SolicitacaoTrabalho solicitacaoTrabalho;

  @OneToMany(mappedBy = "equipe", fetch = FetchType.LAZY)
  @OrderBy("id")
  private Set<Elaborador> elaboradores;

  @Column(name = "dat_inclusao", nullable = false)
  private Calendar dataCriacao;

  @Column(name = "dat_exclusao", nullable = true)
  private Calendar dataExclusao;

  // ****************************************************/
  // Construtores:
  // ****************************************************/
  // public Equipe() {

  // setDataCriacao(Calendar.getInstance());
  // setResponsavel(new Boolean(false));
  // }

  // public Equipe(SolicitacaoTrabalho sol) {
  // setSolicitacaoTrabalho(sol);
  // setDataCriacao(Calendar.getInstance());
  // setResponsavel(new Boolean(false));
  // }

  // ****************************************************/
  // Getters and Setters
  // ****************************************************/

  /**
   * Retorna o elaborador respons�vel pela equipe
   * 
   * @return
   */
  // @Transient
  // public Elaborador getElaboradorResponsavel() {
  // if (elaboradores == null) {
  // return null;
  // }
  // Iterator<Elaborador> i = elaboradores.iterator();

  // while (i.hasNext()) {
  // Elaborador elaborador = i.next();
  // if (elaborador.getResponsavel()) {
  // return elaborador;
  // }
  // }
  // return null;
  // }

  // @Transient
  // public String getDescricaoDaEquipe(boolean incluirCabecalho)
  // {
  // String separador = "";
  // String inicioPrincipal = "";
  // String inicioParticipante = "";
  // String fimBold = "";
  // List<String> nomeRepetido = new ArrayList<>();

  // /*String inicioBadgePrincipal = "";
  // String inicioBadgeParticipante = "";
  // String fimBadge = "</span>";*/

  // if (incluirCabecalho)
  // {
  // separador = "";
  // inicioPrincipal = "<li class=\"list-group-item list-consultor\"
  // alt=\"Consultor respons�vel\" title=\"Consultor respons�vel\">"
  // + "<span class=\"glyphicon glyphicon-user user-primary\" style=\"opacity: 1;
  // margin-right: 5px\"></span>";
  // //inicioBadgePrincipal = "<span class=\"label label-as-badge label-info
  // col-xs-12\">";

  // inicioParticipante = "<li class=\"list-group-item list-consultor\"
  // alt=\"Consultor participante\" title=\"Consultor participante\">"
  // + "<span class=\"glyphicon glyphicon-user user-primary\" style=\"opacity: 0;
  // margin-right: 5px\"></span>";

  // //inicioBadgeParticipante = "<span class=\"label label-as-badge
  // col-xs-12\">";
  // fimBold = "</li>";
  // }
  // else
  // {
  // separador = "; ";
  // }

  // String nomes = "";
  // // Hibernate.initialize(getElaboradores());
  // if (getElaboradores() != null)
  // {
  // for (Elaborador elab : getElaboradores())
  // {
  // if (elab.getDataExclusao() == null)
  // {

  // String nomeUsual = ( elab.getUsuario().getNomeUsual() !=null &&
  // !UtilModel.isEmpty(elab.getUsuario().getNomeUsual().trim()) ?
  // elab.getUsuario().getNomeUsual() :
  // elab.getUsuario().getNome() );

  // if(!nomeRepetido.contains(nomeUsual)) {

  // nomeRepetido.add(nomeUsual);

  // if (elab.getResponsavel().booleanValue()) {
  // nomes += inicioPrincipal + nomeUsual + fimBold + separador; // �
  // } else {
  // nomes += inicioParticipante + nomeUsual + fimBold + separador; // �
  // }
  // }
  // }
  // }
  // }
  // if (nomes.equals(separador))
  // {
  // nomes += /*" ( n�o escolhidos )" + */separador;
  // }

  // if (nomes.startsWith(" - ") && !incluirCabecalho) {
  // nomes = nomes.substring(3); // descarta o in�cio
  // }
  // return nomes;
  // }

  // @Transient
  // public void setNucleosDaEquipe(String descricao)
  // {
  // nucleosDaEquipe = descricao;
  // }

  // @Transient
  // public String getNucleosDaEquipe()
  // {
  // return nucleosDaEquipe;
  // }

  // /**
  // * Adiciona um elaborador ao set de elaboradores dessa equipe
  // *
  // * @param elaborador
  // */
  // @Transient
  // public void addElaborador(Elaborador elaborador)
  // {
  // if (getElaboradores() == null)
  // {
  // elaboradores = new HashSet<Elaborador>();
  // }
  // elaboradores.add(elaborador);
  // }

  // public List<Elaborador> getElaboradoresAtivos()
  // {
  // List<Elaborador> result = new ArrayList<Elaborador>();

  // if (getElaboradores() != null)
  // {
  // for (Elaborador elab : getElaboradores())
  // {
  // if (elab.getDataExclusao() == null)
  // {
  // result.add(elab);
  // }
  // }
  // }
  // return result;
  // }

  // @Override
  // public String toString()
  // {

  // String dataExclusao = getDataExclusao() != null ? " Inativo em "
  // + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(this.getDataExclusao())
  // + ". " : " Ativo. ";

  // return "Equipe da �rea: " + this.getGrupo().getSigla() + dataExclusao +
  // getDescricaoDaEquipe(false);
  // }

}
