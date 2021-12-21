package com.github.cc007.headsplugin.api.business.services.heads;

import com.github.cc007.headsplugin.api.business.domain.Head;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HeadSearcher {
    /**
     * Get the number of times a certain search term is used.
     *
     * @param searchTerm the search term
     * @return the number of times the search term is used
     */
    int getSearchCount(String searchTerm);

    /**
     * Get the {@link Head} for the provided head owner {@link UUID}, as {@link Optional}
     * @param headOwner the head owner UUID
     * @return the optional head
     */
    Optional<Head> getHead(UUID headOwner);

    /**
     * Get all {@link Head}s based on a given search term
     * @param searchTerm the search term
     * @return the list of heads
     */
    List<Head> getHeads(String searchTerm);
}
