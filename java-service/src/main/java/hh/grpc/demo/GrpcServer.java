package hh.grpc.demo;

import hh.grpc.demo.service.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GrpcServer {

    public static void main(String[] args) {
        log.info("Starting GRPC Server");
        Server server = ServerBuilder.forPort(8000)
                .addService(new UserService())
                .build();

        try {
            server.start();
            log.info("Server started at " + server.getPort());
            server.awaitTermination();
        } catch (Exception e) {
            log.error("Error while starting the server");
            throw new RuntimeException(e);
        }
    }
}