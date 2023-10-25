package com.sparta.jsonvoorhees.springapi.apicontroller;

import com.sparta.jsonvoorhees.springapi.controller.CommentApiController;
import com.sparta.jsonvoorhees.springapi.model.entities.Comment;
import com.sparta.jsonvoorhees.springapi.service.ServiceLayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest
public class CommentApiControllerTests {

    @Mock
    private ServiceLayer serviceLayer;
    private WebTestClient testClient;
    @Autowired
    private CommentApiController commentApiController;

    @BeforeEach
    void setup() {
        testClient = WebTestClient.bindToController(commentApiController).build();
    }

    @Test
    @DisplayName("check that get comment by id returns 200 for existing id")
    void checkThatGetCommentByIdReturns200ForExistingId() {
        // The uri has to contain http or the test doesn't work - Most likely because IntelliJ by default uses https
        testClient
                .get()
                .uri("http://localhost:8080/api/comments/getComment/5a9427648b0beebeb6957b28")
                .exchange()
                .expectStatus()
                .isEqualTo(200);
    }

    @Test
    @DisplayName("check that get comments by user id returns 200 for existing user id")
    void checkThatGetCommentsByUserIdReturns200ForExistingUserId() {
        testClient
                .get()
                .uri("http://localhost:8080/api/comments/getAllCommentsByUserId/59b99db5cfa9a34dcd7885b9")
                .exchange()
                .expectStatus()
                .isEqualTo(200);
    }

    @Test
    @DisplayName("check that get comments by movie id returns 200 for existing movie id")
    void checkThatGetCommentsByMovieIdReturns200ForExistingMovieId() {
        testClient
                .get()
                .uri("http://localhost:8080/api/comments/getAllCommentsByMovieId/573a1390f29313caabcd5293")
                .exchange()
                .expectStatus()
                .isEqualTo(200);
    }

    @Test
    @DisplayName("check that create comment returns 200 if given comment object in the body")
    void checkThatCreateCommentReturns200IfGivenCommentObjectInTheBody() {
        Comment comment = new Comment();

        testClient
                .post()
                .uri("http://localhost:8080/api/comments")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(comment)
                .exchange()
                .expectStatus()
                .isEqualTo(200);
    }

    @Test
    @DisplayName("check that delete comment by id returns 200 if given existing comment id")
    void checkThatDeleteCommentByIdReturns200IfGivenExistingCommentId() {
        Mockito.when(serviceLayer.deleteCommentById("commentIdToDelete")).thenReturn(String.valueOf(Mono.just("Comment deleted successfully")));

        testClient
                .delete()
                .uri("http://localhost:8080/api/comments/commentIdToDelete")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Comment deleted successfully");
    }



}
