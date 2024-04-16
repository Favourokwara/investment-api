package za.co.favourokwara.core.results;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResultData<T> extends Result {

    private final T payload;

    @Builder
    public ResultData(boolean success, String message, List<String> errors, T payload) {
        super(success, message, errors);
        this.payload = payload;
    }
}
