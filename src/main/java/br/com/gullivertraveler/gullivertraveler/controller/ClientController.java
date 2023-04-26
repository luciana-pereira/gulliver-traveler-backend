package br.com.gullivertraveler.gullivertraveler.controller;

import br.com.gullivertraveler.gullivertraveler.model.Client;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
        @CrossOrigin("http://localhost:3000")
        @Api(tags = { "Client" }, value = "clients", description = "Operações relacionadas a clientes")

        public class ClientController {

            //@Autowired
            private IClientService service;

            @ApiResponses(value = {
                    @ApiResponse(code = 200, message = "Retorna a lista de clientes"),
                    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
            })

            @ApiOperation(value = "Listar todos os clientes", nickname = "getClient")
            @GetMapping("/client")
            public ResponseEntity<Object> getAll() {
                return ResponseEntity.ok().body(service.getAllClient());
            }

            @ApiOperation(value = "Listar cliente pelo ID", nickname = "getClient")

            @GetMapping("/client/{id}")
            public ResponseEntity<Object> searchById(@PathVariable Integer id) {
                return ResponseEntity.ok().body(service.searchByIdClient(id));
            }

            @ApiOperation(value = "Cadastrar cliente", nickname = "postClient")
            @PostMapping("/client")
            @RequestMapping(value = "/client", method =  RequestMethod.POST, produces="application/json", consumes="application/json")
            public ResponseEntity<Object> addNew(@RequestBody @Valid Client novo) {
                return ResponseEntity.status(HttpStatus.CREATED).body(service.createNewClient(novo));

            }

            @ApiOperation(value = "Atualizar cliente", nickname = "putClient")
            @PutMapping("/client")
            @RequestMapping(value = "/client", method =  RequestMethod.PUT, produces="application/json", consumes="application/json")
            public ResponseEntity<Client> change(@RequestBody @Valid Client data) {
                return ResponseEntity.ok().body((Client) service.updateDataClient(data));
            }

            @ApiOperation(value = "Deletar cliente pelo ID", nickname = "deleteClient")
            @DeleteMapping("/client/{id}")
            public ResponseEntity<Void> delete(@PathVariable Integer id) {
                service.deleteClient(id);
                return ResponseEntity.ok().build();
            }

        }
