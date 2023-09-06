package com.example.Reactordemo;

import lombok.Getter;
import reactor.core.publisher.Mono;

import java.util.List;

@Getter
class ResponseTo {
    public List<String> itemIdList = List.of("abc", "def", "xyz", "mnb");
}

public class TrySO {
    public Mono<List<ResponseTo>> getItemDetails(ResponseTo itemRequest) {
        return itemRequest
                .itemIdList
                .
                .flatMap ( findItemStatus(it) )
                .flatMap {
            response ->
                    Mono.justOrEmpty(ResponseTo(response))
                            .onErrorResume {
                logger.error("Error occurred while mapping entity to response: $response", it)
                Mono.empty()
            }
        }
        .collectList()
    }
}

