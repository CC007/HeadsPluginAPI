package com.github.cc007.headsplugin.api.business.services.heads;

import java.util.Collection;

public interface CategoryUpdater {

    /**
     * Update the specified category
     *
     * @param categoryName the name of the category to update
     * @throws IllegalArgumentException when an unknown category name is provided.
     */
    void updateCategory(String categoryName) throws IllegalArgumentException;

    /**
     * Update all categories.
     */
    void updateCategories();

    /**
     * Update all categories that haven't recently been updated. This depends on the property headsplugin.categories.update.interval in config.yml
     */
    void updateCategoriesIfNecessary();

    /**
     * Provides a list of updatable categories
     *
     * @param necessaryOnly return only the categories that are outside of the update interval
     * @return the updatable categories
     */
    Collection<String> getUpdatableCategoryNames(boolean necessaryOnly);
}
