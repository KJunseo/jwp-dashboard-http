package nextstep.jwp.dashboard.repository;


import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import nextstep.jwp.dashboard.domain.User;

public class InMemoryUserRepository {
    private static Long seq = 0L;
    private static final Map<String, User> database = new ConcurrentHashMap<>();

    static {
        final User user = new User(++seq, "gugu", "password", "hkkang@woowahan.com");
        database.put(user.getAccount(), user);
    }

    public void save(User user) {
        user.setId(++seq);
        database.put(user.getAccount(), user);
    }

    public Optional<User> findByAccount(String account) {
        return Optional.ofNullable(database.get(account));
    }
}
