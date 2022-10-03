package com.example.sisconledoc.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
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
@Table(name = "Usuario")
public class Usuario implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "IDE_USUARIO", nullable = false)
  private Integer id;

  @Column(name = "NUM_PONTO_USUARIO", nullable = false)
  private String ponto;

  @Column(name = "NOM_USUARIO", nullable = false)
  private String nome;

  @Column(name = "IND_ATIVO", nullable = true)
  private String ativo;

  @Column(name = "NOM_USUAL", nullable = true)
  private String nomeUsual;

  @Column(name = "ABA_PREFERIDA", nullable = true)
  private String abaPreferida;

  @Column(name = "DES_EMAIL")
  private String email;

  // @Transient
  // private Set<Perfil> perfis;

  /**
   * Relacionamento feito pois � necess�rio trazer alguns dados que est�o na
   * tabela ServidorCamaranet: o c�digo abaixo
   * � devido ao fato de n�o existir relacionamento direto entre as tabelas na
   * base
   */
  @OneToOne(targetEntity = ServidorCamaranet.class)
  @JoinColumn(name = "NUM_PONTO_USUARIO", referencedColumnName = "ALIAS", nullable = true, insertable = false, updatable = false)
  @NotFound(action = NotFoundAction.IGNORE)
  private ServidorCamaranet servidorCamaranet;

  // @Transient
  // private String descricaoGrupos;

  @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
  @OrderBy("dataInicio desc")
  private Set<UsuarioAfastamento> listaAfastamento;

  @ManyToMany(targetEntity = Grupo.class, fetch = FetchType.LAZY)
  @JoinTable(name = "USUARIO_GRUPO", joinColumns = @javax.persistence.JoinColumn(name = "IDE_USUARIO"), inverseJoinColumns = @javax.persistence.JoinColumn(name = "IDE_GRUPO"))
  private Set<Grupo> grupos;

  // public String getNome() {
  // if (!UtilModel.isEmpty(nome)) {
  // return UtilModel.formataCaixaTexto(nome);
  // }
  // return nome;
  // }

  // /**
  // * Retorna um subset com os grupos do usu�rio que sejam do perfil informado.
  // *
  // * @param idPerfil
  // * @return
  // */
  // @Transient
  // public Set<Grupo> getGrupos(String idPerfil) {
  // Iterator<Grupo> i = this.grupos.iterator();
  // Set<Grupo> grupoSelecionados = new LinkedHashSet<Grupo>();

  // ArrayList<Grupo> listaTmp = new ArrayList<Grupo>();

  // while (i.hasNext()) {
  // Grupo g = i.next();
  // if ((g.getPerfil().getId() + "").equals(idPerfil)) {
  // listaTmp.add(g);
  // }
  // }
  // if (listaTmp.isEmpty()) {
  // return null;
  // }

  // Collections.sort(listaTmp, new GrupoComparatorPorIndice());

  // grupoSelecionados.addAll(listaTmp);

  // return grupoSelecionados;
  // }

  // public Set<Perfil> getPerfis() {

  // if (perfis == null) {
  // perfis = new HashSet<Perfil>();
  // } else {
  // return perfis;
  // }

  // if (getGrupos() == null)
  // return null;
  // Iterator<Grupo> i = getGrupos().iterator();

  // while (i.hasNext()) {
  // Grupo g = i.next();

  // if (!perfis.contains(g.getPerfil())) {
  // perfis.add(g.getPerfil());
  // }
  // }

  // return perfis;
  // }

  // /**
  // * Retorna a descri��o dos grupos aos quais este usu�rio pertence. Se
  // tipoGrupo
  // * for nulo, retorna a descri��o de
  // * todos os grupos. Se n�o, apenas dos grupos que perten�am ao perfil cujo Id
  // * seja = tipoPerfil Se
  // * mostrarDescricaoDoPerfil for true, mostra tambem o nome do perfil ao qual
  // * aquele grupo pertence.
  // *
  // * @param tipoPerfil
  // * @param mostrarDescricaoDoPerfil
  // * @return
  // */
  // @Transient
  // public String getDescricaoGrupos(String tipoPerfil, boolean
  // mostrarDescricaoDoPerfil) {

  // String s = "";

  // for (Grupo grupo : grupos) {

  // String descricaoGrupo = grupo.getSigla().equals(grupo.getDescricao()) ?
  // grupo.getSigla()
  // : grupo.getSigla() + " - "
  // + grupo.getDescricao();

  // if (tipoPerfil != null) {
  // if (grupo.getPerfil().getId().equals(new Integer(tipoPerfil))) {
  // s += descricaoGrupo + (mostrarDescricaoDoPerfil ? " (" +
  // grupo.getPerfil().getDescricao() + "), " : ", ");
  // }
  // } else {
  // s += descricaoGrupo + (mostrarDescricaoDoPerfil ? " (" +
  // grupo.getPerfil().getDescricao() + "), " : ", ");
  // }
  // }
  // if (s.endsWith(", ")) {
  // s = s.substring(0, s.length() - 2);
  // }
  // return s;
  // }

  // /**
  // * Retorna uma lista com a sigla de todos os grupos do usuario
  // *
  // * @return
  // */
  // @Transient
  // public String getSiglaGrupos() {

  // Map<String, String> mapaSiglas = new TreeMap<String, String>();

  // String s = "";

  // for (Grupo grupo : grupos) {
  // mapaSiglas.put(grupo.getSigla(), grupo.getSigla());
  // }

  // for (String sigla : mapaSiglas.keySet()) {
  // s += sigla + ", ";
  // }

  // if (s.endsWith(", ")) {
  // s = s.substring(0, s.length() - 2);
  // }
  // return s;
  // }

  // @Transient
  // public String getDescricaoGrupos() {
  // return descricaoGrupos;
  // }

  // @Transient
  // public void setDescricaoGrupos(String descricaoGrupos) {
  // this.descricaoGrupos = descricaoGrupos;
  // }

  // @Transient
  // public boolean isConsultor() {

  // Set<Perfil> perfis = getPerfis();
  // if (perfis == null || perfis.size() == 0)
  // return false;
  // Iterator<Perfil> i = perfis.iterator();
  // while (i.hasNext()) {
  // Perfil perfil = i.next();
  // if (perfil.getId().equals(new Integer(Constantes.PERFIL_CONSULTOR))) {
  // return true;
  // }
  // }
  // return false;
  // }

  // @Transient
  // public boolean isColaboradorAdministrativo() {

  // Set<Perfil> perfis = getPerfis();
  // if (perfis == null || perfis.size() == 0)
  // return false;
  // Iterator<Perfil> i = perfis.iterator();
  // while (i.hasNext()) {
  // Perfil perfil = i.next();
  // if (perfil.getId().equals(new
  // Integer(Constantes.PERFIL_COLABORADOR_ADMINISTRATIVO))) {
  // return true;
  // }
  // }
  // return false;
  // }

  // @Transient
  // public boolean isDiretoria() {

  // Set<Perfil> perfis = getPerfis();
  // if (perfis == null || perfis.size() == 0)
  // return false;
  // Iterator<Perfil> i = perfis.iterator();
  // while (i.hasNext()) {
  // Perfil perfil = i.next();
  // if (perfil.getId().equals(new Integer(Constantes.PERFIL_DIRETORIA))) {
  // return true;
  // }
  // }
  // return false;
  // }

  // @Transient
  // public boolean isCoordenadorArea() {

  // Set<Perfil> perfis = getPerfis();
  // if (perfis == null || perfis.size() == 0)
  // return false;
  // Iterator<Perfil> i = perfis.iterator();
  // while (i.hasNext()) {
  // Perfil perfil = i.next();
  // if (perfil.getId().equals(new Integer(Constantes.PERFIL_COORDENACAO_AREA))) {
  // return true;
  // }
  // }
  // return false;
  // }

  // @Transient
  // public boolean isServicoAdministrativo() {

  // Set<Perfil> perfis = getPerfis();
  // if (perfis == null || perfis.size() == 0)
  // return false;
  // Iterator<Perfil> i = perfis.iterator();
  // while (i.hasNext()) {
  // Perfil perfil = i.next();
  // if (perfil.getId().equals(new
  // Integer(Constantes.PERFIL_SERVICO_ADMINISTRATIVO))) {
  // return true;
  // }
  // }
  // return false;
  // }

  // @Transient
  // public boolean isApenasCoordenadorArea() {

  // boolean value = false;
  // if (isCoordenadorArea()) {
  // value = true;
  // }
  // if (isDiretoria() || isServicoAdministrativo()) {
  // value = false;
  // }
  // return value;
  // }

  // /**
  // * Retorna true se o usuario logado for do servi�o administrativo e n�o for
  // * diretor, coordenador ou gerente
  // *
  // * @return
  // */
  // @Transient
  // public boolean isApenasServicoAdministrativo() {

  // boolean result = false;
  // if (isServicoAdministrativo()) {
  // result = true;
  // }
  // if (isDiretoria()) {
  // result = false;
  // }
  // if (isCoordenadorArea()) {
  // result = false;
  // }
  // if (isGerencia()) {
  // result = false;
  // }
  // return result;
  // }

  // @Transient
  // public boolean isPessoal() {

  // Set<Perfil> perfis = getPerfis();
  // if (perfis == null || perfis.size() == 0)
  // return false;
  // Iterator<Perfil> i = perfis.iterator();
  // while (i.hasNext()) {
  // Perfil perfil = i.next();
  // if (perfil.getId().equals(new Integer(Constantes.PERFIL_PESSOAL))) {
  // return true;
  // }
  // }
  // return false;
  // }

  // @Transient
  // public boolean isSecaoPesquisa() {

  // Set<Perfil> perfis = getPerfis();
  // if (perfis == null || perfis.size() == 0)
  // return false;
  // Iterator<Perfil> i = perfis.iterator();
  // while (i.hasNext()) {
  // Perfil perfil = i.next();
  // if (perfil.getId().equals(new Integer(Constantes.PERFIL_PESQUISA))) {
  // return true;
  // }
  // }
  // return false;
  // }

  // @Transient
  // public boolean isGerencia() {

  // Set<Perfil> perfis = getPerfis();
  // if (perfis == null || perfis.size() == 0)
  // return false;

  // Iterator<Perfil> i = perfis.iterator();
  // while (i.hasNext()) {
  // Perfil perfil = i.next();
  // if (perfil.getId().equals(new Integer(Constantes.PERFIL_GERENCIA_SEPAD))) {
  // return true;
  // }
  // }
  // return false;
  // }

  // @Transient
  // public boolean isExpedicaoEdicao() {

  // Set<Perfil> perfis = getPerfis();
  // if (perfis == null || perfis.size() == 0)
  // return false;
  // Iterator<Perfil> i = perfis.iterator();
  // while (i.hasNext()) {
  // Perfil perfil = i.next();
  // if (perfil.getId().equals(new Integer(Constantes.PERFIL_EXPEDICAO_EDICAO))) {
  // return true;
  // }
  // }
  // return false;
  // }

  // @Transient
  // public boolean isConsulta() {

  // Set<Perfil> perfis = getPerfis();
  // if (perfis == null || perfis.size() == 0)
  // return false;
  // Iterator<Perfil> i = perfis.iterator();
  // while (i.hasNext()) {
  // Perfil perfil = i.next();
  // if (perfil.getId().equals(new Integer(Constantes.PERFIL_CONSULTA))) {
  // return true;
  // }
  // }
  // return false;
  // }

  // /**
  // * Retorna o grupo de maior hierarquia do usuario
  // *
  // * @return
  // */
  // public Grupo getGrupoMaiorHierarquia() {

  // Grupo grupo = null;

  // if (isDiretoria()) {
  // grupo = getGrupos(Constantes.PERFIL_DIRETORIA).iterator().next();
  // }
  // if (isGerencia()) {
  // grupo = getGrupos(Constantes.PERFIL_GERENCIA_SEPAD).iterator().next();
  // } else if (isCoordenadorArea()) {
  // grupo = getGrupos(Constantes.PERFIL_COORDENACAO_AREA).iterator().next();
  // } else if (isServicoAdministrativo()) {
  // grupo =
  // getGrupos(Constantes.PERFIL_SERVICO_ADMINISTRATIVO).iterator().next();
  // } else if (isConsultor()) {
  // grupo = getGrupos(Constantes.PERFIL_CONSULTOR).iterator().next();
  // } else if (isPessoal()) {
  // grupo = getGrupos(Constantes.PERFIL_PESSOAL).iterator().next();
  // } else if (isSecaoPesquisa()) {
  // grupo = getGrupos(Constantes.PERFIL_PESQUISA).iterator().next();
  // }
  // return grupo;
  // }

  // /**
  // * retorna um array com os c�digos dos perfils do usuario
  // *
  // * @return
  // */
  // public String[] getArrayCodigoPerfilDoUsuario() {

  // ArrayList<String> lista = new ArrayList<String>();

  // if (isConsultor()) {
  // lista.add(Constantes.PERFIL_CONSULTOR);
  // }
  // if (isDiretoria()) {
  // lista.add(Constantes.PERFIL_DIRETORIA);
  // }
  // if (isCoordenadorArea()) {
  // lista.add(Constantes.PERFIL_COORDENACAO_AREA);
  // }
  // if (isServicoAdministrativo()) {
  // lista.add(Constantes.PERFIL_SERVICO_ADMINISTRATIVO);
  // }
  // if (isGerencia()) {
  // lista.add(Constantes.PERFIL_GERENCIA_SEPAD);
  // }
  // if (isExpedicaoEdicao()) {
  // lista.add(Constantes.PERFIL_EXPEDICAO_EDICAO);
  // }
  // if (isSecaoPesquisa()) {
  // lista.add(Constantes.PERFIL_PESQUISA);
  // }
  // if (isPessoal()) {
  // lista.add(Constantes.PERFIL_PESSOAL);
  // }

  // return lista.toArray(new String[lista.size()]);

  // }

  // /**
  // * Ver se o usu�rio pertence ao perfil informado:
  // *
  // * @param constantePerfil
  // * String com o id do perfil pesquisado. Usar as
  // * Constantes.
  // * @return
  // */
  // @Transient
  // public boolean pertenceAoPerfil(String constantePerfil) {

  // Set<Perfil> perfis2 = getPerfis();
  // if (perfis2 == null)
  // return false;

  // for (Perfil perfil : perfis2) {
  // if (perfil.getId().equals(new Integer(constantePerfil))) {
  // return true;
  // }
  // }
  // return false;
  // }

  // /**
  // * Retorna lista de afastamentos que existam nos pr�ximos cinco dias.
  // *
  // * @return
  // */
  // public Set<UsuarioAfastamento> getListaAfastamentosNosProximosCincoDias() {

  // if (listaAfastamento == null) {
  // return null;
  // }

  // Calendar hoje = Calendar.getInstance();
  // UtilModel.zerarHoraMinutoSegundo(hoje);

  // Calendar dataLimite = (Calendar) hoje.clone();
  // dataLimite.add(Calendar.DAY_OF_MONTH, 5);
  // Set<UsuarioAfastamento> result = new HashSet<UsuarioAfastamento>();
  // for (UsuarioAfastamento afastamento : listaAfastamento) {
  // Calendar dataFim = Calendar.getInstance();
  // dataFim.setTime(afastamento.getDataFim());
  // Calendar dataInicio = Calendar.getInstance();
  // dataInicio.setTime(afastamento.getDataInicio());

  // if (hoje.before(dataFim) && dataLimite.after(dataInicio)) {
  // result.add(afastamento);
  // }
  // }

  // if (result.isEmpty()) {
  // return null;
  // }

  // return result;
  // }

  // public String getNomeUsual() {
  // if (nomeUsual == null) {
  // return getNome();
  // }
  // return nomeUsual;
  // }

}