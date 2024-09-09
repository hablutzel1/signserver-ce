/*************************************************************************
 *                                                                       *
 *  SignServer: The OpenSource Automated Signing Server                  *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU Lesser General Public           *
 *  License as published by the Free Software Foundation; either         *
 *  version 2.1 of the License, or any later version.                    *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/
package org.signserver.rest.api.exception;

import org.signserver.common.CryptoTokenOfflineException;
import org.signserver.rest.api.entities.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import static jakarta.ws.rs.core.Response.status;

@Provider
public class CryptoTokenOfflineExceptionMapper implements ExceptionMapper<CryptoTokenOfflineException> {

    @Override
    public Response toResponse(CryptoTokenOfflineException e) {
        return status(Response.Status.SERVICE_UNAVAILABLE)
                .header("Content-Type", "application/json")
                .entity(new ErrorMessage(e.getMessage()))
                .build();
    }

}
