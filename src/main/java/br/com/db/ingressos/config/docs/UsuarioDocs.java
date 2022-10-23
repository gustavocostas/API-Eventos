package br.com.db.ingressos.config.docs;

import br.com.db.ingressos.controller.dto.UsuarioDto;
import br.com.db.ingressos.exception.EntityBadRequestException;
import br.com.db.ingressos.exception.EntityNullPointerException;
import br.com.db.ingressos.resposta.UsuarioAtualizadoResposta;
import br.com.db.ingressos.resposta.UsuarioResposta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Tag(name = "usuario", description = "Responsável por manter usuário no sistema")
public interface UsuarioDocs {
    @Operation(summary = "Cadastra novo usuário.", tags = "usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Usuário incluído com sucesso",
                    content = @Content(schema = @Schema(implementation = UsuarioResposta.class))
            ),
            @ApiResponse(responseCode = "400",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EntityBadRequestException.class))
            ),
            @ApiResponse(responseCode = "500",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EntityNullPointerException.class))
            ),

    })
    ResponseEntity<UsuarioResposta> cadastrarUsuario(@RequestBody @Valid UsuarioDto usuarioDTO);

    @Operation(summary = "Lista os usuários.", tags = "usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Usuários listados com sucesso",
                    content = @Content(schema = @Schema(implementation = UsuarioResposta.class))
            ),
            @ApiResponse(responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = br.com.db.ingressos.exception.EntityNotFoundException.class))
            ),

    })
    ResponseEntity<List<UsuarioResposta>> listarUsuario();

    @Operation(summary = "Encontra o usuário.", tags = "usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Usuário encontrado com sucesso",
                    content = @Content(schema = @Schema(implementation = UsuarioResposta.class))
            ),
            @ApiResponse(responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EntityNotFoundException.class))
            ),

    })
    ResponseEntity<UsuarioResposta> encontrarUsuarioPorId(@PathVariable Long id);

    @Operation(summary = "Atualiza o usuário.", tags = "usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Usuário atualizado com sucesso",
                    content = @Content(schema = @Schema(implementation = UsuarioAtualizadoResposta.class))
            ),
            @ApiResponse(responseCode = "400",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EntityBadRequestException.class))
            ),
            @ApiResponse(responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EntityNotFoundException.class))
            ),

    })
    ResponseEntity<UsuarioAtualizadoResposta> atualizarUsuario(@RequestBody @Valid UsuarioAtualizadoResposta usuarioAtualizadoResposta);

    @Operation(summary = "Exclui o usuário.", tags = "usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Usuário excluído com sucesso",
                    content = @Content(schema = @Schema(implementation = UsuarioResposta.class))
            ),
            @ApiResponse(responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EntityNotFoundException.class))
            ),

    })

    ResponseEntity<Long> deletarUsuario(@PathVariable Long id);
}
