package com.example.starter;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class VertexExample {
	
	private static EmployeeService service=new EmployeeService();
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	private static String jsonData = null;
	
	private static List<EmployeeModel> employeeList=null;
	
	private static EmployeeModel employee=null;
	
	public static void main(String[] args) throws Exception{
		
		Vertx vertx=Vertx.vertx();
		
		HttpServer server=vertx.createHttpServer();
		
		Router router=Router.router(vertx);
		
		Route route1=router.get("/getEmployees");
		route1.handler(routingContext -> {
			HttpServerResponse response = routingContext.response();
			response.setChunked(true);
			response.putHeader("content-type", "application/json");
			try {
				jsonData = mapper.writeValueAsString(service.getEmployees());
			} catch (JsonProcessingException e) {
				
				e.printStackTrace();
			}
			response.write(jsonData);
			response.end();

		});
		
		Route route2=router.get("/getEmployee/:id");
		route2.handler(routingContext -> {
			HttpServerResponse response = routingContext.response();
			String id=routingContext.request().getParam("id");
			response.setChunked(true);
			response.putHeader("content-type", "application/json");
			employee=service.getEmployee(id);
			try {
				jsonData = mapper.writeValueAsString(employee);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			response.write(jsonData);
			response.end();

		});
		
		
		
		
		Route route3=router.post("/createEmployee");
		route3.handler(BodyHandler.create());
		router.post("/createEmployee").handler(routingContext ->{
			HttpServerResponse response = routingContext.response();
			  response.setChunked(true);
			  String jsonString = routingContext.getBodyAsString();
			  try {
				employee=mapper.readValue(jsonString, EmployeeModel.class);
				 jsonData = mapper.writeValueAsString(service.addEmployee(employee));
					
			} catch (JsonProcessingException e) {
				
				e.printStackTrace();
			}
			 	
			  response.write(jsonData);
				response.end();
		});
		
		Route route4=router.delete("/deleteEmployee/:id");
		route4.handler(routingContext -> {
			HttpServerResponse response = routingContext.response();
			String id=routingContext.request().getParam("id");
			response.setChunked(true);
			response.putHeader("content-type", "application/json");
			try {
				jsonData = mapper.writeValueAsString(service.deleteEmployee(id));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			response.write(jsonData);
			response.end();

		});
		
		
		Route route5=router.put("/updateEmployee");
		route5.handler(BodyHandler.create());
		router.put("/updateEmployee").handler(routingContext ->{
			HttpServerResponse response = routingContext.response();
			  response.setChunked(true);
			  String jsonString = routingContext.getBodyAsString();
			  try {
				employee=mapper.readValue(jsonString, EmployeeModel.class);
				 jsonData = mapper.writeValueAsString(service.updateEmployee(employee));
					
			} catch (JsonProcessingException e) {
				
				e.printStackTrace();
			}
			 	
			  response.write(jsonData);
				response.end();
		});
		
		
		
		
		
		server.requestHandler(router).listen(8080);
		
		

	}

}
