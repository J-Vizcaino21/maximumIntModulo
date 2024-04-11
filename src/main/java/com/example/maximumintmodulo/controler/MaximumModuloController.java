package com.example.maximumintmodulo.controler;

import com.example.maximumintmodulo.model.RequestMaximumModulo;
import com.example.maximumintmodulo.model.ResponseMaximumModulo;
import com.example.maximumintmodulo.service.MaximumModuloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping
@CrossOrigin("*")
public class MaximumModuloController {

    @Autowired
    MaximumModuloServiceImpl maximumModuloService;

    @GetMapping("/getMaximumInteger")
    public ResponseMaximumModulo getMaximumModulo() {
        RequestMaximumModulo requestMaximumModulo = maximumModuloService.getParameters();
        ResponseMaximumModulo responseMaximumModulo = new ResponseMaximumModulo();
        final int modulo = requestMaximumModulo.getModulo();
        final int remainder = requestMaximumModulo.getRemainder();
        for (int i = 0; (requestMaximumModulo.getMaximumNumber() + i) > 0; --i) {
            int maximumNumber = (requestMaximumModulo.getMaximumNumber() + i);
            if (maximumNumber % modulo == remainder) {
                responseMaximumModulo.setMaximumModulo(maximumNumber);
                return responseMaximumModulo;
            }
        }
        return responseMaximumModulo;
    }

    @PostMapping("/setParameters")
    public ResponseEntity setParameters(@Valid @RequestBody final RequestMaximumModulo requestMaximumModulo, BindingResult bindingResult) {
        Map<String, String> response = new HashMap<>();

        if (bindingResult.hasErrors()) {
            String errorMessage = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
            response.put("error", errorMessage);
            return ResponseEntity.badRequest().body(response);
        }

        String message = maximumModuloService.setParameters(requestMaximumModulo);
        response.put("message", message);
        return ResponseEntity.ok().body(response);
    }
}
