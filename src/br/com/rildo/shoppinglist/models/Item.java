package br.com.rildo.shoppinglist.models;

public class Item {
  private String nome;
  private String tipo;
  protected int quantidadePrincipal;
  protected String unidadePrincipal;
  protected int quantidadeSecundaria;
  protected String unidadeSecundaria;
  private boolean checked;

  public Item(String nome, String tipo, int quantidadePrincipal, String unidadePrincipal, int quantidadeSecundaria,
      String unidadeSecundaria) {
    this.nome = nome;
    this.tipo = tipo;
    this.quantidadePrincipal = quantidadePrincipal;
    this.unidadePrincipal = unidadePrincipal;
    this.quantidadeSecundaria = quantidadeSecundaria;
    this.unidadeSecundaria = unidadeSecundaria;
    this.checked = false;
  }

  public String getNome() {
    return this.nome;
  }

  public String getTipo() {
    return this.tipo;
  }

  public void altera(String tipo, int quantidadePrincipal, String unidadePrincipal, int quantidadeSecundaria,
      String unidadeSecundaria) {
    this.tipo = tipo;
    this.quantidadePrincipal = quantidadePrincipal;
    this.unidadePrincipal = unidadePrincipal;
    this.quantidadeSecundaria = quantidadeSecundaria;
    this.unidadeSecundaria = unidadeSecundaria;
  }

  @Override
  public String toString() {
    return this.nome + " " + this.tipo;
  }
}
