package com.github.cc007.headsplugin.api.business.domain.events;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.time.Instant;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CategoryUpdatedEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private String categoryName;
    private double duration;
    private Instant endTime;

    @Override
    @NonNull
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
