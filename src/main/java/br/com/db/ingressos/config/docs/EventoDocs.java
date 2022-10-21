package br.com.db.ingressos.config.docs;

import br.com.db.ingressos.controller.dto.EventoDto;
import br.com.db.ingressos.controller.dto.UsuarioDto;
import br.com.db.ingressos.model.Evento;
import br.com.db.ingressos.model.Usuario;
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
import java.util.Optional;

@Tag(name = "evento", description = "Responsável por manter evento no sistema")
public interface EventoDocs {
    @Operation(summary = "Cadastra novo evento.", tags = "evento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Evento incluído com sucesso",
                    content = @Content(schema = @Schema(implementation = Evento.class))
            ),
            @ApiResponse(responseCode = "400",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = HttpClientErrorException.BadRequest.class))
            ),
            @ApiResponse(responseCode = "500",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = NullPointerException.class))
            ),

    })
    ResponseEntity<EventoDto> cadastrarEvento(@RequestBody @Valid EventoDto eventoDto);

    @Operation(summary = "Lista os eventos.", tags = "evento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Eventos listados com sucesso",
                    content = @Content(schema = @Schema(implementation = Evento.class))
            ),
            @ApiResponse(responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EntityNotFoundException.class))
            ),

    })
    ResponseEntity<List<EventoDto>> listarEvento();

    @Operation(summary = "Encontra o evento.", tags = "evento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Evento encontrado com sucesso",
                    content = @Content(schema = @Schema(implementation = Evento.class))
            ),
            @ApiResponse(responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EntityNotFoundException.class))
            ),

    })
    ResponseEntity<Optional<EventoDto>> encontrarEvento(@PathVariable Long id);

    @Operation(summary = "Atualiza o evento.", tags = "evento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Evento atualizado com sucesso",
                    content = @Content(schema = @Schema(implementation = Evento.class))
            ),
            @ApiResponse(responseCode = "400",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = HttpClientErrorException.BadRequest.class))
            ),
            @ApiResponse(responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EntityNotFoundException.class))
            ),

    })
    ResponseEntity<EventoDto> atualizarEvento(@RequestBody @Valid EventoDto eventoDto);

    @Operation(summary = "Exclui o evento.", tags = "evento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Usuário excluído com sucesso",
                    content = @Content(schema = @Schema(implementation = Evento.class))
            ),
            @ApiResponse(responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EntityNotFoundException.class))
            ),

    })

    ResponseEntity<Long> deletarEvento(@PathVariable Long id);
}
