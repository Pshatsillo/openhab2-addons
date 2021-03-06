/**
 * Copyright (c) 2010-2019 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.solaredge.internal.connector;

import org.eclipse.jetty.http.HttpStatus.Code;

/**
 * this class contains the HTTP status of the communication and an optional exception that might occoured during
 * communication
 *
 * @author Alexander Friese - initial contribution
 */
public class CommunicationStatus {

    private Code httpCode;
    private Exception error;

    public final Code getHttpCode() {
        return httpCode == null ? Code.INTERNAL_SERVER_ERROR : httpCode;
    }

    public final void setHttpCode(Code httpCode) {
        this.httpCode = httpCode;
    }

    public final Exception getError() {
        return error;
    }

    public final void setError(Exception error) {
        this.error = error;
    }

    public final String getMessage() {
        if (error != null && error.getMessage() != null && !error.getMessage().isEmpty()) {
            return error.getMessage();
        } else if (httpCode != null & httpCode.getMessage() != null && !httpCode.getMessage().isEmpty()) {
            return httpCode.getMessage();
        }
        return "";
    }

}
