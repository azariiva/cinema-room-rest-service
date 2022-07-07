package cinema.controller.dto;

import java.io.Serializable;
import java.util.UUID;

public class TokenJBean implements Serializable {
    private UUID token;

    public TokenJBean() {
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenJBean{" +
                "token=" + token +
                '}';
    }
}
