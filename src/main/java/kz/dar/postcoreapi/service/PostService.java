package kz.dar.postcoreapi.service;

import kz.dar.postcoreapi.model.PostModel;

import java.util.List;

public interface PostService {
    void createPost(PostModel postModel);

    List<PostModel> getAllPosts();

    PostModel getPostById(String postId);

    void updatePostById(String postId, PostModel postModel);

    void deletePostById(String postId);
}
