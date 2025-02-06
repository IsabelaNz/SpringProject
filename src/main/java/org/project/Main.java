package org.project;

import com.opencsv.bean.CsvToBeanBuilder;
import org.project.models.Produto;
import org.project.service.TraduzProdutoService;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

// leitura de um arquivo csv para uma lista de produtos
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Produto> produtos = new CsvToBeanBuilder(new FileReader("src/main/resources/products.csv"))
                .withType(Produto.class).build().parse();

        for (Produto produto : produtos) {
            System.out.println(produto);
        }

        TraduzProdutoService traducaoService = new TraduzProdutoService();

        for (Produto produto : produtos) {
            traducaoService.traduzir(produto);
            System.out.println(produto);
        }
    }
}

