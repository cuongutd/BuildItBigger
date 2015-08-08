/*
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.cuong.telljokes.backend;

import com.example.JokeSupplier;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.telljokes.cuong.com",
                ownerName = "backend.telljokes.cuong.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name = "getAJoke")
    public MyBean getAJoke(@Named("name") String name) {

        String joke  = (new JokeSupplier()).getAJoke();
        MyBean response = new MyBean();
        response.setData(joke);

        return response;
    }

}
