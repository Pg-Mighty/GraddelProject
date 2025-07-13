package com.sumukh.demo.Repo;

import com.sumukh.demo.model.Students;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class repo implements JpaRepository<Students, Integer> {
    @Override
    public void flush() {

    }

    @Override
    public <S extends Students> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Students> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Students> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    public Students findByUsername(String username){
        return new Students();
    }

    @Override
    public Students getOne(Integer integer) {
        return null;
    }

    @Override
    public Students getById(Integer integer) {
        return null;
    }

    @Override
    public Students getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Students> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Students> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Students> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Students> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Students> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Students> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Students, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Students> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Students> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Students> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Students> findAll() {
        return List.of();
    }

    @Override
    public List<Students> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Students entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Students> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Students> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Students> findAll(Pageable pageable) {
        return null;
    }
}
