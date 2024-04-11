package com.example.maximumintmodulo.service;

import com.example.maximumintmodulo.model.RequestMaximumModulo;
import org.springframework.stereotype.Service;

@Service
public class MaximumModuloServiceImpl implements MaximumModuloService {

    private RequestMaximumModulo parameters;

    @Override
    public RequestMaximumModulo getParameters() {
        RequestMaximumModulo requestMaximumModulo = new RequestMaximumModulo();
        if (parameters != null) {
            requestMaximumModulo = parameters;
        }
        return requestMaximumModulo;
    }

    @Override
    public String setParameters(RequestMaximumModulo requestMaximumModulo) {
        String retValue = null;
        if (requestMaximumModulo != null) {
            parameters = requestMaximumModulo;
            retValue = "Parameters= ".concat(parameters.toString()) + " saved successfully";
        }
        return retValue;
    }
}
