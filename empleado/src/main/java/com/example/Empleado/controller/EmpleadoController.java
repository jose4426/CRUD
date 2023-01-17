package com.example.Empleado.controller;

import com.example.Empleado.dto.request.EmpleadoRequest;
import com.example.Empleado.dto.response.EmpleadoResponse;
import com.example.Empleado.repository.EmpaledoRepository;
import com.example.Empleado.serv.EmpleadoServ;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
@AllArgsConstructor
public class EmpleadoController {
    public static final String LEAVING_FIND_BY_RESPONSE = "Leaving findByid [response]: {}";

    public static final String MESSAGE_NOFOUNDDATA = "message.notdata.found";

    private final   EmpleadoServ serv;
    private final EmpaledoRepository empaledoRepository;

    @GetMapping(value = "/empleado/getall", produces = {MediaType.APPLICATION_JSON_VALUE,
                                                        MediaType.APPLICATION_JSON_VALUE})

    public ResponseEntity<List<EmpleadoResponse>> getAllEmpledo()throws Exception {
        log.debug("lista de Empleados");
        List<EmpleadoResponse> empleadoResponses = this.serv.empledosFindAll();

        log.debug(MESSAGE_NOFOUNDDATA, empleadoResponses);

        return ResponseEntity.ok().body(empleadoResponses);
    }

    @GetMapping(value = "/empleado/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})

    public EmpleadoResponse getEmpleadoById(@PathVariable (name="id") int id) throws Exception {
        log.debug("Empleado");
        EmpleadoResponse empleado = serv.findById(id);
        log.debug(LEAVING_FIND_BY_RESPONSE, empleado);
        return empleado;
    }

    @PostMapping(value = "/empleado/save",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})

    public ResponseEntity inserEmpleado(@RequestBody EmpleadoRequest request) throws Exception {
        log.debug("Entering addProduct [request]: {}", request);

         var  empleadoResponse = serv.inserEmpleado(request);
        log.debug("Leaving addProduct [response]: {}", empleadoResponse);

        return  ResponseEntity.ok().body(request);
    }

    @DeleteMapping(value = "/empleado/delete/{id}",  produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})

    public ResponseEntity deleteEmpleadoById(@PathVariable int id)throws Exception {
        log.debug(" Id del empleado ");

       Long empleado= this.serv.daleteEmpleado(id);
        log.debug(LEAVING_FIND_BY_RESPONSE, empleado);
        return ResponseEntity.ok().body(empleado) ;

    }
    @PutMapping(value = "/empleado",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})

    public ResponseEntity<Long> productUpdate( @RequestBody EmpleadoRequest request) throws Exception {
        log.debug("Entering updateEmplado [request]: {}", request);

        Long  idEmpleadoUpdate = serv.updateEmpleado(request);

        log.debug("Leaving updateProduct [response]: {}", idEmpleadoUpdate);

        return ResponseEntity.ok().body(idEmpleadoUpdate);
    }

    @GetMapping(value = "/empleado/search/{nombre}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})

    public Optional<EmpleadoResponse> findByName(@PathVariable (name="nombre") String nombre) throws Exception {
        log.debug("Busqueda por Nombre");
       Optional<EmpleadoResponse> empleadoResponse= serv.findByNombre(nombre);

        log.debug(LEAVING_FIND_BY_RESPONSE, empleadoResponse);
return empleadoResponse;
    }
    @GetMapping(value = "/empleado/search/{apellido}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})

    public Optional<EmpleadoResponse> findByApellido(@PathVariable (name="apellido") String apellido) throws Exception {
        log.debug("Busqueda por apellido");
        Optional<EmpleadoResponse> empleadoResponse= serv.findByApellido(apellido);

        log.debug(LEAVING_FIND_BY_RESPONSE, empleadoResponse);
        return empleadoResponse;
    }

}
