package br.com.gullivertraveler.gullivertraveler.controller;

import br.com.gullivertraveler.gullivertraveler.model.Client;

interface IClientService {
    void deleteClient(Integer id);

    Object updateDataClient(Client data);

    Object searchByIdClient(Integer id);

    Object createNewClient(Client novo);

    IClientService getAllClient();
}
