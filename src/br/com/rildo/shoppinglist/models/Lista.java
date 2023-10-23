package br.com.rildo.shoppinglist.models;

import java.util.ArrayList;
import java.util.List;

public class Lista {
  private String nome;
  private String descricao;
  List<Celula> itens = new ArrayList<>();
  private int totalDeItens;

  public Lista(String nome, String descricao) {
    this.nome = nome;
    this.descricao = descricao;
    this.totalDeItens = 0;
  }

  public Item getItem(int index) throws IllegalAccessException {
    if (this.totalDeItens == 0) {
      throw new IllegalAccessException("lista vazia");
    }
    if (this.totalDeItens < index) {
      throw new IllegalAccessException("item não existe");
    }
    return itens.get(index).getItem();
  }

  public List<Item> consultaItens() {
    List<Item> lista = new ArrayList<>();
    for (int i = 0; i < this.totalDeItens; i++) {
      lista.add(this.itens.get(i).getItem());
    }
    return lista;
  }

  public List<ItemDePesquisa> consultaItensDePesquisa(int index) {
    List<ItemDePesquisa> itensDePesquisa = new ArrayList<>();
    if (itens.get(index).getProximaCelula() == null) {
      return itensDePesquisa;
    } else {
      return itens.get(index).getProximaCelula().consultaItensDePesquisa(itensDePesquisa);
    }
  }

  public void adiciona(Item item) {
    this.itens.add(new Celula(item));
    this.totalDeItens++;
  }

  public void adicionaItemDePesquisa(int index,
      ItemDePesquisa itemDePesquisa) {
    if (this.itens.get(index) == null) {
      throw new IllegalArgumentException("index " + index + " não existe");
    }
    this.itens.get(index).adicionaItemDePesquisa(itemDePesquisa);
  }

  public void remove(int index) {
    this.itens.remove(index);
    this.totalDeItens--;
  }

  public void removeItemDePesquisa(int index, int indexItemDePesquisa) {
    if (this.itens.get(index) == null) {
      throw new IllegalArgumentException("índice inválido");
    }
    if (indexItemDePesquisa < 0) {
      throw new IllegalArgumentException("índice da lista de pesquisa inválido");
    }
    if (this.itens.get(index).getProximaCelula() == null) {
      throw new IllegalArgumentException("lista de pesquisa vazia");
    }
    try {
      this.itens.get(index)
          .setProximaCelula(this.itens.get(index).getProximaCelula().removeItemDePesquisa(indexItemDePesquisa));
    } catch (Exception e) {
      System.out.println("Ocorreu uma exceção: " + e);
    }
  }

  public void altera(int index,
      String tipo,
      int quantidadePrincipal,
      String unidadePrincipal,
      int quantidadeSecundaria,
      String unidadeSecundaria) {
    if (this.itens.get(index) == null) {
      throw new IllegalArgumentException("índice inválido");
    }
    this.itens.get(index).altera("solúvel",
        1,
        "unidade",
        150,
        "gr");
  }

  public void alteraItemDePesquisa(int index,
      int indexItemDePesquisa,
      String mercado,
      boolean online,
      String marca,
      double preco,
      int quantidadePrincipal,
      String unidadePrincipal,
      int quantidadeSecundaria,
      String unidadeSecundaria) {
    if (this.itens.get(index).getProximaCelula() == null) {
      throw new IllegalArgumentException("lista de itens de pesquisa vazia");
    }
    if (indexItemDePesquisa < 0) {
      throw new IllegalArgumentException("índice da lista de pesquisa inválido");
    }
    this.itens.get(index).getProximaCelula().alteraItemDePesquisa(indexItemDePesquisa,
        mercado,
        online,
        marca,
        preco,
        quantidadePrincipal,
        unidadePrincipal,
        quantidadeSecundaria,
        unidadeSecundaria);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("""
        %s
        %s""".formatted(this.nome, this.descricao));

    if (this.totalDeItens == 0) {
      return builder.append("\n[]").toString();
    }
    for (int i = 0; i < totalDeItens; i++) {
      builder.append("\n" + i + ": " + itens.get(i).toString());
    }
    return builder.toString();
  }

  public List<ItemDePesquisa> getItensDePesquisaOrdenadosPorPreco(int index) {
    List<ItemDePesquisa> itensDePesquisaOrdenados = new ArrayList<>();
    if (totalDeItens == 0) {
      throw new IllegalArgumentException("Lista vazia");
    }
    return itensDePesquisaOrdenados;
  }
}
