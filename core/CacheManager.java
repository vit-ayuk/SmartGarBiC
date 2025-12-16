package core;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {
    // Map to store caching decisions for Content objects
    private Map<String, Integer> cacheState;

    public CacheManager() {
        this.cacheState = new HashMap<>();
    }

    /**
     * Record caching decision for a Content object.
     *
     * @param content The Content object.
     * @param isCached The caching decision (0 = not cached, 1 = cached).
     */
    public void recordCachingDecision(Content content, int isCached) {
        if (isCached != 0 && isCached != 1) {
            throw new IllegalArgumentException("Caching decision must be 0 (not cached) or 1 (cached)");
        }
        content.setIsCached(isCached); // Update content's caching state
        cacheState.put(content.getContentId(), isCached);
    }

    /**
     * Get the caching state for the given Content by its ID.
     *
     * @param contentId The unique ID of the Content.
     * @return The caching decision (0 = not cached, 1 = cached).
     */
    public int getCachingState(String contentId) {
        return cacheState.getOrDefault(contentId, -1); // -1 if no state is recorded
    }

    /**
     * Print the current cache storage state for all Content objects.
     */
    public void printCacheState() {
        System.out.println("Cache Storage State:");
        for (Map.Entry<String, Integer> entry : cacheState.entrySet()) {
            System.out.println("Content ID: " + entry.getKey() +
                    " | Status: " + (entry.getValue() == 1 ? "Cached" : "Not Cached"));
        }
    }
}