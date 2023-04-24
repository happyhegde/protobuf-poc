package hh.grpc.demo.service;

import hh.grpc.demo.protos.User;
import hh.grpc.demo.protos.userGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class UserService extends userGrpc.userImplBase {

    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        log.info(String.format("Inside login method with %s and %s", request.getUsername(), request.getPassword()));
        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        response.setCode(200).setMessage("Login success");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        log.info("Inside logout method");
        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        response.setCode(200).setMessage("Logout success");
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
