package br.com.gullivertraveler.gullivertraveler.controller;

import br.com.gullivertraveler.gullivertraveler.model.Client;

public interface IClienteService {
    void deleteClient(Integer id);

    Object updateDataClient(Client data);

    Object searchByIdClient(Integer id);

    Object createNewClient(Client novo);

    Object getAllClient();
}
