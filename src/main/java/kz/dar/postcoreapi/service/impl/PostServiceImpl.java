package kz.dar.postcoreapi.service.impl;

import kz.dar.postcoreapi.model.PostModel;
import kz.dar.postcoreapi.service.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private static final HashMap<String, PostModel> postMap = new HashMap<>();

    static {
        String clientId1 = UUID.randomUUID().toString();
        String postRecipientId1 = UUID.randomUUID().toString();

        PostModel postModel1 = new PostModel(UUID.randomUUID().toString(), clientId1, UUID.randomUUID().toString(), "Item 1", "status 1");
        PostModel postModel2 = new PostModel(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), "Item 2", "status 1");
        PostModel postModel3 = new PostModel(UUID.randomUUID().toString(), clientId1, postRecipientId1, "Item 3", "status 2");
        PostModel postModel4 = new PostModel(UUID.randomUUID().toString(), UUID.randomUUID().toString(), postRecipientId1, "Item 4", "status 2");
        PostModel postModel5 = new PostModel(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), "Item 5", "status 3");

        postMap.put(postModel1.getPostId(), postModel1);
        postMap.put(postModel2.getPostId(), postModel2);
        postMap.put(postModel3.getPostId(), postModel3);
        postMap.put(postModel4.getPostId(), postModel4);
        postMap.put(postModel5.getPostId(), postModel5);
    }

    @Override
    public void createPost(PostModel postModel) {
        postMap.put(postModel.getPostId(), postModel);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return new ArrayList<>(postMap.values());
    }

    @Override
    public PostModel getPostById(String postId) {
        return postMap.get(postId);
    }

    @Override
    public void updatePostById(String postId, PostModel postModel) {
        PostModel postModel1 = postMap.get(postId);

        postModel1.setClientId(postModel.getClientId());
        postModel1.setPostRecipientId(postModel.getPostRecipientId());
        postModel1.setPostItem(postModel.getPostItem());
        postModel1.setStatus(postModel.getStatus());

        postMap.put(postModel1.getPostId(), postModel1);
    }

    @Override
    public void deletePostById(String postId) {
        postMap.remove(postId);
    }
}
