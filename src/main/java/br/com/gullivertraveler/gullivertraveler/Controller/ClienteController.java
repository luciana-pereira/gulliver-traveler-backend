package Controller;

import br.com.gullivertraveler.api.model.Cliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


        @RestController
        @CrossOrigin("http://localhost:3000")
        @Api(tags = { "Cliente" }, value = "clientes", description = "Operações relacionadas a clientes")

        public class ClienteController {

            @Autowired
            private IClienteService service;

            @ApiResponses(value = {
                    @ApiResponse(code = 200, message = "Retorna a lista de clientes"),
                    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
            })

            @ApiOperation(value = "Listar todos os clientes", nickname = "getCliente")
            @GetMapping("/clientes")
            public ResponseEntity<List<Cliente>> recuperarTodos() {
                return ResponseEntity.ok().body(service.buscarTodosClientes());
            }

            @ApiOperation(value = "Listar cliente pelo ID", nickname = "getCliente")

            @GetMapping("/clientes/{id}")
            public ResponseEntity<Cliente> buscarPeloId(@PathVariable Integer id) {
                return ResponseEntity.ok().body(service.buscarPeloIdCliente(id));
            }

            @ApiOperation(value = "Cadastrar cliente", nickname = "postCliente")
            @PostMapping("/clientes")
            @RequestMapping(value = "/clientes", method =  RequestMethod.POST, produces="application/json", consumes="application/json")
            public ResponseEntity<Cliente> incluirNovo(@RequestBody @Valid Cliente novo) {
                return ResponseEntity.status(HttpStatus.CREATED).body(service.criarNovoCliente(novo));

            }

            @ApiOperation(value = "Atualizar cliente", nickname = "putCliente")
            @PutMapping("/clientes")
            @RequestMapping(value = "/clientes", method =  RequestMethod.PUT, produces="application/json", consumes="application/json")
            public ResponseEntity<Cliente> alterar(@RequestBody @Valid Cliente dados) {
                return ResponseEntity.ok().body(service.atualizarDadosCliente(dados));
            }

            @ApiOperation(value = "Deletar cliente pelo ID", nickname = "deleteCliente")
            @DeleteMapping("/clientes/{id}")
            public ResponseEntity<Void> excluir(@PathVariable Integer id) {
                service.excluirCliente(id);
                return ResponseEntity.ok().build();
            }

        }
