package com.redhat.training.example.javaserverhost.rest;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.net.InetAddress;

@Path("/")
public class ServerHostEndPoint {

  @GET
  @Produces("text/plain")
  public Response doGet() {
    String host = "";
    String ip = "";
    try {
      host = InetAddress.getLocalHost().getHostName();
      ip=Arrays.toString(Inet4Address.getAllByName(host).getAddress()); 
    }
    catch (Exception e) {
       e.printStackTrace();
    }
    String msg = "I am running on server "+host+ ";;"+ip+" Version 1.0 \n";
    return Response.ok(msg).build();
  }
}

