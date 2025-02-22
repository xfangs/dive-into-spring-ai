package io.github.qifan777.knowledge.user;

import org.babyfish.jimmer.spring.repository.JRepository;

import java.util.Optional;

public interface UserRepository extends JRepository<User, String> {
  UserTable t = UserTable.$;
  UserFetcher FETCHER = UserFetcher.$.allScalarFields();

  default Optional<User> findByPhone(String phone) {
    return sql().createQuery(t).where(t.phone().eq(phone)).select(t).fetchOptional();
  }

  // 新增：通过 userId 获取用户
  default Optional<User> findByUserId(String userId) {
    return sql().createQuery(t).where(t.id().eq(userId)).select(t).fetchOptional();
  }
}
