package Controller;

import java.io.IOException;
import java.util.ArrayList;

public class Hotel {


    ArrayList<Hoteis> lista = new ArrayList<Hoteis>();

        lista.add(new Hoteis("Ibis Styles Barra Funda","R. Eduardo Viana, 163 - Barra Funda, São Paulo - SP, 01133-040•(11) 3393-7300"));
        lista.add(new Hoteis("Ape Paulista Bela Cintra"," R. Bela Cintra, 934 - Consolação, São Paulo - SP, 01415-002"));
        lista.add(new Hoteis("Pullman Sao Paulo Ibirapuera"," Rua Joinville, 515 - Vila Mariana, São Paulo - SP, 04008-011",));
        lista.add(new Hoteis("Marabá - Hotel Oficial do Bar Brahma","Av. Ipiranga, 757 - Centro Histórico de São Paulo, São Paulo - SP, 01039-000"));
        lista.add(new Hoteis("Staybridges Suítes São Paulo","R. Bandeira Paulista, 555 - Itaim Bibi, São Paulo - SP, 04532-011"));


    int classificacaoSelecionada = Integer.parseInt(request.getParameter("selectClassif"));

    ArrayList<Hoteis> listaFiltrada = new ArrayList<Hoteis>();
        for(
    Hoteis hotel :lista)

    {
        if (hotel.getClassificacao() == classificacaoSelecionada) {
            listaFiltrada.add(hotel);
        }
    }
}