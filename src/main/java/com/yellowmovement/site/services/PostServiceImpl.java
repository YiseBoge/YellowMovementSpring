package com.yellowmovement.site.services;

import com.yellowmovement.site.domains.Post;
import com.yellowmovement.site.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public List<Post> searchPosts(String keyword) {
        return postRepository.searchPosts(keyword);
    }

    @Override
    public List<Post> findOrderedPosts() {
        return postRepository.findOrderedPosts();
    }

    @Override
    public List<String> findCategoriesList() {
        return postRepository.findCategoriesList();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Iterable<Post> saveAll(Iterable<Post> post) {
        return postRepository.saveAll(post);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return postRepository.existsById(id);
    }

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Iterable<Post> findAllById(Iterable<Long> ids) {
        return postRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return postRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    @Override
    public void deleteAll(Iterable<Post> post) {
        postRepository.deleteAll(post);
    }

    @Override
    public void deleteAll() {
        postRepository.deleteAll();
    }

    @Override
    public Iterable<Post> findAll(Sort sort) {
        return postRepository.findAll(sort);
    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }
}
