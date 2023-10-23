package br.com.rildo.shoppinglist.models;

import java.util.List;

public class Celula {
  private Item item;
  private Celula proximaCelula;

  public Celula(Item item) {
    this.item = item;
    this.proximaCelula = null;
  }

  public Item getItem() {
    return this.item;
  }

  public List<ItemDePesquisa> consultaItensDePesquisa(List<ItemDePesquisa> itensDePesquisa) {
    itensDePesquisa.add((ItemDePesquisa) this.item);
    if (this.proximaCelula == null) {
      return itensDePesquisa;
    } else {
      return this.proximaCelula.consultaItensDePesquisa(itensDePesquisa);
    }

  }

  public Celula getProximaCelula() {
    return this.proximaCelula;
  }

  public void setProximaCelula(Celula celula) {
    this.proximaCelula = celula;
  }

  public void altera(String tipo,
      int quantidadePrincipal,
      String unidadePrincipal,
      int quantidadeSecundaria,
      String unidadeSecundaria) {
    this.item.altera(tipo,
        quantidadePrincipal,
        unidadePrincipal,
        quantidadeSecundaria,
        unidadeSecundaria);
  }

  public void alteraItemDePesquisa(int indexItemDePesquisa,
      String mercado,
      boolean online,
      String marca,
      double preco,
      int quantidadePrincipal,
      String unidadePrincipal,
      int quantidadeSecundaria,
      String unidadeSecundaria) {
    if (indexItemDePesquisa == 0) {
      ((ItemDePesquisa) this.item).alteraItemDePesquisa(mercado,
          online,
          marca,
          preco,
          quantidadePrincipal,
          unidadePrincipal,
          quantidadeSecundaria,
          unidadeSecundaria);
    } else {
      this.proximaCelula.alteraItemDePesquisa(--indexItemDePesquisa,
          mercado,
          online,
          marca,
          preco,
          quantidadePrincipal,
          unidadePrincipal,
          quantidadeSecundaria,
          unidadeSecundaria);
    }
  }

  public void adicionaItemDePesquisa(ItemDePesquisa itemDePesquisa) {
    if (this.proximaCelula == null) {
      this.proximaCelula = new Celula(itemDePesquisa);
    } else {
      this.proximaCelula.adicionaItemDePesquisa(itemDePesquisa);
    }
  }

  public Celula removeItemDePesquisa(int indexItemDePesquisa) {
    if (indexItemDePesquisa == 0) {
      return this.getProximaCelula();
    } else if (this.proximaCelula == null) {
      throw new IllegalArgumentException("índice de item de pesquisa inválido");
    } else {
      this.proximaCelula = this.proximaCelula.removeItemDePesquisa(--indexItemDePesquisa);
      return this;
    }
  }

  @Override
  public String toString() {
    if (this.proximaCelula == null) {
      return this.item.toString();
    }
    return this.item.toString() + " " + this.proximaCelula.toString();
  }
}
