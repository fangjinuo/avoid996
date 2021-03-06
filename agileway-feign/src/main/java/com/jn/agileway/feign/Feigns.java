/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the LGPL, Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at  http://www.gnu.org/licenses/lgpl-3.0.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jn.agileway.feign;

import com.jn.easyjson.core.JSONFactory;
import com.jn.langx.http.rest.RestRespBody;
import com.jn.langx.util.io.IOs;
import com.jn.langx.util.reflect.Reflects;
import com.jn.langx.util.reflect.type.Types;
import feign.InvocationHandlerFactory;
import feign.MethodMetadata;
import feign.Response;

import java.io.IOException;

public class Feigns {
    public static <T> RestRespBody<T> toRestRespBody(Response response, JSONFactory jsonFactory, Class<T> dataClass) throws IOException {
        return jsonFactory.get().fromJson(response.body().asReader(), dataClass == RestRespBody.class ? dataClass : Types.getParameterizedType(RestRespBody.class, dataClass));
    }

    public static Response toByteArrayResponse(Response response) throws IOException {
        if (response == null || response.body() == null) {
            return null;
        }
        Response.Body body = response.body();

        if (!body.isRepeatable()) {
            byte[] bytes = IOs.toByteArray(body.asInputStream());
            Response repeatableResponse = Response
                    .builder()
                    .headers(response.headers())
                    .status(response.status())
                    .reason(response.reason())
                    .request(response.request())
                    .body(bytes)
                    .build();
            response = repeatableResponse;
        }
        return response;
    }

    public static MethodMetadata getMethodMetadata(InvocationHandlerFactory.MethodHandler methodHandler) {
        MethodMetadata metadata = ((MethodMetadata) Reflects.getAnyFieldValue(methodHandler, "metadata", true, false));
        return metadata;
    }
}
