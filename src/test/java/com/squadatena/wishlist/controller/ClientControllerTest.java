package com.squadatena.wishlist.controller;

import com.squadatena.wishlist.model.Client;
import com.squadatena.wishlist.service.ClientService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class ClientControllerTest {

    @Autowired
    ClientService clientService;

    //Salvar Cliente
    @Test
    void salveClient(){

        //Preciso de salvar um cliente no banco
        Client client = new Client();
        client.setName("Poliana Pereira Andrade");
        client.setCpf("07249755609");
        client.setAddress("Rua Ovideo Bradamante Toledo");


        //Quando cliente for salvo
        Client saveClient = clientService.saveClient(client);

        //Resultado não é vazio
        assertThat(saveClient).isNotNull();
        assertThat(saveClient.getId_client()).isNotNull();

    }
    //Verificar id do cliente
    @Test
    void getClient(){
    //Preciso de salvar um cliente no banco
        Client client = new Client();
        client.setName("Poliana Pereira Andrade");
        client.setCpf("07249755609");
        client.setAddress("Rua Ovideo Bradamante Toledo");


    //Quando cliente for salvo
    Client saveClient = clientService.saveClient(client);

    //Resultado tem ser ser o id igual a 1
        assertThat(saveClient.getId_client()).isEqualTo(1);
    }

    //Buscar lista de clientes
    @Test
    void getClientID(){

       //Preciso de salvar clientes no banco
        Client client = new Client();
        client.setName("Poliana Pereira Andrade");
        client.setCpf("07249755609");
        client.setAddress("Rua Ovideo Bradamante Toledo");


        //Quando cliente for salvo
        List<Client> list = clientService.clientList();

        //Resultado retornar uma lista de cliente
        assertThat(clientService.clientList());

      }
    }
