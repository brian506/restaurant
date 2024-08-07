package study.restaurant.postTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.restaurant.post.repository.PostRepository;
import study.restaurant.post.service.PostService;

@Transactional
@SpringBootTest
public class PostServiceTest {

    @Autowired private PostService postService;
    @Autowired private PostRepository postRepository;
}
