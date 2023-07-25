package dev.clement.wine.service;

import dev.clement.wine.entity.Client;
import dev.clement.wine.entity.Price;
import dev.clement.wine.exception.WineException;
import dev.clement.wine.model.ClientRequest;
import dev.clement.wine.model.ClientResponse;
import dev.clement.wine.model.PriceRequest;
import dev.clement.wine.model.PriceResponse;
import dev.clement.wine.repository.ClientRepository;
import dev.clement.wine.repository.PriceRepository;
import dev.clement.wine.repository.SiteRepository;
import dev.clement.wine.repository.WineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static dev.clement.wine.exception.ErrorCode.NOT_FOUND;

@Service
public class ClientService {

    private final static Logger log = LoggerFactory.getLogger(ClientService.class);

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public ClientResponse createClient(final ClientRequest request) {
        var client = new Client(request.email(), request.firstname(), request.lastname(), request.phoneNumber());
        clientRepository.save(client);
        return ClientResponse.from(client);
    }

}
