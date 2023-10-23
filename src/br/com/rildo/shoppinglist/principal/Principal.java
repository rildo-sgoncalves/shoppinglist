package br.com.rildo.shoppinglist.principal;

import java.util.ArrayList;
import java.util.List;

import br.com.rildo.shoppinglist.models.Item;
import br.com.rildo.shoppinglist.models.ItemDePesquisa;
import br.com.rildo.shoppinglist.models.Lista;

public class Principal {
  public static void main(String[] args) throws Exception {
    Lista minhaLista = new Lista("mercado", "compra mensal");
    Item item1 = new Item("café",
        "embalado à vácuo",
        1,
        "pct",
        500,
        "gr");
    Item item2 = new Item("leite",
        "longa vida",
        12,
        "caixa",
        1,
        "L");
    Item item3 = new Item("arroz",
        "integra",
        1,
        "pct",
        5,
        "kg");

    minhaLista.adiciona(item1);
    minhaLista.adiciona(item2);
    minhaLista.adiciona(item3);
    // minhaLista.remove(3);
    minhaLista.altera(0,
        "solúvel",
        1,
        "unidade",
        150,
        "gr");
    ItemDePesquisa item1ItemDePesquisa1 = new ItemDePesquisa(minhaLista.getItem(0),
        "dia a dia",
        false,
        "pilão",
        17.0,
        1,
        "pct",
        500,
        "gr");
    ItemDePesquisa item1ItemDePesquisa2 = new ItemDePesquisa(minhaLista.getItem(0),
        "carrefour",
        false,
        "do ponto",
        15.0,
        1,
        "pct",
        500,
        "gr");
    ItemDePesquisa item1ItemDePesquisa3 = new ItemDePesquisa(minhaLista.getItem(0),
        "extra",
        true,
        "pilão",
        14.0,
        1,
        "pct",
        500,
        "gr");
    minhaLista.adicionaItemDePesquisa(0, item1ItemDePesquisa1);
    minhaLista.adicionaItemDePesquisa(0, item1ItemDePesquisa2);
    minhaLista.adicionaItemDePesquisa(0, item1ItemDePesquisa3);
    // System.out.println(minhaLista);
    List<Item> lista = new ArrayList<>();
    lista = minhaLista.consultaItens();
    System.out.println(lista);

    List<ItemDePesquisa> listaItensDePesquisa = new ArrayList<>();
    listaItensDePesquisa = minhaLista.consultaItensDePesquisa(0);
    System.out.println(listaItensDePesquisa);

    // minhaLista.alteraItemDePesquisa(0,
    // 0,
    // "extra",
    // true,
    // "do sítio",
    // 13.5,
    // 1,
    // "pct",
    // 500,
    // "gr");

    minhaLista.removeItemDePesquisa(0, 3);

    listaItensDePesquisa = minhaLista.consultaItensDePesquisa(0);
    System.out.println(listaItensDePesquisa);

    List<ItemDePesquisa> itensDePesquisaOrdenados = new ArrayList<>();
    itensDePesquisaOrdenados = minhaLista.getItensDePesquisaOrdenadosPorPreco(0);
  }
}
