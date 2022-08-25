package kz.dar.postcoreapi.controller;

import javafx.geometry.Pos;
import kz.dar.postcoreapi.model.PostModel;
import kz.dar.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/check")
    public String check() {
        return "post-core-api is working";
    }

    @PostMapping
    public ResponseEntity<String> createPost(@Valid @RequestBody PostModel postModel) {
        postService.createPost(postModel);
        return new ResponseEntity<String>("PostModel is created.", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<PostModel> getAll() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostModel getByPostId(@PathVariable("postId") String postId) {
        return postService.getPostById(postId);
    }

    @PutMapping("{postId}")
    public ResponseEntity<String> updatePostModel(@PathVariable("postId") String postId, @RequestBody PostModel postModel) {
        postService.updatePostById(postId, postModel);
        return new ResponseEntity<String>("PostModel updated", HttpStatus.OK);
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<String> deletePostModel(@PathVariable("postId") String postId) {
        postService.deletePostById(postId);
        return new ResponseEntity<String>("PostModel deleted", HttpStatus.OK);
    }
}
