package br.com.db.ingressos.config.docs;

import br.com.db.ingressos.controller.dto.IngressoDto;
import br.com.db.ingressos.exception.EntityBadRequestException;
import br.com.db.ingressos.exception.EntityNullPointerException;
import br.com.db.ingressos.resposta.IngressoResposta;
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

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Tag(name = "ingresso", description = "Responsável por manter ingresso no sistema")
public interface IngressoDocs {
        @Operation(summary = "Cadastra novo ingresso.", tags = "ingresso")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Ingresso incluído com sucesso", content = @Content(schema = @Schema(implementation = IngressoResposta.class))),
                        @ApiResponse(responseCode = "400", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EntityBadRequestException.class))),
                        @ApiResponse(responseCode = "500", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EntityNullPointerException.class))),

        })
        ResponseEntity<IngressoResposta> cadastrarIngresso(@RequestBody @Valid IngressoDto ingressoDto);

        @Operation(summary = "Lista os ingressos.", tags = "ingresso")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Ingressos listados com sucesso", content = @Content(schema = @Schema(implementation = IngressoResposta.class))),
                        @ApiResponse(responseCode = "404", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EntityNotFoundException.class))),

        })
        ResponseEntity<List<IngressoResposta>> listarIngresso();

        @Operation(summary = "Encontra o ingresso.", tags = "ingresso")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Ingresso encontrado com sucesso", content = @Content(schema = @Schema(implementation = IngressoResposta.class))),
                        @ApiResponse(responseCode = "404", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EntityNotFoundException.class))),

        })
        ResponseEntity<IngressoResposta> encontrarIngressoPorId(@PathVariable Long id);

        @Operation(summary = "Exclui o ingresso.", tags = "ingresso")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Ingresso excluído com sucesso", content = @Content(schema = @Schema(implementation = IngressoResposta.class))),
                        @ApiResponse(responseCode = "404", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EntityNotFoundException.class))),

        })
        ResponseEntity<Long> deletarIngresso(@PathVariable Long id);
}
