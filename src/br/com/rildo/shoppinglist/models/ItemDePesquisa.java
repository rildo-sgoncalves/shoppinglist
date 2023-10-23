package br.com.rildo.shoppinglist.models;

public class ItemDePesquisa extends Item {
  private String mercado;
  private boolean online;
  private String marca;
  private Double preco;
  private Double precoPorUnidade;

  public ItemDePesquisa(Item item,
      String mercado,
      boolean online,
      String marca,
      double preco,
      int quantidadePrincipal,
      String unidadePrincipal,
      int quantidadeSecundaria,
      String unidadeSecundaria) {

    super(item.getNome(),
        item.getTipo(),
        quantidadePrincipal,
        unidadePrincipal,
        quantidadeSecundaria,
        unidadeSecundaria);
    this.mercado = mercado;
    this.online = online;
    this.marca = marca;
    this.preco = preco;
    this.precoPorUnidade = preco / quantidadePrincipal / quantidadeSecundaria;
  }

  public void alteraItemDePesquisa(String mercado,
      boolean online,
      String marca,
      double preco,
      int quantidadePrincipal,
      String unidadePrincipal,
      int quantidadeSecundaria,
      String unidadeSecundaria) {
    this.mercado = mercado;
    this.online = online;
    this.marca = marca;
    this.preco = preco;
    super.quantidadePrincipal = quantidadePrincipal;
    super.unidadePrincipal = unidadePrincipal;
    super.quantidadeSecundaria = quantidadeSecundaria;
    super.unidadeSecundaria = unidadeSecundaria;
  }

  @Override
  public String toString() {
    return "Pesquisa no mercado: " + this.mercado;
  }
}
