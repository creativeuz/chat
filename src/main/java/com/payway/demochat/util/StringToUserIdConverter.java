package com.payway.demochat.util;

import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StringToUserIdConverter implements Converter<String, UUID> {

    @Override
    public UUID convert(@NonNull String uuid) {
        return UUID.fromString(uuid);
    }
}
