package nextstep.jwp.dashboard.controller.dto;

import nextstep.jwp.dashboard.domain.User;

public class UserDto {
    private final Long id;
    private final String account;
    private final String password;
    private final String email;

    public UserDto(User user) {
        this(user.getId(), user.getAccount(), user.getPassword(), user.getEmail());
    }

    public UserDto(Long id, String account, String password, String email) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
