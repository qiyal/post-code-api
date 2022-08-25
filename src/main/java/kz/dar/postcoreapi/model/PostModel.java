package kz.dar.postcoreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostModel {
    @NotNull(message = "postId must not be NULL")
    private String postId;

    @NotNull(message = "clientId must not be NULL")
    private String clientId;

    @NotNull(message = "postRecipientId must not be NULL")
    private String postRecipientId;

    private String postItem;
    private String status;
}
